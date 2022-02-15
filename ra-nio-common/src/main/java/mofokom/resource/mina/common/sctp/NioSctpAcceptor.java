/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package mofokom.resource.mina.common.sctp;

import com.sun.nio.sctp.SctpChannel;
import com.sun.nio.sctp.SctpServerChannel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;

import org.apache.mina.core.polling.AbstractPollingIoAcceptor;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.SimpleIoProcessorPool;
import org.apache.mina.core.service.TransportMetadata;
import org.apache.mina.transport.socket.DefaultSocketSessionConfig;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioProcessor;

/**
 * {@link IoAcceptor} for socket transport (TCP/IP). This class handles incoming
 * TCP/IP based socket connections.
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class NioSctpAcceptor
        extends AbstractPollingIoAcceptor<NioSctpSession, SctpServerChannel>
        implements SocketAcceptor {

    private volatile Selector selector;

    /**
     * Constructor for {@link NioSctpAcceptor} using default parameters
     * (multiple thread model).
     */
    public NioSctpAcceptor() {
        super(new DefaultSocketSessionConfig(), NioSctpProcessor.class);
        ((DefaultSocketSessionConfig) getSessionConfig()).init(this);
    }

    /**
     * Constructor for {@link NioSctpAcceptor} using default parameters, and
     * given number of {@link NioProcessor} for multithreading I/O operations.
     *
     * @param processorCount the number of processor to create and place in a
     * {@link SimpleIoProcessorPool}
     */
    public NioSctpAcceptor(int processorCount) {
        super(new DefaultSocketSessionConfig(), NioSctpProcessor.class, processorCount);
        ((DefaultSocketSessionConfig) getSessionConfig()).init(this);
    }

    /**
     * Constructor for {@link NioSctpAcceptor} with default configuration but a
     * specific {@link IoProcessor}, useful for sharing the same processor over
     * multiple
     *  {@link IoService} of the same type.
     *
     * @param processor the processor to use for managing I/O events
     */
    public NioSctpAcceptor(IoProcessor<NioSctpSession> processor) {
        super(new DefaultSocketSessionConfig(), processor);
        ((DefaultSocketSessionConfig) getSessionConfig()).init(this);
    }

    /**
     * Constructor for {@link NioSctpAcceptor} with a given {@link Executor} for
     * handling connection events and a given {@link IoProcessor} for handling
     * I/O events, useful for sharing the same processor and executor over
     * multiple {@link IoService} of the same type.
     *
     * @param executor the executor for connection
     * @param processor the processor for I/O operations
     */
    public NioSctpAcceptor(Executor executor, IoProcessor<NioSctpSession> processor) {
        super(new DefaultSocketSessionConfig(), executor, processor);
        ((DefaultSocketSessionConfig) getSessionConfig()).init(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void init() throws Exception {
        selector = Selector.open();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void destroy() throws Exception {
        if (selector != null)
            selector.close();
    }

    /**
     * {@inheritDoc}
     */
    public TransportMetadata getTransportMetadata() {
        return NioSctpSession.METADATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SocketSessionConfig getSessionConfig() {
        return (SocketSessionConfig) super.getSessionConfig();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InetSocketAddress getLocalAddress() {
        return (InetSocketAddress) super.getLocalAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InetSocketAddress getDefaultLocalAddress() {
        return (InetSocketAddress) super.getDefaultLocalAddress();
    }

    /**
     * {@inheritDoc}
     */
    public void setDefaultLocalAddress(InetSocketAddress localAddress) {
        setDefaultLocalAddress((SocketAddress) localAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected NioSctpSession accept(IoProcessor<NioSctpSession> processor,
            SctpServerChannel handle) throws Exception {

        SelectionKey key = handle.keyFor(selector);

        if ((key == null) || (!key.isValid()) || (!key.isAcceptable()))
            return null;

        // accept the connection from the client
        SctpChannel ch = handle.accept();

        ch.association().associationID();
        if (ch == null)
            return null;
        NioSctpSession session = new NioSctpSession(this, processor, ch);
        //session.setAttribute("",this);
        return session;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected SctpServerChannel open(SocketAddress localAddress)
            throws Exception {
        // Creates the listening ServerSocket
        SctpServerChannel channel = SctpServerChannel.open();

        boolean success = false;

        try {
            // This is a non blocking socket channel
            channel.configureBlocking(false);

            channel.bind(localAddress, getBacklog());

            // Register the channel within the selector for ACCEPT event
            channel.register(selector, SelectionKey.OP_ACCEPT);
            success = true;
        } finally {
            if (!success)
                close(channel);
        }
        return channel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected SocketAddress localAddress(SctpServerChannel handle)
            throws Exception {
        return new ArrayList<SocketAddress>(handle.getAllLocalAddresses()).get(0);
    }

    /**
     * Check if we have at least one key whose corresponding channels is ready
     * for I/O operations.
     *
     * This method performs a blocking selection operation. It returns only
     * after at least one channel is selected, this selector's wakeup method is
     * invoked, or the current thread is interrupted, whichever comes first.
     *
     * @return The number of keys having their ready-operation set updated
     * @throws IOException If an I/O error occurs
     * @throws ClosedSelectorException If this selector is closed
     */
    @Override
    protected int select() throws Exception {
        return selector.select();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Iterator<SctpServerChannel> selectedHandles() {
        return new SctpServerChannelIterator(selector.selectedKeys());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void close(SctpServerChannel handle) throws Exception {
        SelectionKey key = handle.keyFor(selector);

        if (key != null)
            key.cancel();

        handle.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void wakeup() {
        selector.wakeup();
    }

}
    /**
     * Defines an iterator for the selected-key Set returned by the
     * selector.selectedKeys(). It replaces the SelectionKey operator.
     */
    class SctpServerChannelIterator implements Iterator<SctpServerChannel> {

        /**
         * The selected-key iterator
         */
        private final Iterator<SelectionKey> iterator;

        /**
         * Build a SocketChannel iterator which will return a SocketChannel
         * instead of a SelectionKey.
         *
         * @param selectedKeys The selector selected-key set
         */
        SctpServerChannelIterator(Collection<SelectionKey> selectedKeys) {
            iterator = selectedKeys.iterator();
        }

        /**
         * Tells if there are more SockectChannel left in the iterator
         *
         * @return
         * <code>true</code> if there is at least one more SockectChannel object
         * to read
         */
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * Get the next SocketChannel in the operator we have built from the
         * selected-key et for this selector.
         *
         * @return The next SocketChannel in the iterator
         */
        public SctpServerChannel next() {
            SelectionKey key = iterator.next();
            if (key.isValid() && key.isAcceptable())
                return (SctpServerChannel) key.channel();
            return null;
        }

        /**
         * Remove the current SocketChannel from the iterator
         */
        public void remove() {
            iterator.remove();
        }
    }
