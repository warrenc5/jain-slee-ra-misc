package mofokom.sap.io;

import java.io.IOException;
import java.net.DatagramPacket;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public abstract class AbstractHandler implements Runnable
{

    /** Field log  */
    protected final Logger log = Logger.getLogger(this.getClass().getName());
    /** Field stack  */
    protected final Stack stack;

    /**
     * Constructor AbstractHandler creates a new AbstractHandler instance.
     *
     * @param stack of type Stack
     */
    public AbstractHandler(Stack stack)
    {
        this.stack = stack;
    }

    /**
     * Method initialize ...
     * @throws IOException when
     */
    abstract void initialize() throws IOException;

    /**
     * Method teardown ...
     * @throws IOException when
     */
    abstract void teardown() throws IOException;

    /**
     * Method send ...
     *
     * @param buf of type byte[]
     * @param offset of type int
     * @param length of type int
     * @return int
     * @throws UnsupportedOperationException when
     * @throws IOException when
     */
    abstract int send(byte[] buf, int offset, int length) throws UnsupportedOperationException, IOException;

    /**
     * Method decodeBuffer ...
     *
     * @param datagram of type DatagramPacket
     * @throws IOException when
     */
    void decodeBuffer(DatagramPacket datagram) throws IOException
    {

        // TODO: account for fragmentated packets and packet loss here

        final Struct struct = new StructImpl(datagram.getData(), datagram.getOffset(), datagram.getLength());

        stack.notifyListenersMessageReceived(datagram.getAddress(), struct);

    }

    /**
     * this method is for testing purposes only and will not be used by production code
     * HACK:
     *
     * @param data
     * @param offset
     * @param length
     * @return
     */
    Struct decodeBuffer(byte[] data, int offset, int length)
    {
        return new StructImpl(data, offset, length);
    }

    /**
     * Method encodeBuffer ...
     *
     * @param message of type Struct
     * @return byte[]
     * @throws IllegalArgumentException when
     */
    byte[] encodeBuffer(Struct message) throws IllegalArgumentException
    {

        if (message.getAuthenticationData() != null && message.getAuthenticationLength() * 4 != message.getAuthenticationData().length)
        {
            throw new IllegalArgumentException("Authentication Length Header does not match optional authentication data field");
        }

        if (message.getAuthenticationData() == null && message.getAuthenticationLength() != 0)
        {
            throw new IllegalArgumentException("Authentication Length Header invalid for missing optional authentication data field");
        }

        if (message.getMessageIdHash() == 0)
        {
            throw new IllegalArgumentException("Message ID hash MUST be specified");
        }

        if (message.getOriginatingSource() == null)
        {
            throw new IllegalArgumentException("Originating address MUST be specified");
        }

        if (message.getAddressType() == 0 && message.getOriginatingSource().length != 4)
        {
            throw new IllegalArgumentException("Originating address length not correct for IPV4 address");
        }

        if (message.getAddressType() == 1 && message.getOriginatingSource().length != 16)
        {
            throw new IllegalArgumentException("Originating address length not correct for IPV6 address");
        }

        final byte[] data = new byte[stack.getDatagramBufferLength()];
        int p = 0, l = 0;

        final byte b = (byte) (
            message.getVersion() << 5
                ^ message.getAddressType() << 4
                ^ 0 //reserved
                ^ message.getMessageType() << 2
                ^ (message.isEncrypted() ? 1 : 0) << 1
                ^ (message.isCompressed() ? 1 : 0)
        );

        if (log.isEnabledFor(Level.DEBUG))
        {
            log.debug("byte0 is " + b);
        }

        data[p++] = (byte) b;

        data[p++] = Integer.valueOf(message.getAuthenticationLength()).byteValue();
        int hashCode = message.getMessageIdHash();

        //low byte
        data[p++] = (byte) (hashCode << 24 >> 24);
        //high byte
        data[p++] = (byte) (hashCode >> 8); 

        System.arraycopy(message.getOriginatingSource(), 0, data, p, l = message.getAddressType() == 0 ? 4 : 16);

        p += l;
        if (message.getAuthenticationLength() > 0)
        {
            System.arraycopy(message.getAuthenticationData(), 0, data, p, l = message.getAuthenticationLength() * 4);
            p += l;
        }

        System.arraycopy(message.getPayloadType().getBytes(), 0, data, p, l = message.getPayloadType().getBytes().length);

        p += l;

        data[p++] = 0x0; // payload type field terminator

        //TODO: perhaps throw exception here if no payload specified? - what about in the case of deletions?


        if ((l = message.getPayload().length) > data.length - p)
        {
            throw new IllegalArgumentException("payload too big for packet:" + stack.getDatagramBufferLength());
        }        
        
        System.arraycopy(message.getPayload(), 0, data, p , l);
        
        p += l; 
        final byte[] src = new byte[p];

        System.arraycopy(data, 0, src, 0, p);

        if (log.isEnabledFor(Level.DEBUG))
        {
            log.debug("data length :" + p);
        }

        if (log.isEnabledFor(Level.DEBUG))
        {
            for (int i = 0; i < src.length; i++)
            {
                log.debug(i + " " + src[i] + " " + (char) src[i]);
            }
        }

        return src;
    }
}
