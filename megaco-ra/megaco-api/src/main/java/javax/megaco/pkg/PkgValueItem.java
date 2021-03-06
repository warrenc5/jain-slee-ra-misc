package javax.megaco.pkg;

import java.util.Arrays;

import javax.megaco.ParameterNotSetException;

/**
 * This class is just a place holder for common part.
 * 
 * @author <a href="mailto:baranowb@gmail.com">baranowb - Bartosz Baranowski
 *         </a>
 * @author Amit Bhayani
 */
public abstract class PkgValueItem extends PkgItem {

    /**
     * 
     */
    protected int[] intValue;
    /**
     * 
     */
    protected String[] stringValue;
    /**
     * 
     */
    protected double[] doubleValue;
    /**
     * 
     */
    protected Boolean booleanValue = false;
    /**
     * 
     */
    protected int itemValueType = -1;

	/**
	 * The method can be used to set the valid value which is of string type.
	 * This is to be called only if the getItemValueType returns M_STRING. Else
	 * shall throw an exception.
	 * 
	 * @return value - The string values that needs to be set for the item.
	 * 
	 * @throws IllegalStateException
	 *             - Thrown if item value type is not of string type.
	 */
	public final java.lang.String[] getItemStringValue() throws IllegalStateException {
		if (itemValueType != ParamValueType.M_STRING) {
			throw new IllegalStateException("Item type is not String, its: " + super.typeToString(itemValueType));
		}

		return this.stringValue;
	}

	/**
	 * 
	 * The method can be used to set the valid item value which is of integer.
	 * This is to be called only if the getItemValueType returns
	 * {@link ParamValueType.M_INTEGER}. 
	 * 
	 * @return intValues - The integer values corresponding to the value set for
	 *         the item. The enumerated values shall be defined in in the
	 *         respective package parameter classes.
	 * 
	 * 
	 * @throws IllegalStateException
	 *             - Thrown if item value type is of enumerated type and the
	 *             value does not match with one of the enumerated members. It
	 *             shall also throw an exception if the value type is neither
	 *             integer nor enumerated. .
	 */
	public final int[] getItemIntValue() throws IllegalStateException {
		if (itemValueType != ParamValueType.M_INTEGER) {
			throw new IllegalStateException("Item type is not integer, its: " + super.typeToString(itemValueType));
		}

	
		return this.intValue;
	}

	/**
	 * The method can be used to get the valid value which is of boolean type.
	 * If the parameter value is of type boolean, only one value can be
	 * returned. This is to be called only if the getItemValueType returns
	 * {@link ParamValueType.M_BOOLEAN}. Else shall throw an exception.
	 * 
	 * @return booValue - The boolean value qualifying the item.
	 * 
	 * 
	 * @throws IllegalStateException
	 *             - Thrown if item value type is not of boolean type.
	 * @throws javax.megaco.ParameterNotSetException
	 *             - Thrown if this parameter has not been set.
	 */
	public final boolean getItemBooleanValue() throws IllegalStateException, javax.megaco.ParameterNotSetException {
		if (itemValueType != ParamValueType.M_BOOLEAN) {
			throw new IllegalStateException("Item type is not boolean, its: " + super.typeToString(this.itemValueType));
		}
		
		//FIXME: return Boolean
		if (this.booleanValue == null) {
			throw new ParameterNotSetException();
		}
		return this.booleanValue.booleanValue();
	}

	/**
	 * The method can be used to get the valid value which is of double type.
	 * This is to be called only if the getItemValueType returns
	 * {@link ParamValueType.M_DOUBLE}. Else shall throw an exception. This
	 * shall change to INT64 bit value in the next release of RFC3015.
	 * 
	 * @return doubleValues - The double values corresponding to the items to
	 *         which the value is set.
	 * @throws IllegalStateException
	 *             - Thrown if item value type is not of double type.
	 */
	public final double[] getItemDoubleValue() throws IllegalStateException {
		if (itemValueType != ParamValueType.M_DOUBLE) {
			throw new IllegalStateException("Item type is not double, its: " + super.typeToString(itemValueType));
		}

	
		return this.doubleValue;
	}

	/**
	 * This method sets the list of values where each element is of string type.
	 * This is to be called only if the getItemValueType returns
	 * {@link ParamValueType.M_STRING}. Else shall throw an exception.
	 * 
	 * @param value
	 *            - A vector of string values.
	 * @throws IllegalArgumentException
	 *             - Thrown if invalid argument is passed for setting the item
	 *             value.
	 */
	public final void setItemValue(java.lang.String[] value) throws IllegalArgumentException {
		if (value == null) {
			// FIXME: ??
			throw new IllegalArgumentException("Value can not be null");
		}

		if (itemValueType != ParamValueType.M_STRING) {
			throw new IllegalArgumentException("Item type is not String, its: " + super.typeToString(itemValueType));
		}
		this.stringValue = value;
	}

	/**
	 * This method sets the list of values where each element is of integer
	 * type. This is to be called only if the getItemValueType returns
	 * {@link ParamValueType.M_INTEGER}. If values is of enumerated type, the
	 * integer value should be one defined in the corresponding parameter's
	 * constants. Else shall throw an exception.
	 * 
	 * 
	 * 
	 * @param value
	 *            - A vector of integer values.
	 * @throws IllegalArgumentException
	 *             - Thrown if invalid argument is passed for setting the item
	 *             value.
	 */
	public final void setItemValue(int[] value) throws IllegalArgumentException {
		if (value == null) {
			// FIXME: ??
			throw new IllegalArgumentException("Value can not be null");
		}

		if (itemValueType != ParamValueType.M_INTEGER) {
			throw new IllegalArgumentException("Item type is not integer, its: " + super.typeToString(itemValueType));
		}
		this.intValue = value;
	}

	/**
	 * 
	 * This method sets the valid value which is of boolean type. If the
	 * parameter value is of type boolean, only one value can be set. This is to
	 * be called only if the getItemValueType returns
	 * {@link ParamValueType.M_BOOLEAN}. Else shall throw an exception.
	 * 
	 * @param value
	 *            - a Boolean value
	 * @throws IllegalArgumentException
	 *             - Thrown if invalid argument is passed for setting the item
	 *             value.
	 */
	public final void setItemValue(boolean value) throws IllegalArgumentException {

		// FIXME: jsr jdoc has no throws
		if (itemValueType != ParamValueType.M_BOOLEAN) {
			throw new IllegalArgumentException("Item type is not boolean, its: " + super.typeToString(itemValueType));
		}
		this.booleanValue = new Boolean(value);
	}

	/**
	 * 
	 * This method sets the list of values where each element is of double type.
	 * This is to be called only if the getItemValueType returns
	 * {@link ParamValueType.M_DOUBLE}. Else shall throw an exception. This
	 * shall change to INT64 bit value in the next release of RFC3015.
	 * 
	 * @param value
	 *            - A vector of double values.
	 * @throws IllegalArgumentException
	 *             - Thrown if invalid argument is passed for setting the item
	 *             value.
	 */
	public final void setItemValue(double[] value) throws IllegalArgumentException {
		if (value == null) {
			// FIXME: ??
			throw new IllegalArgumentException("Value can not be null");
		}

		if (itemValueType != ParamValueType.M_DOUBLE) {
			throw new IllegalArgumentException("Item type is not double, its: " + super.typeToString(itemValueType));
		}
		this.doubleValue = value;
	}

    /**
     * 
     * @return
     */
    protected String getValueAsString() {
		switch (itemValueType) {
		case ParamValueType.M_BOOLEAN:
			if (this.booleanValue != null)
				return this.booleanValue + "";
			break;
		case ParamValueType.M_DOUBLE:
			if (this.doubleValue != null)
				return Arrays.toString(this.doubleValue);
			break;
		case ParamValueType.M_INTEGER:
			if (this.intValue != null)
				return Arrays.toString(this.intValue);
			break;
		case ParamValueType.M_STRING:
			if (this.stringValue != null)
				return Arrays.toString(this.stringValue);
			break;
		default:
			return "Value not set";

		}

		return "Value not set";
	}











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("PkgValueItem:");
bob.append(super.toString());

if (intValue !=null && intValue.length > 0) { bob.append("intValue=["); 
 for(int i = 0 ; i < intValue.length; i ++ )
bob.append(intValue[i]).append(",");
bob.append("]");}
if (stringValue !=null && stringValue.length > 0) { bob.append("stringValue=["); 
 for(int i = 0 ; i < stringValue.length; i ++ )
if(stringValue[i] !=null)
bob.append(stringValue[i]).append(",");
bob.append("]");}
if (doubleValue !=null && doubleValue.length > 0) { bob.append("doubleValue=["); 
 for(int i = 0 ; i < doubleValue.length; i ++ )
bob.append(doubleValue[i]).append(",");
bob.append("]");}
if(booleanValue !=null)
bob.append("booleanValue=").append(booleanValue).append(",");
bob.append("itemValueType=").append(itemValueType).append(",");

return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.PkgValueItem o = (javax.megaco.pkg.PkgValueItem)oo;
if (!super.equals(o)) return false;
if((intValue !=null && o.intValue == null) ||(intValue == null && o.intValue != null) ) return false;
if (intValue ==null && o.intValue == null) return true; else if (intValue.length != o.intValue.length) return false;
if (intValue.length == o.intValue.length) for(int i = 0 ; i < intValue.length; i ++ )
if (intValue[i] != o.intValue[i]) return false;
if((stringValue !=null && o.stringValue == null) ||(stringValue == null && o.stringValue != null) ) return false;
if(stringValue ==null && o.stringValue == null) return true ; else if(stringValue !=null && o.stringValue != null)
{
if (stringValue ==null && o.stringValue == null) return true; else if (stringValue.length != o.stringValue.length) return false;
if (stringValue.length == o.stringValue.length) for(int i = 0 ; i < stringValue.length; i ++ )
{
if((stringValue[i] !=null && o.stringValue[i] == null) ||(stringValue[i] == null && o.stringValue[i] != null) ) return false;
if(stringValue[i] !=null && o.stringValue[i] != null)
if (!stringValue[i].equals(o.stringValue[i])) return false;
}
}
if((doubleValue !=null && o.doubleValue == null) ||(doubleValue == null && o.doubleValue != null) ) return false;
if (doubleValue ==null && o.doubleValue == null) return true; else if (doubleValue.length != o.doubleValue.length) return false;
if (doubleValue.length == o.doubleValue.length) for(int i = 0 ; i < doubleValue.length; i ++ )
if (doubleValue[i] != o.doubleValue[i]) return false;
if((booleanValue !=null && o.booleanValue == null) ||(booleanValue == null && o.booleanValue != null) ) return false;
if(booleanValue ==null && o.booleanValue == null) return true ; else if(booleanValue !=null && o.booleanValue != null)
if (booleanValue != null && o.booleanValue !=null && !booleanValue.equals(o.booleanValue)) return false;
if (itemValueType != o.itemValueType) return false;

return true;
}

}


















