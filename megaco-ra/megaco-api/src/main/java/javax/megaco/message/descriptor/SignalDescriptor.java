package javax.megaco.message.descriptor;

import java.io.Serializable;


import javax.megaco.message.Descriptor;
import javax.megaco.message.DescriptorType;

/**
 * The class extends JAIN MEGACO Descriptor. This class describes the signal
 * descriptor as defined in the MEGACO protocol.
 */
public class SignalDescriptor extends Descriptor implements Serializable {

	private SignalParam[] signalParam;

	/**
	 * Constructs a Signal Descriptor. This contains signals to be applied on
	 * the terminations and the associated opeartions as defined by the
	 * protocol.
	 */
	public SignalDescriptor() {
		super();
		super.descriptorId = DescriptorType.M_SIGNAL_DESC;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * returns that the descriptor identifier is of type descriptor Signal. This
	 * method overrides the corresponding method of the base class Descriptor.
	 * 
	 * @return Returns an integer value that identifies this signal object as
	 *         the type of signal descriptor. It returns value
	 *         {@link DescriptorType.M_SIGNAL_DESC} for a Signal Descriptor.
	 */
	public final int getDescriptorId() {
		return super.descriptorId;
	}

	/**
	 * This method sets the signals. The signal specified are as defined in the
	 * MEGACO packages.
	 * 
	 * @param signalParam
	 *            - Sets the signals as defined in the MEGACO packages. This
	 *            method takes vector of the signal parameters therefore allows
	 *            multiple signals to be set.
	 * @throws IllegalArgumentException
	 *             : This exception is raised if the reference of Signal Param
	 *             passed to this method is NULL.
	 */
	public final void setSignalParam(SignalParam[] signalParam) throws IllegalArgumentException {
		if (signalParam == null) {
			throw new IllegalArgumentException("SignalParam[] must not be null");
		}

		this.signalParam = signalParam;
	}

	/**
	 * This method gets the multiple signals params as a vector format.
	 * 
	 * @return Returns the vector of the multiple signal params. If the signal
	 *         parameter is not set then this shall return a NULL value.
	 */
	public final SignalParam[] getSignalParam() {
		return this.signalParam;
	}

















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("SignalDescriptor:");
bob.append(super.toString());

if (signalParam !=null && signalParam.length > 0) { bob.append("signalParam=["); 
 for(int i = 0 ; i < signalParam.length; i ++ )
if(signalParam[i] !=null)
bob.append(signalParam[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.SignalDescriptor o = (javax.megaco.message.descriptor.SignalDescriptor)oo;
if (!super.equals(o)) return false;
if((signalParam !=null && o.signalParam == null) ||(signalParam == null && o.signalParam != null) ) return false;
if(signalParam ==null && o.signalParam == null) return true ; else if(signalParam !=null && o.signalParam != null)
{
if (signalParam ==null && o.signalParam == null) return true; else if (signalParam.length != o.signalParam.length) return false;
if (signalParam.length == o.signalParam.length) for(int i = 0 ; i < signalParam.length; i ++ )
{
if((signalParam[i] !=null && o.signalParam[i] == null) ||(signalParam[i] == null && o.signalParam[i] != null) ) return false;
if(signalParam[i] !=null && o.signalParam[i] != null)
if (!signalParam[i].equals(o.signalParam[i])) return false;
}
}

return true;
}

}
























