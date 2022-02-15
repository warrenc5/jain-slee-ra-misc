package javax.megaco.pkg.ext.AdvancedAudioServerBasePkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * The advanced audio server (AAS) base package provides a signal to play an 
 */
@Generated({"warren crossing"})
public class AdvancedAudioServerBasePkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 3;

    static final MegacoPkg PACKAGE_INSTANCE = new AdvancedAudioServerBasePkg(); 

	private static int[] extendedPkgIds = new int[] {  }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x0033 ; 
	}

	public String getPackageName() {
		return "aasb" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AdvancedAudioServerBasePkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
