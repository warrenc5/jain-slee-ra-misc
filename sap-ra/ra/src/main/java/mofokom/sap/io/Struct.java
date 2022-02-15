package mofokom.sap.io;

import java.io.Serializable;

/**
 * Interface Struct ...
 *
 * @author warren
 * Created on Mar 19, 2007
 */
public interface Struct extends Serializable
{
    /**
     * Method getVersion returns the version of this Struct object.
     *
     * @return the version (type byte) of this Struct object.
     */
    public byte getVersion();

    /**
     * Method getAddressType returns the addressType of this Struct object.
     *
     * @return the addressType (type byte) of this Struct object.
     */
    public byte getAddressType();

    /**
     * Method getAuthenticationLength returns the authenticationLength of this Struct object.
     *
     * @return the authenticationLength (type int) of this Struct object.
     */
    public int getAuthenticationLength();

    /**
     * Method getMessageIdHash returns the messageIdHash of this Struct object.
     *
     * @return the messageIdHash (type int) of this Struct object.
     */
    public int getMessageIdHash();

    /**
     * Method getMessageType returns the messageType of this Struct object.
     *
     * @return the messageType (type byte) of this Struct object.
     */
    public byte getMessageType();

    /**
     * Method isEncrypted returns the encrypted of this Struct object.
     *
     * @return the encrypted (type boolean) of this Struct object.
     */
    public boolean isEncrypted();

    /**
     * Method isCompressed returns the compressed of this Struct object.
     *
     * @return the compressed (type boolean) of this Struct object.
     */
    public boolean isCompressed();

    /**
     * Method getOriginatingSource returns the originatingSource of this Struct object.
     *
     * @return the originatingSource (type byte[]) of this Struct object.
     */
    public byte[] getOriginatingSource();

    /**
     * Method getAuthenticationData returns the authenticationData of this Struct object.
     *
     * @return the authenticationData (type byte[]) of this Struct object.
     */
    public byte[] getAuthenticationData();

    /**
     * Method getPayloadType returns the payloadType of this Struct object.
     *
     * @return the payloadType (type String) of this Struct object.
     */
    public String getPayloadType();

    /**
     * Method getPayload returns the payload of this Struct object.
     *
     * @return the payload (type byte[]) of this Struct object.
     */
    public byte[] getPayload();
    
    public int transmits();

    public static final int ANNOUNCEMENT=0;
    public static final int DELETION=1;
}
