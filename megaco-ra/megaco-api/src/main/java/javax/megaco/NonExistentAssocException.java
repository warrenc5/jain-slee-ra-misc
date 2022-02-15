package javax.megaco;

/**
 * 
 * @author wozza
 */
public class NonExistentAssocException extends MegacoException {

    /**
     * 
     */
    public NonExistentAssocException() {
		super();
	}

    /**
     * 
     * @param msg
     */
    public NonExistentAssocException(String msg) {
		super(msg);
	}





public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("NonExistentAssocException:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}


