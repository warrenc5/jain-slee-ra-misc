package javax.megaco.message.descriptor;

import java.io.Serializable;



/**
 * The DigitMapString object is a class that shall be used to set the digit
 * string in digit map within the digit map descriptor. This is an independent
 * class derived from java.util.Object and shall not have any derived classes.
 * Each digit string object in turn stores a vector of DigitPosition object
 * references. The DigitPosition object specifies the combination of digits that
 * can be present at a position in the digit string.
 */
public class DigitMapString implements Serializable {

	private DigitStringPosition[] digitStringPosition = null;

	/**
	 * Constructs a Digit Map String Object. This shall contain information
	 * about the digit string in the digit plan.
	 */
	public DigitMapString() {
		super();

	}

	/**
	 * The method is used to get the vector of the digit position object
	 * references. Each of these digit positions represents digits with values
	 * between 1-9 and A-K, L, S or Z. The index of the vector
	 * DigitStringPosition gives the position for which the position object is
	 * specifying the digits.
	 * 
	 * @return The vector specifying the digit combinations that can occur at
	 *         each digit position for the current digit string in a digit plan.
	 *         If no value for digit position is specified, then this method
	 *         will return NULL.
	 */
	public DigitStringPosition[] getDigitStringPosition() {
		return this.digitStringPosition;
	}

	/**
	 * The method sets the vector of the object identifier for the digit
	 * positions. Each of the vector element specifies digits that are valid for
	 * each digit position within one digit string. The index of the vector
	 * DigitStringPosition gives the position for which the position object is
	 * specifying the digits.
	 * 
	 * @param digitPositions
	 *            The vector of the object identifer of the digit positions.
	 * @throws IllegalArgumentException
	 *             : This exception is raised if the reference of Digit String
	 *             Position passed to this method is NULL.
	 */
	public void setDigitStringPosition(DigitStringPosition[] digitPositions) throws IllegalArgumentException {
		if (digitPositions == null) {
			throw new IllegalArgumentException("DigitStringPosition[] must not be null.");
		}
		this.digitStringPosition = digitPositions;
	}

















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DigitMapString:");

if (digitStringPosition !=null && digitStringPosition.length > 0) { bob.append("digitStringPosition=["); 
 for(int i = 0 ; i < digitStringPosition.length; i ++ )
if(digitStringPosition[i] !=null)
bob.append(digitStringPosition[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.DigitMapString o = (javax.megaco.message.descriptor.DigitMapString)oo;
if((digitStringPosition !=null && o.digitStringPosition == null) ||(digitStringPosition == null && o.digitStringPosition != null) ) return false;
if(digitStringPosition ==null && o.digitStringPosition == null) return true ; else if(digitStringPosition !=null && o.digitStringPosition != null)
{
if (digitStringPosition ==null && o.digitStringPosition == null) return true; else if (digitStringPosition.length != o.digitStringPosition.length) return false;
if (digitStringPosition.length == o.digitStringPosition.length) for(int i = 0 ; i < digitStringPosition.length; i ++ )
{
if((digitStringPosition[i] !=null && o.digitStringPosition[i] == null) ||(digitStringPosition[i] == null && o.digitStringPosition[i] != null) ) return false;
if(digitStringPosition[i] !=null && o.digitStringPosition[i] != null)
if (!digitStringPosition[i].equals(o.digitStringPosition[i])) return false;
}
}

return true;
}

}


























