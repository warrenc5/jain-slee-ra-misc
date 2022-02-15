package javax.megaco.pkg.ext.AASDigitCollectionPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class PlayCollectSig extends PkgSignalItem {

	public static final int PLAYCOLLECT = 0x0002;
	public static final String TOKEN = "playcol";


	public PlayCollectSig() {
		super();
        super.packageId = AASDigitCollectionPkg.PACKAGE_INSTANCE;
		super.signalId = PLAYCOLLECT;
		super.itemId = PLAYCOLLECT;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("PlayCollectSig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
