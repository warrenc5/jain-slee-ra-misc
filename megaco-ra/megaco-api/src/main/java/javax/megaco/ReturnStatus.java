package javax.megaco;

import java.io.Serializable;

/**
 * 
 * @author wozza
 */
public class ReturnStatus implements Serializable{

    /**
     * 
     */
    public static final int M_SUCCESS = 1;
    /**
     * 
     */
    public static final int M_FAILURE = 2;

    /**
     * 
     */
    public static final ReturnStatus SUCCESS = new ReturnStatus(M_SUCCESS);

    /**
     * 
     */
    public static final ReturnStatus FAILURE = new ReturnStatus(M_FAILURE);

	private int return_status;

	private ReturnStatus(int return_status) {
		this.return_status = return_status;

	}

    /**
     * 
     * @return
     */
    public int getReturnStatus() {
		return this.return_status;
	}

    /**
     * 
     * @param value
     * @return
     * @throws IllegalArgumentException
     */
    public static final ReturnStatus getObject(int value) throws IllegalArgumentException {
		ReturnStatus r = null;
		switch (value) {
		case M_SUCCESS:
			r = SUCCESS;
			break;

		case M_FAILURE:
			r = FAILURE;
			break;
		default:
			throw new IllegalArgumentException("No ReturnStatus for value " + value);

		}

		return r;
	}

	private Object readResolve() {

		return this.getObject(this.return_status);

	}

	@Override




public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ReturnStatus:");

bob.append("return_status=").append(return_status).append(",");

return bob.append(";").toString(); 
}











public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.ReturnStatus o = (javax.megaco.ReturnStatus)oo;
if (return_status != o.return_status) return false;

return true;
}

}












