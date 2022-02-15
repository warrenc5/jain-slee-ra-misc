package javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class TTSOperationFailureEvt extends PkgEventItem {
	public static final int TTS_OPERATION_FAILURE = 0x0001;
	public static final String TOKEN = "ttsfail";

	public TTSOperationFailureEvt() {
		super();
		super.itemId = TTS_OPERATION_FAILURE;
		super.eventId = TTS_OPERATION_FAILURE;
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
bob.append("TTSOperationFailureEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}


}
