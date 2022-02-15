package javax.megaco;

/**
 * 
 * @author wozza
 */
public class InvalidUserIdException extends MegacoException {

    /**
     * 
     */
    public InvalidUserIdException() {
		super();
	}

    /**
     * 
     * @param msg
     */
    public InvalidUserIdException(String msg) {
		super(msg);
		
	}





public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("InvalidUserIdException:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}


