package javax.megaco;

/**
 * 
 * @author wozza
 */
public class DeleteProviderException extends MegacoException {

    /**
     * 
     */
    public DeleteProviderException() {
		super();
	}

    /**
     * 
     * @param msg
     */
    public DeleteProviderException(String msg) {
		super(msg);
		
	}





public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DeleteProviderException:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}


