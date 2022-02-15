package javax.megaco.message.descriptor;

import java.io.Serializable;



/**
 * The MediaStreamParam object is a class that shall be used to set the local
 * descriptor, local control descriptor and the remote descriptor. This is an
 * independent class derived from java.util.Object and shall not have any
 * derived classes.
 */
public class MediaStreamParam implements Serializable {

	private LocalCtrlDescriptor localCtrlDescriptor;
	private SDPInfo localDescriptor;
	private SDPInfo remoteDescriptor;

	/**
	 * Constructs a Stream Parameter Object consisting of local, remote and
	 * local control descriptor.
	 */
	public MediaStreamParam() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * The method can be used to get the local control descriptor.
	 * 
	 * @return localControlDesc - The reference to the object corresponding to
	 *         the local control descriptor. This shall be returned only if the
	 *         local control descriptor is present in the media stream parameter
	 *         of the media descriptor else shall return a NULL value.
	 */
	public LocalCtrlDescriptor getLclCtrlDescriptor() {
		return this.localCtrlDescriptor;
	}

	/**
	 * The method can be used to get the SDP information for local descriptor.
	 * 
	 * @return SDPinfo - The reference to the object corresponding to SDPInfo.
	 *         This shall be returned only if the SDP information is present in
	 *         the local descriptor of the media descriptor.
	 */
	public SDPInfo getLocalDescriptor() {
		return this.localDescriptor;
	}

	/**
	 * The method can be used to get the SDP information for remote descriptor.
	 * 
	 * @return SDPInfo - The reference to the object corresponding to SDPInfo.
	 *         This shall be returned only if the SDP information is present in
	 *         the remote descriptor of the media descriptor.
	 */
	public SDPInfo getRemoteDescriptor() {
		return this.remoteDescriptor;
	}

	/**
	 * The method can be used to set the local control descriptor within the
	 * media descriptor.
	 * 
	 * @param localControlDesc
	 *            - The reference to the object corresponding to the local
	 *            control descriptor.
	 * @throws IllegalArgumentException
	 *             - Thrown if local control descriptor has incompatible
	 *             parameters.
	 */
	public void setLclCtrlDescriptor(LocalCtrlDescriptor localControlDesc) throws IllegalArgumentException {

		// FIXME this is not present
		if (localControlDesc == null) {
			throw new IllegalArgumentException("LocalCtrlDescriptor must not be null");
		}

		// FIXME: add error checks

		this.localCtrlDescriptor = localControlDesc;
	}

	/**
	 * The method can be used to set the local descriptor within the media
	 * descriptor.
	 * 
	 * @param sdp
	 *            - The reference to the object corresponding to the SDPInfo for
	 *            setting the local descriptor.
	 * @throws IllegalArgumentException
	 *             - Thrown if sdp information has incompatible parameters.
	 */
	public void setLocalDescriptor(SDPInfo sdp) throws IllegalArgumentException {
		// FIXME this is not present
		if (sdp == null) {
			throw new IllegalArgumentException("SDPInfo must not be null");
		}

		// FIXME: add error checks

		this.localDescriptor = sdp;

	}

	/**
	 * The method can be used to set the remote descriptor within the media
	 * descriptor.
	 * 
	 * @param sdp
	 *            - The reference to the object corresponding to the SDPInfo for
	 *            setting the remote descriptor.
	 * @throws IllegalArgumentException
	 *             - Thrown if sdp information has incompatible parameters.
	 */
	public void setRemoteDescriptor(SDPInfo sdp) throws IllegalArgumentException {
		// FIXME this is not present
		if (sdp == null) {
			throw new IllegalArgumentException("SDPInfo must not be null");
		}

		// FIXME: add error checks

		this.remoteDescriptor = sdp;
	}

















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("MediaStreamParam:");

if(localCtrlDescriptor !=null)
bob.append("localCtrlDescriptor=").append(localCtrlDescriptor).append(",");
if(localDescriptor !=null)
bob.append("localDescriptor=").append(localDescriptor).append(",");
if(remoteDescriptor !=null)
bob.append("remoteDescriptor=").append(remoteDescriptor).append(",");

return bob.append(";").toString(); 
}









	// }











public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.MediaStreamParam o = (javax.megaco.message.descriptor.MediaStreamParam)oo;
if((localCtrlDescriptor !=null && o.localCtrlDescriptor == null) ||(localCtrlDescriptor == null && o.localCtrlDescriptor != null) ) return false;
if(localCtrlDescriptor ==null && o.localCtrlDescriptor == null) return true ; else if(localCtrlDescriptor !=null && o.localCtrlDescriptor != null)
if (localCtrlDescriptor != null && o.localCtrlDescriptor !=null && !localCtrlDescriptor.equals(o.localCtrlDescriptor)) return false;
if((localDescriptor !=null && o.localDescriptor == null) ||(localDescriptor == null && o.localDescriptor != null) ) return false;
if(localDescriptor ==null && o.localDescriptor == null) return true ; else if(localDescriptor !=null && o.localDescriptor != null)
if (localDescriptor != null && o.localDescriptor !=null && !localDescriptor.equals(o.localDescriptor)) return false;
if((remoteDescriptor !=null && o.remoteDescriptor == null) ||(remoteDescriptor == null && o.remoteDescriptor != null) ) return false;
if(remoteDescriptor ==null && o.remoteDescriptor == null) return true ; else if(remoteDescriptor !=null && o.remoteDescriptor != null)
if (remoteDescriptor != null && o.remoteDescriptor !=null && !remoteDescriptor.equals(o.remoteDescriptor)) return false;

return true;
}

}


























