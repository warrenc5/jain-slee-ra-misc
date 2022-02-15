package javax.megaco.association;

import java.io.Serializable;
import java.util.Arrays;

import javax.megaco.ExceptionInfoCode;

import javax.megaco.ParameterNotSetException;

/**
 * This class represents the local transport address. This transport address is
 * used by the stack to send messages to peer. It can be used to store and
 * retrieve the local transport type and the corresponding address. Only one of
 * the transport addresses can be set for the local entity. If the transport is
 * SCTP, then multiple local IP addresses can be set. If transport is TCP or
 * UDP, then only one IPv4/IPv6 address or domain name can be set. In this case
 * optional port id can also be specified.
 * 
 * 
 */
public class LocalAddr implements Serializable {

	private String[] ipAddr = null;
	private TransportType tpt_type = null;
	private String addrString = null;
	private String aal5Addr = null;
	private String mtpAddr = null;

	private String domainName = null;
	private int portId = -1;
	private boolean isPortIdPresent = false;
    private boolean transportTypePresent = false;

	/**
	 * Constructs a empty Local Address Identifier reference object. The
	 * parameters would be set to this object using get methods defined for this
	 * class.
	 */
	public LocalAddr() {

	}

    /**
     * 
     * @param ipAddr
     * @param tpt_type
     * @throws IllegalArgumentException
     */
    public LocalAddr(java.lang.String[] ipAddr, TransportType tpt_type) throws IllegalArgumentException {
		if (ipAddr == null || tpt_type == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException("IP Address or TransportType cannot be null for LocalAddr");
			//invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_LOCAL_ADDR);
			throw invalidArgumentException;
		}

		// TODO : check for IP valid form

		this.ipAddr = ipAddr;
		this.tpt_type = tpt_type;
	}

    /**
     * 
     * @param addrString
     * @param tpt_type
     * @throws IllegalArgumentException
     */
    public LocalAddr(java.lang.String addrString, TransportType tpt_type) throws IllegalArgumentException {

		if (addrString == null || tpt_type == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException("AddressString or TransportType cannot be null for LocalAddr");
			//invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_LOCAL_ADDR);
			throw invalidArgumentException;
		}

		// TODO : check for validity

		this.addrString = addrString;
		this.tpt_type = tpt_type;
	}

    /**
     * 
     * @param aal5Addr
     * @throws IllegalArgumentException
     */
    public LocalAddr(java.lang.String aal5Addr) throws IllegalArgumentException {

		if (aal5Addr == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException("aal5 AddressString cannot be null for LocalAddr");
			//invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_LOCAL_ADDR);
			throw invalidArgumentException;
		}

		// TODO : check for validity

		tpt_type = TransportType.ATM_TPT;
		this.aal5Addr = aal5Addr;
	}

    /**
     * 
     * @param domainName
     * @param tpt_type
     * @throws IllegalArgumentException
     */
    public void setDomainName(java.lang.String domainName, TransportType tpt_type) throws IllegalArgumentException {
		if (domainName == null || tpt_type == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException("domainName  or TransportType cannot be null for LocalAddr");
			//invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_LOCAL_ADDR);
			throw invalidArgumentException;
		}

		// TODO: Set the domainName as per tpt_type
		this.domainName = domainName;
		this.tpt_type = tpt_type;
	}

    /**
     * 
     * @param ipAddr
     * @param tpt_type
     * @throws IllegalArgumentException
     */
    public void setIpAddr(java.lang.String[] ipAddr, TransportType tpt_type) throws IllegalArgumentException {
		if (domainName == null || tpt_type == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException("ipAddr  or TransportType cannot be null for LocalAddr");
			//invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_LOCAL_ADDR);
			throw invalidArgumentException;
		}

		// TODO: Check for validity

		this.ipAddr = ipAddr;
		this.tpt_type = tpt_type;
	}

    /**
     * 
     * @param portId
     * @throws IllegalArgumentException
     */
    public void setPortId(int portId) throws IllegalArgumentException {

		if (portId < 1) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException("portId cannot be less than 1 for LocalAddr");
			//invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_LOCAL_ADDR);
			throw invalidArgumentException;
		}
		this.isPortIdPresent = true;
		this.portId = portId;
	}

    /**
     * 
     * @param mtpAddr
     * @throws IllegalArgumentException
     */
    public void setMtp3Addr(java.lang.String mtpAddr) throws IllegalArgumentException {
		if (mtpAddr == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException("mtpAddr cannot be null for LocalAddr");
			//invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_LOCAL_ADDR);
			throw invalidArgumentException;
		}
		this.tpt_type = TransportType.MTP3B_TPT;
		this.mtpAddr = mtpAddr;
	}

    /**
     * 
     * @param aal5Addr
     * @throws IllegalArgumentException
     */
    public void setAAL5Addr(java.lang.String aal5Addr) throws IllegalArgumentException {
		if (aal5Addr == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException("aal5Addr cannot be null for LocalAddr");
			//invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_LOCAL_ADDR);
			throw invalidArgumentException;
		}
		// TODO : Validity check?
		this.aal5Addr = aal5Addr;
		this.tpt_type = TransportType.ATM_TPT;
	}

    /**
     * 
     * @return
     */
    public java.lang.String getDomainName() {
		return this.domainName;
	}

    /**
     * 
     * @return
     */
    public java.lang.String[] getIpAddr() {
		return this.ipAddr;
	}

    /**
     * 
     * @return
     * @throws ParameterNotSetException
     */
    public int getPortId() throws ParameterNotSetException {
		if (!this.isPortIdPresent) {
			ParameterNotSetException parameterNotSetException = new ParameterNotSetException("PortId not yet set for LocalAddr");
			throw parameterNotSetException;
		}
		return this.portId;
	}

    /**
     * 
     * @return
     */
    public boolean isPortIdPresent() {
		return this.isPortIdPresent;
	}

    /**
     * 
     * @return
     */
    public java.lang.String getMtp3Addr() {
		return this.mtpAddr;
	}

    /**
     * 
     * @return
     */
    public java.lang.String getAAL5Addr() {
		return this.aal5Addr;
	}

    /**
     * 
     * @return
     */
    public int getTransportType() {
		return this.tpt_type.getTransportType();
	}

    /**
     * 
     * @return
     */
    public boolean isTransportTypePresent() {
        return tpt_type!=null;
    }


	@Override


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("LocalAddr:");

if (ipAddr !=null && ipAddr.length > 0) { bob.append("ipAddr=["); 
 for(int i = 0 ; i < ipAddr.length; i ++ )
if(ipAddr[i] !=null)
bob.append(ipAddr[i]).append(",");
bob.append("]");}
if(tpt_type !=null)
bob.append("tpt_type=").append(tpt_type).append(",");
if(addrString !=null)
bob.append("addrString=").append(addrString).append(",");
if(aal5Addr !=null)
bob.append("aal5Addr=").append(aal5Addr).append(",");
if(mtpAddr !=null)
bob.append("mtpAddr=").append(mtpAddr).append(",");
if(domainName !=null)
bob.append("domainName=").append(domainName).append(",");
bob.append("portId=").append(portId).append(",");
bob.append("isPortIdPresent=").append(isPortIdPresent).append(",");
bob.append("transportTypePresent=").append(transportTypePresent).append(",");

return bob.append(";").toString(); 
}






    @Override










public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.association.LocalAddr o = (javax.megaco.association.LocalAddr)oo;
if((ipAddr !=null && o.ipAddr == null) ||(ipAddr == null && o.ipAddr != null) ) return false;
if(ipAddr ==null && o.ipAddr == null) return true ; else if(ipAddr !=null && o.ipAddr != null)
{
if (ipAddr ==null && o.ipAddr == null) return true; else if (ipAddr.length != o.ipAddr.length) return false;
if (ipAddr.length == o.ipAddr.length) for(int i = 0 ; i < ipAddr.length; i ++ )
{
if((ipAddr[i] !=null && o.ipAddr[i] == null) ||(ipAddr[i] == null && o.ipAddr[i] != null) ) return false;
if(ipAddr[i] !=null && o.ipAddr[i] != null)
if (!ipAddr[i].equals(o.ipAddr[i])) return false;
}
}
if((tpt_type !=null && o.tpt_type == null) ||(tpt_type == null && o.tpt_type != null) ) return false;
if(tpt_type ==null && o.tpt_type == null) return true ; else if(tpt_type !=null && o.tpt_type != null)
if (tpt_type != null && o.tpt_type !=null && !tpt_type.equals(o.tpt_type)) return false;
if((addrString !=null && o.addrString == null) ||(addrString == null && o.addrString != null) ) return false;
if(addrString ==null && o.addrString == null) return true ; else if(addrString !=null && o.addrString != null)
if (addrString != null && o.addrString !=null && !addrString.equals(o.addrString)) return false;
if((aal5Addr !=null && o.aal5Addr == null) ||(aal5Addr == null && o.aal5Addr != null) ) return false;
if(aal5Addr ==null && o.aal5Addr == null) return true ; else if(aal5Addr !=null && o.aal5Addr != null)
if (aal5Addr != null && o.aal5Addr !=null && !aal5Addr.equals(o.aal5Addr)) return false;
if((mtpAddr !=null && o.mtpAddr == null) ||(mtpAddr == null && o.mtpAddr != null) ) return false;
if(mtpAddr ==null && o.mtpAddr == null) return true ; else if(mtpAddr !=null && o.mtpAddr != null)
if (mtpAddr != null && o.mtpAddr !=null && !mtpAddr.equals(o.mtpAddr)) return false;
if((domainName !=null && o.domainName == null) ||(domainName == null && o.domainName != null) ) return false;
if(domainName ==null && o.domainName == null) return true ; else if(domainName !=null && o.domainName != null)
if (domainName != null && o.domainName !=null && !domainName.equals(o.domainName)) return false;
if (portId != o.portId) return false;
if (isPortIdPresent != o.isPortIdPresent) return false;
if (transportTypePresent != o.transportTypePresent) return false;

return true;
}

}




















