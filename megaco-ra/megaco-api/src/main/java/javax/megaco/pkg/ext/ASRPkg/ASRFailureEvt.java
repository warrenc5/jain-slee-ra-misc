package javax.megaco.pkg.ext.ASRPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class ASRFailureEvt extends PkgEventItem {
	public static final int ASR_FAILURE = 0x0001;
	public static final String TOKEN = "asrfail";

	public ASRFailureEvt() {
		super();
		super.itemId = ASR_FAILURE;
		super.eventId = ASR_FAILURE;
        super.packageId = ASRPkg.PACKAGE_INSTANCE;

	}

	public int getEventId() {

		return super.itemId;
	}

	public int getItemId() {
		return super.itemId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ASRFailureEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}


}
