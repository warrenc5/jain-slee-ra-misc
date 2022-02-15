package javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class PlaySegmentIdentifierSig extends PkgSignalItem {

	public static final int PLAY_SEGMENT_IDENTIFIER = 0x0001;
	public static final String TOKEN = "playsid";


	public PlaySegmentIdentifierSig() {
		super();
        super.packageId = AdvancedAudioServerBaseEnhancementPkg.PACKAGE_INSTANCE;
		super.signalId = PLAY_SEGMENT_IDENTIFIER;
		super.itemId = PLAY_SEGMENT_IDENTIFIER;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("PlaySegmentIdentifierSig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
