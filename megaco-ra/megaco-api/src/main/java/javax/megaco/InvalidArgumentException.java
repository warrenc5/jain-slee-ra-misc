package javax.megaco;

/**
 * 
 * @author wozza
 */
public class InvalidArgumentException extends MegacoException {
	
    /**
     * 
     */
    public InvalidArgumentException() {
		super();
	}
	
    /**
     * 
     * @param msg
     */
    public InvalidArgumentException(java.lang.String msg) {
		super(msg);
	}




public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("InvalidArgumentException:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}


