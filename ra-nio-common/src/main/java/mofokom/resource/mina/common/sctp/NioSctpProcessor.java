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

import com.sun.nio.sctp.MessageInfo;
import com.sun.nio.sctp.SctpChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.file.FileRegion;
import org.apache.mina.core.polling.AbstractPollingIoProcessor;
import org.apache.mina.core.session.SessionState;

/**
 * TODO Add documentation
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class NioSctpProcessor extends AbstractPollingIoProcessor<NioSctpSession> {

    /**
     * The selector associated with this processor
     */
    private Selector selector;


    /**
     *
     * Creates a new instance of NioProcessor.
     *
     * @param executor
     */
    public NioSctpProcessor(Executor executor) {
        super(executor);

        try {
            // Open a new selector
            selector = Selector.open();
        } catch (IOException e) {
            throw new RuntimeIoException("Failed to open a selector.", e);
        }
    }

    @Override
    protected void doDispose() throws Exception {
        selector.close();
    }

    @Override
    protected int select(long timeout) throws Exception {
        return selector.select(timeout);
    }

    @Override
    protected int select() throws Exception {
        return selector.select();
    }

    @Override
    protected boolean isSelectorEmpty() {
        return selector.keys().isEmpty();
    }

    @Override
    protected void wakeup() {
        wakeupCalled.getAndSet(true);
        selector.wakeup();
    }

    @Override
    protected Iterator<NioSctpSession> allSessions() {
        return new IoSessionIterator(selector.keys());
    }

    @SuppressWarnings("synthetic-access")
    @Override
    protected Iterator<NioSctpSession> selectedSessions() {
        return new IoSessionIterator(selector.selectedKeys());
    }

    @Override
    protected void init(NioSctpSession session) throws Exception {
        SelectableChannel ch = (SelectableChannel) session.getChannel();
        ch.configureBlocking(false);
        session.setSelectionKey(ch.register(selector, SelectionKey.OP_READ,
                session));
    }

    @Override
    protected void destroy(NioSctpSession session) throws Exception {
        SctpChannel ch = session.getChannel();
        SelectionKey key = session.getSelectionKey();
        if (key != null)
            key.cancel();
        ch.close();
    }

    /**
     * In the case we are using the java select() method, this method is used to
     * trash the buggy selector and create a new one, registering all the
     * sockets on it.
     */
    @Override
    protected void registerNewSelector() throws IOException {
        synchronized (selector) {
            Set<SelectionKey> keys = selector.keys();

            // Open a new selector
            Selector newSelector = Selector.open();

            // Loop on all the registered keys, and register them on the new selector
            for (SelectionKey key : keys) {
                SelectableChannel ch = key.channel();

                // Don't forget to attache the session, and back !
                NioSctpSession session = (NioSctpSession) key.attachment();
                SelectionKey newKey = ch.register(newSelector, key.interestOps(), session);
                session.setSelectionKey(newKey);
            }

            // Now we can close the old selector and switch it
            selector.close();
            selector = newSelector;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isBrokenConnection() throws IOException {
        // A flag set to true if we find a broken session

        boolean brokenSession = false;

        synchronized (selector) {
            // Get the selector keys
            Set<SelectionKey> keys = selector.keys();

            // Loop on all the keys to see if one of them
            // has a closed channel
            for (SelectionKey key : keys) {
                SelectableChannel channel = key.channel();

                //FIXME
                Thread.dumpStack();
                if ((((channel instanceof SctpChannel) && ((SctpChannel) channel).isConnectionPending()))) {
                    // The channel is not connected anymore. Cancel
                    // the associated key then.
                    key.cancel();

                    // Set the flag to true to avoid a selector switch
                    brokenSession = true;
                }
            }
        }

        return brokenSession;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected SessionState getState(NioSctpSession session) {
        SelectionKey key = session.getSelectionKey();

        if (key == null)
            // The channel is not yet registred to a selector
            return SessionState.OPENING;

        if (key.isValid())
            // The session is opened
            return SessionState.OPENED;
        else
            // The session still as to be closed
            return SessionState.CLOSING;
    }

    @Override
    protected boolean isReadable(NioSctpSession session) {
        SelectionKey key = session.getSelectionKey();
        return key.isValid() && key.isReadable();
    }

    @Override
    protected boolean isWritable(NioSctpSession session) {
        SelectionKey key = session.getSelectionKey();
        return key.isValid() && key.isWritable();
    }

    @Override
    protected boolean isInterestedInRead(NioSctpSession session) {
        SelectionKey key = session.getSelectionKey();
        return key.isValid() && ((key.interestOps() & SelectionKey.OP_READ) != 0);
    }

    @Override
    protected boolean isInterestedInWrite(NioSctpSession session) {
        SelectionKey key = session.getSelectionKey();
        return key.isValid()
                && ((key.interestOps() & SelectionKey.OP_WRITE) != 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setInterestedInRead(NioSctpSession session, boolean isInterested)
            throws Exception {
        SelectionKey key = session.getSelectionKey();
        int oldInterestOps = key.interestOps();
        int newInterestOps = oldInterestOps;

        if (isInterested)
            newInterestOps |= SelectionKey.OP_READ;
        else
            newInterestOps &= ~SelectionKey.OP_READ;

        if (oldInterestOps != newInterestOps)
            key.interestOps(newInterestOps);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setInterestedInWrite(NioSctpSession session, boolean isInterested)
            throws Exception {
        SelectionKey key = session.getSelectionKey();

        if (key == null)
            return;

        int newInterestOps = key.interestOps();

        if (isInterested)
            newInterestOps |= SelectionKey.OP_WRITE; //newInterestOps &= ~SelectionKey.OP_READ;
        else
            newInterestOps &= ~SelectionKey.OP_WRITE; //newInterestOps |= SelectionKey.OP_READ;

        key.interestOps(newInterestOps);
    }

    @Override
    protected int read(NioSctpSession session, IoBuffer buf) throws Exception {
        SctpChannel channel = session.getChannel();
        MessageInfo messageInfo = null;
        ByteBuffer buffy = ByteBuffer.allocate(10000);
        int bytes=0;

        messageInfo = channel.receive(buffy, session, session.getAssociationNotificationHandler());

        if(messageInfo!=null) {
            bytes = messageInfo.bytes();
        }
        session.setIncommingMessageInfo(messageInfo);

        if (buffy.position() > 0) {

            buffy.flip();
            buf.put(buffy);
        }

        return bytes;//(buf.position());
    }

    @Override
    protected int write(NioSctpSession session, IoBuffer buf, int length)
            throws Exception {
        SctpChannel channel = session.getChannel();

        MessageInfo messageInfo = session.getOutgoingMessageInfo();

        ByteBuffer buffy = ByteBuffer.allocate(length);
        byte[] b = new byte[length];

        buf.get(b);
        buffy.put(b);
        buffy.flip();
        return channel.send(buffy, messageInfo);
    }

    @Override
    protected int transferFile(NioSctpSession session, FileRegion region, int length)
            throws Exception {
        throw new IllegalAccessException("not implemented");
        /*
         * try { return (int) region.getFileChannel().transferTo(
         * region.getPosition(), length, session.getChannel()); } catch
         * (IOException e) { // Check to see if the IOException is being thrown
         * due to // http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=5103988
         * String message = e.getMessage(); if ((message != null) &&
         * message.contains("temporarily unavailable")) return 0;
         *
         * throw e; }
         *
         */
    }

    /**
     * An encapsulating iterator around the {@link Selector#selectedKeys()} or
     * the {@link Selector#keys()} iterator;
     */
    protected static class IoSessionIterator<NioSctpSession> implements
            Iterator<NioSctpSession> {

        private final Iterator<SelectionKey> iterator;

        /**
         * Create this iterator as a wrapper on top of the selectionKey Set.
         *
         * @param keys The set of selected sessions
         */
        private IoSessionIterator(Set<SelectionKey> keys) {
            iterator = keys.iterator();
        }

        /**
         * {@inheritDoc}
         */
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * {@inheritDoc}
         */
        public NioSctpSession next() {
            SelectionKey key = iterator.next();
            NioSctpSession NioSctpSession = (NioSctpSession) key.attachment();
            return NioSctpSession;
        }

        /**
         * {@inheritDoc}
         */
        public void remove() {
            iterator.remove();
        }
    }
}