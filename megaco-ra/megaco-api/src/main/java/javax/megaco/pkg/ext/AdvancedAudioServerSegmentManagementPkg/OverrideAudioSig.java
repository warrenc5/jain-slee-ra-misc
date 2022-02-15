package javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class OverrideAudioSig extends PkgSignalItem {

	public static final int OVERRIDE_AUDIO = 0x0002;
	public static final String TOKEN = "override";


	public OverrideAudioSig() {
		super();
        super.packageId = AdvancedAudioServerSegmentManagementPkg.PACKAGE_INSTANCE;
		super.signalId = OVERRIDE_AUDIO;
		super.itemId = OVERRIDE_AUDIO;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("OverrideAudioSig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
