package javax.megaco.pkg.ext.AASRecordingPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * AAS recording package: extends the AAS base package by providing signals 
 */
@Generated({"warren crossing"})
public class AASRecordingPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 3;

    static final MegacoPkg PACKAGE_INSTANCE = new AASRecordingPkg(); 

	private static int[] extendedPkgIds = new int[] { 51 }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x0035 ; 
	}

	public String getPackageName() {
		return "aasrec" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AASRecordingPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
