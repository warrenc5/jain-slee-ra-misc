package javax.megaco.pkg.ext.AdvancedAudioServerBasePkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class PlayoutCompletionEvt extends PkgEventItem {
	public static final int PLAYOUT_COMPLETION = 0x0012;
	public static final String TOKEN = "playcom";

	public PlayoutCompletionEvt() {
		super();
		super.itemId = PLAYOUT_COMPLETION;
		super.eventId = PLAYOUT_COMPLETION;
        super.packageId = AdvancedAudioServerBasePkg.PACKAGE_INSTANCE;

	}

	public int getEventId() {

		return super.itemId;
	}

	public int getItemId() {
		return super.itemId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("PlayoutCompletionEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}


}
