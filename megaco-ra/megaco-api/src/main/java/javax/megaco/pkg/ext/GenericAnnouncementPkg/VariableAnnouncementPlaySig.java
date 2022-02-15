package javax.megaco.pkg.ext.GenericAnnouncementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class VariableAnnouncementPlaySig extends PkgSignalItem {

	public static final int VARIABLE_ANNOUNCEMENT_PLAY = 0x0002;
	public static final String TOKEN = "apv";


	public VariableAnnouncementPlaySig() {
		super();
        super.packageId = GenericAnnouncementPkg.PACKAGE_INSTANCE;
		super.signalId = VARIABLE_ANNOUNCEMENT_PLAY;
		super.itemId = VARIABLE_ANNOUNCEMENT_PLAY;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("VariableAnnouncementPlaySig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
