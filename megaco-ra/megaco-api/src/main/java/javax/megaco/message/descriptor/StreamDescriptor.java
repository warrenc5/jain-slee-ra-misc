package javax.megaco.message.descriptor;

import java.io.Serializable;

import javax.megaco.CommandEvent;
import javax.megaco.ParameterNotSetException;
import javax.megaco.message.CommandReq;
import javax.megaco.message.CommandResp;
import javax.megaco.message.Descriptor;
import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.PkgItemParam;
import javax.megaco.pkg.GenericPkg.GenSigComplEvent;
import javax.megaco.pkg.ToneGenPkg.ToneGenParamInd;
import javax.megaco.pkg.ToneGenPkg.ToneGenParamTl;
import javax.megaco.pkg.ToneGenPkg.ToneGenPlayToneSignal;

/**
 * The class extends JAIN MEGACO Descriptor. This class describes the stream
 * descriptor. The SDP information set within the local and remote descriptor
 * for this class is outside the scope of JAIN MEGACO. It is defined in
 * javax.sdp.
 */
public class StreamDescriptor extends Descriptor implements Serializable {

	private MediaStreamParam mediaStreamParam = null;
	private Integer streamId = null;

	/**
	 * Constructs a Stream Descriptor object. This extends the Descriptor class.
	 * It defines the Stream descriptor of the Megaco which contains the stream
	 * id and stream parameter. Multiple of these can be set in the media
	 * descriptor.
	 */
	public StreamDescriptor() {
		super();
		super.descriptorId = DescriptorType.M_STREAM_DESC;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * returns that the descriptor identifier is of type descriptor Stream. This
	 * method overrides the corresponding method of the base class Descriptor.
	 * 
	 * @return descriptorId - Returns an integer value that identifies this
	 *         stream object as the type of stream descriptor. It returns that
	 *         it is Stream Descriptor i.e., M_STREAM_DESC.
	 */
	public int getDescriptorId() {
		return super.descriptorId;
	}

	/**
	 * This method gets the Stream parameter for the stream descriptor. This can
	 * be used to get the local descriptor, remote descriptor and the local
	 * control descriptor.
	 * 
	 * @return Returns the object reference of type stream parameter.
	 */
	public final MediaStreamParam getMediaStreamParam() {

		return this.mediaStreamParam;
	}

	/**
	 * This method sets the stream parameter.
	 * 
	 * @param streamParam
	 *            - Sets the stream parameter consisiting of atleast one of
	 *            local descriptor, local control and remote descriptor.
	 * @throws IllegalArgumentException
	 *             if the parameters set for the stream parameter are such that
	 *             the Stream Descriptor cannot be encoded.
	 */
	public final void setMediaStreamParam(MediaStreamParam streamParam) throws IllegalArgumentException {
		// FIXME: add error checks

		if (streamParam == null) {
			throw new IllegalArgumentException("MediaStreamParam must not be null");
		}

		this.mediaStreamParam = streamParam;
	}

	/**
	 * The method can be used to get stream id in the stream descriptor. This
	 * method should be invoked after verifying that the port number is present
	 * using method isStreamIdPresent().
	 * 
	 * @return streamId - The integer value of the stream id shall be returned.
	 * @throws javax.megaco.ParameterNotSetException
	 *             - Thrown if streamId has not been set.
	 */
	public int getStreamId() throws javax.megaco.ParameterNotSetException {
		if (this.streamId == null) {
			throw new ParameterNotSetException();
		}

		return this.streamId.intValue();
	}

	/**
	 * The method can be used to set stream id in the stream descriptor.
	 * 
	 * @param streamId
	 *            - The integer value of the stream id shall be set.
	 * @throws IllegalArgumentException
	 *             - Thrown if streamId is set with an invalid value.
	 */
	public void setStreamId(int streamId) throws IllegalArgumentException {
		if (streamId <= 0) {
			throw new IllegalArgumentException("StreamId must not be less or equal to zero");
		}

		this.streamId = new Integer(streamId);
	}

	/**
	 * This method is used for checking if the Stream Id is present for this
	 * descriptor or not.
	 * 
	 * @return
	 */
	public boolean isStreamIdPresent() {
		
		
		
		return this.streamId != null;
	}

















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("StreamDescriptor:");
bob.append(super.toString());

if(mediaStreamParam !=null)
bob.append("mediaStreamParam=").append(mediaStreamParam).append(",");
if(streamId !=null)
bob.append("streamId=").append(streamId).append(",");

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.StreamDescriptor o = (javax.megaco.message.descriptor.StreamDescriptor)oo;
if (!super.equals(o)) return false;
if((mediaStreamParam !=null && o.mediaStreamParam == null) ||(mediaStreamParam == null && o.mediaStreamParam != null) ) return false;
if(mediaStreamParam ==null && o.mediaStreamParam == null) return true ; else if(mediaStreamParam !=null && o.mediaStreamParam != null)
if (mediaStreamParam != null && o.mediaStreamParam !=null && !mediaStreamParam.equals(o.mediaStreamParam)) return false;
if((streamId !=null && o.streamId == null) ||(streamId == null && o.streamId != null) ) return false;
if(streamId ==null && o.streamId == null) return true ; else if(streamId !=null && o.streamId != null)
if (streamId != null && o.streamId !=null && !streamId.equals(o.streamId)) return false;

return true;
}

}
























