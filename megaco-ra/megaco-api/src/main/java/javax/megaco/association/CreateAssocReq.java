/**
 * Start time:11:45:35 2009-01-30<br> Project:
 * mobicents-media-server-controllers<br>
 *
 * @author <a href="mailto:baranowb@gmail.com">baranowb - Bartosz Baranowski
 * </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
package javax.megaco.association;

import java.io.Serializable;

import javax.megaco.AssociationEvent;

/**
 * The class extends JAIN MEGACO Association Events. This would cause the stack
 * to configure the association with the parameters specified and initiate the
 * protocol procedures to create an association with the peer. If the
 * application is MGC, then the stack would expect ServiceChange messages from
 * MG. And if the application if MG, then the stack would send ServiceChange
 * command with the specified ServiceChangeMethod and ServiceChangeReason to
 * MGC.
 */
public class CreateAssocReq extends AssociationEvent implements Serializable {

    /**
     *
     */
    protected LocalAddr localAddr = null;
    /**
     *
     */
    protected RemoteAddr[] remoteAddr = null;
    /**
     *
     */
    protected SrvChngReason srvChangeReason = null;
    /**
     *
     */
    protected SrvChngMethod srvChngMethod = null;
    /**
     *
     */
    protected LocalAddr srvChngAddress = null;
    /**
     *
     */
    protected LocalAddr handOffMGCId = null;
    /**
     *
     */
    protected EncodingFormat endcodingFormat = null;

    /**
     *
     * @param source
     * @param assocHandle
     * @throws IllegalArgumentException
     */
    public CreateAssocReq(Object source, int assocHandle)
            throws IllegalArgumentException {
        super(source, assocHandle);

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.megaco.AssociationEvent#getAssocOperIdentifier()
     */
    @Override
    public int getAssocOperIdentifier() {
        return AssocEventType.M_CREATE_ASSOC_REQ;
    }

    /**
     * Gets the local entity transport address. The local address specifies the
     * transport address which the stack would use to send MEGACO messages to
     * peer.
     *
     * @return Returns the local entity transport address. If the local address
     * field is not present, then this method would return NULL.
     */
    public LocalAddr getLocalAddr() {
        return localAddr;
    }

    /**
     * This method sets the local entity identity. The localAddr specifies the
     * transport address which the stack would use to send transactions to peer.
     *
     * @param localAddr localAddr - The local entity transport address. Since
     * the format of the message header Id is same as that of the transport
     * address, the value of this may or may not be different from the local
     * entity configured in the user Id as specified in the addMegacoListener
     * method of MegacoProvider interface.
     * @throws IllegalArgumentException This exception is raised if the local
     * transport address specified is invalid.
     */
    public void setLocalAddr(LocalAddr localAddr)
            throws IllegalArgumentException {
        this.localAddr = localAddr;
    }

    /**
     * Gets the List of remote entity transport address for the User Id. The
     * remote address specified in the address to which the stack would send
     * MEGACO messages. There is one to one correspondence between the list of
     * remote address specified here and the list of remote entity Ids in the
     * UserId class. The messages comming from a particular remote entity must
     * have same message header Id as the corresponding remote entity Id in
     * UserId class.
     *
     * @return Returns the list of remote entity transport address. If the
     * remote address parameter is not present, then this method would return
     * NULL.
     */
    public RemoteAddr[] getRemoteAddr() {
        return remoteAddr;
    }

    /**
     * Sets the list of remote entity identities of the user Id. The remote
     * address specified in the address to which the stack would send MEGACO
     * messages. There is one to one correspondence between the list of remote
     * address specified here and the list of remote entity Ids in the UserId
     * class. The messages comming from a particular remote entity must have
     * same message header Id as the corresponding remote entity Id in UserId
     * class.
     *
     * @param remoteAddr -- List of remote entity transport addresses of the
     * MGC/MG.
     * @throws IllegalArgumentException This exception is raised if the
     * reference of Remote Address passed to this method is NULL.
     */
    public void setRemoteAddr(RemoteAddr[] remoteAddr)
            throws IllegalArgumentException {
        this.remoteAddr = remoteAddr;
    }

    /**
     * Gets the integer value which identifies the service change reason. This
     * parameter is required on if the application is MG. The MG stack would use
     * the same ServiceChange Reason in the ServiceChange command request sent
     * to peer MGC.
     *
     * @return Returns the integer value corresponding to the service change
     * reason. If the ServiceChangeReason is not set, then this method would
     * return value null. The possible values are field constants defined for
     * the class {@link SrvChngReason}.
     */
    public SrvChngReason getSrvChangeReason() {
//		return srvChangeReason == null ? 0 : srvChangeReason
//				.getSrvChngReasonId();
        return srvChangeReason;
    }

    /**
     * This method sets the service change reason. This parameter is required on
     * if the application is MG. The MG stack would use the same ServiceChange
     * Reason in the ServiceChange command request sent to peer MGC.
     *
     * @param reason - The object reference to ServiceChange Reason.
     * @throws IllegalArgumentException This exception is raised if the
     * reference of Service Change Reason passed to this method is NULL.
     */
    public void setSrvChangeReason(SrvChngReason reason)
            throws IllegalArgumentException {
        if (reason == null)
            throw new IllegalArgumentException("Change reason can not be null");
        this.srvChangeReason = reason;
    }

    /**
     * Gets the integer value which identifies the service change method. This
     * parameter is required on if the application is MG. The MG stack would use
     * the same ServiceChange Method in ServiceChange command request sent to
     * peer MGC.
     *
     * @return Returns the integer value corresponding to the service change
     * method. If the ServiceChangeMethod is not set, then this method would
     * return value null. The possible values are field constants defined for
     * the class SrvChngMethod.
     */
    public SrvChngMethod getSrvChngMethod() {
        //return srvChngMethod == null ? 0 : srvChngMethod.getSrvChngReasonId();
        return srvChngMethod;
    }

    /**
     * This method sets the service change method. This parameter is required on
     * if the application is MG. The MG stack would use the same ServiceChange
     * Method in ServiceChange command request sent to peer MGC.
     *
     * @param method - The object reference to ServiceChange Method.
     * @throws IllegalArgumentException This exception is raised if the
     * reference of Service Change Reason passed to this method is NULL.
     */
    public void setSrvChngMethod(SrvChngMethod method)
            throws IllegalArgumentException {
        if (method == null)
            throw new IllegalArgumentException("Change method can not be null");
        this.srvChngMethod = method;
    }

    /**
     * Gets the service change address.
     *
     * @return Returns the service change address. if the service change address
     * is not set, then this method would return NULL.
     */
    public LocalAddr getSrvChngAddress() {
        return srvChngAddress;
    }

    /**
     * This method sets the service change address. The local entity specfied
     * earlier is the transport address would be used for initial registration
     * and then subsequently, the address specified in the serviceChngAddress
     * field would be used for the local transport address. If the application
     * is MGC, then on receipt of ServiceChange command (on ROOT termination),
     * it will reply with ServiceChangeAddress field in
     * serviceChangeReplyDescriptor descriptor, with value as set using this
     * method. And If the application is MG, then the stack will send the
     * ServiceChange command (on ROOT termination) with ServiceChangeAddress
     * field in serviceChangeDescriptor descriptor, with value as set using this
     * method.
     *
     * @param srvChngAddress The service change address.
     * @throws IllegalArgumentException This exception is raised if the service
     * change address specified is invalid.
     */
    public void setSrvChngAddress(LocalAddr srvChngAddress)
            throws IllegalArgumentException {
        //FIXME: IllegalArgumentException
        this.srvChngAddress = srvChngAddress;
    }

    /**
     * Gets the identity of the MGC to which the association is to be handoffed.
     * This parameter may be set if the application is MGC.
     *
     * @return Returns the identity of the MGC to which the association is to be
     * handoffed. If the HandedOff MGC Id is missing, then method returns NULL.
     */
    public LocalAddr getHandOffMGCId() {
        return handOffMGCId;
    }

    /**
     * This method sets the identity of the MGC to which the association is to
     * be handoffed. This parameter may be set if the application is MGC. If
     * this parameter is set, then on receipt of service change request from MG
     * (with ROOT termination), the stack will reply with MgcIdToTry field in
     * serviceChangeDescriptor descriptor, with value as set using this method.
     *
     * @param handOffMGCId The identity of the MGC to which the association is
     * to be handoffed.
     * @throws IllegalArgumentException This exception is raised if the
     * HandedOffMGCId specified is invalid.
     */
    public void setHandOffMGCId(LocalAddr handOffMGCId)
            throws IllegalArgumentException {
        //FIXME: IllegalArgumentException
        this.handOffMGCId = handOffMGCId;
    }

    /**
     *
     * @return
     */
    public int getEndcodingFormat() {
        //FIXME 0 is valid value == TEXT ?
        return endcodingFormat == null ? 0 : endcodingFormat.getEncodingFormat();
    }

    /**
     * This method sets the encoding format which is to be configured.
     *
     * @param format
     * @throws IllegalArgumentException This exception is raised if the
     * reference of Encoding Format passed to this method is NULL.
     */
    public void setEndcodingFormat(EncodingFormat format)
            throws IllegalArgumentException {
        if (format == null)
            throw new IllegalArgumentException("Encoding format can not be null");
        this.endcodingFormat = format;
    }







public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.association.CreateAssocReq o = (javax.megaco.association.CreateAssocReq)oo;
if (!super.equals(o)) return false;
if((localAddr !=null && o.localAddr == null) ||(localAddr == null && o.localAddr != null) ) return false;
if(localAddr ==null && o.localAddr == null) return true ; else if(localAddr !=null && o.localAddr != null)
if (localAddr != null && o.localAddr !=null && !localAddr.equals(o.localAddr)) return false;
if((remoteAddr !=null && o.remoteAddr == null) ||(remoteAddr == null && o.remoteAddr != null) ) return false;
if(remoteAddr ==null && o.remoteAddr == null) return true ; else if(remoteAddr !=null && o.remoteAddr != null)
{
if (remoteAddr ==null && o.remoteAddr == null) return true; else if (remoteAddr.length != o.remoteAddr.length) return false;
if (remoteAddr.length == o.remoteAddr.length) for(int i = 0 ; i < remoteAddr.length; i ++ )
{
if((remoteAddr[i] !=null && o.remoteAddr[i] == null) ||(remoteAddr[i] == null && o.remoteAddr[i] != null) ) return false;
if(remoteAddr[i] !=null && o.remoteAddr[i] != null)
if (!remoteAddr[i].equals(o.remoteAddr[i])) return false;
}
}
if((srvChangeReason !=null && o.srvChangeReason == null) ||(srvChangeReason == null && o.srvChangeReason != null) ) return false;
if(srvChangeReason ==null && o.srvChangeReason == null) return true ; else if(srvChangeReason !=null && o.srvChangeReason != null)
if (srvChangeReason != null && o.srvChangeReason !=null && !srvChangeReason.equals(o.srvChangeReason)) return false;
if((srvChngMethod !=null && o.srvChngMethod == null) ||(srvChngMethod == null && o.srvChngMethod != null) ) return false;
if(srvChngMethod ==null && o.srvChngMethod == null) return true ; else if(srvChngMethod !=null && o.srvChngMethod != null)
if (srvChngMethod != null && o.srvChngMethod !=null && !srvChngMethod.equals(o.srvChngMethod)) return false;
if((srvChngAddress !=null && o.srvChngAddress == null) ||(srvChngAddress == null && o.srvChngAddress != null) ) return false;
if(srvChngAddress ==null && o.srvChngAddress == null) return true ; else if(srvChngAddress !=null && o.srvChngAddress != null)
if (srvChngAddress != null && o.srvChngAddress !=null && !srvChngAddress.equals(o.srvChngAddress)) return false;
if((handOffMGCId !=null && o.handOffMGCId == null) ||(handOffMGCId == null && o.handOffMGCId != null) ) return false;
if(handOffMGCId ==null && o.handOffMGCId == null) return true ; else if(handOffMGCId !=null && o.handOffMGCId != null)
if (handOffMGCId != null && o.handOffMGCId !=null && !handOffMGCId.equals(o.handOffMGCId)) return false;
if((endcodingFormat !=null && o.endcodingFormat == null) ||(endcodingFormat == null && o.endcodingFormat != null) ) return false;
if(endcodingFormat ==null && o.endcodingFormat == null) return true ; else if(endcodingFormat !=null && o.endcodingFormat != null)
if (endcodingFormat != null && o.endcodingFormat !=null && !endcodingFormat.equals(o.endcodingFormat)) return false;

return true;
}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("CreateAssocReq:");
bob.append(super.toString());

if(localAddr !=null)
bob.append("localAddr=").append(localAddr).append(",");
if (remoteAddr !=null && remoteAddr.length > 0) { bob.append("remoteAddr=["); 
 for(int i = 0 ; i < remoteAddr.length; i ++ )
if(remoteAddr[i] !=null)
bob.append(remoteAddr[i]).append(",");
bob.append("]");}
if(srvChangeReason !=null)
bob.append("srvChangeReason=").append(srvChangeReason).append(",");
if(srvChngMethod !=null)
bob.append("srvChngMethod=").append(srvChngMethod).append(",");
if(srvChngAddress !=null)
bob.append("srvChngAddress=").append(srvChngAddress).append(",");
if(handOffMGCId !=null)
bob.append("handOffMGCId=").append(handOffMGCId).append(",");
if(endcodingFormat !=null)
bob.append("endcodingFormat=").append(endcodingFormat).append(",");

return bob.append(";").toString(); 
}










}