package javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class DeletePersistentSig extends PkgSignalItem {

	public static final int DELETE_PERSISTENT = 0x0001;
	public static final String TOKEN = "delpers";


	public DeletePersistentSig() {
		super();
        super.packageId = AdvancedAudioServerSegmentManagementPkg.PACKAGE_INSTANCE;
		super.signalId = DELETE_PERSISTENT;
		super.itemId = DELETE_PERSISTENT;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DeletePersistentSig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
