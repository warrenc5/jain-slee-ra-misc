package javax.megaco.pkg.ext.AASRecordingPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class PlayRecordSig extends PkgSignalItem {

	public static final int PLAYRECORD = 0x0002;
	public static final String TOKEN = "playrec";


	public PlayRecordSig() {
		super();
        super.packageId = AASRecordingPkg.PACKAGE_INSTANCE;
		super.signalId = PLAYRECORD;
		super.itemId = PLAYRECORD;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("PlayRecordSig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
