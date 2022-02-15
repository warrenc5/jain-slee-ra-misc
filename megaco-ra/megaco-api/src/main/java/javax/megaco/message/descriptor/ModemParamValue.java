package javax.megaco.message.descriptor;

import java.io.Serializable;


import javax.megaco.pkg.ParamRelation;
import javax.megaco.pkg.ParamValueType;

/**
 * The MEGACO Modem Parameter value class stores the parameter name and value
 * for the Modem Descriptor.
 */
public class ModemParamValue implements Serializable {

	private ParamRelation paramRelation;
	private String paramName;
	private java.lang.String[] paramsValue;

	/**
	 * Constructs a Jain Megaco Modem Parameter Value class that is used for
	 * specifying the parameters of a modem descriptor.
	 */
	public ModemParamValue() {

	}

	/**
	 * The method can be used to get the parameter name for the modem descriptor
	 * parameter.
	 * 
	 * @return paramName - The string value corresponding to the parameter name.
	 *         If the param name is not set then this method will return NULL.
	 */
	public java.lang.String getParamName() {

		return this.paramName;
	}

	/**
	 * The method can be used to set the parameter name for the modem descriptor
	 * parameter.
	 * 
	 * @param name
	 *            - The string value corresponding to the parameter name.
	 * @throws IllegalArgumentException
	 *             - Exception shall be thrown if the param name is not of
	 *             proper format.
	 */
	public void setParamName(java.lang.String name) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("ParamName must not be null");
		}

		DescriptorUtils.checkParamNameRules(name);

		this.paramName = name;
	}

	/**
	 * The method can be used to get the relation set in the parameter for the
	 * parameter value as defined in the MEGACO packages. The relation operator
	 * can be one of equal, not equal, greater than or less than operator for
	 * single value. The Megaco parameter is accompanied by a parameter value
	 * that can be single value or set of values or sublist of values or range
	 * of values. The relation operator can be equal when the value is set or
	 * sublist or range. This method specifies both the relation operator and
	 * also specifies whether the accompaning parameter value is single value or
	 * set of values or sublist of values or range of value. If the relation
	 * specifies set or range or sublist, it automatically assumes the relation
	 * to be "MEGACO_EQUAL".
	 * 
	 * @return paramRelation - The integer corresponding to the parameter
	 *         relation. The values shall be defined in ParamRelation. If the
	 *         param value is not set then this method will return NULL.
	 */
	public ParamRelation getParamsValueRelation() {
		return this.paramRelation;
	}

	/**
	 * The method can be used to get the valid parameter which is of string
	 * type.
	 * 
	 * @return value - The string values that needs to be set for the parameter.
	 *         If the param value is not set then this method will return NULL.
	 */
	public java.lang.String[] getParamsValue() {
		return this.paramsValue;
	}

	/**
	 * The method can be used to set the relation of the value as defined in the
	 * MEGACO packages. The relation operator can be one of equal, not equal,
	 * greater than or less than operator for single value. The Megaco parameter
	 * is accompanied by a parameter value that can be single value or set of
	 * values or sublist of values or range of values. The relation operator can
	 * be equal when the value is set or sublist or range. This method specifies
	 * both the relation operator and also specifies whether the accompaning
	 * parameter value is single value or set of values or sublist of values or
	 * range of value. If the relation specifies set or range or sublist, it
	 * automatically assumes the relation to be "MEGACO_EQUAL". The default
	 * value of the relation can be set in constructor of each class that
	 * derives this class.
	 * 
	 * @param paramRelation
	 *            paramRelation - The integer corresponding to the value
	 *            relation. The values shall be defined in ParamRelation.
	 * @throws IllegalArgumentException
	 *             : This exception is raised if the reference of Param Relation
	 *             passed to this method is NULL.
	 */
	public void setParamsValueRelation(ParamRelation paramRelation) throws IllegalArgumentException {
		if (paramRelation == null) {
			throw new IllegalArgumentException("ParamRelation must not be null.");
		}

		this.paramRelation = paramRelation;
	}

	/**
	 * This method sets the list of parameter values where each element is of
	 * string type.
	 * 
	 * @param value
	 *            - A vector of string values.
	 * @throws IllegalArgumentException
	 *             - Thrown if invalid argument is passed for setting the item
	 *             value.
	 */
	public void setParamsValue(java.lang.String[] value) throws IllegalArgumentException {
		if (value == null) {
			throw new IllegalArgumentException("Value must not be null.");
		}
		if (value.length == 0) {
			throw new IllegalArgumentException("Value must not be empty.");
		}
		this.paramsValue = value;
	}

















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ModemParamValue:");

if(paramRelation !=null)
bob.append("paramRelation=").append(paramRelation).append(",");
if(paramName !=null)
bob.append("paramName=").append(paramName).append(",");
if (paramsValue !=null && paramsValue.length > 0) { bob.append("paramsValue=["); 
 for(int i = 0 ; i < paramsValue.length; i ++ )
if(paramsValue[i] !=null)
bob.append(paramsValue[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.ModemParamValue o = (javax.megaco.message.descriptor.ModemParamValue)oo;
if((paramRelation !=null && o.paramRelation == null) ||(paramRelation == null && o.paramRelation != null) ) return false;
if(paramRelation ==null && o.paramRelation == null) return true ; else if(paramRelation !=null && o.paramRelation != null)
if (paramRelation != null && o.paramRelation !=null && !paramRelation.equals(o.paramRelation)) return false;
if((paramName !=null && o.paramName == null) ||(paramName == null && o.paramName != null) ) return false;
if(paramName ==null && o.paramName == null) return true ; else if(paramName !=null && o.paramName != null)
if (paramName != null && o.paramName !=null && !paramName.equals(o.paramName)) return false;
if((paramsValue !=null && o.paramsValue == null) ||(paramsValue == null && o.paramsValue != null) ) return false;
if(paramsValue ==null && o.paramsValue == null) return true ; else if(paramsValue !=null && o.paramsValue != null)
{
if (paramsValue ==null && o.paramsValue == null) return true; else if (paramsValue.length != o.paramsValue.length) return false;
if (paramsValue.length == o.paramsValue.length) for(int i = 0 ; i < paramsValue.length; i ++ )
{
if((paramsValue[i] !=null && o.paramsValue[i] == null) ||(paramsValue[i] == null && o.paramsValue[i] != null) ) return false;
if(paramsValue[i] !=null && o.paramsValue[i] != null)
if (!paramsValue[i].equals(o.paramsValue[i])) return false;
}
}

return true;
}

}


























