package javax.megaco.pkg.ext.AASRecordingPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class PlayRecordSuccessEvt extends PkgEventItem {
	public static final int PLAYRECORD_SUCCESS = 0x0002;
	public static final String TOKEN = "precsucc";

	public PlayRecordSuccessEvt() {
		super();
		super.itemId = PLAYRECORD_SUCCESS;
		super.eventId = PLAYRECORD_SUCCESS;
        super.packageId = AASRecordingPkg.PACKAGE_INSTANCE;

	}

	public int getEventId() {

		return super.itemId;
	}

	public int getItemId() {
		return super.itemId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("PlayRecordSuccessEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}


}
