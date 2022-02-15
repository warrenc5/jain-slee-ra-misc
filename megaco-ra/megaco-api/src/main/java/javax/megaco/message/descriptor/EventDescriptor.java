package javax.megaco.message.descriptor;


import javax.megaco.ParameterNotSetException;
import javax.megaco.message.Descriptor;
import javax.megaco.message.DescriptorType;

/**
 * The class extends JAIN MEGACO Descriptor. This class describes the Event
 * descriptor of the MEGACO protocol.
 * 
 * 
 */
public class EventDescriptor extends Descriptor {

	private int requestId;
	private RequestedEventParam[] requestedEventParam = null;

	/**
	 * Constructs a Event Descriptor with specific request identifier.
	 * 
	 * @param requestId
	 *            requestId - An integer value specifying the request
	 *            identifier, which uniquely identifies the event.
	 * @throws IllegalArgumentException
	 *             : This exception is raised if the value of request identifier
	 *             passed to this method is less than 0.
	 */
	public EventDescriptor(int requestId) throws IllegalArgumentException {
		if (requestId < 0) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException("requestId cannot be less than 0 for EventDescriptor");

			// TODO set ExceptionInfoCode ?
			throw invalidArgumentException;
		}
		this.requestId = requestId;
		super.descriptorId = DescriptorType.M_EVENT_DESC;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * returns that the descriptor identifier is of type descriptor Event. This
	 * method overrides the corresponding method of the base class Descriptor.
	 */
	@Override
	public final int getDescriptorId() {
		return super.descriptorId;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * returns an integer value identifying the RequestID field of the event
	 * descriptor.
	 * 
	 * @return Returns an integer value that identifies request identifier which
	 *         uniquely identifies the event descriptor.
	 */
	public final int getRequestId() {
		return this.requestId;
	}

	/**
	 * This method sets the Requested Event Params field of the event
	 * descriptor.
	 * 
	 * @param requestedParam
	 *            - Sets the requested params. There can be multiple requested
	 *            parameters set, but atleaset one should be present.
	 * @throws IllegalArgumentException
	 *             : This exception is raised if the reference of request event
	 *             params as passed to this method is NULL.
	 */
	public final void setRequestedEventParam(RequestedEventParam[] requestedParam) throws IllegalArgumentException {

		// FIXME: add zero length check?
		if (requestedParam == null) {

			throw new IllegalArgumentException();
		}

		this.requestedEventParam = requestedParam;
	}

	/**
	 * This method gets the Request Events Params field of the event descriptor.
	 * This method returns vector of objects of type RequsetedEventParams.
	 * 
	 * @return Returns the vector of the request event params. If requested
	 *         event parameter has not been set for the event descriptor, then
	 *         this method would return NULL.

	 */
	public final RequestedEventParam[] getRequestedEventParam() {

		return this.requestedEventParam;
	}

















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("EventDescriptor:");
bob.append(super.toString());

bob.append("requestId=").append(requestId).append(",");
if (requestedEventParam !=null && requestedEventParam.length > 0) { bob.append("requestedEventParam=["); 
 for(int i = 0 ; i < requestedEventParam.length; i ++ )
if(requestedEventParam[i] !=null)
bob.append(requestedEventParam[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.EventDescriptor o = (javax.megaco.message.descriptor.EventDescriptor)oo;
if (!super.equals(o)) return false;
if (requestId != o.requestId) return false;
if((requestedEventParam !=null && o.requestedEventParam == null) ||(requestedEventParam == null && o.requestedEventParam != null) ) return false;
if(requestedEventParam ==null && o.requestedEventParam == null) return true ; else if(requestedEventParam !=null && o.requestedEventParam != null)
{
if (requestedEventParam ==null && o.requestedEventParam == null) return true; else if (requestedEventParam.length != o.requestedEventParam.length) return false;
if (requestedEventParam.length == o.requestedEventParam.length) for(int i = 0 ; i < requestedEventParam.length; i ++ )
{
if((requestedEventParam[i] !=null && o.requestedEventParam[i] == null) ||(requestedEventParam[i] == null && o.requestedEventParam[i] != null) ) return false;
if(requestedEventParam[i] !=null && o.requestedEventParam[i] != null)
if (!requestedEventParam[i].equals(o.requestedEventParam[i])) return false;
}
}

return true;
}

}
























