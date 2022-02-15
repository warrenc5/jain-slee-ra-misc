package javax.megaco.pkg.DTMFGenPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;

/**
 * The MEGACO DTMF character * signal class extends the PkgSignalItem class.
 * This is a final class. This class defines DTMF character * signal of MEGACO
 * DTMF package. The methods shall define that this signal item belongs to the
 * DTMF package.
 */
public final class DTMFGenDStarSignal extends PkgSignalItem {

	/**
	 * Identifies signal id DTMF character * of the MEGACO DTMF Generator
	 * Package. Its value shall be set equal to 0x0020.
	 */
	public static final int DTMF_GEN_DSTAR_SIGNAL = 0x0020;

	

	/**
	 * Constructs a MEGACO signal item with signal id as DTMF character *.
	 */
	public DTMFGenDStarSignal() {
		super();
    super.packageId = DTMFGenPkg.PACKAGE_INSTANCE;
		super.signalId = DTMF_GEN_DSTAR_SIGNAL;
		super.itemId = DTMF_GEN_DSTAR_SIGNAL;
	}
	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the DTMF
	 * character * signal of DTMF Generator Package.
	 * 
	 * @return It shall return {@link DTMF_GEN_DSTAR_SIGNAL}.
	 */
	public int getSignalId() {
		return super.signalId;
	}











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DTMFGenDStarSignal:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.DTMFGenPkg.DTMFGenDStarSignal o = (javax.megaco.pkg.DTMFGenPkg.DTMFGenDStarSignal)oo;
if (!super.equals(o)) return false;

return true;
}

}


















