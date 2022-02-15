package javax.megaco.pkg.ext.AdvancedAudioServerBasePkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class PlaySig extends PkgSignalItem {

	public static final int PLAY = 0x0001;
	public static final String TOKEN = "play";


	public PlaySig() {
		super();
        super.packageId = AdvancedAudioServerBasePkg.PACKAGE_INSTANCE;
		super.signalId = PLAY;
		super.itemId = PLAY;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("PlaySig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
