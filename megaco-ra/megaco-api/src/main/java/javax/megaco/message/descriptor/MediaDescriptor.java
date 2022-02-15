package javax.megaco.message.descriptor;

import java.io.Serializable;

import javax.megaco.ParameterNotSetException;
import javax.megaco.message.Descriptor;
import javax.megaco.message.DescriptorType;

/**
 * The class extends JAIN MEGACO Descriptor. This class describes the stream
 * descriptor. The SDP information set within the local and remote descriptor
 * for this class is outside the scope of JAIN MEGACO. It is defined in
 * javax.sdp.
 */
public class MediaDescriptor extends Descriptor implements Serializable {

    private MediaStreamParam mediaStreamParam = null;
    private Integer streamId = null;
    private StreamDescriptor[] streamDesc;
    private TermStateDescriptor termState;

    /**
     * Constructs a Stream Descriptor object. This extends the Descriptor class.
     * It defines the Stream descriptor of the Megaco which contains the stream
     * id and stream parameter. Multiple of these can be set in the media
     * descriptor.
     */
    public MediaDescriptor() {
        super();
        super.descriptorId = DescriptorType.M_MEDIA_DESC;
    }

    /**
     * This method cannot be overridden by the derived class. This method
     * returns that the descriptor identifier is of type descriptor Stream. This
     * method overrides the corresponding method of the base class Descriptor.
     *
     * @return descriptorId - Returns an integer value that identifies this
     * stream object as the type of stream descriptor. It returns that it is
     * Stream Descriptor i.e., M_STREAM_DESC.
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
     * @param streamParam - Sets the stream parameter consisiting of atleast one
     * of local descriptor, local control and remote descriptor.
     * @throws IllegalArgumentException if the parameters set for the stream
     * parameter are such that the Stream Descriptor cannot be encoded.
     */
    public final void setMediaStreamParam(MediaStreamParam streamParam) throws IllegalArgumentException {
        // FIXME: add error checks

        if (streamParam == null)
            throw new IllegalArgumentException("MediaStreamParam must not be null");

        this.mediaStreamParam = streamParam;
    }


    /*
     *
     * Returns the vector of the object identifier of type StreamDescriptor. If
     * stream descriptor is not present for the media, then this shall return a
     * NULL value.
     */
    /**
     * 
     * @return
     */
    public StreamDescriptor[] getStreamDescriptor() {
        return streamDesc;
    }
    /*
     * Returns an object identifier of type TermStateDescriptor. If termination
     * state descriptor is not sent for the media, then this shall return a NULL
     * value.
     *
     */

    /**
     * 
     * @return
     */
    public TermStateDescriptor getTermStateDescriptor() {
        return termState;
    }
    /*
     *
     * Sets the TermStateDescriptor in a media descriptor. If termination state
     * descriptor is not to be sent, then this method would not be called.
     */

    /**
     * 
     * @param streamDesc
     * @throws javax.megaco.InvalidArgumentException
     */
    public void setStreamDescriptor(StreamDescriptor[] streamDesc) throws javax.megaco.InvalidArgumentException {
        this.streamDesc = streamDesc;
    }

    /*
     * Sets the vector of the StreamDescriptor in a media descriptor. If stream
     * descriptor is not to be sent, then this method would not be called.
     */
    /**
     * 
     * @param termState
     * @throws javax.megaco.InvalidArgumentException
     */
    public void setTermStateDescriptor(TermStateDescriptor termState) throws javax.megaco.InvalidArgumentException {

        this.termState = termState;
    }







public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("MediaDescriptor:");
bob.append(super.toString());

if(mediaStreamParam !=null)
bob.append("mediaStreamParam=").append(mediaStreamParam).append(",");
if(streamId !=null)
bob.append("streamId=").append(streamId).append(",");
if (streamDesc !=null && streamDesc.length > 0) { bob.append("streamDesc=["); 
 for(int i = 0 ; i < streamDesc.length; i ++ )
if(streamDesc[i] !=null)
bob.append(streamDesc[i]).append(",");
bob.append("]");}
if(termState !=null)
bob.append("termState=").append(termState).append(",");

return bob.append(";").toString(); 
}












public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.MediaDescriptor o = (javax.megaco.message.descriptor.MediaDescriptor)oo;
if (!super.equals(o)) return false;
if((mediaStreamParam !=null && o.mediaStreamParam == null) ||(mediaStreamParam == null && o.mediaStreamParam != null) ) return false;
if(mediaStreamParam ==null && o.mediaStreamParam == null) return true ; else if(mediaStreamParam !=null && o.mediaStreamParam != null)
if (mediaStreamParam != null && o.mediaStreamParam !=null && !mediaStreamParam.equals(o.mediaStreamParam)) return false;
if((streamId !=null && o.streamId == null) ||(streamId == null && o.streamId != null) ) return false;
if(streamId ==null && o.streamId == null) return true ; else if(streamId !=null && o.streamId != null)
if (streamId != null && o.streamId !=null && !streamId.equals(o.streamId)) return false;
if((streamDesc !=null && o.streamDesc == null) ||(streamDesc == null && o.streamDesc != null) ) return false;
if(streamDesc ==null && o.streamDesc == null) return true ; else if(streamDesc !=null && o.streamDesc != null)
{
if (streamDesc ==null && o.streamDesc == null) return true; else if (streamDesc.length != o.streamDesc.length) return false;
if (streamDesc.length == o.streamDesc.length) for(int i = 0 ; i < streamDesc.length; i ++ )
{
if((streamDesc[i] !=null && o.streamDesc[i] == null) ||(streamDesc[i] == null && o.streamDesc[i] != null) ) return false;
if(streamDesc[i] !=null && o.streamDesc[i] != null)
if (!streamDesc[i].equals(o.streamDesc[i])) return false;
}
}
if((termState !=null && o.termState == null) ||(termState == null && o.termState != null) ) return false;
if(termState ==null && o.termState == null) return true ; else if(termState !=null && o.termState != null)
if (termState != null && o.termState !=null && !termState.equals(o.termState)) return false;

return true;
}
}





