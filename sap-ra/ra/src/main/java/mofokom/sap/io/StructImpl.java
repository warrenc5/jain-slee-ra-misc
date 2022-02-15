package mofokom.sap.io;

import java.util.Arrays;
import java.io.Serializable;

import org.apache.log4j.Logger;

final class StructImpl implements Struct, Serializable
{

    private static final byte BITMASK_VERSION = (byte) (128 + 64 + 32);
    private static final byte BITMASK_ADDRESS_TYPE = 16;
    private static final byte BITMASK_RESERVED = 8;
    private static final byte BITMASK_MESSAGE_TYPE = 4;
    private static final byte BITMASK_ENCRYPTION = 2;
    private static final byte BITMASK_COMPRESSION = 1;
    private static final byte BITMASK_AUTHENTICATION_LENGTH = -127;

    private transient final byte[] data;
    private byte[] originatingSource;
    private byte[] authenticationData;
    private byte[] payload;

    private byte version;
    private byte addressType;
    private boolean encrypted;
    private boolean compressed;
    private byte messageType;
    private int authenticationLength;
    private int messageIdHash;
    private int transmitCount;
    private String payloadType;
    protected transient final Logger log = Logger.getLogger(Handler.class.getName());

    public StructImpl(byte[] buf)
    {
        this.data = buf;
    }

    public StructImpl(byte[] buf, int offset, int length) throws UnsupportedOperationException
    {
        //create a heap data buffer
        this.data = new byte[length - offset];
        System.arraycopy(buf, offset, data, 0, length);

        parsePopulateStruct();
    }
    
    StructImpl(final byte version, final byte addressType, final byte reserved, final byte messageType, final boolean encrypted, final boolean compressed, final int authenticationLength, final int messageIdHash, final byte[] originatingSource, final byte[] authenticationData, final String payloadType, final byte[] payload){

        this.version=version;
        this.addressType=addressType;
        //this.reserved=reserved;
        this.messageType=messageType;
        this.encrypted=encrypted;
        this.compressed=compressed;
        this.authenticationLength=authenticationLength;
        this.messageIdHash=messageIdHash;
        this.originatingSource=originatingSource;
        this.authenticationData=authenticationData;
        this.payloadType=payloadType;
        this.payload=payload;
        data=null;
    }

    public String toString()
    {
        final StringBuffer buffy = new StringBuffer();
        buffy.append(
            version + " " + addressType + " 0 " + messageType + " " + encrypted + " " + compressed + " " + authenticationLength + " " + messageIdHash)
            .append(' ')
            .append(Arrays.toString(originatingSource))
            .append(' ')
            .append(Arrays.toString(authenticationData))
            .append(' ')
            .append(payloadType)
            .append(' ')
            .append(Arrays.toString(payload));

        return buffy.toString();
    }

    public byte getVersion()
    {
        return version;
    }

    public byte getAddressType()
    {
        return addressType;
    }

    public int getAuthenticationLength()
    {
        return authenticationLength;
    }

    public int getMessageIdHash()
    {
        return messageIdHash;
    }

    public byte getMessageType()
    {
        return messageType;
    }

    public boolean isEncrypted()
    {
        return encrypted;
    }

    public boolean isCompressed()
    {
        return compressed;
    }

    public byte[] getOriginatingSource()
    {
        return originatingSource;
    }

    public byte[] getAuthenticationData()
    {
        return authenticationData;
    }

    public String getPayloadType()
    {
        return payloadType;
    }

    public byte[] getPayload()
    {
        return payload;
    }

    public int hashCode()
    {
        return messageIdHash;
    }

    public int transmits(){
        return ++transmitCount;
    }

    private void parsePopulateStruct() throws UnsupportedOperationException
    {

        version = (byte) ((data[0] & BITMASK_VERSION) >> 5);

        if (version != 1)
        {
            throw new UnsupportedOperationException("Version " + version + " not supported");
        }

        addressType = (byte) ((data[0] & BITMASK_ADDRESS_TYPE) >> 4);

        /**
         * ignored in this version
         * reserved=data[0]& BITMASK_RESERVED >> 3;
         *
         */

        messageType = (byte) ((data[0] & BITMASK_MESSAGE_TYPE) >> 2);

        encrypted = (data[0] & BITMASK_ENCRYPTION) == BITMASK_ENCRYPTION;

        compressed = (data[0] & BITMASK_COMPRESSION) == BITMASK_COMPRESSION;

        authenticationLength = (int) data[1];

        int l = ((data[2] >>> 31) << 7) | (data[2] & 0xff);
        int h = ((data[3] & 0xff) | ((data[3] >>> 31) << 7) ) << 8;

        messageIdHash = l+h;

        //check the address type to see if ipv4 or ipv6

        int len = addressType == 0 ? 4 : 16;
        int p = 4;

        //allocate
        originatingSource = new byte[len];
        System.arraycopy(data, 4, originatingSource, 0, len);

        p = p + len;

        //calculate 32bit words in bytes
        len = authenticationLength * 4;

        if (len > 0)
        {
            //allocate
            authenticationData = new byte[len];
            System.arraycopy(data, 4, originatingSource, 0, len);
            p = p + len;
        }

        //read content type
        int b;

        b = data[p++];

        if (b != 0)
        {
            final StringBuffer buffy = new StringBuffer(14);

            do
            {

                buffy.append((char) b);
                b = data[p++];

            } while (b != 0 && p < data.length);

            payloadType = buffy.toString();
        }

        final StringBuffer buffy = new StringBuffer(data.length - p);

        while (p < data.length)
        {
            buffy.append((char) data[p++]);
        }

        //BUG: toString creates immutable tring here
        payload = buffy.toString().getBytes();

    }
}

