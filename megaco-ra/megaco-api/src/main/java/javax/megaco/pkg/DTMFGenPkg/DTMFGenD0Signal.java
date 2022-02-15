package javax.megaco.pkg.DTMFGenPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;

/**
 * The MEGACO DTMF character 0 signal class extends the PkgSignalItem class.
 * This is a final class. This class defines DTMF character 0 signal of MEGACO
 * DTMF package. The methods shall define that this signal item belongs to the
 * DTMF package.
 */
public final class DTMFGenD0Signal extends PkgSignalItem {

	/**
	 * Identifies signal id DTMF character 0 of the MEGACO DTMF Generator
	 * Package. Its value shall be set equal to 0x0010.
	 */
	public static final int DTMF_GEN_D0_SIGNAL = 0x0010;

	

	/**
	 * Constructs a MEGACO signal item with signal id as DTMF character 0.
	 */
	public DTMFGenD0Signal() {
		super();
    super.packageId = DTMFGenPkg.PACKAGE_INSTANCE;
		super.signalId = DTMF_GEN_D0_SIGNAL;
		super.itemId = DTMF_GEN_D0_SIGNAL;
	}

	/**
	 * This method is used to get the signal identifier from an Signal Item
	 * object. The implementations of this method in this class returns the id
	 * of the DTMF character 0 signal of DTMF Generator Package.
	 * 
	 * @return It shall return {@link DTMF_GEN_D0_SIGNAL}.
	 */
	public int getItemId() {

		return super.itemId;
	}

	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the DTMF
	 * character 0 signal of DTMF Generator Package.
	 * 
	 * @return It shall return {@link DTMF_GEN_D0_SIGNAL}.
	 */
	public int getSignalId() {
		return super.signalId;
	}











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DTMFGenD0Signal:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.DTMFGenPkg.DTMFGenD0Signal o = (javax.megaco.pkg.DTMFGenPkg.DTMFGenD0Signal)oo;
if (!super.equals(o)) return false;

return true;
}

}


















