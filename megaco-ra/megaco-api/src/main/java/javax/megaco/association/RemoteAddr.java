package javax.megaco.association;

import java.io.Serializable;

import javax.megaco.ExceptionInfoCode;

/**
 * This class represents the remote transport address. This transport address is
 * used by the stack to send messages to peer. It can be used to store and
 * retrieve the remote transport type and the corresponding address. Only one of
 * the transport addresses can be set for the remote entity. If the transport is
 * SCTP, then multiple remote IP addresses can be set. If transport is TCP or
 * UDP, then only one IPv4/IPv6 address or domain name can be set. In this case
 * optional port id can also be specified.
 */
public class RemoteAddr implements Serializable {

    private String[] ipAddr = null;
    private TransportType tpt_type = null;
    private String addrString = null;
    private String AAL5Addr = null;
    private String mtp3Addr = null;
    private String domainName = null;
    private int portId;

    /**
     * Constructs a new remote address object identifier.
     */
    public RemoteAddr() {
    }

    /**
     * Constructs a new remote address with IPv4/ IPv6 addresses. The list of
     * address may be specified in case the transport type is M_SCTP_TPT. In
     * case of IPv4 or IPv6 address, the transport type must be set to M_UDP_TPT
     * or M_TCP_TPT.
     *
     * @param ipAddr
     * @param tpt_type
     * @throws IllegalArgumentException
     */
    public RemoteAddr(java.lang.String[] ipAddr, TransportType tpt_type) throws IllegalArgumentException {
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
     * Constructs a new remote entity with domain name. The possible values for
     * transport type could be M_SCTP_TPT, M_UDP_TPT, M_TCP_TPT, M_MTP3B_TPT,
     * and M_ATM_TPT.
     *
     * @param addrString
     * @param tpt_type
     * @throws IllegalArgumentException
     */
    public RemoteAddr(java.lang.String addrString, TransportType tpt_type) throws IllegalArgumentException {

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
     * Constructs a new remote entity with ATM AAL type 5 Address, if the
     * signalling is over ATM layer. The transport type in this case is set to
     * M_ATM_TPT.
     *
     * @param aal5Addr
     * @throws IllegalArgumentException
     */
    public RemoteAddr(java.lang.String aal5Addr) throws IllegalArgumentException {

        if (addrString == null) {
            IllegalArgumentException invalidArgumentException = new IllegalArgumentException("aal5 AddressString cannot be null for LocalAddr");
            //invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_LOCAL_ADDR);
            throw invalidArgumentException;
        }

        // TODO : check for validity

        tpt_type = TransportType.ATM_TPT;
        this.AAL5Addr = aal5Addr;
    }

    /**
     * Sets the domain name for the remote address. The transport type in this
     * case can be set to M_SCTP_TPT, M_UDP_TPT, M_TCP_TPT, and M_ATM_TPT. The
     * underlying transport in this case would resolve the domain name to actual
     * transport address.
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
        if (tpt_type.getTransportType() == TransportType.MTP3B_TPT.getTransportType()) {
            IllegalArgumentException invalidArgumentException = new IllegalArgumentException("Transport type can not be set to MTP3B_TPT");
            //invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_LOCAL_ADDR);
            throw invalidArgumentException;
        }
        // TODO: Set the domainName as per tpt_type
        this.domainName = domainName;
        this.tpt_type = tpt_type;
    }

    /**
     * Sets the IPv4/ IPv6 addresses for the remote address. In case the
     * transport type is M_SCTP_TPT, the user can specify multiples of IP
     * addresses. The other valid values for transport type are M_UDP_TPT and
     * M_TCP_TPT.
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
     * Sets the remote port identity.
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
        this.portId = portId;
    }

    /**
     * Sets the MTP-3 Address for the remote address. This is used if the
     * underlying link is over SS7.
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
        this.addrString = mtpAddr;
    }

    /**
     * Sets the AAL of type 5 address for the remote address when the remote
     * transport is over ATM cells.
     *
     * @param aal5Addr
     * @throws IllegalArgumentException
     */
    public void setAAL5Addr(java.lang.String aal5Addr) throws IllegalArgumentException {
        if (aal5Addr == null) {
            IllegalArgumentException invalidArgumentException = new IllegalArgumentException("aal5Addr cannot be null for RemoteAddrd");
            //invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_LOCAL_ADDR);
            throw invalidArgumentException;
        }
        // ??
        this.tpt_type = TransportType.ATM_TPT;
        this.AAL5Addr = aal5Addr;
    }

    /**
     * 
     * @return
     */
    public String[] getIpAddr() {
        return ipAddr;
    }

    /**
     * 
     * @return
     */
    public int getTransportType() {
        return tpt_type.getTransportType();
    }

    /**
     * 
     * @return
     */
    public String getAddrString() {
        return addrString;
    }

    /**
     * 
     * @return
     */
    public String getAAL5Addr() {
        return AAL5Addr;
    }

    /**
     * 
     * @return
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * 
     * @return
     */
    public int getPortId() {
        return portId;
    }

    /**
     * 
     * @return
     */
    public boolean isPortIdPresent() {
        // ??
        return this.portId > 0;
    }

    /**
     * 
     * @return
     */
    public String getMtp3Addr() {
        return mtp3Addr;
    }









public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.association.RemoteAddr o = (javax.megaco.association.RemoteAddr)oo;
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
if((AAL5Addr !=null && o.AAL5Addr == null) ||(AAL5Addr == null && o.AAL5Addr != null) ) return false;
if(AAL5Addr ==null && o.AAL5Addr == null) return true ; else if(AAL5Addr !=null && o.AAL5Addr != null)
if (AAL5Addr != null && o.AAL5Addr !=null && !AAL5Addr.equals(o.AAL5Addr)) return false;
if((mtp3Addr !=null && o.mtp3Addr == null) ||(mtp3Addr == null && o.mtp3Addr != null) ) return false;
if(mtp3Addr ==null && o.mtp3Addr == null) return true ; else if(mtp3Addr !=null && o.mtp3Addr != null)
if (mtp3Addr != null && o.mtp3Addr !=null && !mtp3Addr.equals(o.mtp3Addr)) return false;
if((domainName !=null && o.domainName == null) ||(domainName == null && o.domainName != null) ) return false;
if(domainName ==null && o.domainName == null) return true ; else if(domainName !=null && o.domainName != null)
if (domainName != null && o.domainName !=null && !domainName.equals(o.domainName)) return false;
if (portId != o.portId) return false;

return true;
}







public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("RemoteAddr:");

if (ipAddr !=null && ipAddr.length > 0) { bob.append("ipAddr=["); 
 for(int i = 0 ; i < ipAddr.length; i ++ )
if(ipAddr[i] !=null)
bob.append(ipAddr[i]).append(",");
bob.append("]");}
if(tpt_type !=null)
bob.append("tpt_type=").append(tpt_type).append(",");
if(addrString !=null)
bob.append("addrString=").append(addrString).append(",");
if(AAL5Addr !=null)
bob.append("AAL5Addr=").append(AAL5Addr).append(",");
if(mtp3Addr !=null)
bob.append("mtp3Addr=").append(mtp3Addr).append(",");
if(domainName !=null)
bob.append("domainName=").append(domainName).append(",");
bob.append("portId=").append(portId).append(",");

return bob.append(";").toString(); 
}








}










