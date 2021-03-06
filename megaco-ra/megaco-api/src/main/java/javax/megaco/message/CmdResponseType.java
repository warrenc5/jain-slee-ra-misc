package javax.megaco.message;

import java.io.Serializable;

/**
 * 
 * @author wozza
 */
public class CmdResponseType implements Serializable {

    /**
     * 
     */
    public static final int M_ADD_RESP = 1;
    /**
     * 
     */
    public static final int M_MODIFY_RESP = 2;
    /**
     * 
     */
    public static final int M_MOVE_RESP = 3;
    /**
     * 
     */
    public static final int M_SERVICE_CHANGE_RESP = 4;
    /**
     * 
     */
    public static final int M_NOTIFY_RESP = 5;
    /**
     * 
     */
    public static final int M_AUDIT_VAL_RESP = 6;
    /**
     * 
     */
    public static final int M_AUDIT_CAP_RESP = 7;
    /**
     * 
     */
    public static final int M_SUBTRACT_RESP = 8;

    /**
     * 
     */
    public static final CmdResponseType ADD_RESP = new CmdResponseType(M_ADD_RESP);
    /**
     * 
     */
    public static final CmdResponseType MODIFY_RESP = new CmdResponseType(M_MODIFY_RESP);
    /**
     * 
     */
    public static final CmdResponseType MOVE_RESP = new CmdResponseType(M_MOVE_RESP);
    /**
     * 
     */
    public static final CmdResponseType SERVICE_CHANGE_RESP = new CmdResponseType(M_SERVICE_CHANGE_RESP);
    /**
     * 
     */
    public static final CmdResponseType NOTIFY_RESP = new CmdResponseType(M_NOTIFY_RESP);
    /**
     * 
     */
    public static final CmdResponseType AUDIT_VAL_RESP = new CmdResponseType(M_AUDIT_VAL_RESP);
    /**
     * 
     */
    public static final CmdResponseType AUDIT_CAP_RESP = new CmdResponseType(M_AUDIT_CAP_RESP);
    /**
     * 
     */
    public static final CmdResponseType SUBTRACT_RESP = new CmdResponseType(M_SUBTRACT_RESP);

	private int cmd_type;

	private CmdResponseType(int cmd_type) {
		this.cmd_type = cmd_type;
	}

    /**
     * 
     * @return
     */
    public int getResponseType() {
		return this.cmd_type;
	}

    /**
     * 
     * @param value
     * @return
     * @throws IllegalArgumentException
     */
    public static final CmdResponseType getObject(int value) throws IllegalArgumentException {
		CmdResponseType c = null;
		switch (value) {
		case M_ADD_RESP:
			c = ADD_RESP;
			break;

		case M_MODIFY_RESP:
			c = MODIFY_RESP;
			break;

		case M_MOVE_RESP:
			c = MOVE_RESP;
			break;

		case M_SERVICE_CHANGE_RESP:
			c = SERVICE_CHANGE_RESP;
			break;

		case M_NOTIFY_RESP:
			c = NOTIFY_RESP;
			break;

		case M_AUDIT_VAL_RESP:
			c = AUDIT_VAL_RESP;
			break;

		case M_AUDIT_CAP_RESP:
			c = AUDIT_CAP_RESP;
			break;

		case M_SUBTRACT_RESP:
			c = SUBTRACT_RESP;
			break;

		default:
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No CmdResponseType found for value = " + value);
			throw illegalArgumentException;
		}
		return c;
	}

	private Object readResolve() {
		return this.getObject(this.cmd_type);
	}

	@Override
















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("CmdResponseType:");

bob.append("cmd_type=").append(cmd_type).append(",");

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.CmdResponseType o = (javax.megaco.message.CmdResponseType)oo;
if (cmd_type != o.cmd_type) return false;

return true;
}

}


























