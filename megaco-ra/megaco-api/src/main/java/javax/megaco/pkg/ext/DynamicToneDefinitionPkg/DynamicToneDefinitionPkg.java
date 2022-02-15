package javax.megaco.pkg.ext.DynamicToneDefinitionPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * null 
 */
@Generated({"warren crossing"})
public class DynamicToneDefinitionPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 1;

    static final MegacoPkg PACKAGE_INSTANCE = new DynamicToneDefinitionPkg(); 

	private static int[] extendedPkgIds = new int[] {  }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x001c ; 
	}

	public String getPackageName() {
		return "dtd" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DynamicToneDefinitionPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
