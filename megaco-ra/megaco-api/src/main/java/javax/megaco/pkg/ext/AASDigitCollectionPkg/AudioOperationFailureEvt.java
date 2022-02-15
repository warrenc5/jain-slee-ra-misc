package javax.megaco.pkg.ext.AASDigitCollectionPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class AudioOperationFailureEvt extends PkgEventItem {
	public static final int AUDIO_OPERATION_FAILURE = 0x0001;
	public static final String TOKEN = "audfail";

	public AudioOperationFailureEvt() {
		super();
		super.itemId = AUDIO_OPERATION_FAILURE;
		super.eventId = AUDIO_OPERATION_FAILURE;
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
bob.append("AudioOperationFailureEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}


}
