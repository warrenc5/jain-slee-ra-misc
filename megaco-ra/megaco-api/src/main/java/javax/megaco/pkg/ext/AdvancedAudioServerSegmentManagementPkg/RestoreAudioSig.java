package javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class RestoreAudioSig extends PkgSignalItem {

	public static final int RESTOREAUDIO = 0x0003;
	public static final String TOKEN = "restore";


	public RestoreAudioSig() {
		super();
        super.packageId = AdvancedAudioServerSegmentManagementPkg.PACKAGE_INSTANCE;
		super.signalId = RESTOREAUDIO;
		super.itemId = RESTOREAUDIO;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("RestoreAudioSig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
