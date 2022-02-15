package javax.megaco.association;

import javax.megaco.AssociationEvent;

/**
 * 
 * @author wozza
 */
public class ModifyAssocReq extends AssociationEvent {

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
    protected String srvChngMethodExtension = null;

    /**
     * 
     * @param source
     * @param assocHandle
     * @throws IllegalArgumentException
     */
    public ModifyAssocReq(Object source, int assocHandle) throws IllegalArgumentException {
		super(source, assocHandle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAssocOperIdentifier() {
		return AssocEventType.M_MODIFY_ASSOC_REQ;
	}

	/**
	 * Gets the integer value which identifies the service change reason. The
	 * stack would use the same ServiceChange Reason in the ServiceChange
	 * command request sent to peer.
	 * 
	 * @return Returns the integer value corresponding to the service change
	 *         reason. If the ServiceChangeReason is not set, then this method
	 *         would return value null. The possible values are field constants
	 *         defined for the class SrvChngReason.
	 */
	public SrvChngReason getSrvChangeReason() {
		// return srvChangeReason == null ? 0 : srvChangeReason
		// .getSrvChngReasonId();
		return srvChangeReason;
	}

	/**
	 * This method sets the service change reason. This parameter is required on
	 * if the application is MG. The MG stack would use the same ServiceChange
	 * Reason in the ServiceChange command request sent to peer MGC.
	 * 
	 * @param reason
	 *            - The object reference to ServiceChange Reason.
	 * @throws IllegalArgumentException
	 *             This exception is raised if the reference of Service Change
	 *             Reason passed to this method is NULL.
	 */
	public void setSrvChangeReason(SrvChngReason reason) throws IllegalArgumentException {
		if (reason == null) {
			throw new IllegalArgumentException("Change reason can not be null");
		}
		this.srvChangeReason = reason;
	}

	/**
	 * Gets the integer value which identifies the service change method. This
	 * parameter is required on if the application is MG. The MG stack would use
	 * the same ServiceChange Method in ServiceChange command request sent to
	 * peer MGC.
	 * 
	 * @return Returns the integer value corresponding to the service change
	 *         method. If the ServiceChangeMethod is not set, then this method
	 *         would return value null. The possible values are field constants
	 *         defined for the class SrvChngMethod.
	 */
	public SrvChngMethod getSrvChngMethod() {
		// return srvChngMethod == null ? 0 :
		// srvChngMethod.getSrvChngMethodId();
		return srvChngMethod;
	}

	/**
	 * This method sets the service change method. This parameter is required on
	 * if the application is MG. The MG stack would use the same ServiceChange
	 * Method in ServiceChange command request sent to peer MGC.
	 * 
	 * @param method
	 *            - The object reference to ServiceChange Method.
	 * @throws IllegalArgumentException
	 *             This exception is raised if the reference of Service Change
	 *             Reason passed to this method is NULL.
	 */
	public void setSrvChngMethod(SrvChngMethod method) throws IllegalArgumentException {
		if (method == null) {
			throw new IllegalArgumentException("Change method can not be null");
		}
		this.srvChngMethod = method;
	}

	/**
	 * Gets the object reference corresponding to the service change address.
	 * The stack would use the same ServiceChange Address in the ServiceChange
	 * command request sent to peer.
	 * 
	 * @return Returns the service change address. If the service change address
	 *         has not been specified for this class, then this method returns
	 *         NULL.
	 */
	public LocalAddr getSrvChngAddress() {
		return srvChngAddress;
	}

	/**
	 * This method sets the service change address. The stack would use the same
	 * ServiceChange Address in the ServiceChange command request sent to peer.
	 * 
	 * @param srvChngAddress
	 *            - The service change address.
	 * @throws IllegalArgumentException
	 *             This exception is raised if the service change address
	 *             specified is invalid.
	 */
	public void setSrvChngAddress(LocalAddr srvChngAddress) throws IllegalArgumentException {
		// FIXME: IllegalArgumentException
		this.srvChngAddress = srvChngAddress;
	}

	/**
	 * Gets the string value of the extended service change method.
	 * 
	 * 
	 * @return Returns string value of the extended service change method. This
	 *         is to be set only if the service change method is set to
	 *         {@link javax.megaco.association.SrvChngMethod.M_EXTENSION}.
	 * @throws javax.megaco.association.MethodExtensionException
	 *             javax.megaco.association.MethodExtensionException - Thrown if
	 *             service change method has not been set to
     *             {@link javax.megaco.association.SrvChngMethod.M_EXTENSION}
     * @throws IllegalArgumentException  
	 */
	public java.lang.String getSrvChngMethodExtension() throws javax.megaco.association.MethodExtensionException, IllegalArgumentException {
		if (getSrvChngMethod() == null || getSrvChngMethod().getSrvChngMethodId() != SrvChngMethod.M_EXTENSION) {
			throw new MethodExtensionException("Changed Method is not equal to {@link javax.megaco.association.SrvChngMethod.M_EXTENSION}");
		}

		return this.srvChngMethodExtension;
	}

	/**
	 * This method sets the extended service change method. This needs to be set
	 * if and only if the service change method is
	 * {@link javax.megaco.association.SrvChngMethod.M_EXTENSION}.
	 * 
	 * @param extMethod
	 *            - The string value of the extended service change method.
	 * @throws javax.megaco.association.MethodExtensionException
	 *             - Thrown if service change method has not been set to
	 *             {@link javax.megaco.association.SrvChngMethod.M_EXTENSION}.
	 * @throws IllegalArgumentException
	 *             - Thrown if extension string does not follow the rules of the
	 *             extension parameter, e.g, should start with X+ or X- etc.
	 */
	public void setSrvChngMethod(java.lang.String extMethod) throws javax.megaco.association.MethodExtensionException, IllegalArgumentException {
		if (getSrvChngMethod() == null || getSrvChngMethod().getSrvChngMethodId() != SrvChngMethod.M_EXTENSION) {
			throw new MethodExtensionException("Changed Method is not equal to SrvChngMethod.{@link javax.megaco.association.SrvChngMethod.M_EXTENSION}");
		}
		// FIXME IllegalArgumentException - Thrown if extension
		// string does not follow the rules of the extension parameter, e.g,
		// should start with X+ or X- etc.

		this.srvChngMethodExtension = extMethod;
	}







public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ModifyAssocReq:");
bob.append(super.toString());

if(srvChangeReason !=null)
bob.append("srvChangeReason=").append(srvChangeReason).append(",");
if(srvChngMethod !=null)
bob.append("srvChngMethod=").append(srvChngMethod).append(",");
if(srvChngAddress !=null)
bob.append("srvChngAddress=").append(srvChngAddress).append(",");
if(srvChngMethodExtension !=null)
bob.append("srvChngMethodExtension=").append(srvChngMethodExtension).append(",");

return bob.append(";").toString(); 
}












public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.association.ModifyAssocReq o = (javax.megaco.association.ModifyAssocReq)oo;
if (!super.equals(o)) return false;
if((srvChangeReason !=null && o.srvChangeReason == null) ||(srvChangeReason == null && o.srvChangeReason != null) ) return false;
if(srvChangeReason ==null && o.srvChangeReason == null) return true ; else if(srvChangeReason !=null && o.srvChangeReason != null)
if (srvChangeReason != null && o.srvChangeReason !=null && !srvChangeReason.equals(o.srvChangeReason)) return false;
if((srvChngMethod !=null && o.srvChngMethod == null) ||(srvChngMethod == null && o.srvChngMethod != null) ) return false;
if(srvChngMethod ==null && o.srvChngMethod == null) return true ; else if(srvChngMethod !=null && o.srvChngMethod != null)
if (srvChngMethod != null && o.srvChngMethod !=null && !srvChngMethod.equals(o.srvChngMethod)) return false;
if((srvChngAddress !=null && o.srvChngAddress == null) ||(srvChngAddress == null && o.srvChngAddress != null) ) return false;
if(srvChngAddress ==null && o.srvChngAddress == null) return true ; else if(srvChngAddress !=null && o.srvChngAddress != null)
if (srvChngAddress != null && o.srvChngAddress !=null && !srvChngAddress.equals(o.srvChngAddress)) return false;
if((srvChngMethodExtension !=null && o.srvChngMethodExtension == null) ||(srvChngMethodExtension == null && o.srvChngMethodExtension != null) ) return false;
if(srvChngMethodExtension ==null && o.srvChngMethodExtension == null) return true ; else if(srvChngMethodExtension !=null && o.srvChngMethodExtension != null)
if (srvChngMethodExtension != null && o.srvChngMethodExtension !=null && !srvChngMethodExtension.equals(o.srvChngMethodExtension)) return false;

return true;
}

}












