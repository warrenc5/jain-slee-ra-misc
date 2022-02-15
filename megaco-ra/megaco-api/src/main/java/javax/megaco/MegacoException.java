package javax.megaco;

/**
 * 
 * @author wozza
 */
public class MegacoException extends Exception {
	private int assocHandle;
	private ExceptionInfoCode exceptionInfoCode = null;

    /**
     * 
     */
    public MegacoException() {
		super();
	}

    /**
     * 
     * @param msg
     */
    public MegacoException(java.lang.String msg) {
		super(msg);
	}

    /**
     * 
     * @param assocHandle
     */
    public void setAssocHandle(int assocHandle) {
		this.assocHandle = assocHandle;

	}

    /**
     * 
     * @return
     */
    public int getAssocHandle() {
		return this.assocHandle;
	}

    /**
     * 
     * @param ecode
     */
    public void setInfoCode(ExceptionInfoCode ecode) {
		this.exceptionInfoCode = ecode;
	}

    /**
     * 
     * @return
     */
    public int getInfoCode() {
		return this.exceptionInfoCode.getExceptionInfoCode();
	}




public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("MegacoException:");
bob.append(super.toString());

bob.append("assocHandle=").append(assocHandle).append(",");
if(exceptionInfoCode !=null)
bob.append("exceptionInfoCode=").append(exceptionInfoCode).append(",");

return bob.append(";").toString(); 
}



}


