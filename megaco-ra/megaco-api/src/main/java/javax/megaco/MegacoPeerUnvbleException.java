package javax.megaco;

/**
 * 
 * @author wozza
 */
public class MegacoPeerUnvbleException extends MegacoException {
    /**
     * 
     */
    public MegacoPeerUnvbleException() {
		super();
	}

    /**
     * 
     * @param msg
     */
    public MegacoPeerUnvbleException(java.lang.String msg) {
		super(msg);
	}




public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("MegacoPeerUnvbleException:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}


