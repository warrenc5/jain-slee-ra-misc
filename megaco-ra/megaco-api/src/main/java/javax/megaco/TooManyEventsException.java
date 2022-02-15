package javax.megaco;

/**
 * 
 * @author wozza
 */
public class TooManyEventsException extends MegacoException {

    /**
     * 
     */
    public TooManyEventsException() {
		super();
	}

    /**
     * 
     * @param msg
     */
    public TooManyEventsException(String msg) {
		super(msg);
	}





public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("TooManyEventsException:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}


