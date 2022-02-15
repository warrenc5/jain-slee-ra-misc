package javax.megaco;

import java.io.Serializable;

/**
 * This class defines the error codes which can be returned in the response
 * events from stack. These error codes would help the application in
 * identifying the granularity of the error occured.
 * 
 * 
 */
public class ErrorCode implements Serializable {

    /**
     * 
     */
    public static final int M_MISSING_ENC_FORMAT = 1;
    /**
     * 
     */
    public static final int M_TPT_ADDR_ALREADY_INUSE = 2;
    /**
     * 
     */
    public static final int M_PEER_ENTITY_UNVBLE = 3;
    /**
     * 
     */
    public static final int M_INV_LOCAL_TPT_ADDRESS = 4;
    /**
     * 
     */
    public static final int M_INV_REMOTE_TPT_ADDRESS = 5;
    /**
     * 
     */
    public static final int M_INV_LCL_RMT_ADDR_PAIR = 6;
    /**
     * 
     */
    public static final int M_INV_ASSOC_ID = 7;
    /**
     * 
     */
    public static final int M_MISSING_SVC_CHNG_METHOD = 8;
    /**
     * 
     */
    public static final int M_INV_SVC_CHNG_METH_REASON_PAIR = 9;
    /**
     * 
     */
    public static final int M_UNSPTD_ENC_FORMAT = 10;
    /**
     * 
     */
    public static final int M_UNSPTD_TPT_TYPE = 11;
    /**
     * 
     */
    public static final int M_INV_SVC_CHNG_ADDR = 12;
    /**
     * 
     */
    public static final int M_INV_HOFF_MGCID = 13;
    /**
     * 
     */
    public static final int M_UNSPTD_SVC_CHNG_METH_EXTN = 14;
    /**
     * 
     */
    public static final int M_INV_SVC_CHNG_REASON = 15;
    /**
     * 
     */
    public static final int M_INV_SVC_CHNG_METHOD = 16;
    /**
     * 
     */
    public static final int M_RES_UNVBLE = 17;
    /**
     * 
     */
    public static final int M_MODIFY_ENC_FORMAT_FAILURE = 18;
    /**
     * 
     */
    public static final int M_MODIFY_TPT_TYPE_FAILURE = 19;
    /**
     * 
     */
    public static final int M_MODIFY_SVC_PROFILE_FAILURE = 20;
    /**
     * 
     */
    public static final int M_MODIFY_PROTOCOL_VERSION_FAILURE = 21;
    /**
     * 
     */
    public static final int M_INV_ACTION_HANDLE = 22;
    /**
     * 
     */
    public static final int M_WLDCRD_CMD_NOT_SUPTD = 23;
    /**
     * 
     */
    public static final int M_INV_CMD_REQID = 24;
    /**
     * 
     */
    public static final int M_INV_CMD_RESPID = 25;
    /**
     * 
     */
    public static final int M_TERM_TYPE_NOT_INSYNCH = 26;
    /**
     * 
     */
    public static final int M_INV_TERM_NAME_FORMAT = 27;
    /**
     * 
     */
    public static final int M_TOPOLOGY_DESC_NOT_SUPTD = 28;
    /**
     * 
     */
    public static final int M_MEDIA_DESC_NOT_SUPTD = 29;
    /**
     * 
     */
    public static final int M_MODEM_DESC_NOT_SUPTD = 30;
    /**
     * 
     */
    public static final int M_MUX_DESC_NOT_SUPTD = 31;
    /**
     * 
     */
    public static final int M_EVENT_DESC_NOT_SUPTD = 32;
    /**
     * 
     */
    public static final int M_SIGNAL_DESC_NOT_SUPTD = 33;
    /**
     * 
     */
    public static final int M_DIGITMAP_DESC_NOT_SUPTD = 34;
    /**
     * 
     */
    public static final int M_EVENTBUFF_DESC_NOT_SUPTD = 35;
    /**
     * 
     */
    public static final int M_AUDIT_DESC_NOT_SUPTD = 36;
    /**
     * 
     */
    public static final int M_OBSRD_EVENT_DESC_NOT_SUPTD = 37;
    /**
     * 
     */
    public static final int M_STATS_DESC_NOT_SUPTD = 38;
    /**
     * 
     */
    public static final int M_PCKG_DESC_NOT_SUPTD = 39;
    /**
     * 
     */
    public static final int M_SDPINFO_NOT_SUPTD = 40;
    /**
     * 
     */
    public static final int M_INV_PKG_ITEM_TYPE = 41;
    /**
     * 
     */
    public static final int M_INV_CTXID_TERMTYPE_PAIR = 42;
    /**
     * 
     */
    public static final int M_MISSING_LCL_TPT_ADDR = 43;
    /**
     * 
     */
    public static final int M_MISSING_REMOTE_TPT_ADDR = 44;
    /**
     * 
     */
    public static final int M_MISSING_SVC_CHNG_REASON = 45;

    /**
     * 
     */
    public static final ErrorCode PEER_ENTITY_UNVBLE = new ErrorCode(M_PEER_ENTITY_UNVBLE);
    /**
     * 
     */
    public static final ErrorCode INV_LOCAL_TPT_ADDRESS = new ErrorCode(M_INV_LOCAL_TPT_ADDRESS);
    /**
     * 
     */
    public static final ErrorCode INV_REMOTE_TPT_ADDRESS = new ErrorCode(M_INV_REMOTE_TPT_ADDRESS);
    /**
     * 
     */
    public static final ErrorCode INV_LCL_RMT_ADDR_PAIR = new ErrorCode(M_INV_LCL_RMT_ADDR_PAIR);
    /**
     * 
     */
    public static final ErrorCode INV_ASSOC_ID = new ErrorCode(M_INV_ASSOC_ID);
    /**
     * 
     */
    public static final ErrorCode INV_SVC_CHNG_METH_REASON_PAIR = new ErrorCode(M_INV_SVC_CHNG_METH_REASON_PAIR);
    /**
     * 
     */
    public static final ErrorCode UNSPTD_ENC_FORMAT = new ErrorCode(M_UNSPTD_ENC_FORMAT);
    /**
     * 
     */
    public static final ErrorCode UNSPTD_TPT_TYPE = new ErrorCode(M_UNSPTD_TPT_TYPE);
    /**
     * 
     */
    public static final ErrorCode INV_SVC_CHNG_ADDR = new ErrorCode(M_INV_SVC_CHNG_ADDR);
    /**
     * 
     */
    public static final ErrorCode INV_HOFF_MGCID = new ErrorCode(M_INV_HOFF_MGCID);
    /**
     * 
     */
    public static final ErrorCode UNSPTD_SVC_CHNG_METH_EXTN = new ErrorCode(M_UNSPTD_SVC_CHNG_METH_EXTN);
    /**
     * 
     */
    public static final ErrorCode INV_SVC_CHNG_REASON = new ErrorCode(M_INV_SVC_CHNG_REASON);
    /**
     * 
     */
    public static final ErrorCode INV_SVC_CHNG_METHOD = new ErrorCode(M_INV_SVC_CHNG_METHOD);
    /**
     * 
     */
    public static final ErrorCode RES_UNVBLE = new ErrorCode(M_RES_UNVBLE);
    /**
     * 
     */
    public static final ErrorCode MODIFY_ENC_FORMAT_FAILURE = new ErrorCode(M_MODIFY_ENC_FORMAT_FAILURE);
    /**
     * 
     */
    public static final ErrorCode MODIFY_TPT_TYPE_FAILURE = new ErrorCode(M_MODIFY_TPT_TYPE_FAILURE);
    /**
     * 
     */
    public static final ErrorCode MODIFY_SVC_PROFILE_FAILURE = new ErrorCode(M_MODIFY_SVC_PROFILE_FAILURE);
    /**
     * 
     */
    public static final ErrorCode MODIFY_PROTOCOL_VERSION_FAILURE = new ErrorCode(M_MODIFY_PROTOCOL_VERSION_FAILURE);
    /**
     * 
     */
    public static final ErrorCode INV_ACTION_HANDLE = new ErrorCode(M_INV_ACTION_HANDLE);
    /**
     * 
     */
    public static final ErrorCode WLDCRD_CMD_NOT_SUPTD = new ErrorCode(M_WLDCRD_CMD_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode INV_CMD_REQID = new ErrorCode(M_INV_CMD_REQID);
    /**
     * 
     */
    public static final ErrorCode INV_CMD_RESPID = new ErrorCode(M_INV_CMD_RESPID);
    /**
     * 
     */
    public static final ErrorCode TERM_TYPE_NOT_INSYNCH = new ErrorCode(M_TERM_TYPE_NOT_INSYNCH);
    /**
     * 
     */
    public static final ErrorCode INV_TERM_NAME_FORMAT = new ErrorCode(M_INV_TERM_NAME_FORMAT);
    /**
     * 
     */
    public static final ErrorCode TOPOLOGY_DESC_NOT_SUPTD = new ErrorCode(M_TOPOLOGY_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode MEDIA_DESC_NOT_SUPTD = new ErrorCode(M_MEDIA_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode MODEM_DESC_NOT_SUPTD = new ErrorCode(M_MODEM_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode MUX_DESC_NOT_SUPTD = new ErrorCode(M_MUX_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode EVENT_DESC_NOT_SUPTD = new ErrorCode(M_EVENT_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode SIGNAL_DESC_NOT_SUPTD = new ErrorCode(M_SIGNAL_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode DIGITMAP_DESC_NOT_SUPTD = new ErrorCode(M_DIGITMAP_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode EVENTBUFF_DESC_NOT_SUPTD = new ErrorCode(M_EVENTBUFF_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode AUDIT_DESC_NOT_SUPTD = new ErrorCode(M_AUDIT_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode OBSRD_EVENT_DESC_NOT_SUPTD = new ErrorCode(M_OBSRD_EVENT_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode STATS_DESC_NOT_SUPTD = new ErrorCode(M_STATS_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode PCKG_DESC_NOT_SUPTD = new ErrorCode(M_PCKG_DESC_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode SDPINFO_NOT_SUPTD = new ErrorCode(M_SDPINFO_NOT_SUPTD);
    /**
     * 
     */
    public static final ErrorCode INV_PKG_ITEM_TYPE = new ErrorCode(M_INV_PKG_ITEM_TYPE);
    /**
     * 
     */
    public static final ErrorCode INV_CTXID_TERMTYPE_PAIR = new ErrorCode(M_INV_CTXID_TERMTYPE_PAIR);
    /**
     * 
     */
    public static final ErrorCode MISSING_LCL_TPT_ADDR = new ErrorCode(M_MISSING_LCL_TPT_ADDR);
    /**
     * 
     */
    public static final ErrorCode MISSING_REMOTE_TPT_ADDR = new ErrorCode(M_MISSING_REMOTE_TPT_ADDR);
    /**
     * 
     */
    public static final ErrorCode MISSING_SVC_CHNG_REASON = new ErrorCode(M_MISSING_SVC_CHNG_REASON);
    /**
     * 
     */
    public static final ErrorCode MISSING_SVC_CHNG_METHOD = new ErrorCode(M_MISSING_SVC_CHNG_METHOD);
    /**
     * 
     */
    public static final ErrorCode MISSING_ENC_FORMAT = new ErrorCode(M_MISSING_ENC_FORMAT);
    /**
     * 
     */
    public static final ErrorCode TPT_ADDR_ALREADY_INUSE = new ErrorCode(M_TPT_ADDR_ALREADY_INUSE);

	private int error_code;

	private ErrorCode(int error_code) {
		this.error_code = error_code;
	}

    /**
     * 
     * @return
     */
    public int getErrorCode() {
		return this.error_code;
	}

    /**
     * 
     * @param value
     * @return
     * @throws IllegalArgumentException
     */
    public static final ErrorCode getObject(int value) throws IllegalArgumentException {
		ErrorCode e = null;
		switch (value) {
		case M_MISSING_ENC_FORMAT:
			e = MISSING_ENC_FORMAT;
			break;

		case M_TPT_ADDR_ALREADY_INUSE:
			e = TPT_ADDR_ALREADY_INUSE;
			break;

		case M_PEER_ENTITY_UNVBLE:
			e = PEER_ENTITY_UNVBLE;
			break;

		case M_INV_LOCAL_TPT_ADDRESS:
			e = INV_LOCAL_TPT_ADDRESS;
			break;

		case M_INV_REMOTE_TPT_ADDRESS:
			e = INV_REMOTE_TPT_ADDRESS;
			break;

		case M_INV_LCL_RMT_ADDR_PAIR:
			e = INV_LCL_RMT_ADDR_PAIR;
			break;

		case M_INV_ASSOC_ID:
			e = INV_ASSOC_ID;
			break;

		case M_MISSING_SVC_CHNG_METHOD:
			e = MISSING_SVC_CHNG_METHOD;
			break;

		case M_INV_SVC_CHNG_METH_REASON_PAIR:
			e = INV_SVC_CHNG_METH_REASON_PAIR;
			break;

		case M_UNSPTD_ENC_FORMAT:
			e = UNSPTD_ENC_FORMAT;
			break;

		case M_UNSPTD_TPT_TYPE:
			e = UNSPTD_TPT_TYPE;
			break;

		case M_INV_SVC_CHNG_ADDR:
			e = INV_SVC_CHNG_ADDR;
			break;

		case M_INV_HOFF_MGCID:
			e = INV_HOFF_MGCID;
			break;

		case M_UNSPTD_SVC_CHNG_METH_EXTN:
			e = UNSPTD_SVC_CHNG_METH_EXTN;
			break;

		case M_INV_SVC_CHNG_REASON:
			e = INV_SVC_CHNG_REASON;
			break;

		case M_INV_SVC_CHNG_METHOD:
			e = INV_SVC_CHNG_METHOD;
			break;

		case M_RES_UNVBLE:
			e = RES_UNVBLE;
			break;

		case M_MODIFY_ENC_FORMAT_FAILURE:
			e = MODIFY_ENC_FORMAT_FAILURE;
			break;

		case M_MODIFY_TPT_TYPE_FAILURE:
			e = MODIFY_TPT_TYPE_FAILURE;
			break;

		case M_MODIFY_SVC_PROFILE_FAILURE:
			e = MODIFY_SVC_PROFILE_FAILURE;
			break;

		case M_MODIFY_PROTOCOL_VERSION_FAILURE:
			e = MODIFY_PROTOCOL_VERSION_FAILURE;
			break;

		case M_INV_ACTION_HANDLE:
			e = INV_ACTION_HANDLE;
			break;

		case M_WLDCRD_CMD_NOT_SUPTD:
			e = WLDCRD_CMD_NOT_SUPTD;
			break;

		case M_INV_CMD_REQID:
			e = INV_CMD_REQID;
			break;

		case M_INV_CMD_RESPID:
			e = INV_CMD_RESPID;
			break;

		case M_TERM_TYPE_NOT_INSYNCH:
			e = TERM_TYPE_NOT_INSYNCH;
			break;

		case M_INV_TERM_NAME_FORMAT:
			e = INV_TERM_NAME_FORMAT;
			break;

		case M_TOPOLOGY_DESC_NOT_SUPTD:
			e = TOPOLOGY_DESC_NOT_SUPTD;
			break;

		case M_MEDIA_DESC_NOT_SUPTD:
			e = MEDIA_DESC_NOT_SUPTD;
			break;

		case M_MODEM_DESC_NOT_SUPTD:
			e = MODEM_DESC_NOT_SUPTD;
			break;

		case M_MUX_DESC_NOT_SUPTD:
			e = MUX_DESC_NOT_SUPTD;
			break;

		case M_EVENT_DESC_NOT_SUPTD:
			e = EVENT_DESC_NOT_SUPTD;
			break;

		case M_SIGNAL_DESC_NOT_SUPTD:
			e = SIGNAL_DESC_NOT_SUPTD;
			break;

		case M_DIGITMAP_DESC_NOT_SUPTD:
			e = DIGITMAP_DESC_NOT_SUPTD;
			break;

		case M_EVENTBUFF_DESC_NOT_SUPTD:
			e = EVENTBUFF_DESC_NOT_SUPTD;
			break;

		case M_AUDIT_DESC_NOT_SUPTD:
			e = AUDIT_DESC_NOT_SUPTD;
			break;

		case M_OBSRD_EVENT_DESC_NOT_SUPTD:
			e = OBSRD_EVENT_DESC_NOT_SUPTD;
			break;

		case M_STATS_DESC_NOT_SUPTD:
			e = STATS_DESC_NOT_SUPTD;
			break;

		case M_PCKG_DESC_NOT_SUPTD:
			e = PCKG_DESC_NOT_SUPTD;
			break;

		case M_SDPINFO_NOT_SUPTD:
			e = SDPINFO_NOT_SUPTD;
			break;

		case M_INV_PKG_ITEM_TYPE:
			e = INV_PKG_ITEM_TYPE;
			break;

		case M_INV_CTXID_TERMTYPE_PAIR:
			e = INV_CTXID_TERMTYPE_PAIR;
			break;

		case M_MISSING_LCL_TPT_ADDR:
			e = MISSING_LCL_TPT_ADDR;
			break;

		case M_MISSING_REMOTE_TPT_ADDR:
			e = MISSING_REMOTE_TPT_ADDR;
			break;

		case M_MISSING_SVC_CHNG_REASON:
			e = MISSING_SVC_CHNG_REASON;
			break;
		default:
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No ErrorCode for passed value = " + value);
			throw illegalArgumentException;
		}
		return e;
	}

	private Object readResolve() {

		return this.getObject(this.error_code);

	}

	@Override




public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ErrorCode:");

bob.append("error_code=").append(error_code).append(",");

return bob.append(";").toString(); 
}











public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.ErrorCode o = (javax.megaco.ErrorCode)oo;
if (error_code != o.error_code) return false;

return true;
}

}












