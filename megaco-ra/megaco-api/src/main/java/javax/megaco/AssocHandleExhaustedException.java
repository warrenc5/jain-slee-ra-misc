package javax.megaco;

/**
 * 
 * @author wozza
 */
public class AssocHandleExhaustedException extends MegacoException {

    /**
     * 
     */
    public AssocHandleExhaustedException() {
		super();
	}

    /**
     * 
     * @param msg
     */
    public AssocHandleExhaustedException(String msg) {
		super(msg);
		
	}





public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AssocHandleExhaustedException:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}


