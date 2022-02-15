package javax.megaco.message.descriptor;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


import javax.megaco.message.Descriptor;
import javax.megaco.message.DescriptorType;

/**
 * The class extends JAIN MEGACO Descriptor. This class describes the audit
 * value response descriptor. It specifies the tokens and descriptors for audit
 * value response.
 */
public class AuditValRespDescriptor extends Descriptor implements Serializable {

	private boolean obsEventToken;
	private boolean eventsToken;
	private boolean statsToken;
	private boolean eventBuffToken;
	private boolean signalToken;
	private boolean mediaToken;
	private boolean modemTokenPresent;
	private boolean muxToken;
	private boolean digitMapToken;
	private boolean packagesToken;
	
	private Descriptor[] descriptors;

	/**
	 * * <br>
	 * 1. Media Descriptor<br>
	 * 2. Modem Descriptor<br>
	 * 3. Mux Descriptor<br>
	 * 4. Events Descriptor<br>
	 * 5. Signal Descriptor<br>
	 * 6. Digit Map Descriptor<br>
	 * 7. Observed Events Descriptor<br>
	 * 8. Event Buffer Descriptor<br>
	 * 9. Statistics Descriptor<br>
	 * 10. Package Descriptor<br>
	 * 11. Error Descriptor<br>
	 **/
	private static final Set<Integer> allowedDescritpors;
	static {

		Set<Integer> tmps = new HashSet<Integer>();
		tmps.add(DescriptorType.M_MEDIA_DESC);
		tmps.add(DescriptorType.M_MODEM_DESC);
		tmps.add(DescriptorType.M_MUX_DESC);
		tmps.add(DescriptorType.M_EVENT_DESC);
		tmps.add(DescriptorType.M_SIGNAL_DESC);
		tmps.add(DescriptorType.M_DIGIT_MAP_DESC);
		tmps.add(DescriptorType.M_OBSERVED_EVENT_DESC);
		tmps.add(DescriptorType.M_EVENT_BUF_DESC);
		tmps.add(DescriptorType.M_STATISTICS_DESC);
		tmps.add(DescriptorType.M_PACKAGE_DESC);
		tmps.add(DescriptorType.M_ERROR_DESC);

		allowedDescritpors = Collections.unmodifiableSet(tmps);
	}

	/**
	 * Constructs a Audit Value Response Descriptor. It specifies the tokens for
	 * which the audit value is required.
	 */
	public AuditValRespDescriptor() {
		super.descriptorId = DescriptorType.M_AUDIT_VAL_REPLY_DESC;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * returns that the descriptor identifier is of type audit value response
	 * descriptor. This method overrides the corresponding method of the base
	 * class Descriptor.
	 * 
	 * @return Returns an integer value that identifies this object of the type
	 *         of audit value response descriptor. It returns that it is audit
	 *         value response Descriptor i.e., M_AUDIT_VAL_REPLY_DESC.
	 */
	public int getDescriptorId() {
		return super.descriptorId;
	}

	/**
	 * Gets the Descriptor information for all the descriptor in this audit
	 * response parameter.
	 * 
	 * @return The vector of the reference to the object identifier of type
	 *         descriptor information.
	 */
	public Descriptor[] getDescriptor() {
		return this.descriptors;
	}

	/**
	 * Sets the vector of Descriptor Information for this audit response
	 * parameter. Only valid descriptors are <br>
	 * <br>
	 * 1. Media Descriptor<br>
	 * 2. Modem Descriptor<br>
	 * 3. Mux Descriptor<br>
	 * 4. Events Descriptor<br>
	 * 5. Signal Descriptor<br>
	 * 6. Digit Map Descriptor<br>
	 * 7. Observed Events Descriptor<br>
	 * 8. Event Buffer Descriptor<br>
	 * 9. Statistics Descriptor<br>
	 * 10. Package Descriptor<br>
	 * 11. Error Descriptor<br>
	 * 
	 * 
     * @param descriptors 
     * @throws IllegalArgumentException
	 *             if the descriptor passed to this method is invalid.
	 */
	public void setDescriptor(Descriptor[] descriptors) throws IllegalArgumentException {
		if (descriptors == null) {
			throw new IllegalArgumentException("Descriptor[] must not be null.");
		}

		if (descriptors.length == 0) {
			throw new IllegalArgumentException("Descriptor[] must not be empty.");
		}
		int count = 0;
		for (Descriptor d : descriptors) {
			if (d == null) {
				throw new IllegalArgumentException("Descriptor[" + count + "] is null!");
			}
			if (!allowedDescritpors.contains(d.getDescriptorId())) {
				throw new IllegalArgumentException("Descriptor[" + count + "] is is of wrong type, its not allowed: " + d.toString());
			}

			count++;
		}
		this.descriptors = descriptors;

	}
	
	
	
	
	
	/**
	 * This method cannot be overridden by the derived class. This method
	 * indicates if the mux token is present or not.
	 * 
	 * @return Returns TRUE if the Mux token is present.
	 */
	public final boolean isMuxTokenPresent() {
		return this.muxToken;
	}

	/**
	 * This method cannot be overridden by the derived class. This method sets a
	 * flag to indicate that the mux token is present.
	 */
	public final void setMuxToken() {
		this.muxToken = true;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * indicates if the Modem token is present or not.
	 * 
	 * @return Returns TRUE if the Modem token is present.
	 */
	public final boolean isModemTokenPresent() {
		return this.modemTokenPresent;
	}

	/**
	 * This method cannot be overridden by the derived class. This method sets a
	 * flag to indicate that the Modem token is present.
	 */
	public final void setModemToken() {
		this.modemTokenPresent = true;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * indicates if the Media token is present or not.
	 * 
	 * @return Returns TRUE if the Media token is present.
	 */
	public final boolean isMediaTokenPresent() {
		return this.mediaToken;
	}

	/**
	 * This method cannot be overridden by the derived class. This method sets a
	 * flag to indicate that the Media token is present.
	 */
	public final void setMediaToken() {
		this.mediaToken = true;
	}
	
	
	
	/**
	 * This method cannot be overridden by the derived class. This method
	 * indicates if the Signal token is present or not.
	 * 
	 * @return Returns TRUE if the Signal token is present.
	 */
	public final boolean isSignalTokenPresent() {
		return this.signalToken;
	}

	/**
	 * This method cannot be overridden by the derived class. This method sets a
	 * flag to indicate that the Signal token is present.
	 */
	public final void setSignalToken() {
		this.signalToken = true;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * indicates if the Event Buffer token is present or not.
	 * 
	 * @return Returns TRUE if the Event Buffer token is present.
	 */
	public final boolean isEventBuffTokenPresent() {
		return this.eventBuffToken;
	}

	/**
	 * This method cannot be overridden by the derived class. This method sets a
	 * flag to indicate that the Event Buffer token is present.
	 */
	public final void setEventBuffToken() {
		this.eventBuffToken = true;
	}
	
	
	
    /**
	 * This method cannot be overridden by the derived class. This method
	 * indicates if the Statistics token is present or not.
	 * 
	 * @return Returns TRUE if the Statistics token is present.
	 */
	public final boolean isStatsTokenPresent() {
		return this.statsToken;
	}

	/**
	 * This method cannot be overridden by the derived class. This method sets a
	 * flag to indicate that the Statistics token is present.
	 */
	public final void setStatsToken() {
		this.statsToken = true;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * indicates if the Events token is present or not.
	 * 
	 * @return Returns TRUE if the Events token is present.
	 */
	public final boolean isEventsTokenPresent() {

		return this.eventsToken;
	}

	/**
	 * This method cannot be overridden by the derived class. This method sets a
	 * flag to indicate that the Events token is present.
	 */
	public final void setEventsToken() {
		this.eventsToken = true;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * indicates if the Observed Event token is present or not.
	 * 
	 * @return Returns TRUE if the Observed Event token is present.
	 */
	public final boolean isObsEventTokenPresent() {
		return this.obsEventToken;
	}

	/**
	 * This method cannot be overridden by the derived class. This method sets a
	 * flag to indicate that the Observed Event token is present.
	 */
	public final void setObsEventToken() {
		this.obsEventToken = true;
	}
	
	
	/**
	 * This method cannot be overridden by the derived class. This method
	 * indicates if the digit map token is present or not.
	 * 
     * @return 
     * @returnReturns TRUE if the digit map token is present.
	 */
	public final boolean isDigitMapTokenPresent() {
		return this.digitMapToken;
	}

	/**
	 * This method cannot be overridden by the derived class. This method sets a
	 * flag to indicate that the digit map token is present.
	 */
	public final void setDigitMapToken() {
		this.digitMapToken = true;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * indicates if the Packages token is present or not.
	 * 
	 * @return Returns TRUE if the Packages token is present.
	 */
	public final boolean isPackagesTokenPresent() {
		return this.packagesToken;
	}

	/**
	 * This method cannot be overridden by the derived class. This method sets a
	 * flag to indicate that the Packages token is present.
	 */
	public final void setPackagesToken() {
		this.packagesToken = true;
	}
















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AuditValRespDescriptor:");
bob.append(super.toString());

bob.append("obsEventToken=").append(obsEventToken).append(",");
bob.append("eventsToken=").append(eventsToken).append(",");
bob.append("statsToken=").append(statsToken).append(",");
bob.append("eventBuffToken=").append(eventBuffToken).append(",");
bob.append("signalToken=").append(signalToken).append(",");
bob.append("mediaToken=").append(mediaToken).append(",");
bob.append("modemTokenPresent=").append(modemTokenPresent).append(",");
bob.append("muxToken=").append(muxToken).append(",");
bob.append("digitMapToken=").append(digitMapToken).append(",");
bob.append("packagesToken=").append(packagesToken).append(",");
if (descriptors !=null && descriptors.length > 0) { bob.append("descriptors=["); 
 for(int i = 0 ; i < descriptors.length; i ++ )
if(descriptors[i] !=null)
bob.append(descriptors[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.AuditValRespDescriptor o = (javax.megaco.message.descriptor.AuditValRespDescriptor)oo;
if (!super.equals(o)) return false;
if (obsEventToken != o.obsEventToken) return false;
if (eventsToken != o.eventsToken) return false;
if (statsToken != o.statsToken) return false;
if (eventBuffToken != o.eventBuffToken) return false;
if (signalToken != o.signalToken) return false;
if (mediaToken != o.mediaToken) return false;
if (modemTokenPresent != o.modemTokenPresent) return false;
if (muxToken != o.muxToken) return false;
if (digitMapToken != o.digitMapToken) return false;
if (packagesToken != o.packagesToken) return false;
if((descriptors !=null && o.descriptors == null) ||(descriptors == null && o.descriptors != null) ) return false;
if(descriptors ==null && o.descriptors == null) return true ; else if(descriptors !=null && o.descriptors != null)
{
if (descriptors ==null && o.descriptors == null) return true; else if (descriptors.length != o.descriptors.length) return false;
if (descriptors.length == o.descriptors.length) for(int i = 0 ; i < descriptors.length; i ++ )
{
if((descriptors[i] !=null && o.descriptors[i] == null) ||(descriptors[i] == null && o.descriptors[i] != null) ) return false;
if(descriptors[i] !=null && o.descriptors[i] != null)
if (!descriptors[i].equals(o.descriptors[i])) return false;
}
}

return true;
}

}
























