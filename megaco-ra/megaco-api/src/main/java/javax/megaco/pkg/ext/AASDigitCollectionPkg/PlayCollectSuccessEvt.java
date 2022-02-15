package javax.megaco.pkg.ext.AASDigitCollectionPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class PlayCollectSuccessEvt extends PkgEventItem {
	public static final int PLAY_COLLECT_SUCCESS = 0x0002;
	public static final String TOKEN = "pcolsucc";

	public PlayCollectSuccessEvt() {
		super();
		super.itemId = PLAY_COLLECT_SUCCESS;
		super.eventId = PLAY_COLLECT_SUCCESS;
        super.packageId = AASDigitCollectionPkg.PACKAGE_INSTANCE;

	}

	public int getEventId() {

		return super.itemId;
	}

	public int getItemId() {
		return super.itemId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("PlayCollectSuccessEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}


}
