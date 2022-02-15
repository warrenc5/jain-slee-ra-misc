package javax.megaco.association;

import javax.megaco.AssociationEvent;

import javax.megaco.ParameterNotSetException;

/**
 * 
 * @author wozza
 */
public class AssociationConfigReq extends AssociationEvent {

    /**
     * 
     */
    protected Integer maxRegstRetries = -1;
    /**
     * 
     */
    protected Integer restartAvalancheMWD = -1;
    /**
     * 
     */
    protected Integer normalMGExecTime = -1;
    /**
     * 
     */
    protected Integer provisionalRespTime = -1;
    /**
     * 
     */
    protected Integer responseRetentionTimePresent = -1;
    /**
     * 
     */
    protected Integer maxPndngRespCountPresent = -1;
    /**
     * 
     */
    protected Integer maxRetransmissionCountPresent = -1;
    /**
     * 
     */
    protected Integer initialRTT = -1;
    /**
     * 
     */
    protected EncodingFormat endcodingFormat = null;
    /**
     * 
     */
    protected TransportType transportType;
    /**
     * 
     */
    protected Integer protocolVersion = -1;
    /**
     * 
     */
    protected String srvChngProfile = null;

    /**
     * 
     * @param source
     * @param assocHandle
     * @throws IllegalArgumentException
     */
    public AssociationConfigReq(Object source, int assocHandle)
			throws IllegalArgumentException {
		super(source, assocHandle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAssocOperIdentifier() {
		return AssocEventType.M_ASSOC_CONFIG_REQ;
	}

	/**
	 * Gets the integer value of maximum registration retries.
	 * 
	 * @return Returns the integer value of maximum registration retries.
	 * @throws javax.megaco.ParameterNotSetException
	 *             This exception is raised if the max registration retires has
	 *             not been specified.
	 */
	public int getMaxRegstRetries()
			throws javax.megaco.ParameterNotSetException {
		if (this.maxRegstRetries == null)
			throw new ParameterNotSetException();

		return this.maxRegstRetries;
	}

	/**
	 * Identifies whether the maximum registration retries is present.
	 * 
	 * @return Returns true if the maximum registration retries is present.
	 */
	public boolean isMaxRegstRetriesPresent() {
		return this.maxRegstRetries != null;
	}

	// FIXME: name should me avalanche not avalance ?

	/**
	 * Gets the integer value of MWD used during restart avalance prevention.
	 * 
	 * @return Returns the integer value of MWD used during restart avalance
	 *         prevention.
	 * @throws javax.megaco.ParameterNotSetException
	 *             This exception is raised if the restart avalanche MWD has not
	 *             been specified.
	 */
	public int getRestartAvalancheMWD()
			throws javax.megaco.ParameterNotSetException {
		if (!isRestartAvalanceMWDPresent())
			throw new ParameterNotSetException();

		return this.restartAvalancheMWD;
	}

	/**
	 * This method sets the MWD used during restart avalance prevention which is
	 * to be configured. This sets the Maximum Wait Delay parameter required to
	 * prevent the restart avalanche.
	 * 
	 * @param restartAvalancheTime
	 *            The integer value of MWD used during restart avalance
	 *            prevention .
	 * @throws IllegalArgumentException
	 *             This exception is raised if the value of restart avalanche
	 *             time passed to this method is less than 0.
	 */
	public void setRestartAvalancheMWD(int restartAvalancheTime)
			throws IllegalArgumentException {

		if (restartAvalancheTime < 0)
			throw new IllegalArgumentException(
					"Restart Avalanche Time can not be less than zero");
		this.restartAvalancheMWD = restartAvalancheTime;

	}

	/**
	 * Identifies whether the MWD used during restart avalance prevention is
	 * present.
	 * 
	 * @return Returns true if the MWD used during restart avalanche prevention
	 *         is present.
	 */
	public boolean isRestartAvalanceMWDPresent() {
		return this.restartAvalancheMWD != null;
	}

	/**
	 * This method sets the normal MG execution time which is to be configured.
	 * This sets execution time beyond whih MG retransmits the message.
	 * 
	 * @return The integer value of normal MG execution time.
	 * @throws javax.megaco.ParameterNotSetException
	 *             This exception is raised if the MG Normal execution value has
	 *             not been specified.
	 */
	public int getNormalMGExecTime()
			throws javax.megaco.ParameterNotSetException {
		// FIXME: isNormalMGCExecTimePresent !=isNormalMGExecTimePresent
		if (!this.isNormalMGCExecTimePresent())
			throw new ParameterNotSetException();
		return normalMGExecTime;
	}

	/**
	 * This method sets the normal MG execution time which is to be configured.
	 * This sets execution time beyond whih MG retransmits the message.
	 * 
	 * @param mgExecTime
	 *            The integer value of normal MG execution time.
	 * @throws IllegalArgumentException
	 *             This exception is raised if the value of normal MG execution
	 *             time passed to this method is less than 0.
	 */
	public void setNormalMGExecTime(int mgExecTime)
			throws IllegalArgumentException {
		if (mgExecTime < 0)
			throw new IllegalArgumentException(
					"Exec Time can not be less than zero");
		this.normalMGExecTime = mgExecTime;
	}

	/**
	 * Identifies whether the normal MGC execution time is present.
	 * 
	 * @return Returns true if the normal MGC execution time is present is
	 *         present.
	 */
	public boolean isNormalMGCExecTimePresent() {
		return this.normalMGExecTime != null;
	}

	/**
	 * Gets the integer value of provisional response timer.
	 * 
	 * @return Returns the integer value of provisional response timer.
	 * @throws javax.megaco.ParameterNotSetException
	 *             This exception is raised if the provisional response time has
	 *             not been specified.
	 */
	public int getProvisionalRespTime()
			throws javax.megaco.ParameterNotSetException {
		if (!isProvisionalRespTimePresent()) {
			throw new ParameterNotSetException();
		}
		return this.provisionalRespTime;
	}

	/**
	 * This method sets the provisional response timer which is to be
	 * configured. This sets the time when the provisional response has to be
	 * sent by the stack, if the application does not send back a response by
	 * that time.
	 * 
	 * 
	 * @param provRespTime
	 *            The integer value of provisional response timer.
	 * @throws IllegalArgumentException
	 *             This exception is raised if the value of provisional response
	 *             time passed to this method is less than 0.
	 */
	public void setProvisionalRespTime(int provRespTime)
			throws IllegalArgumentException {
		if (provRespTime < 0) {
			throw new IllegalArgumentException(
					"value can not be less than zero");
		}
		this.provisionalRespTime = provRespTime;
	}

	/**
	 * Identifies whether the provisional response timer is present.
	 * 
	 * @return Returns true if the provisional response timer is present is
	 *         present.
	 */
	public boolean isProvisionalRespTimePresent() {
		return this.provisionalRespTime != null;
	}

	/**
	 * Identifies whether the response retention time is present.
	 * 
	 * @return Returns true if the response retention time is present is
	 *         present.
	 */
	public boolean isResponseRetentionTimePresent() {
		return this.responseRetentionTimePresent != null;
	}

	/**
	 * This method sets the response retention time which is to be configured.
	 * This sets the Maximum time during which the transaction has to be
	 * retained after the receipt of the response.
	 * 
	 * @param responseTime
	 *            The integer value of response retention time.
	 * @throws IllegalArgumentException
	 *             This exception is raised if the value of response retention
	 *             time passed to this method is less than 0.
	 */
	public void setResponseRetentionTime(int responseTime)
			throws IllegalArgumentException {
		if (responseTime < 0) {
			throw new IllegalArgumentException(
					"value can not be less than zero");
		}
		this.responseRetentionTimePresent = responseTime;
	}

	// FIXME again TYPO ?
	/**
	 * Identifies whether the maximum pending response count is present.
	 * 
	 * @return Returns true if the maximum pending response count is present is
	 *         present.
	 */
	public boolean isMaxPndngRespCountPresent() {
		return this.maxPndngRespCountPresent != null;
	}

	/**
	 * This method sets the maximum pending response count which is to be
	 * configured. This sets the count, which gives the maximum provisional
	 * responses beyond which the stack shall assume that the application could
	 * not send the message back. The stack in this case will generate a error
	 * response towards the peer.
	 * 
     * @param pndngCount 
	 * @throws IllegalArgumentException
	 *             This exception is raised if the value of response retention
	 *             time passed to this method is less than 0.
	 */
	public void setMaxPndngRespCount(int pndngCount)
			throws IllegalArgumentException {
		if (pndngCount < 0) {
			throw new IllegalArgumentException(
					"value can not be less than zero");
		}
		this.maxPndngRespCountPresent = pndngCount;
	}

	/**
	 * Gets the integer value of maximum pending response count.
	 * 
	 * @return Returns the integer value of maximum pending response count.
	 * @throws javax.megaco.ParameterNotSetException
	 *             This exception is raised if the value of maximum pending
	 *             response count has not been specified.
	 */
	public int getMaxPndngRespCount()
			throws javax.megaco.ParameterNotSetException {
		if (!isMaxPndngRespCountPresent()) {
			throw new ParameterNotSetException();
		}

		return this.maxPndngRespCountPresent;
	}

	/**
	 * Identifies whether the maximum retransmission count is present.
	 * 
	 * @return Returns true if the maximum retransmission count is present.
	 */
	public boolean isMaxRetransmissionCountPresent() {
		return this.maxRetransmissionCountPresent != null;
	}

	/**
	 * This method sets the maximum retransmission count which is to be
	 * configured. This sets the count, which gives the maximum retransmission
	 * count, beyond which if stack still does not get back a response from
	 * peer, the stack shall assume a network problem with the peer.
	 * 
     * @param retransmissionCount 
	 * @throws IllegalArgumentException
	 *             This exception is raised if the value of response retention
	 *             time passed to this method is less than 0.
	 */
	public void setMaxRetransmissionCount(int retransmissionCount)
			throws IllegalArgumentException {
		if (retransmissionCount < 0) {
			throw new IllegalArgumentException(
					"value can not be less than zero");
		}
		this.maxRetransmissionCountPresent = retransmissionCount;
	}

	/**
	 * Gets the integer value of maximum retransmission count.
	 * 
	 * @return Returns the integer value of maximum retransmission count.
	 * @throws javax.megaco.ParameterNotSetException
	 *             This exception is raised if the value of maximum
	 *             retransmission counthas not been specified.
	 */
	public int getMaxRetransmissionCount()
			throws javax.megaco.ParameterNotSetException {
		if (!isMaxRetransmissionCountPresent()) {
			throw new ParameterNotSetException();
		}
		return this.maxRetransmissionCountPresent;
	}

    /**
     * 
     * @return
     */
    public boolean isInitialRTTPresent() {
		return this.initialRTT != null;
	}

	/**
	 * This method sets the initial rtt which is to be configured. This is used
	 * for calculating the retransmission timer.
	 * 
     * @param rtt 
	 * @throws IllegalArgumentException
	 *             This exception is raised if the value passed to this method
	 *             is less than 0.
	 */
	public void setInitialRTT(int rtt)
			throws IllegalArgumentException {
		if (rtt < 0) {
			throw new IllegalArgumentException(
					"value can not be less than zero");
		}
		this.initialRTT = rtt;
	}

	/**
	 * Gets the integer value of initial rtt.
	 * 
	 * @return Returns the integer value of initial rtt.
	 * @throws javax.megaco.ParameterNotSetException
	 *             This exception is raised if the value of initial rtt has not
	 *             been specified.
	 */
	public int getInitialRTT() throws javax.megaco.ParameterNotSetException {
		if (!isInitialRTTPresent()) {
			throw new ParameterNotSetException();
		}

		return this.initialRTT;
	}

	/**
	 * Gets the object reference to the encoding format. The possible values are
	 * field constants defined for the class EncodingFormat.
	 * 
	 * @return Returns the a derived object of the EncodingFormat class to
	 *         represent the value of encoding format. If the encoding format
	 *         has not been specified, then this method would return value 0.
	 */
	public int getEndcodingFormat() {
		// FIXME 0 is valid value == TEXT ?
		return endcodingFormat == null ? 0 : endcodingFormat
				.getEncodingFormat();
	}

	/**
	 * This method sets the encoding format which is to be configured.
	 * 
     * @param format 
     * @throws IllegalArgumentException
	 *             This exception is raised if the reference of Encoding Format
	 *             passed to this method is NULL.
	 */
	public void setEndcodingFormat(EncodingFormat format)
			throws IllegalArgumentException {
		if (format == null) {
			throw new IllegalArgumentException(
					"Encoding format can not be null");
		}
		this.endcodingFormat = format;
	}

	/**
	 * This method sets the transport type which is to be configured.
	 * 
	 * @param transport
	 *            The object refenrece to transport type.
	 * 
	 * @throws IllegalArgumentException
	 *             This exception is raised if the reference of Transport type
	 *             passed to this method is NULL.
	 */
	public void setTransportType(TransportType transport)
			throws IllegalArgumentException {
		if (transport == null)
			throw new IllegalArgumentException("Value can not be null");
		this.transportType = transport;

	}

	/**
	 * Gets the integer value which identifies the transport type. The possible
	 * values are the field constants defined for the class TransportType.
	 * 
	 * @return Returns the object reference to transport type. If no transport
	 *         type has been specified, then this method would return value 0.
	 */
	public int getTransportType() {
		return this.transportType == null ? 0 : this.transportType
				.getTransportType();
	}

	/**
	 * This method sets the protocol version value that is to be used for the
	 * specified association.
	 * 
	 * @param version
	 *            The protocol version as an integer value.
	 * @throws IllegalArgumentException
	 *             This exception is raised if the value of protocol version
	 *             passed to this method is less than 0.
	 */
	public void setProtocolVersion(int version)
			throws IllegalArgumentException {
		if (version < 0) {
			throw new IllegalArgumentException(
					"Value can not be less than zero");
		}

		this.protocolVersion = version;
	}

	/**
	 * Identifies whether the protocol version is present.
	 * 
	 * @return Returns true if the protocol version is present.
	 */
	public boolean isProtocolVersionPresent() {
		return this.protocolVersion != null;
	}

	/**
	 * Gets the protocol version value received from peer in the service change.
	 * This is ther protocol version after negotiation.
	 * 
	 * @return Returns the protocol version parameter as an integer value.
	 * @throws javax.megaco.ParameterNotSetException
	 *             This exception is raised if the service change delay has not
	 *             been specified.
	 */
	public int getProtocolVersion()
			throws javax.megaco.ParameterNotSetException {
		if (!isProtocolVersionPresent()) {
			throw new ParameterNotSetException();
		}

		return this.protocolVersion;
	}

	/**
	 * Gets the service change profile value to be sent to peer in the service
	 * change.
	 * 
	 * @return Returns the service change profile parameter as a string value.
	 *         If service change profile is not set then a NULL value is
	 *         returned.
	 */
	public java.lang.String getSrvChngProfile() {
		return this.srvChngProfile;
	}

    /**
     * 
     * @param profile
     * @throws IllegalArgumentException
     */
    public void setSrvChngProfile(java.lang.String profile)
			throws IllegalArgumentException {
		if (profile == null)
			throw new IllegalArgumentException("Value can not be null");
		this.srvChngProfile = profile;
	}






public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AssociationConfigReq:");
bob.append(super.toString());

if(maxRegstRetries !=null)
bob.append("maxRegstRetries=").append(maxRegstRetries).append(",");
if(restartAvalancheMWD !=null)
bob.append("restartAvalancheMWD=").append(restartAvalancheMWD).append(",");
if(normalMGExecTime !=null)
bob.append("normalMGExecTime=").append(normalMGExecTime).append(",");
if(provisionalRespTime !=null)
bob.append("provisionalRespTime=").append(provisionalRespTime).append(",");
if(responseRetentionTimePresent !=null)
bob.append("responseRetentionTimePresent=").append(responseRetentionTimePresent).append(",");
if(maxPndngRespCountPresent !=null)
bob.append("maxPndngRespCountPresent=").append(maxPndngRespCountPresent).append(",");
if(maxRetransmissionCountPresent !=null)
bob.append("maxRetransmissionCountPresent=").append(maxRetransmissionCountPresent).append(",");
if(initialRTT !=null)
bob.append("initialRTT=").append(initialRTT).append(",");
if(endcodingFormat !=null)
bob.append("endcodingFormat=").append(endcodingFormat).append(",");
if(transportType !=null)
bob.append("transportType=").append(transportType).append(",");
if(protocolVersion !=null)
bob.append("protocolVersion=").append(protocolVersion).append(",");
if(srvChngProfile !=null)
bob.append("srvChngProfile=").append(srvChngProfile).append(",");

return bob.append(";").toString(); 
}












public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.association.AssociationConfigReq o = (javax.megaco.association.AssociationConfigReq)oo;
if (!super.equals(o)) return false;
if((maxRegstRetries !=null && o.maxRegstRetries == null) ||(maxRegstRetries == null && o.maxRegstRetries != null) ) return false;
if(maxRegstRetries ==null && o.maxRegstRetries == null) return true ; else if(maxRegstRetries !=null && o.maxRegstRetries != null)
if (maxRegstRetries != null && o.maxRegstRetries !=null && !maxRegstRetries.equals(o.maxRegstRetries)) return false;
if((restartAvalancheMWD !=null && o.restartAvalancheMWD == null) ||(restartAvalancheMWD == null && o.restartAvalancheMWD != null) ) return false;
if(restartAvalancheMWD ==null && o.restartAvalancheMWD == null) return true ; else if(restartAvalancheMWD !=null && o.restartAvalancheMWD != null)
if (restartAvalancheMWD != null && o.restartAvalancheMWD !=null && !restartAvalancheMWD.equals(o.restartAvalancheMWD)) return false;
if((normalMGExecTime !=null && o.normalMGExecTime == null) ||(normalMGExecTime == null && o.normalMGExecTime != null) ) return false;
if(normalMGExecTime ==null && o.normalMGExecTime == null) return true ; else if(normalMGExecTime !=null && o.normalMGExecTime != null)
if (normalMGExecTime != null && o.normalMGExecTime !=null && !normalMGExecTime.equals(o.normalMGExecTime)) return false;
if((provisionalRespTime !=null && o.provisionalRespTime == null) ||(provisionalRespTime == null && o.provisionalRespTime != null) ) return false;
if(provisionalRespTime ==null && o.provisionalRespTime == null) return true ; else if(provisionalRespTime !=null && o.provisionalRespTime != null)
if (provisionalRespTime != null && o.provisionalRespTime !=null && !provisionalRespTime.equals(o.provisionalRespTime)) return false;
if((responseRetentionTimePresent !=null && o.responseRetentionTimePresent == null) ||(responseRetentionTimePresent == null && o.responseRetentionTimePresent != null) ) return false;
if(responseRetentionTimePresent ==null && o.responseRetentionTimePresent == null) return true ; else if(responseRetentionTimePresent !=null && o.responseRetentionTimePresent != null)
if (responseRetentionTimePresent != null && o.responseRetentionTimePresent !=null && !responseRetentionTimePresent.equals(o.responseRetentionTimePresent)) return false;
if((maxPndngRespCountPresent !=null && o.maxPndngRespCountPresent == null) ||(maxPndngRespCountPresent == null && o.maxPndngRespCountPresent != null) ) return false;
if(maxPndngRespCountPresent ==null && o.maxPndngRespCountPresent == null) return true ; else if(maxPndngRespCountPresent !=null && o.maxPndngRespCountPresent != null)
if (maxPndngRespCountPresent != null && o.maxPndngRespCountPresent !=null && !maxPndngRespCountPresent.equals(o.maxPndngRespCountPresent)) return false;
if((maxRetransmissionCountPresent !=null && o.maxRetransmissionCountPresent == null) ||(maxRetransmissionCountPresent == null && o.maxRetransmissionCountPresent != null) ) return false;
if(maxRetransmissionCountPresent ==null && o.maxRetransmissionCountPresent == null) return true ; else if(maxRetransmissionCountPresent !=null && o.maxRetransmissionCountPresent != null)
if (maxRetransmissionCountPresent != null && o.maxRetransmissionCountPresent !=null && !maxRetransmissionCountPresent.equals(o.maxRetransmissionCountPresent)) return false;
if((initialRTT !=null && o.initialRTT == null) ||(initialRTT == null && o.initialRTT != null) ) return false;
if(initialRTT ==null && o.initialRTT == null) return true ; else if(initialRTT !=null && o.initialRTT != null)
if (initialRTT != null && o.initialRTT !=null && !initialRTT.equals(o.initialRTT)) return false;
if((endcodingFormat !=null && o.endcodingFormat == null) ||(endcodingFormat == null && o.endcodingFormat != null) ) return false;
if(endcodingFormat ==null && o.endcodingFormat == null) return true ; else if(endcodingFormat !=null && o.endcodingFormat != null)
if (endcodingFormat != null && o.endcodingFormat !=null && !endcodingFormat.equals(o.endcodingFormat)) return false;
if((transportType !=null && o.transportType == null) ||(transportType == null && o.transportType != null) ) return false;
if(transportType ==null && o.transportType == null) return true ; else if(transportType !=null && o.transportType != null)
if (transportType != null && o.transportType !=null && !transportType.equals(o.transportType)) return false;
if((protocolVersion !=null && o.protocolVersion == null) ||(protocolVersion == null && o.protocolVersion != null) ) return false;
if(protocolVersion ==null && o.protocolVersion == null) return true ; else if(protocolVersion !=null && o.protocolVersion != null)
if (protocolVersion != null && o.protocolVersion !=null && !protocolVersion.equals(o.protocolVersion)) return false;
if((srvChngProfile !=null && o.srvChngProfile == null) ||(srvChngProfile == null && o.srvChngProfile != null) ) return false;
if(srvChngProfile ==null && o.srvChngProfile == null) return true ; else if(srvChngProfile !=null && o.srvChngProfile != null)
if (srvChngProfile != null && o.srvChngProfile !=null && !srvChngProfile.equals(o.srvChngProfile)) return false;

return true;
}

}












