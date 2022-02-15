package javax.megaco.message.descriptor;

import java.io.Serializable;


import javax.megaco.message.Descriptor;
import javax.megaco.message.DescriptorType;

/**
 * The class extends JAIN MEGACO Descriptor. This class describes the modem
 * descriptor.
 */
public class ModemDescriptor extends Descriptor implements Serializable {

	private ModemParam[] modemParam;
	private ModemParamValue[] modemParamValues;

	/**
	 * Constructs a Modem Descriptor with a vector of object references to
	 * ModemParam.
	 * 
	 * @param modemParam
	 * @throws IllegalArgumentException
	 *             : This exception is raised if the reference of vector of
	 *             Modem Param passed to this method is NULL.
	 */
	public ModemDescriptor(ModemParam[] modemParam) throws IllegalArgumentException {
		if (modemParam == null) {
			throw new IllegalArgumentException("ModemParam[] must not be null.");
		}
		if (modemParam.length == 0) {
			throw new IllegalArgumentException("ModemParam[] must not be empty.");
		}
		this.modemParam = modemParam;

		super.descriptorId = DescriptorType.M_MODEM_DESC;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * returns that the descriptor identifier is of type Modem descriptor. This
	 * method overrides the corresponding method of the base class Descriptor.
	 * 
	 * @return Returns an integer value that identifies this object as the type
	 *         of modem descriptor. It returns that it is Modem Descriptor i.e.,
	 *         M_MODEM_DESC.
	 */
	public int getDescriptorId() {
		return super.descriptorId;
	}

	/**
	 * This method returns the vector of the object of class ModemParam. The
	 * class ModemParam contains the modem type and extension string if the
	 * modem type is extension parameter.
	 * 
	 * @return Returns a vector of objects of class ModemParam.
	 */
	public ModemParam[] getModemParam() {
		return this.modemParam;
	}

	/**
	 * Gets the vector of name and parameter values for specifying the property
	 * of the modem. This would return a NULL value when the param value has not
	 * been set.
	 * 
	 * @return Returns the vector of name and parameter values for specifying
	 *         the property of the modem. This would return a NULL value when
	 *         the param value has not been set.
	 */
	public ModemParamValue[] getModemParamValue() {
		return this.modemParamValues;
	}

	/**
	 * Sets the vector of name and parameter values for specifying the property
	 * of the modem. If the parameter is not be set then this method need not be
	 * called.
	 * 
	 * @param param
	 *            - Sets the vector of the object refernces to name-param value
	 *            pair for modem properties.
	 * @throws IllegalArgumentException
	 *             if the param name or param value or the relation used is not
	 *             one of the allowed values or the vector of ModemParamValue is
	 *             set to NULL.
	 */
	public void setModemParamValue(ModemParamValue[] param) throws IllegalArgumentException {
		if (param == null) {
			throw new IllegalArgumentException("ModemParamValue[] must not be null.");
		}
		if (param.length == 0) {
			throw new IllegalArgumentException("ModemParamValue[] must not be empty.");
		}

		// FIXME: add checks here

		this.modemParamValues = param;

	}

















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ModemDescriptor:");
bob.append(super.toString());

if (modemParam !=null && modemParam.length > 0) { bob.append("modemParam=["); 
 for(int i = 0 ; i < modemParam.length; i ++ )
if(modemParam[i] !=null)
bob.append(modemParam[i]).append(",");
bob.append("]");}
if (modemParamValues !=null && modemParamValues.length > 0) { bob.append("modemParamValues=["); 
 for(int i = 0 ; i < modemParamValues.length; i ++ )
if(modemParamValues[i] !=null)
bob.append(modemParamValues[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.ModemDescriptor o = (javax.megaco.message.descriptor.ModemDescriptor)oo;
if (!super.equals(o)) return false;
if((modemParam !=null && o.modemParam == null) ||(modemParam == null && o.modemParam != null) ) return false;
if(modemParam ==null && o.modemParam == null) return true ; else if(modemParam !=null && o.modemParam != null)
{
if (modemParam ==null && o.modemParam == null) return true; else if (modemParam.length != o.modemParam.length) return false;
if (modemParam.length == o.modemParam.length) for(int i = 0 ; i < modemParam.length; i ++ )
{
if((modemParam[i] !=null && o.modemParam[i] == null) ||(modemParam[i] == null && o.modemParam[i] != null) ) return false;
if(modemParam[i] !=null && o.modemParam[i] != null)
if (!modemParam[i].equals(o.modemParam[i])) return false;
}
}
if((modemParamValues !=null && o.modemParamValues == null) ||(modemParamValues == null && o.modemParamValues != null) ) return false;
if(modemParamValues ==null && o.modemParamValues == null) return true ; else if(modemParamValues !=null && o.modemParamValues != null)
{
if (modemParamValues ==null && o.modemParamValues == null) return true; else if (modemParamValues.length != o.modemParamValues.length) return false;
if (modemParamValues.length == o.modemParamValues.length) for(int i = 0 ; i < modemParamValues.length; i ++ )
{
if((modemParamValues[i] !=null && o.modemParamValues[i] == null) ||(modemParamValues[i] == null && o.modemParamValues[i] != null) ) return false;
if(modemParamValues[i] !=null && o.modemParamValues[i] != null)
if (!modemParamValues[i].equals(o.modemParamValues[i])) return false;
}
}

return true;
}

}
























