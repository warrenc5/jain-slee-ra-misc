package javax.megaco;

/**
 * 
 * @author wozza
 */
public class MegacoFactory extends ClassLoader {

	
    /**
     * 
     * @param objectClassName
     * @return
     * @throws MegacoPeerUnvbleException
     */
    public java.lang.Object createMegacoObject(java.lang.String objectClassName)
			throws MegacoPeerUnvbleException {
		//TODO : implemet the ClassLoader
		String className = objectClassName + ".javax.megaco.MegacoStackImpl";
		Class impl;
		try {
			impl = MegacoFactory.class.getClassLoader().loadClass(className);
			return (MegacoStack) impl.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new MegacoPeerUnvbleException(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new MegacoPeerUnvbleException(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new MegacoPeerUnvbleException(e.getMessage());
		}

	}




public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("MegacoFactory:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}


