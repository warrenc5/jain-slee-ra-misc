package javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * The Enhanced DTMF Detection Package allows a MGC to indicate in which 
 */
@Generated({"warren crossing"})
public class EnhancedDTMFDetectionPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 1;

    static final MegacoPkg PACKAGE_INSTANCE = new EnhancedDTMFDetectionPkg(); 

	private static int[] extendedPkgIds = new int[] { 6 }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x0100 ; 
	}

	public String getPackageName() {
		return "edtmf" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("EnhancedDTMFDetectionPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
