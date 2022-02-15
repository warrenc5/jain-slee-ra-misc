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
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;

import org.apache.mina.core.polling.AbstractPollingIoConnector;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.SimpleIoProcessorPool;
import org.apache.mina.core.service.TransportMetadata;
import org.apache.mina.transport.socket.DefaultSocketSessionConfig;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioProcessor;

/**
 * {@link IoConnector} for socket transport (TCP/IP).
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class NioSctpConnector
        extends AbstractPollingIoConnector<NioSctpSession, SctpChannel>
        implements IoConnector {

    private volatile Selector selector;

    /**
     * Constructor for {@link NioSctpConnector} with default configuration (multiple thread model).
     */
    public NioSctpConnector() {
        super(new DefaultSocketSessionConfig(), NioSctpProcessor.class);
        ((DefaultSocketSessionConfig) getSessionConfig()).init(this);
    }

    /**
     * Constructor for {@link NioSctpConnector} with default configuration, and 
     * given number of {@link NioProcessor} for multithreading I/O operations
     * @param processorCount the number of processor to create and place in a
     * {@link SimpleIoProcessorPool} 
     */
    public NioSctpConnector(int processorCount) {
        super(new DefaultSocketSessionConfig(), NioSctpProcessor.class, processorCount);
        ((DefaultSocketSessionConfig) getSessionConfig()).init(this);
    }

    /**
     *  Constructor for {@link NioSctpConnector} with default configuration but a
     *  specific {@link IoProcessor}, useful for sharing the same processor over multiple
     *  {@link IoService} of the same type.
     * @param processor the processor to use for managing I/O events
     */
    public NioSctpConnector(IoProcessor<NioSctpSession> processor) {
        super(new DefaultSocketSessionConfig(), processor);
        ((DefaultSocketSessionConfig) getSessionConfig()).init(this);
    }

    /**
     *  Constructor for {@link NioSctpConnector} with a given {@link Executor} for handling 
     *  connection events and a given {@link IoProcessor} for handling I/O events, useful for sharing 
     *  the same processor and executor over multiple {@link IoService} of the same type.
     * @param executor the executor for connection
     * @param processor the processor for I/O operations
     */
    public NioSctpConnector(Executor executor, IoProcessor<NioSctpSession> processor) {
        super(new DefaultSocketSessionConfig(), executor, processor);
        ((DefaultSocketSessionConfig) getSessionConfig()).init(this);
    }
    
    /**
     * Constructor for {@link NioSctpConnector} with default configuration which will use a built-in 
     * thread pool executor to manage the given number of processor instances. The processor class must have 
     * a constructor that accepts ExecutorService or Executor as its single argument, or, failing that, a 
     * no-arg constructor.
     * 
     * @param processorClass the processor class.
     * @param processorCount the number of processors to instantiate.
     * @see org.apache.mina.core.service.SimpleIoProcessorPool#SimpleIoProcessorPool(Class, Executor, int)
     * @since 2.0.0-M4
     */
    public NioSctpConnector(Class<? extends IoProcessor<NioSctpSession>> processorClass,
            int processorCount) {
        super(new DefaultSocketSessionConfig(), processorClass, processorCount);
    }

    /**
     * Constructor for {@link NioSctpConnector} with default configuration with default configuration which will use a built-in 
     * thread pool executor to manage the default number of processor instances. The processor class must have 
     * a constructor that accepts ExecutorService or Executor as its single argument, or, failing that, a 
     * no-arg constructor. The default number of instances is equal to the number of processor cores 
     * in the system, plus one.
     * 
     * @param processorClass the processor class.
     * @see org.apache.mina.core.service.SimpleIoProcessorPool#SimpleIoProcessorPool(Class, Executor, int)
     * @see org.apache.mina.core.service.SimpleIoProcessorPool#DEFAULT_SIZE
     * @since 2.0.0-M4
     */
    public NioSctpConnector(Class<? extends IoProcessor<NioSctpSession>> processorClass) {
        super(new DefaultSocketSessionConfig(), processorClass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void init() throws Exception {
        this.selector = Selector.open();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void destroy() throws Exception {
        if (selector != null) {
            selector.close();
        }
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
    public InetSocketAddress getDefaultRemoteAddress() {
        return (InetSocketAddress) super.getDefaultRemoteAddress();
    }
    
    /**
     * {@inheritDoc}
     */
    public void setDefaultRemoteAddress(InetSocketAddress defaultRemoteAddress) {
        super.setDefaultRemoteAddress(defaultRemoteAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Iterator<SctpChannel> allHandles() {
        return new SctpChannelIterator(selector.keys());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean connect(SctpChannel handle, SocketAddress remoteAddress)
            throws Exception {
        return handle.connect(remoteAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ConnectionRequest getConnectionRequest(SctpChannel handle) {
        SelectionKey key = handle.keyFor(selector);
        
        if ((key == null) || (!key.isValid())) { 
            return null;
        }

        return (ConnectionRequest) key.attachment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void close(SctpChannel handle) throws Exception {
        SelectionKey key = handle.keyFor(selector);
        
        if (key != null) {
            key.cancel();
        }
        
        handle.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean finishConnect(SctpChannel handle) throws Exception {
        if (handle.finishConnect()) {
            SelectionKey key = handle.keyFor(selector);

            if (key != null) {
                key.cancel();
            }
            
            return true;
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected SctpChannel newHandle(SocketAddress localAddress)
            throws Exception {
        SctpChannel ch = SctpChannel.open();

        int receiveBufferSize =
            (getSessionConfig()).getReceiveBufferSize();
        //FIXME:
        /*
        if (receiveBufferSize > 65535) {
            ch.socket().setReceiveBufferSize(receiveBufferSize);
        }
        * 
        */

        if (localAddress != null) {
            ch.bind(localAddress);
        }
        
        ch.configureBlocking(false);
        return ch;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected NioSctpSession newSession(IoProcessor<NioSctpSession> processor, SctpChannel handle) {
        NioSctpSession session =  new NioSctpSession(this, processor, handle);
        return session;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void register(SctpChannel handle, ConnectionRequest request)
            throws Exception {
        handle.register(selector, SelectionKey.OP_CONNECT, request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int select(int timeout) throws Exception {
        return selector.select(timeout);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Iterator<SctpChannel> selectedHandles() {
        return new SctpChannelIterator(selector.selectedKeys());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void wakeup() {
        selector.wakeup();
    }

    private static class SctpChannelIterator implements Iterator<SctpChannel> {

        private final Iterator<SelectionKey> i;

        private SctpChannelIterator(Collection<SelectionKey> selectedKeys) {
            this.i = selectedKeys.iterator();
        }

        /**
         * {@inheritDoc}
         */
        public boolean hasNext() {
            return i.hasNext();
        }

        /**
         * {@inheritDoc}
         */
        public SctpChannel next() {
            SelectionKey key = i.next();
            return (SctpChannel) key.channel();
        }

        /**
         * {@inheritDoc}
         */
        public void remove() {
            i.remove();
        }
    }
}
