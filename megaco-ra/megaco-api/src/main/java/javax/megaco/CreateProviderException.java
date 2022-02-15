package javax.megaco;

/**
 * 
 * @author wozza
 */
public class CreateProviderException extends MegacoException {
    /**
     * 
     */
    public CreateProviderException(){
		super();
	}
	
    /**
     * 
     * @param msg
     */
    public CreateProviderException(java.lang.String msg){
		super(msg);
	}




public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("CreateProviderException:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}


