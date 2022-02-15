package mofokom.megaco.resource.impl.codec;

import java.util.List;
import javax.megaco.CommandEvent;
import javax.megaco.message.ContextInfoReq;
import mofokom.resource.mina.common.codec.AbstractABNFProtocolEncoder;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;
import static mofokom.megaco.resource.impl.codec.Constants.*;
import org.apache.log4j.Logger;

/**
 *
 * @author wozza
 */
public class ABNFProtocolEncoder extends AbstractABNFProtocolEncoder {

    private Logger logger = Logger.getLogger("megaco.encode.abnf");
    private final ObjectEncoder encoder;

    abstract class DefaultMessageEncoder<T> implements MessageEncoder<T> {

        public DefaultMessageEncoder() {
        }

        @Override
        public void encode(IoSession session, T message, ProtocolEncoderOutput out) throws Exception {
            if (message == null)
                throw new Exception(new NullPointerException("can't encode null message "));
            IoBuffer buffer = (IoBuffer) session.getAttribute("buffer");
            StringBuffer buffy = (StringBuffer) session.getAttribute("buffy");
            if (buffy == null) {
                buffy = new StringBuffer();
                session.setAttribute("buffy", buffy);
            }

            if (buffer == null) {
                session.setAttribute("buffer", (buffer = IoBuffer.allocate(2048, false))); //TODO get from RA CP
                buffer.setAutoExpand(true);
            }


            if (encode(session, message, buffy)) {
                buffer.put(buffy.toString().getBytes());
                buffer.flip();

                //TODO
                logger.debug(buffy.toString());

                buffy.setLength(0);
                out.write(buffer);
                //out.mergeAll();
                out.flush();
                //buffer.flip();
            }
        }

        abstract boolean encode(IoSession session, T message, StringBuffer buffer) throws Exception;
    }

    public ABNFProtocolEncoder(IoSession is) {
        this.encoder = new ObjectEncoder();
        this.addMessageEncoder(List.class, new DefaultMessageEncoder<List>() {

            @Override
            boolean encode(IoSession session, List message, StringBuffer buffy) throws Exception {
                buffy.append(LBRKT).append(EOL);

                if (message.isEmpty()) {
                    MessageHeader header = (MessageHeader) session.getAttribute(MessageHeader.class.getName());
                    if (!header.isPending() && !header.isTransactionResponseAck())
                        throw new Exception("No commands for transaction/reply");

                } else {
                    encoder.encode(buffy, ((CommandEvent) message.get(0)).getCntxtInfo());

                    if (message.get(0) instanceof ContextInfoReq) {
                    } else {
                        buffy.append(LBRKT).append(EOL);
                        encoder.encode(buffy, message);
                        buffy.append(RBRKT).append(EOL);
                    }
                    buffy.append(RBRKT).append(EOL);
                }
                return true;
            }
        });
        this.addMessageEncoder(CommandEvent.class, new DefaultMessageEncoder<CommandEvent>() {

            @Override
            boolean encode(IoSession session, CommandEvent message, StringBuffer buffy) throws Exception {
                buffy.append(LBRKT).append(EOL);

                encoder.encode(buffy, message.getCntxtInfo());

                if (message instanceof ContextInfoReq) {
                } else {
                    buffy.append(LBRKT).append(EOL);
                    encoder.encode(buffy, message);
                    buffy.append(RBRKT).append(EOL);
                }
                buffy.append(RBRKT).append(EOL);
                return true;
            }
        });
        this.addMessageEncoder(MessageHeader.class, new DefaultMessageEncoder<MessageHeader>() {

            @Override
            boolean encode(IoSession session, MessageHeader message, StringBuffer buffy) throws Exception {
                session.setAttribute(MessageHeader.class.getName(), message);
                encoder.encode(buffy, message);
                if (message.isPending() || message.isTransactionResponseAck())
                    return true;
                else
                    return false;
            }
        });
    }
}