/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.telnet.common;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.*;
import mofokom.resource.telnet.common.TelnetCommand;
import static mofokom.resource.telnet.common.TelnetCommand.*;
import org.apache.log4j.Logger;

/**
 *
 * @author wozza
 */
public class TelnetCommandCodec implements ProtocolEncoder, ProtocolDecoder {

    private final TelnetResourceAdaptor ra;
    private Map<TelnetCommand, List> sessionConfig;
    private Logger logger;
    private TelnetCommand state;

    TelnetCommandCodec(TelnetResourceAdaptor ra) {
        this.ra = ra;
        this.logger = Logger.getLogger(this.getClass().getSimpleName());
    }

    private void initializeSessionConfig() {
        sessionConfig = new EnumMap<TelnetCommand, List>(TelnetCommand.class);
    }

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        IoBuffer buffy = null;
        if (message instanceof LinkedHashMap) {
            logger.debug("Array of telnet commands");

            LinkedHashMap<TelnetCommand[], Byte[]> commands = (LinkedHashMap<TelnetCommand[], Byte[]>) message;
            buffy = IoBuffer.allocate(commands.size());

            for (Entry<TelnetCommand[], Byte[]> e : commands.entrySet()) {
                processTelnetCommand(buffy, e.getKey(), e.getValue());
            }

        } else if (message.getClass().isArray() && message.getClass().getDeclaringClass().isAssignableFrom(TelnetCommand.class)) {
            logger.debug("Array of telnet commands");
            buffy = IoBuffer.allocate(((TelnetCommand[]) message).length);
            processTelnetCommand(buffy, (TelnetCommand[]) message, null);
        } else if (message instanceof List) {
            logger.debug("List of telnet commands");
            List<TelnetCommand> commands = (List<TelnetCommand>) message;
            buffy = IoBuffer.allocate(commands.size());
                processTelnetCommand(buffy, commands.toArray(new TelnetCommand[commands.size()]), null);
        } else if (message instanceof TelnetCommand) {
            logger.debug("single telnet commands");
            TelnetCommand command = (TelnetCommand) message;
            processTelnetCommand(buffy, new TelnetCommand[]{command}, null);
        }
        if (buffy != null)
            out.write(message);
    }

    @Override
    public void dispose(IoSession session) throws Exception {
    }

    @Override
    public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        byte[] data = new byte[in.remaining()];

        in.get(data);
        logger.debug(new String(data));
        in.flip();

        for (int i = 0; i < data.length; i++) {
            byte b = data[i];
            processByte(b, session);
        }

    }

    @Override
    public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
    }

    private void processByte(byte b, IoSession session) {
        state = (TelnetCommand) session.getAttribute(TelnetCommand.class.getName());
        switch (state) {
            case IAC:
                if (b == TelnetCommand.IAC.byteValue()) {
                }
                if (b == TelnetCommand.DO.byteValue())
                    state = TelnetCommand.DO;
                if (b == TelnetCommand.DONT.byteValue())
                    state = TelnetCommand.DONT;

                break;
            case DO:
                break;
            case DONT:
                break;
        }
        session.setAttribute(TelnetCommand.class.getName(), state);
    }

    private IoBuffer processTelnetCommand(IoBuffer buffy, TelnetCommand[] tc, Byte[] data) {
        for (TelnetCommand t : tc) {
            buffy.put(t.byteValue());
        }

        for (Byte b : data) {
            buffy.put(b);
        }

        return buffy;
    }
}
