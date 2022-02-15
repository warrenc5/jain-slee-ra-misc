package javax.megaco.message.descriptor;

import java.io.Serializable;


import javax.megaco.ParameterNotSetException;

/**
 * The DigitMapValue object is a class that shall be used to set the digit map
 * within the digit map descriptor. The DigitMap value class contains
 * information about the dial plan. This may also contains special symbols like
 * wildcards and timer values to be used on application of the dial plan. This
 * is an independent class derived from java.util.Object and shall not have any
 * derived classes.
 */
public class DigitMapValue implements Serializable {

	private Integer timerT, timerL, timerS;
	private DigitMapString[] digitMapString = null;

	/**
	 * Constructs a Digit Map Value Object. This shall contain information about
	 * the digit string in the dial plan.
	 */
	public DigitMapValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method specifies whether the timer T value is present or not.
	 * 
	 * @return TRUE if the timer T value is present.
	 */
	public boolean isTimerTPresent() {
		return this.timerT != null;
	}

	/**
	 * The method gets the timer T value.This method should be invoked after
	 * verifying using method isTimerTPresent() that the timer T value has been
	 * set.
	 * 
	 * @return The integer value for the timer value if it is set.
	 * @throws javax.megaco.ParameterNotSetException
	 *             - if isTimerTPresent() returns FALSE.
	 */
	public int getTimerTValue() throws javax.megaco.ParameterNotSetException {
		if (!this.isTimerTPresent()) {
			throw new ParameterNotSetException("Timer value has not been set.");
		}
		return this.timerT.intValue();
	}

	/**
	 * The method sets the timer T value.
	 * 
	 * @param timerT
	 *            The integer value for the timer value. This automatically sets
	 *            the isTimerTPresent() to TRUE.
	 * @throws IllegalArgumentException
	 *             - if timer value is not correctly set.
	 */
	public void setTimerTValue(int timerT) throws IllegalArgumentException {
		if (timerT <= 0) {
			new IllegalArgumentException("Timer value must not be less or equal to zero");
		}
		this.timerT = timerT;
	}

	/**
	 * This method specifies whether the timer S value is present or not.
	 * 
	 * @return TRUE if the timer S value is present.
	 */
	public boolean isTimerSPresent() {
		return this.timerS != null;
	}

	/**
	 * The method gets the timer S value. This method should be invoked after
	 * verifying using method isTimerSPresent() that the timer S value has been
	 * set.
	 * 
	 * @return The integer value for the timer value if it is set.
	 * @throws javax.megaco.ParameterNotSetException
	 *             - if isTimerSPresent() returns FALSE.
	 */
	public int getTimerSValue() throws javax.megaco.ParameterNotSetException {
		if (!this.isTimerSPresent()) {
			throw new ParameterNotSetException("Timer value has not been set.");
		}
		return this.timerS.intValue();
	}

	/**
	 * The method sets the timer S value.
	 * 
	 * @param timerS
	 *            The integer value for the timer value. This automatically sets
	 *            the isTimerSPresent() to TRUE.
	 * @throws IllegalArgumentException
	 *             - if timer value is not correctly set.
	 */
	public void setTimerSValue(int timerS) throws IllegalArgumentException {
		if (timerS <= 0) {
			new IllegalArgumentException("Timer value must not be less or equal to zero");
		}
		this.timerS = timerS;
	}

	/**
	 * This method specifies whether the timer L value is present or not.
	 * 
	 * @return TRUE if the timer L value is present.
	 */
	public boolean isTimerLPresent() {
		return this.timerL != null;
	}

	/**
	 * The method gets the timer L value. This method should be invoked after
	 * verifying using method isTimerLPresent() that the timer L value has been
	 * set.
	 * 
	 * @return The integer value for the timer value if it is set.
	 * @throws javax.megaco.ParameterNotSetException
	 *             - if isTimerLPresent() returns FALSE.
	 */
	public int getTimerLValue() throws javax.megaco.ParameterNotSetException {
		if (!this.isTimerLPresent()) {
			throw new ParameterNotSetException("Timer value has not been set.");
		}
		return this.timerL.intValue();
	}

	/**
	 * The method sets the timer L value.
	 * 
	 * @param timerL
	 *            The integer value for the timer value. This automatically sets
	 *            the isTimerLPresent() to TRUE.
	 * @throws IllegalArgumentException
	 *             - if timer value is not correctly set.
	 */
	public void setTimerLValue(int timerL) throws IllegalArgumentException {
		if (timerL <= 0) {
			new IllegalArgumentException("Timer value must not be less or equal to zero");
		}
		this.timerL = timerL;
	}

	/**
	 * The method is used to get the vector of all dial plans in the digit map.
	 * 
	 * @return The vector of all digit strings in a dial plan. If the vector of
	 *         digit map strings is not set then this method will return NULL.
	 */
	public DigitMapString[] getDigitMapStrings() {
		return this.digitMapString;
	}

	/**
	 * The method sets the vector of the object identifier for the digit string.
	 * Each of the vector element specifies one digit string.
	 * 
	 * @param digitStrings
	 *            The vector of the object identifer of the digit strings.
	 * @throws IllegalArgumentException
	 *             - if the digit string is not set properly.
	 */
	public void setDigitMapStrings(DigitMapString[] digitStrings) throws IllegalArgumentException {
		// FIXME: what does mean - not correctly?
		this.digitMapString = digitStrings;
	}

















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DigitMapValue:");

if(timerT !=null)
bob.append("timerT=").append(timerT).append(",");
if(timerL !=null)
bob.append("timerL=").append(timerL).append(",");
if(timerS !=null)
bob.append("timerS=").append(timerS).append(",");
if (digitMapString !=null && digitMapString.length > 0) { bob.append("digitMapString=["); 
 for(int i = 0 ; i < digitMapString.length; i ++ )
if(digitMapString[i] !=null)
bob.append(digitMapString[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.DigitMapValue o = (javax.megaco.message.descriptor.DigitMapValue)oo;
if((timerT !=null && o.timerT == null) ||(timerT == null && o.timerT != null) ) return false;
if(timerT ==null && o.timerT == null) return true ; else if(timerT !=null && o.timerT != null)
if (timerT != null && o.timerT !=null && !timerT.equals(o.timerT)) return false;
if((timerL !=null && o.timerL == null) ||(timerL == null && o.timerL != null) ) return false;
if(timerL ==null && o.timerL == null) return true ; else if(timerL !=null && o.timerL != null)
if (timerL != null && o.timerL !=null && !timerL.equals(o.timerL)) return false;
if((timerS !=null && o.timerS == null) ||(timerS == null && o.timerS != null) ) return false;
if(timerS ==null && o.timerS == null) return true ; else if(timerS !=null && o.timerS != null)
if (timerS != null && o.timerS !=null && !timerS.equals(o.timerS)) return false;
if((digitMapString !=null && o.digitMapString == null) ||(digitMapString == null && o.digitMapString != null) ) return false;
if(digitMapString ==null && o.digitMapString == null) return true ; else if(digitMapString !=null && o.digitMapString != null)
{
if (digitMapString ==null && o.digitMapString == null) return true; else if (digitMapString.length != o.digitMapString.length) return false;
if (digitMapString.length == o.digitMapString.length) for(int i = 0 ; i < digitMapString.length; i ++ )
{
if((digitMapString[i] !=null && o.digitMapString[i] == null) ||(digitMapString[i] == null && o.digitMapString[i] != null) ) return false;
if(digitMapString[i] !=null && o.digitMapString[i] != null)
if (!digitMapString[i].equals(o.digitMapString[i])) return false;
}
}

return true;
}

}


























