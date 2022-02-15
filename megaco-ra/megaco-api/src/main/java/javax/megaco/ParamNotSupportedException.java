package javax.megaco;

/**
 * 
 * @author wozza
 */
public class ParamNotSupportedException extends MegacoException {

    /**
     * 
     */
    public ParamNotSupportedException() {
		super();
	}

    /**
     * 
     * @param msg
     */
    public ParamNotSupportedException(String msg) {
		super(msg);		
	}





public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ParamNotSupportedException:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}


