package javax.megaco.pkg.ext.AnnouncementSetSyntaxPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * This package exists only to indicate that the MG is capable of processing the 
 */
@Generated({"warren crossing"})
public class AnnouncementSetSyntaxPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 3;

    static final MegacoPkg PACKAGE_INSTANCE = new AnnouncementSetSyntaxPkg(); 

	private static int[] extendedPkgIds = new int[] { 71 }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x0049 ; 
	}

	public String getPackageName() {
		return "setsyx" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AnnouncementSetSyntaxPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
