/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.telnet.common;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.List;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.ConfigProperties.Property;
import mofokom.resource.common.AbstractTransaction;
import mofokom.resource.common.TransactionException;
import mofokom.resource.common.UsageParameters;
import mofokom.resource.mina.common.AbstractMinaResourceAdaptor;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 *
 * @author wozza
 */
public abstract class TelnetResourceAdaptor<ACTIVITY extends AbstractTransaction, AHO extends Serializable, USAGE extends UsageParameters> extends AbstractMinaResourceAdaptor<ACTIVITY, AHO, USAGE> implements ProtocolCodecFactory {

    private Boolean ENABLE_TELNET_NEGOTIATION;

    @Override
    public abstract ProtocolDecoder initializeDecoder(IoSession is) throws Exception;

    @Override
    public abstract ProtocolEncoder initializeEncoder(IoSession is) throws Exception;

    @Override
    public void initializeConnector(IoConnector connector) throws UnknownHostException, InterruptedException, IOException {

        if (ENABLE_TELNET_NEGOTIATION) {
            tracer.info("Telnet negoation enabled " + connector);
            connector.getFilterChain().addLast("telnet", new ProtocolCodecFilter(new SessionDelegateProtocolCodecFactory(this)));
        }

        super.initializeConnector(connector);

    }

    @Override
    protected void initializeAcceptor(IoAcceptor acceptor, List socketAddress) throws IOException, UnknownHostException, InterruptedException {
        acceptor.getFilterChain().addLast("telnet", new ProtocolCodecFilter(new SessionDelegateProtocolCodecFactory(this)));
        super.initializeAcceptor(acceptor, socketAddress);
    }

    @Override
    public void raConfigure(ConfigProperties properties) {
        super.raConfigure(properties);
        ENABLE_TELNET_NEGOTIATION = (Boolean) properties.getProperty("ENABLE_TELNET_NEGOTIATION").getValue();
    }

    @Override
    public ACTIVITY createActivity(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession session) throws Exception {
        return new TelnetCommandCodec(this);

    }

    @Override
    public ProtocolEncoder getEncoder(IoSession session) throws Exception {
        return new TelnetCommandCodec(this);
    }

    @Override
    public abstract boolean useProtocolCodec();

    @Override
    public Object getResourceAdaptorInterface(String className) {
        return this;
    }

    public void testStart() throws UnknownHostException, InterruptedException, IOException {
        initializeConnectors();
        Thread.sleep(3000L);
        for (IoSession e : super.clientSessionMap.values()) {
            tracer.info(e + " writing " );
            byte[] data = new byte[]{TelnetCommand.IAC.byteValue(), TelnetCommand.WILL.byteValue(),
                0x25, TelnetCommand.IAC.byteValue(), TelnetCommand.ARE_YOU_THERE.byteValue(),};

            write(e, data);
            data = new byte[]{
                TelnetCommand.IAC.byteValue(), TelnetCommand.GO_AHEAD.byteValue()
            };
            write(e, data);

        }
    }
}
