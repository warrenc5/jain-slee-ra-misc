package javax.megaco.message.descriptor;



class DescriptorUtils {

	static void checkMethodExtensionRules(String s) throws IllegalArgumentException {
		// FIXME add checks
		return;
	}
	
	static void checkTimeStampRules(String s) throws IllegalArgumentException {
		// FIXME add checks
		return;
	}

	public static void checkSrvcChngProfileRules(String profile)  throws IllegalArgumentException{
		// TODO Auto-generated method stub
		
	}

	public static void checkParamNameRules(String name)  throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}






public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DescriptorUtils:");


return bob.append(";").toString(); 
}












public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.DescriptorUtils o = (javax.megaco.message.descriptor.DescriptorUtils)oo;

return true;
}

}












