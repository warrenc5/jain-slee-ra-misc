package javax.megaco.association;

import javax.megaco.AssociationEvent;
import javax.megaco.ErrorCode;

import javax.megaco.MethodInvocationException;
import javax.megaco.ReturnStatus;

/**
 * 
 * @author wozza
 */
public class ModifyAssocResp extends AssociationEvent {

    /**
     * 
     */
    protected ReturnStatus eventStatus = null;
    /**
     * 
     */
    protected ErrorCode errorCode = null;

    /**
     * 
     * @param source
     * @param assocHandle
     * @throws IllegalArgumentException
     */
    public ModifyAssocResp(Object source, int assocHandle) throws IllegalArgumentException {
		super(source, assocHandle);

	}

	@Override
	public int getAssocOperIdentifier() {
		return AssocEventType.M_MODIFY_ASSOC_RESP;
	}

	/**
	 * This method returns whether the execution of modify association request
	 * was success or not.
	 * 
	 * @return Returns an integer value that identifies whether the delete
	 *         association event issued earlier could be performed successfuly
	 *         or not. The values are field constants defined in class
	 *         ReturnStatus. If the returnStatus is not set, then this method
	 *         would return value null.
	 */
	public final ReturnStatus getEventStatus() {
		// return eventStatus == null ? 0 : eventStatus.getReturnStatus();
		return eventStatus;
	}

	/**
	 * This method sets the status of whether the execution of the modify
	 * association request was success or not.
	 * 
	 * @param returnStatus
	 *            - The return status of the processing of the modify
	 *            association event. The static object corresponding to the
	 *            return status which are one of the derived classes of the
	 *            ReturnStatus shall be set.
	 * @throws IllegalArgumentException
	 *             This exception is raised if the reference of Return Status
	 *             passed to this method is NULL.
	 */
	public final void setEventStatus(ReturnStatus returnStatus) throws IllegalArgumentException {
		if (returnStatus == null)
			throw new IllegalArgumentException("Event status can not be null.");

		this.eventStatus = returnStatus;
	}

	/**
	 * This method returns the error code qualifying why the modify association
	 * event could not be processed successfuly.
	 * 
	 * @return Returns an integer value that identifies the error code
	 *         specifying why the execution of the modify association event
	 *         could not be successful. The possible values are field constants
	 *         defined for the class ErrorCode. If the error code is not set,
	 *         then this method would return value null.
	 * @throws IllegalStateException
	 *             - This exception would be raised if the return status is set
	 *             to M_SUCCESS, the error code is not set and hence should not
	 *             invoke this method.
	 */
	public final ErrorCode getErrorCode() throws IllegalStateException {
		if (getEventStatus() == null || getEventStatus().getReturnStatus() == ReturnStatus.M_SUCCESS) {
			throw new IllegalStateException("Event status is success or not set, error code is not premited.");
		}
		// return errorCode == null ? 0 : errorCode.getErrorCode();
		return errorCode;
	}

	/**
	 * This method sets the error code specifying why the modify association
	 * event could not be executed successfuly.
	 * 
	 * @param errorCode
	 *            The error code corresponding to why the modify association
	 *            event could not be executed successfuly.
	 * @throws IllegalArgumentException
	 *             This exception would be raised in following conditions
	 * 
	 * <br>
	 *             1. If the return status is not set to M_FAILURE, the error
	 *             code should not be set. <br>
	 *             2. If the error code is not valid for the ModifyAssocReq
	 *             class.
	 */
	public final void setErrorCode(ErrorCode errorCode) throws IllegalArgumentException {
		if (errorCode == null)
			throw new IllegalArgumentException("Error code can not be null.");
		if (getEventStatus() == null || getEventStatus().getReturnStatus() != ReturnStatus.M_FAILURE) {
			throw new IllegalArgumentException("Event status is not failure or nto set, error code is not premited.");
		}
		this.errorCode = errorCode;
	}







public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ModifyAssocResp:");
bob.append(super.toString());

if(eventStatus !=null)
bob.append("eventStatus=").append(eventStatus).append(",");
if(errorCode !=null)
bob.append("errorCode=").append(errorCode).append(",");

return bob.append(";").toString(); 
}












public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.association.ModifyAssocResp o = (javax.megaco.association.ModifyAssocResp)oo;
if (!super.equals(o)) return false;
if((eventStatus !=null && o.eventStatus == null) ||(eventStatus == null && o.eventStatus != null) ) return false;
if(eventStatus ==null && o.eventStatus == null) return true ; else if(eventStatus !=null && o.eventStatus != null)
if (eventStatus != null && o.eventStatus !=null && !eventStatus.equals(o.eventStatus)) return false;
if((errorCode !=null && o.errorCode == null) ||(errorCode == null && o.errorCode != null) ) return false;
if(errorCode ==null && o.errorCode == null) return true ; else if(errorCode !=null && o.errorCode != null)
if (errorCode != null && o.errorCode !=null && !errorCode.equals(o.errorCode)) return false;

return true;
}

}












