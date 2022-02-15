/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.megaco.resource.impl.codec;

import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import javax.megaco.CommandEvent;
import mofokom.megaco.resource.impl.MegaCoResourceAdaptor;
import mofokom.megaco.resource.impl.codec.abnf.ParserContext;
import mofokom.megaco.resource.impl.codec.abnf.ParserException;
import mofokom.megaco.resource.impl.codec.abnf.Rule;
import mofokom.megaco.resource.impl.codec.abnf.Rule$megacoMessage;
import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;

/**
 *
 * @author wozza
 */
public class MessagePacketizer implements MessageDecoder {

    private Logger logger;
    private AbstractDefaultVisitor visitorStateMachine;
    private RecursiveVisitorWrapper r;

    public MessagePacketizer() {
        init();
    }

    public void init() {
        logger = Logger.getLogger("megaco.decode.abnf");
        visitorStateMachine = new AbstractDefaultVisitor();
        r = new RecursiveVisitorWrapper(visitorStateMachine, logger);
        visitorStateMachine.init();
    }

    @Override
    public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
        IoBuffer buffer = (IoBuffer) session.getAttribute("buffer");
        Integer depth = (Integer) session.getAttribute("depth");
        Integer offset = (Integer) session.getAttribute("offset");

        //logger.debug("decode " + in.toString());
        //TODO ADD TIMER for incomplete packet?

        if (depth == null)
            depth = 0;

        Boolean first = (Boolean) session.getAttribute("first");

        if (first == null)
            first = Boolean.TRUE;

        if (buffer == null) {
            session.setAttribute("buffer", buffer = IoBuffer.allocate(4098, true));
            buffer.setAutoExpand(true);
        }
        int j = 0;
        while (in.hasRemaining()) {
            //logger.debug("decode " + in.toString());
            byte[] b = new byte[Math.min(128, in.remaining())];

            in.get(b);

            for (int i = 0; i < b.length; i++) {
                //logger.info( i + " " + ((char)b[i]) + " " + depth);
                if (b[i] == '{') {
                    first = false;
                    depth++;
                } else if (b[i] == '}')
                    depth--;

                if (depth < 0) {
                    session.removeAttribute("buffer");
                    session.removeAttribute("depth");
                    session.removeAttribute("first");

                    IllegalStateException x = new IllegalStateException("too many closing braces for packet. " + buffer.toString(), new StreamCorruptedException(new StringBuilder(new String(b)).insert(i + 1, "<<<HERE").toString() + " " + in.toString()));
                    logger.error(x.getMessage(), x);
                    return NOT_OK;
                }

                if (depth == 0 && !first) {
                    j += i;
                    if (logger.isDebugEnabled())
                        logger.debug("message detected position " + j + " " + i + " " + b.length + " " + (char) b[i] + " " + in.toString() + " " + buffer.toString());

                    buffer.put(b, 0, i + 1);

                    /*
                     * if (i < b.length - 1) { logger.debug("remaining data,
                     * position " + j + " length " + b.length + " " + (char)
                     * b[i] + " " + in.toString()); }
                     */
                    in.position(j + 1);
                    session.setAttribute("offset", in.position());
                    session.setAttribute("depth", 0);
                    session.setAttribute("first", Boolean.TRUE);
                    return OK;
                }
            }
            j += b.length;
            buffer.put(b);
        }

        exit:
        session.setAttribute("depth", depth);
        session.setAttribute("first", first);

        return NEED_DATA;
    }

    @Override
    public MessageDecoderResult decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        IoBuffer buffer = (IoBuffer) session.getAttribute("buffer");

        int length = buffer.position();
        byte[] bytes = new byte[length];
        buffer.flip();
        buffer.get(bytes);
        buffer.flip();

        String packet = new String(bytes).trim();
        if (logger.isDebugEnabled())
            logger.debug("read message len:" + bytes.length + " \n^" + packet + "$");

        try {
            List<CommandEvent> events = (List<CommandEvent>) readResolve(packet);

            if (logger.isInfoEnabled()) //FIXME: debug
                logger.info(events.size() + " command event(s) resolved " + visitorStateMachine.getMessageHeader().toString());
            //TODO this in an executor?
            out.write(visitorStateMachine.getMessageHeader());
            //MegaCoResourceAdaptor ra = (MegaCoResourceAdaptor) session.getAttribute(MegaCoResourceAdaptor.class.getName());

            if (events.size() == 1)
                out.write(events.get(0));
            else if (events.size() > 1)
                out.write(Collections.unmodifiableList(events));
        } catch (Exception x) {
            //session.removeAttribute("offset");
            logger.error("read resolve " + x.getMessage(), x);
            return NOT_OK;
        }

        Integer offset = (Integer) session.getAttribute("offset");
        //logger.debug("offset " + offset + " " + buffer + " in " + in.toString()); //+ " >" + buf2string(in) + "<");

        in.position(in.position() + offset);
        return OK;
    }

    @Override
    public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
        logger.debug("****** finish decode ***********");
    }

    public Object readResolve(String content) throws ParserException {
        visitorStateMachine.reset();
        ParserContext context = new ParserContext(content, false);
        Rule rule = Rule$megacoMessage.parse(context);
        checkError(context);
        return rule.accept(r);
    }

    public boolean checkError(ParserContext context) throws ParserException {
        if (context.text.length() > context.index) {
            ParserException primaryError = new ParserException("codec error ", context.text, context.index, new Stack<String>());
            if (logger.isDebugEnabled())
                if (context.getErrorIndex() > context.index) {
                    ParserException secondaryError = new ParserException("rule \"" + (String) context.getErrorStack().peek() + "\" failed", context.text, context.getErrorIndex(), context.getErrorStack());
                    primaryError.initCause(secondaryError);
                }
            throw primaryError;
        }
        return true;
    }

    private static String buf2string(IoBuffer buf) {
        byte[] b = new byte[buf.limit()];
        buf.get(b);
        return new String(b);

    }
}
