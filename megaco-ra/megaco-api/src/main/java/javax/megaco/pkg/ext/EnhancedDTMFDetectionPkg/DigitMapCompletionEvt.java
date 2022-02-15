package javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class DigitMapCompletionEvt extends PkgEventItem {
	public static final int DIGITMAP_COMPLETION_EVENT = 0x0004;
	public static final String TOKEN = "ce";

	public DigitMapCompletionEvt() {
		super();
		super.itemId = DIGITMAP_COMPLETION_EVENT;
		super.eventId = DIGITMAP_COMPLETION_EVENT;
        super.packageId = EnhancedDTMFDetectionPkg.PACKAGE_INSTANCE;

	}

	public int getEventId() {

		return super.itemId;
	}

	public int getItemId() {
		return super.itemId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DigitMapCompletionEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}


}
