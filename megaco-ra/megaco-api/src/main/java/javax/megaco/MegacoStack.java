package javax.megaco;

/**
 * This interface defines the methods that are required to represent a
 * proprietary JAIN MEGACO protocol stack, the implementation of which will be
 * vendor-specific. Methods are defined for creating and deleting instances of a
 * MegacoProvider.
 * 
 * 
 */
public interface MegacoStack {
    /**
     * 
     * @return
     * @throws javax.megaco.CreateProviderException
     */
    public MegacoProvider createProvider()
			throws javax.megaco.CreateProviderException;

    /**
     * 
     * @param MegacoProvider
     * @throws javax.megaco.DeleteProviderException
     */
    public void deleteProvider(MegacoProvider MegacoProvider)
			throws javax.megaco.DeleteProviderException;

    /**
     * 
     * @param assocHandle
     * @return
     * @throws javax.megaco.NonExistentAssocException
     */
    public MegacoProvider getProvider(int assocHandle)
			throws javax.megaco.NonExistentAssocException;

    /**
     * 
     * @return
     */
    public java.lang.String getProtocolVersion();

    /**
     * 
     * @param protocolVersion
     * @throws javax.megaco.VersionNotSupportedException
     */
    public void setProtocolVersion(java.lang.String protocolVersion)
			throws javax.megaco.VersionNotSupportedException;


}
