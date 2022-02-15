package javax.megaco.message.descriptor;

import javax.megaco.message.Descriptor;
import javax.megaco.message.DescriptorType;

/**
 * 
 * The class extends JAIN MEGACO Descriptor. This class describes the observed
 * event descriptor.
 * 
 */
public class ObsEventDescriptor extends Descriptor {
	private int reqId;
	private ObservedEvent[] obsEvents = null;

	/**
	 * Constructs a ObservedEvent Descriptor with the requesteId corresponding
	 * to the request Id received in the event descriptor. It also sends the
	 * vector of object references to ObservedEvents that store the list of
	 * events that have been observed with the stream id on which they have been
	 * observed.
	 * 
	 * @param reqId
	 *            This specifies an request identifier specifying the events
	 *            that have been observed correspond to which event descriptor.
	 * @param obsEvents
	 *            This specifies a vector of object refernces for the observed
	 *            events.
	 * @throws javax.megaco.InvalidArgumentException
	 *             if the parameters set for observed events are imcompatible.
	 */
	public ObsEventDescriptor(int reqId, ObservedEvent[] obsEvents) throws javax.megaco.InvalidArgumentException {
		// TODO Throw InvalidArgumentException if the parameters set for
		// observed events are imcompatible.

		this.reqId = reqId;
		this.obsEvents = obsEvents;
		super.descriptorId = DescriptorType.M_OBSERVED_EVENT_DESC;

	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * returns that the descriptor identifier is of type Observed Event
	 * descriptor. This method overrides the corresponding method of the base
	 * class Descriptor.
	 */
	@Override
	public final int getDescriptorId() {
        return descriptorId;
	}

	/**
	 * This method retrieves the request identifier set in the observed event
	 * descriptor.
	 * 
	 * @return Returns the request id for the observed event descriptor.
	 */
	public int getRequestId() {
		return this.reqId;
	}

	/**
	 * This method vector of object references set in the observed event
	 * descriptor.
	 * 
	 * @return Returns the vector of observed event object references for the
	 *         observed event descriptor.
	 */
	public ObservedEvent[] getObservedEvent() {
		return this.obsEvents;
	}
















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ObsEventDescriptor:");
bob.append(super.toString());

bob.append("reqId=").append(reqId).append(",");
if (obsEvents !=null && obsEvents.length > 0) { bob.append("obsEvents=["); 
 for(int i = 0 ; i < obsEvents.length; i ++ )
if(obsEvents[i] !=null)
bob.append(obsEvents[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.ObsEventDescriptor o = (javax.megaco.message.descriptor.ObsEventDescriptor)oo;
if (!super.equals(o)) return false;
if (reqId != o.reqId) return false;
if((obsEvents !=null && o.obsEvents == null) ||(obsEvents == null && o.obsEvents != null) ) return false;
if(obsEvents ==null && o.obsEvents == null) return true ; else if(obsEvents !=null && o.obsEvents != null)
{
if (obsEvents ==null && o.obsEvents == null) return true; else if (obsEvents.length != o.obsEvents.length) return false;
if (obsEvents.length == o.obsEvents.length) for(int i = 0 ; i < obsEvents.length; i ++ )
{
if((obsEvents[i] !=null && o.obsEvents[i] == null) ||(obsEvents[i] == null && o.obsEvents[i] != null) ) return false;
if(obsEvents[i] !=null && o.obsEvents[i] != null)
if (!obsEvents[i].equals(o.obsEvents[i])) return false;
}
}

return true;
}

}
























