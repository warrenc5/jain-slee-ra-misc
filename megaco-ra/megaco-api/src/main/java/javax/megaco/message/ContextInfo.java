package javax.megaco.message;

import java.io.Serializable;



/**
 * This class defines the context information block that contains the context id
 * sent in the protocol and the context level parameters.
 * 
 */
public class ContextInfo implements Serializable {
    /**
     * 
     */
    public static final int M_CTX_NULL = 0;
    /**
     * 
     */
    public static final int M_CTX_CHOOSE = 0xFFFFFFFE;
    /**
     * 
     */
    public static final int M_CTX_ALL = 0xFFFFFFFF;

	private int contextId;
	private ContextParam contextParam = null;

    /**
     * 
     * @param contextId
     * @throws IllegalArgumentException
     */
    public ContextInfo(int contextId)
			throws IllegalArgumentException {
        /*
		if (contextId < 0) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException(
					"ContextID for ContextInfo cannot be less than zero");
			throw invalidArgumentException;
		}
        * 
        */
		this.contextId = contextId;
	}

    /**
     * 
     * @return
     */
    public int getContextId() {
		return this.contextId;
	}

    /**
     * 
     * @return
     */
    public ContextParam getContextParam() {
		return this.contextParam;
	}

    /**
     * 
     * @param contextParam
     * @throws IllegalArgumentException
     */
    public void setContextParam(ContextParam contextParam)
			throws IllegalArgumentException {
		if (contextParam == null) {
			IllegalArgumentException IllegalArgumentException = new IllegalArgumentException(
					"ContextParam cannot be null for ContextInfo");
			throw IllegalArgumentException;
		}

		this.contextParam = contextParam;
	}
















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ContextInfo:");

bob.append("contextId=").append(contextId).append(",");
if(contextParam !=null)
bob.append("contextParam=").append(contextParam).append(",");

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.ContextInfo o = (javax.megaco.message.ContextInfo)oo;
if (contextId != o.contextId) return false;
if((contextParam !=null && o.contextParam == null) ||(contextParam == null && o.contextParam != null) ) return false;
if(contextParam ==null && o.contextParam == null) return true ; else if(contextParam !=null && o.contextParam != null)
if (contextParam != null && o.contextParam !=null && !contextParam.equals(o.contextParam)) return false;

return true;
}

}
























