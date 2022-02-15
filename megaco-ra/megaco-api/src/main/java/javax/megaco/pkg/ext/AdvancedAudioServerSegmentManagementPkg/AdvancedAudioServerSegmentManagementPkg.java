package javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * The Advanced audio server segment management package provides a 
 */
@Generated({"warren crossing"})
public class AdvancedAudioServerSegmentManagementPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 1;

    static final MegacoPkg PACKAGE_INSTANCE = new AdvancedAudioServerSegmentManagementPkg(); 

	private static int[] extendedPkgIds = new int[] {  }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x0036 ; 
	}

	public String getPackageName() {
		return "aassm" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AdvancedAudioServerSegmentManagementPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
