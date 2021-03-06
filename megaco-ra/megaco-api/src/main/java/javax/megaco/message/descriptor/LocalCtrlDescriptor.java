package javax.megaco.message.descriptor;

import java.io.Serializable;


import javax.megaco.message.Descriptor;
import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.PkgItemStr;
import javax.megaco.pkg.PkgPrptyItem;

/**
 * The class extends JAIN MEGACO Descriptor. This class describes the local
 * control descriptor. It specifies the stream mode, value of reserve group/
 * reserve value and the package property values.
 */
public class LocalCtrlDescriptor extends Descriptor implements Serializable {

	private StreamMode streamMode;
	private Boolean reserveValue;
	private Boolean reserveGroup;
	private PkgPrptyItem[] pkgPrptyItem;
	private PkgItemStr[] pkgItemStr;

	/**
	 * Constructs a LclCtrl Descriptor object. The object may contain atleast
	 * one of stream mode, reserve value, reserve group and property param.
	 */
	public LocalCtrlDescriptor() {
		super();
		super.descriptorId = DescriptorType.M_LOCAL_CONTROL_DESC;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * returns that the descriptor identifier is of type descriptor LclCtrl.
	 * This method overrides the corresponding method of the base class
	 * Descriptor.
	 * 
	 * @return Returns an integer value that identifies this local control
	 *         object as the type of local control descriptor. It returns that
	 *         it is LclCtrl Descriptor i.e., M_LOCAL_CONTROL_DESC.
	 */
	public final int getDescriptorId() {
		return super.descriptorId;
	}

	/**
	 * This method gets the Stream mode for the local control descriptor. This
	 * shall specify one of send only or receive only or send receive or
	 * inactive or loopback.
	 * 
	 * @return Returns the StreamMode value which identifies the stream mode. If
	 *         the stream mode is not set then this shall return null. The
	 *         possible values are field constants defined in the class
	 *         StreamMode.
	 */
	public final StreamMode getStreamMode() {
		// FIXME: its int in jdoc

		return this.streamMode;
	}

	/**
	 * This method sets the stream mode with one of send ronly or receive only
	 * or send receive or inactive or loopback. When stream mode is not to be
	 * sent then this method would not be invoked.
	 * 
	 * @param streamMode
	 *            - Sets the object reference of the derived object of
	 *            StreamMode to specify one of send only or receive only or send
	 *            receive or inactive or loopback.
	 * @throws IllegalArgumentException
	 *             : This exception is raised if the reference of Stream Mode
	 *             passed to this method is NULL.
	 */
	public final void setStreamMode(StreamMode streamMode)

	throws IllegalArgumentException {

		if (streamMode == null) {
			throw new IllegalArgumentException("StreamMode must not be null.");
		}

		this.streamMode = streamMode;
	}

	/**
	 * Specifies if reserve value is True or False. If the reserve value was not
	 * set then this shall return the default value - False. Thus application
	 * can call this method without checking for whether the reserve value was
	 * set or not, but the stack should always call this method only after
	 * verifying that the reserve value was set.
	 * 
	 * @return Return FALSE if reserve value has not been set. Else it return
	 *         proper value.
	 */
	public final boolean getReserveValue() {
		if (!isReserveValuePresent()) {
			return false;
		}
		return this.reserveValue.booleanValue();
	}

	/**
	 * Sets the reserve value to be True or False. If application does not call
	 * this method then the corresponding parameter would not be sent to the
	 * peer.
	 * 
	 * @param reserveValue
	 *            reserveValue - Takes a value TRUE if the reserve value is to
	 *            be set to ON and FALSE if reserve value is to be set to False.
	 */
	public final void setReserveValue(boolean reserveValue) {
		this.reserveValue = new Boolean(reserveValue);
	}

	/**
	 * Specifies if reserve group is True or False. If the reserve group was not
	 * set then this shall return the default value - False. Thus application
	 * can call this method without checking for whether the reserve group was
	 * set or not, but the stack should always call this method only after
	 * verifying that the reserve group was set.
	 * 
	 * @return Returns FALSE when reserve group has not been set. Else it return
	 *         proper value.
	 */
	public final boolean getReserveGroup() {
		if (!isReserveGroupPresent())
			return false;
		return this.reserveGroup.booleanValue();
	}

	/**
	 * Sets the reserve group to be True or False. If application does not call
	 * this method then the corresponding parameter would not be sent to the
	 * peer.
	 * 
	 * @param reserveGroup
	 *            - Takes a value TRUE if the reserve group is to be set to ON
	 *            and FALSE if reserve group is to be set to False.
	 */
	public final void setReserveGroup(boolean reserveGroup) {
		this.reserveGroup = new Boolean(reserveGroup);
	}

	/**
	 * The method is used to get the vector of property param within the local
	 * control descriptor. If this is not set then this method shall return a
	 * NULL value.
	 * 
	 * @return Returns the vector of object reference of type PkgPrptyItem. If
	 *         the package property item is not set then this shall return a
	 *         NULL value.
	 */
	public final PkgPrptyItem[] getMegacoPkgPrptyItem() {
		return this.pkgPrptyItem;
	}

	/**
	 * Sets the vector of type PkgPrptyItem in a local control descriptor. If
	 * Megaco package property is not to be sent, then this method would not be
	 * called.
	 * 
	 * @param prptyParam
	 *            - The Megaco Property parameter specifying the property for
	 *            the termination in the command.
	 * @throws IllegalArgumentException
	 *             if the parameters set for the property parameter are such
	 *             that the LclCtrl Descriptor cannot be encoded.
	 */
	public final void setMegacoPkgPrptyItem(PkgPrptyItem[] prptyParam) throws IllegalArgumentException {

		// FIXME: what does this mean - cant be encoded?
		if (prptyParam == null) {
			throw new IllegalArgumentException("PkgPrptyItem[] must not be null");
		}

		if (prptyParam.length == 0) {
			throw new IllegalArgumentException("PkgPrptyItem[] must not be empty");
		}

		this.pkgPrptyItem = prptyParam;

	}

	/**
	 * The method is used to get the vector of property param within the local
	 * control descriptor. The property param returned in this case have package
	 * name, item name and associated parameters specified in the string format.
	 * If this is not set then this method shall return a NULL value.
	 * 
	 * @return Returns the vector of object reference of type PkgPrptyItem. If
	 *         the package property item is not set then this shall return a
	 *         NULL value.
	 */
	public final PkgItemStr[] getMegacoPkgItemStr() {
		return this.pkgItemStr;
	}

	/**
	 * Sets the vector of type PkgItemStr in a local control descriptor. If
	 * Megaco package property is not to be sent, then this method would not be
	 * called. This method would invoked for the packages which have not been
	 * defined in javax.megaco.pkg package.
	 * 
     * @param prptyParamStr 
     * @throws IllegalArgumentException
	 *             : This exception is raised if the reference of Package Item
	 *             string passed to this method is NULL.
	 */
	public final void setMegacoPkgItemStr(PkgItemStr[] prptyParamStr)

	throws IllegalArgumentException {
		if (prptyParamStr == null) {
			throw new IllegalArgumentException("PkgItemStr[] must not be null");
		}

		if (prptyParamStr.length == 0) {
			throw new IllegalArgumentException("PkgItemStr[] must not be empty");
		}

		this.pkgItemStr = prptyParamStr;
	}

	/**
	 * Specifies if reserve group is set or not.
	 * 
	 * @return Returns TRUE if the reserve group was set.
	 */
	public final boolean isReserveGroupPresent() {
		return this.reserveGroup != null;
	}

	/**
	 * Specifies if reserve value is set or not.
	 * 
	 * @return Returns TRUE if the reserve value was set.
	 */
	public final boolean isReserveValuePresent() {
		return this.reserveValue != null;
	}

















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("LocalCtrlDescriptor:");
bob.append(super.toString());

if(streamMode !=null)
bob.append("streamMode=").append(streamMode).append(",");
if(reserveValue !=null)
bob.append("reserveValue=").append(reserveValue).append(",");
if(reserveGroup !=null)
bob.append("reserveGroup=").append(reserveGroup).append(",");
if (pkgPrptyItem !=null && pkgPrptyItem.length > 0) { bob.append("pkgPrptyItem=["); 
 for(int i = 0 ; i < pkgPrptyItem.length; i ++ )
if(pkgPrptyItem[i] !=null)
bob.append(pkgPrptyItem[i]).append(",");
bob.append("]");}
if (pkgItemStr !=null && pkgItemStr.length > 0) { bob.append("pkgItemStr=["); 
 for(int i = 0 ; i < pkgItemStr.length; i ++ )
if(pkgItemStr[i] !=null)
bob.append(pkgItemStr[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.LocalCtrlDescriptor o = (javax.megaco.message.descriptor.LocalCtrlDescriptor)oo;
if (!super.equals(o)) return false;
if((streamMode !=null && o.streamMode == null) ||(streamMode == null && o.streamMode != null) ) return false;
if(streamMode ==null && o.streamMode == null) return true ; else if(streamMode !=null && o.streamMode != null)
if (streamMode != null && o.streamMode !=null && !streamMode.equals(o.streamMode)) return false;
if((reserveValue !=null && o.reserveValue == null) ||(reserveValue == null && o.reserveValue != null) ) return false;
if(reserveValue ==null && o.reserveValue == null) return true ; else if(reserveValue !=null && o.reserveValue != null)
if (reserveValue != null && o.reserveValue !=null && !reserveValue.equals(o.reserveValue)) return false;
if((reserveGroup !=null && o.reserveGroup == null) ||(reserveGroup == null && o.reserveGroup != null) ) return false;
if(reserveGroup ==null && o.reserveGroup == null) return true ; else if(reserveGroup !=null && o.reserveGroup != null)
if (reserveGroup != null && o.reserveGroup !=null && !reserveGroup.equals(o.reserveGroup)) return false;
if((pkgPrptyItem !=null && o.pkgPrptyItem == null) ||(pkgPrptyItem == null && o.pkgPrptyItem != null) ) return false;
if(pkgPrptyItem ==null && o.pkgPrptyItem == null) return true ; else if(pkgPrptyItem !=null && o.pkgPrptyItem != null)
{
if (pkgPrptyItem ==null && o.pkgPrptyItem == null) return true; else if (pkgPrptyItem.length != o.pkgPrptyItem.length) return false;
if (pkgPrptyItem.length == o.pkgPrptyItem.length) for(int i = 0 ; i < pkgPrptyItem.length; i ++ )
{
if((pkgPrptyItem[i] !=null && o.pkgPrptyItem[i] == null) ||(pkgPrptyItem[i] == null && o.pkgPrptyItem[i] != null) ) return false;
if(pkgPrptyItem[i] !=null && o.pkgPrptyItem[i] != null)
if (!pkgPrptyItem[i].equals(o.pkgPrptyItem[i])) return false;
}
}
if((pkgItemStr !=null && o.pkgItemStr == null) ||(pkgItemStr == null && o.pkgItemStr != null) ) return false;
if(pkgItemStr ==null && o.pkgItemStr == null) return true ; else if(pkgItemStr !=null && o.pkgItemStr != null)
{
if (pkgItemStr ==null && o.pkgItemStr == null) return true; else if (pkgItemStr.length != o.pkgItemStr.length) return false;
if (pkgItemStr.length == o.pkgItemStr.length) for(int i = 0 ; i < pkgItemStr.length; i ++ )
{
if((pkgItemStr[i] !=null && o.pkgItemStr[i] == null) ||(pkgItemStr[i] == null && o.pkgItemStr[i] != null) ) return false;
if(pkgItemStr[i] !=null && o.pkgItemStr[i] != null)
if (!pkgItemStr[i].equals(o.pkgItemStr[i])) return false;
}
}

return true;
}

}
























