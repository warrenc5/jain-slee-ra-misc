package javax.megaco.pkg.ext.AASRecordingPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class MakePersistentSig extends PkgSignalItem {

	public static final int MAKE_PERSISTENT = 0x0003;
	public static final String TOKEN = "makepers";


	public MakePersistentSig() {
		super();
        super.packageId = AASRecordingPkg.PACKAGE_INSTANCE;
		super.signalId = MAKE_PERSISTENT;
		super.itemId = MAKE_PERSISTENT;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("MakePersistentSig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
