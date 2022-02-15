package javax.megaco.association;

import javax.megaco.MegacoException;

/**
 * 
 * @author wozza
 */
public class MethodExtensionException extends MegacoException {

    /**
     * 
     */
    public MethodExtensionException() {
		// TODO Auto-generated constructor stub
	}

    /**
     * 
     * @param msg
     */
    public MethodExtensionException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}







public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("MethodExtensionException:");
bob.append(super.toString());


return bob.append(";").toString(); 
}












public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.association.MethodExtensionException o = (javax.megaco.association.MethodExtensionException)oo;
if (!super.equals(o)) return false;

return true;
}

}












