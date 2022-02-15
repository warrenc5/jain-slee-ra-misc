package javax.megaco;

/**
 * 
 * @author wozza
 */
public class VersionNotSupportedException extends MegacoException {

    /**
     * 
     */
    public VersionNotSupportedException() {
		super();
	}

    /**
     * 
     * @param msg
     */
    public VersionNotSupportedException(String msg) {
		super(msg);

	}





public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("VersionNotSupportedException:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}


