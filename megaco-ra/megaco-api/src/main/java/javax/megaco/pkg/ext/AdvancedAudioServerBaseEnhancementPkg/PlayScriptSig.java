package javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class PlayScriptSig extends PkgSignalItem {

	public static final int PLAY_SCRIPT = 0x0002;
	public static final String TOKEN = "playscript";


	public PlayScriptSig() {
		super();
        super.packageId = AdvancedAudioServerBaseEnhancementPkg.PACKAGE_INSTANCE;
		super.signalId = PLAY_SCRIPT;
		super.itemId = PLAY_SCRIPT;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("PlayScriptSig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
