package javax.megaco.pkg.ext.MultimediaRecordingPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * The Multimedia Recording Package indicates that the recording is associated 
 */
@Generated({"warren crossing"})
public class MultimediaRecordingPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 2;

    static final MegacoPkg PACKAGE_INSTANCE = new MultimediaRecordingPkg(); 

	private static int[] extendedPkgIds = new int[] { 53 }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x00b3 ; 
	}

	public String getPackageName() {
		return "mrp" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("MultimediaRecordingPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
