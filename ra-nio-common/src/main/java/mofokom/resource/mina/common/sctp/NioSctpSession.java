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

import com.sun.nio.sctp.AssociationChangeNotification.AssocChangeEvent;
import com.sun.nio.sctp.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.file.FileRegion;
import org.apache.mina.core.filterchain.DefaultIoFilterChain;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.service.DefaultTransportMetadata;
import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.TransportMetadata;
import org.apache.mina.core.session.AbstractIoSession;
import org.apache.mina.core.session.AbstractIoSessionConfig;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.transport.socket.SocketSessionConfig;

/**
 * An {@link IoSession} for socket transport (TCP/IP).
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class NioSctpSession extends AbstractIoSession {

    static final TransportMetadata METADATA = new DefaultTransportMetadata("sctp", "socket", false, true,
            InetSocketAddress.class, SocketSessionConfig.class, IoBuffer.class, FileRegion.class);
    /**
     * The NioSctpSession processor
     */
    protected final IoProcessor<NioSctpSession> processor;
    /**
     * The communication channel
     */
    protected final SctpChannel channel;
    /**
     * The SelectionKey used for this session
     */
    protected SelectionKey key;
    /**
     * The FilterChain created for this session
     */
    private final IoFilterChain filterChain;
    private MessageInfo incommingMessageInfo;
    private NotificationHandler associationHandler;
    private Association association;

    @Override
    public IoFilterChain getFilterChain() {
        return filterChain;
    }

    /**
     * @return The {@link SelectionKey} associated with this {@link IoSession}
     */
    /*
     * No qualifier
     */
    SelectionKey getSelectionKey() {
        return key;
    }

    /**
     * Sets the {@link SelectionKey} for this {@link IoSession}
     *
     * @param key The new {@link SelectionKey}
     */
    /*
     * No qualifier
     */
    void setSelectionKey(SelectionKey key) {
        this.key = key;
    }

    /**
     * {@inheritDoc}
     */
    public IoProcessor<NioSctpSession> getProcessor() {
        return processor;
    }

    /**
     *
     * Creates a new instance of NioSctpSession.
     *
     * @param service the associated IoService
     * @param processor the associated IoProcessor
     * @param ch the used channel
     */
    public NioSctpSession(IoService service, IoProcessor<NioSctpSession> processor, SctpChannel channel) {
        super(service);
        this.channel = channel;
        this.processor = processor;
        filterChain = new DefaultIoFilterChain(this);
        associationHandler = new AssociationHandler();
        config = new SessionConfigImpl();
        this.config.setAll(service.getSessionConfig());
    }

    public TransportMetadata getTransportMetadata() {
        return METADATA;
    }

    /**
     * {@inheritDoc}
     */
    public IoSessionConfig getConfig() {
        return config;
    }

    /**
     * {@inheritDoc}
     */
    public InetSocketAddress getRemoteAddress() {
        if (channel == null)
            return null;
        try {
            if (channel.getRemoteAddresses().iterator().hasNext())
                return (InetSocketAddress) channel.getRemoteAddresses().iterator().next();
            else
                return null;
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public InetSocketAddress getLocalAddress() {
        if (channel == null)
            return null;
        try {
            if (channel.getRemoteAddresses().iterator().hasNext())
                return (InetSocketAddress) channel.getAllLocalAddresses().iterator().next();
            else
                return null;
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public InetSocketAddress getServiceAddress() {
        return (InetSocketAddress) super.getServiceAddress();
    }

    SctpChannel getChannel() {
        return channel;
    }

    MessageInfo getOutgoingMessageInfo() {
        return MessageInfo.createOutgoing(null, 0);
    }

    NotificationHandler<NioSctpSession> getAssociationNotificationHandler() {
        return associationHandler;
    }

    void setIncommingMessageInfo(MessageInfo messageInfo) {
        this.incommingMessageInfo = messageInfo;
    }

    private void setAssociation(Association association) {
        this.association = association;
    }

    public Association getAssociation() {
        return association;
    }

    private class SessionConfigImpl extends AbstractIoSessionConfig {

        @Override
        protected void doSetAll(IoSessionConfig config) {
        }
    }

    static class AssociationHandler
            extends AbstractNotificationHandler<NioSctpSession> {

        private Logger logger = Logger.getLogger(NioSctpSession.class.getSimpleName());

        public HandlerResult handleNotification(AssociationChangeNotification not, NioSctpSession session) {
            if (not.event().equals(AssocChangeEvent.COMM_UP)) {
                int outbound = not.association().maxOutboundStreams();
                int inbound = not.association().maxInboundStreams();
                logger.info("association setup. " + not.association().associationID());
                session.setAssociation(not.association());
         //       session.getFilterChain().fireSessionOpened();
            }else if (not.event().equals(AssocChangeEvent.COMM_LOST)) {
                logger.info("association lost. " + not.association().associationID());
        //        session.getFilterChain().fireSessionClosed();
            }else if (not.event().equals(AssocChangeEvent.CANT_START)) {
                logger.info("association can't start. " + not.association().associationID());
       //         session.getFilterChain().fireSessionClosed();
            }

            return HandlerResult.CONTINUE;
        }

        public HandlerResult handleNotification(ShutdownNotification not, NioSctpSession session) {
            logger.warn("association shutdown. " + not.association().associationID());
      //      session.getFilterChain().fireSessionClosed();
            return HandlerResult.RETURN;
        }

        @Override
        public HandlerResult handleNotification(PeerAddressChangeNotification pacn, NioSctpSession session) {
            logger.warn("association peer change. " +pacn.association().associationID() + " " + pacn.address());
    //        session.getFilterChain().fireSessionClosed();
     //       session.getFilterChain().fireSessionOpened();
            return HandlerResult.CONTINUE;
        }

        @Override
        public HandlerResult handleNotification(SendFailedNotification sfn, NioSctpSession session) {
            logger.warn("association send fail. " + sfn.association().associationID() +" " + sfn.address());
            session.getFilterChain().fireSessionClosed();
            return HandlerResult.RETURN;
        }
    }
}
