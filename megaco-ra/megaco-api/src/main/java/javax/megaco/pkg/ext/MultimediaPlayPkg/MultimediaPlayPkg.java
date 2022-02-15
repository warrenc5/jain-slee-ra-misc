package javax.megaco.pkg.ext.MultimediaPlayPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * Multimedia Play Package indicates that the playout is associated with 
 */
@Generated({"warren crossing"})
public class MultimediaPlayPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 2;

    static final MegacoPkg PACKAGE_INSTANCE = new MultimediaPlayPkg(); 

	private static int[] extendedPkgIds = new int[] { 51 }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x00a9 ; 
	}

	public String getPackageName() {
		return "mpp" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("MultimediaPlayPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
