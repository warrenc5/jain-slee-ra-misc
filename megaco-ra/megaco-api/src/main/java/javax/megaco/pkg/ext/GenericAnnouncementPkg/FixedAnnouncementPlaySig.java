package javax.megaco.pkg.ext.GenericAnnouncementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class FixedAnnouncementPlaySig extends PkgSignalItem {

	public static final int FIXED_ANNOUNCEMENT_PLAY = 0x0001;
	public static final String TOKEN = "apf";


	public FixedAnnouncementPlaySig() {
		super();
        super.packageId = GenericAnnouncementPkg.PACKAGE_INSTANCE;
		super.signalId = FIXED_ANNOUNCEMENT_PLAY;
		super.itemId = FIXED_ANNOUNCEMENT_PLAY;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("FixedAnnouncementPlaySig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
