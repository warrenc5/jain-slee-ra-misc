package javax.megaco.pkg.ext.ASRPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class ASRSuccessEvt extends PkgEventItem {
	public static final int ASR_SUCCESS = 0x0002;
	public static final String TOKEN = "asrsucc";

	public ASRSuccessEvt() {
		super();
		super.itemId = ASR_SUCCESS;
		super.eventId = ASR_SUCCESS;
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
bob.append("ASRSuccessEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}


}
