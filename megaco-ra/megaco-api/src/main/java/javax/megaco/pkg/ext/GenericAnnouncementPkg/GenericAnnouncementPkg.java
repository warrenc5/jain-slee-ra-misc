package javax.megaco.pkg.ext.GenericAnnouncementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * null 
 */
@Generated({"warren crossing"})
public class GenericAnnouncementPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 1;

    static final MegacoPkg PACKAGE_INSTANCE = new GenericAnnouncementPkg(); 

	private static int[] extendedPkgIds = new int[] {  }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x001d ; 
	}

	public String getPackageName() {
		return "an" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("GenericAnnouncementPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
