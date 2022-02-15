package javax.megaco;

import java.io.Serializable;

/**
 * 
 * @author wozza
 */
public class UserId implements Serializable {

	private String localEntId = null;
	private String[] remoteEntId = null;
	private char listenerInstance;
	private boolean isListenerInstancePresent = false;

    /**
     * 
     */
    public UserId() {
    }


	/**
	 * Constructs a UserId with the specified local entity id, list of remote
	 * entity ids and listener Instance. Using this, constructor will
	 * automatically set the listener Instance to false.
	 * 
	 * @param localEntId
	 *            the Local Entity Identity. If the local entity is MG, then
	 *            this gives the MG identity else shall give MGC identity. The
	 *            localEndId specified is used for encoding the message header
	 *            Id used for the megaco messages emanating from the stack to
	 *            the peer. The format of the string specified must be in
	 *            accordance with the syntax defined for "mId" by the protocol.
	 * @param remoteEntId
	 *            the list of remote entity ids of the User Id. If there are
	 *            number of remote entities, then all the remote entities are
	 *            specified in the user Id and any event received from any of
	 *            these remote entities are delivered to the same user Id. The
	 *            list of remote End Ids specified here are one to one in
	 *            correspondence with the remote entity address in the
	 *            CreateAssocReq
	 * @throws IllegalArgumentException
	 *             This exception is raised if the reference of Local Entity Id
	 *             or Remote Entity Id passed to this method is NULL.
	 */

	public UserId(java.lang.String localEntId, java.lang.String[] remoteEntId)
			throws IllegalArgumentException {
		if (remoteEntId == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException(
					"RemoteEntityIds cannot be null for UserId");
//			invalidArgumentException
//					.setInfoCode(ExceptionInfoCode.INV_REMOTE_ADDR);
			throw invalidArgumentException;
		}

		if (localEntId == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException(
					"LocalEntityId cannot be null for UserId");
			throw invalidArgumentException;
		}

		this.localEntId = localEntId;
		this.remoteEntId = remoteEntId;
		this.isListenerInstancePresent = false;
	}

    /**
     * 
     * @param localEntId
     * @param remoteEntId
     * @param listenerInstance
     * @throws IllegalArgumentException
     */
    public UserId(java.lang.String localEntId, java.lang.String[] remoteEntId,
			char listenerInstance) throws IllegalArgumentException {
		if (remoteEntId == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException(
					"RemoteEntityIds cannot be null for UserId");
//			invalidArgumentException
//					.setInfoCode(ExceptionInfoCode.INV_REMOTE_ADDR);
			throw invalidArgumentException;
		}

		if (localEntId == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException(
					"LocalEntityId cannot be null for UserId");
			throw invalidArgumentException;
		}

		this.localEntId = localEntId;
		this.remoteEntId = remoteEntId;
		this.listenerInstance = listenerInstance;
		this.isListenerInstancePresent = true;

	}

    /**
     * 
     * @return
     */
    public boolean isListenerInstancePresent() {
		return this.isListenerInstancePresent;
	}

    /**
     * 
     * @param localEntId
     * @throws IllegalArgumentException
     */
    public void setLocalEntId(java.lang.String localEntId)
			throws IllegalArgumentException {

		if (localEntId == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException(
					"LocalEntityId cannot be null for UserId");
			throw invalidArgumentException;
		}

		this.localEntId = localEntId;

	}

    /**
     * 
     * @param remoteEntId
     * @throws IllegalArgumentException
     */
    public void setRemoteEntId(java.lang.String[] remoteEntId)
			throws IllegalArgumentException {
		if (remoteEntId == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException(
					"RemoteEntityIds cannot be null for UserId");
//			invalidArgumentException
//					.setInfoCode(ExceptionInfoCode.INV_REMOTE_ADDR);
			throw invalidArgumentException;
		}
		this.remoteEntId = remoteEntId;
	}

    /**
     * 
     * @param listenerInstance
     */
    public void setListenerInstance(char listenerInstance) {
		this.listenerInstance = listenerInstance;
	}

    /**
     * 
     * @return
     */
    public java.lang.String getLocalEntId() {
		return this.localEntId;
	}

    /**
     * 
     * @return
     */
    public java.lang.String[] getRemoteEntId() {
		return this.remoteEntId;
	}

    /**
     * 
     * @return
     * @throws javax.megaco.ParameterNotSetException
     */
    public char getListenerInstance()
			throws javax.megaco.ParameterNotSetException {
		
		//FIXME: ???
		if (!this.isListenerInstancePresent()) {
			ParameterNotSetException parameterNotSetException = new ParameterNotSetException(
					"ListenerInstance not yet set for UserId");
			throw parameterNotSetException;
		}
		return this.listenerInstance;
	}

    @Override
    public int hashCode() {
        return 0;
    }




public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("UserId:");

if(localEntId !=null)
bob.append("localEntId=").append(localEntId).append(",");
if (remoteEntId !=null && remoteEntId.length > 0) { bob.append("remoteEntId=["); 
 for(int i = 0 ; i < remoteEntId.length; i ++ )
if(remoteEntId[i] !=null)
bob.append(remoteEntId[i]).append(",");
bob.append("]");}
bob.append("listenerInstance=").append(listenerInstance).append(",");
bob.append("isListenerInstancePresent=").append(isListenerInstancePresent).append(",");

return bob.append(";").toString(); 
}


















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.UserId o = (javax.megaco.UserId)oo;
if((localEntId !=null && o.localEntId == null) ||(localEntId == null && o.localEntId != null) ) return false;
if(localEntId ==null && o.localEntId == null) return true ; else if(localEntId !=null && o.localEntId != null)
if (localEntId != null && o.localEntId !=null && !localEntId.equals(o.localEntId)) return false;
if((remoteEntId !=null && o.remoteEntId == null) ||(remoteEntId == null && o.remoteEntId != null) ) return false;
if(remoteEntId ==null && o.remoteEntId == null) return true ; else if(remoteEntId !=null && o.remoteEntId != null)
{
if (remoteEntId ==null && o.remoteEntId == null) return true; else if (remoteEntId.length != o.remoteEntId.length) return false;
if (remoteEntId.length == o.remoteEntId.length) for(int i = 0 ; i < remoteEntId.length; i ++ )
{
if((remoteEntId[i] !=null && o.remoteEntId[i] == null) ||(remoteEntId[i] == null && o.remoteEntId[i] != null) ) return false;
if(remoteEntId[i] !=null && o.remoteEntId[i] != null)
if (!remoteEntId[i].equals(o.remoteEntId[i])) return false;
}
}
if (listenerInstance != o.listenerInstance) return false;
if (isListenerInstancePresent != o.isListenerInstancePresent) return false;

return true;
}

}




















