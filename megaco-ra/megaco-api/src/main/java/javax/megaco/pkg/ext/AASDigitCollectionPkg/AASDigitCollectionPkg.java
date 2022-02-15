package javax.megaco.pkg.ext.AASDigitCollectionPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * The AAS Digit Collection Package extends the AAS base package by 
 */
@Generated({"warren crossing"})
public class AASDigitCollectionPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 3;

    static final MegacoPkg PACKAGE_INSTANCE = new AASDigitCollectionPkg(); 

	private static int[] extendedPkgIds = new int[] { 51 }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x0034 ; 
	}

	public String getPackageName() {
		return "aasdc" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AASDigitCollectionPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
