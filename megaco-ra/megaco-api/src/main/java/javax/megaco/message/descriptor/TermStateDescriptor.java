package javax.megaco.message.descriptor;

import java.io.Serializable;


import javax.megaco.message.Descriptor;
import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.PkgItemStr;
import javax.megaco.pkg.PkgPrptyItem;

/**
 * The class extends JAIN MEGACO Descriptor. This class describes the
 * termination state descriptor. It specifies the service state, event buffer
 * control and the package property values. Atleaset one of the above needs to
 * be specified for the termination state descriptor.
 */
public class TermStateDescriptor extends Descriptor implements Serializable {

	private ServiceState serviceState = null;
	private EventBufferCtrl evtBufferControl = null;
	private PkgPrptyItem[] pkgPrptyItems = null;
	private PkgItemStr[] prptyParamStr;

	/**
	 * Constructs a TermState Descriptor which may contain atleast one of
	 * service state, reserve value, reserve group and property param.
	 */
	public TermStateDescriptor() {
		super();
		super.descriptorId = DescriptorType.M_TERMINATION_STATE_DESC;
	}

	@Override
	public int getDescriptorId() {
		return super.descriptorId;
	}

	/**
	 * This method gets the service state for the termination state descriptor.
	 * This shall specify one of out of service or in service or test. When
	 * service state is not present, then this shall return value null.
	 * 
	 * @return Returns the object reference of type service state. If the
	 *         service state is not set then this shall return value null.
	 */
	public final ServiceState getServiceState() {

		return this.serviceState;
	}

	/**
	 * This method sets the service state with one of out of service or in
	 * service or test. When service state is not to be sent then this method
	 * would not be invoked.
	 * 
	 * @param serviceState
	 *            - Sets the object reference of the derived object of
	 *            ServiceState to specify one of out of service or in service or
	 *            test.
	 * @throws IllegalArgumentException
	 *             : This exception is raised if the reference of Service State
	 *             passed to this method is NULL.
	 */
	public final void setServiceState(ServiceState serviceState)

	throws IllegalArgumentException {
		if (serviceState == null) {
			throw new IllegalArgumentException("ServiceState must not be null.");
		}

		this.serviceState = serviceState;
	}

	/**
	 * This method gets the event buffer control for the termination state
	 * descriptor. This shall specify one of off or lock step. When event buffer
	 * control is not present, then this shall return value null.
	 * 
	 * @return Returns the object reference of type event buffer control. If the
	 *         event buffer control is not set then this shall return value nul.
	 */
	public final EventBufferCtrl getEvtBufferControl() {

		return this.evtBufferControl;
	}

	/**
	 * This method sets the event buffer control with one of off or lock step.
	 * When event buffer control is not to be sent then this method would not be
	 * invoked.
	 * 
	 * @param eventBufferControl
	 *            - Sets the object reference of the derived object of
	 *            EventBufferCtrl to specify one of off or lock step.
	 * @throws IllegalArgumentException
	 *             : This exception is raised if the reference of Event Buffer
	 *             Control passed to this method is NULL.
	 */
	public final void setEvtBufferControl(EventBufferCtrl eventBufferControl) throws IllegalArgumentException {

		if (eventBufferControl == null) {
			throw new IllegalArgumentException("EventBufferCtrl must not be null.");
		}
		this.evtBufferControl = eventBufferControl;
	}

	/**
	 * The method is used to get the vector of property param within the
	 * termination state descriptor. If this is not set then this method shall
	 * return a NULL value.
	 * 
	 * @return Returns the vector of object reference of type PkgPrptyItem. If
	 *         the package property item is not set then this shall return a
	 *         NULL value.
	 */
	public final PkgPrptyItem[] getMegacoPkgPrptyItem() {
		return this.pkgPrptyItems;
	}

	/**
	 * Sets the vector of type PkgPrptyItem in a termination state descriptor.
	 * If Megaco package property is not to be sent, then this method would not
	 * be called.
	 * 
	 * @param prptyParam
	 *            - The Megaco Property parameter specifying the property for
	 *            the termination in the command.
	 * @throws IllegalArgumentException
	 *             - if the parameters set for the property parameter are such
	 *             that the TermState Descriptor cannot be encoded.
	 */
	public final void setMegacoPkgPrptyItem(PkgPrptyItem[] prptyParam) throws IllegalArgumentException {

		// FIXME: add error checks
		if (prptyParam == null) {
			throw new IllegalArgumentException("PkgPrptyItem[] must not be null.");
		}
		if (prptyParam.length == 0) {
			throw new IllegalArgumentException("PkgPrptyItem[] must not be empty.");
		}
		this.pkgPrptyItems = prptyParam;

	}

	/**
	 * The method is used to get the vector of property param within the
	 * termination state descriptor. The property param returned in this case
	 * have package name, item name and associated parameters specified in the
	 * string format. If this is not set then this method shall return a NULL
	 * value.
	 * 
	 * @return Returns the vector of object reference of type PkgPrptyItem. If
	 *         the package property item is not set then this shall return a
	 *         NULL value.
	 */
	public final PkgItemStr[] getMegacoPkgItemStr() {
		return this.prptyParamStr;
	}

	/**
	 * Sets the vector of type PkgItemStr in a termination state descriptor. If
	 * Megaco package property is not to be sent, then this method would not be
	 * called. This method would invoked for the packages which have not been
	 * defined in javax.megaco.pkg package.
	 * 
     * @param prptyParamStr 
     * @throws IllegalArgumentException
	 *             : This exception is raised if the reference of Package Item
	 *             string passed to this method is NULL.
	 */
	public final void setMegacoPkgItemStr(PkgItemStr[] prptyParamStr) throws IllegalArgumentException {
		// FIXME: add error checks
		if (prptyParamStr == null) {
			throw new IllegalArgumentException("PkgItemStr[] must not be null.");
		}
		if (prptyParamStr.length == 0) {
			throw new IllegalArgumentException("PkgItemStr[] must not be empty.");
		}
		this.prptyParamStr = prptyParamStr;
	}

















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("TermStateDescriptor:");
bob.append(super.toString());

if(serviceState !=null)
bob.append("serviceState=").append(serviceState).append(",");
if(evtBufferControl !=null)
bob.append("evtBufferControl=").append(evtBufferControl).append(",");
if (pkgPrptyItems !=null && pkgPrptyItems.length > 0) { bob.append("pkgPrptyItems=["); 
 for(int i = 0 ; i < pkgPrptyItems.length; i ++ )
if(pkgPrptyItems[i] !=null)
bob.append(pkgPrptyItems[i]).append(",");
bob.append("]");}
if (prptyParamStr !=null && prptyParamStr.length > 0) { bob.append("prptyParamStr=["); 
 for(int i = 0 ; i < prptyParamStr.length; i ++ )
if(prptyParamStr[i] !=null)
bob.append(prptyParamStr[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.TermStateDescriptor o = (javax.megaco.message.descriptor.TermStateDescriptor)oo;
if (!super.equals(o)) return false;
if((serviceState !=null && o.serviceState == null) ||(serviceState == null && o.serviceState != null) ) return false;
if(serviceState ==null && o.serviceState == null) return true ; else if(serviceState !=null && o.serviceState != null)
if (serviceState != null && o.serviceState !=null && !serviceState.equals(o.serviceState)) return false;
if((evtBufferControl !=null && o.evtBufferControl == null) ||(evtBufferControl == null && o.evtBufferControl != null) ) return false;
if(evtBufferControl ==null && o.evtBufferControl == null) return true ; else if(evtBufferControl !=null && o.evtBufferControl != null)
if (evtBufferControl != null && o.evtBufferControl !=null && !evtBufferControl.equals(o.evtBufferControl)) return false;
if((pkgPrptyItems !=null && o.pkgPrptyItems == null) ||(pkgPrptyItems == null && o.pkgPrptyItems != null) ) return false;
if(pkgPrptyItems ==null && o.pkgPrptyItems == null) return true ; else if(pkgPrptyItems !=null && o.pkgPrptyItems != null)
{
if (pkgPrptyItems ==null && o.pkgPrptyItems == null) return true; else if (pkgPrptyItems.length != o.pkgPrptyItems.length) return false;
if (pkgPrptyItems.length == o.pkgPrptyItems.length) for(int i = 0 ; i < pkgPrptyItems.length; i ++ )
{
if((pkgPrptyItems[i] !=null && o.pkgPrptyItems[i] == null) ||(pkgPrptyItems[i] == null && o.pkgPrptyItems[i] != null) ) return false;
if(pkgPrptyItems[i] !=null && o.pkgPrptyItems[i] != null)
if (!pkgPrptyItems[i].equals(o.pkgPrptyItems[i])) return false;
}
}
if((prptyParamStr !=null && o.prptyParamStr == null) ||(prptyParamStr == null && o.prptyParamStr != null) ) return false;
if(prptyParamStr ==null && o.prptyParamStr == null) return true ; else if(prptyParamStr !=null && o.prptyParamStr != null)
{
if (prptyParamStr ==null && o.prptyParamStr == null) return true; else if (prptyParamStr.length != o.prptyParamStr.length) return false;
if (prptyParamStr.length == o.prptyParamStr.length) for(int i = 0 ; i < prptyParamStr.length; i ++ )
{
if((prptyParamStr[i] !=null && o.prptyParamStr[i] == null) ||(prptyParamStr[i] == null && o.prptyParamStr[i] != null) ) return false;
if(prptyParamStr[i] !=null && o.prptyParamStr[i] != null)
if (!prptyParamStr[i].equals(o.prptyParamStr[i])) return false;
}
}

return true;
}

}
























