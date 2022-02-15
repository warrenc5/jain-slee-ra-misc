package javax.megaco.pkg.ext.BasicAnnouncementSyntaxPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * This package exists only to indicate that the MG is capable of processing the 
 */
@Generated({"warren crossing"})
public class BasicAnnouncementSyntaxPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 1;

    static final MegacoPkg PACKAGE_INSTANCE = new BasicAnnouncementSyntaxPkg(); 

	private static int[] extendedPkgIds = new int[] {  }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x0047 ; 
	}

	public String getPackageName() {
		return "bannsyx" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("BasicAnnouncementSyntaxPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
