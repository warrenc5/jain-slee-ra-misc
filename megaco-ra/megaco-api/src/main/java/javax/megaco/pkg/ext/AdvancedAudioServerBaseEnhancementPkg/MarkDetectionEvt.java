package javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class MarkDetectionEvt extends PkgEventItem {
	public static final int MARK_DETECTION = 0x0002;
	public static final String TOKEN = "md";

	public MarkDetectionEvt() {
		super();
		super.itemId = MARK_DETECTION;
		super.eventId = MARK_DETECTION;
        super.packageId = AdvancedAudioServerBaseEnhancementPkg.PACKAGE_INSTANCE;

	}

	public int getEventId() {

		return super.itemId;
	}

	public int getItemId() {
		return super.itemId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("MarkDetectionEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}


}
