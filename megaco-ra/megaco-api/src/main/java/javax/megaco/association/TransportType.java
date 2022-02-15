package javax.megaco.association;

import java.io.Serializable;

/**
 * 
 * @author wozza
 */
public class TransportType implements Serializable {
    /**
     * 
     */
    public static final int M_TCP_TPT = 1;
    /**
     * 
     */
    public static final int M_UDP_TPT = 2;
    /**
     * 
     */
    public static final int M_SCTP_TPT = 3;
    /**
     * 
     */
    public static final int M_ATM_TPT = 4;
    /**
     * 
     */
    public static final int M_MTP3B_TPT = 5;

    /**
     * 
     */
    public static final TransportType TCP_TPT = new TransportType(M_TCP_TPT);
    /**
     * 
     */
    public static final TransportType UDP_TPT = new TransportType(M_UDP_TPT);
    /**
     * 
     */
    public static final TransportType SCTP_TPT = new TransportType(M_SCTP_TPT);
    /**
     * 
     */
    public static final TransportType ATM_TPT = new TransportType(M_ATM_TPT);
    /**
     * 
     */
    public static final TransportType MTP3B_TPT = new TransportType(M_MTP3B_TPT);

	private int transport_type;

	private TransportType(int transport_type) {
		this.transport_type = transport_type;
	}

    /**
     * 
     * @return
     */
    public int getTransportType() {
		return this.transport_type;
	}

    /**
     * 
     * @param value
     * @return
     * @throws IllegalArgumentException
     */
    public static final TransportType getObject(int value) throws IllegalArgumentException {
		TransportType t = null;
		switch (value) {
		case M_TCP_TPT:
			t = TCP_TPT;
			break;

		case M_UDP_TPT:
			t = UDP_TPT;
			break;

		case M_SCTP_TPT:
			t = SCTP_TPT;
			break;

		case M_ATM_TPT:
			t = ATM_TPT;
			break;

		case M_MTP3B_TPT:
			t = MTP3B_TPT;
			break;
		default:
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No TransportType defined for value = " + value);
			throw illegalArgumentException;
		}
		return t;

	}

	private Object readResolve() {
		return this.getObject(this.transport_type);
	}

	@Override






public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("TransportType:");

bob.append("transport_type=").append(transport_type).append(",");

return bob.append(";").toString(); 
}












public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.association.TransportType o = (javax.megaco.association.TransportType)oo;
if (transport_type != o.transport_type) return false;

return true;
}

}














