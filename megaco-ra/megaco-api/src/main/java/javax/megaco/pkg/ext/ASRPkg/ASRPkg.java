package javax.megaco.pkg.ext.ASRPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * The ASR package provides a signal to play an ASR and an event to indicate 
 */
@Generated({"warren crossing"})
public class ASRPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 1;

    static final MegacoPkg PACKAGE_INSTANCE = new ASRPkg(); 

	private static int[] extendedPkgIds = new int[] {  }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x00a6 ; 
	}

	public String getPackageName() {
		return "asr" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ASRPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
