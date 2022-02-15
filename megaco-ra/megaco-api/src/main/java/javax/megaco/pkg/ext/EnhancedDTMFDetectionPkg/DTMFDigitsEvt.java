package javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class DTMFDigitsEvt extends PkgEventItem {
	public static final int DTMF_DIGITS = 0x0002;
	public static final String TOKEN = "extkey";

	public DTMFDigitsEvt() {
		super();
		super.itemId = DTMF_DIGITS;
		super.eventId = DTMF_DIGITS;
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
bob.append("DTMFDigitsEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}


}
