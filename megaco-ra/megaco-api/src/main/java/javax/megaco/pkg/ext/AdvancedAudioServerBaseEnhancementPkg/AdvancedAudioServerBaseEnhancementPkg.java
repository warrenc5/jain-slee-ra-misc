package javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * The Advanced Audio Server (AAS) package for TTS enhancement provides a 
 */
@Generated({"warren crossing"})
public class AdvancedAudioServerBaseEnhancementPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 2;

    static final MegacoPkg PACKAGE_INSTANCE = new AdvancedAudioServerBaseEnhancementPkg(); 

	private static int[] extendedPkgIds = new int[] {  }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x00a8 ; 
	}

	public String getPackageName() {
		return "aastts" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AdvancedAudioServerBaseEnhancementPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
