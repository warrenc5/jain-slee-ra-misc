package javax.megaco.pkg.CPToneGenPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;

/**
 * The MEGACO Special Information Tone signal class extends the PkgSignalItem
 * class. This is a final class. This class defines Special Information Tone
 * signal of MEGACO Call Progress Tone Generator package. The methods shall
 * define that this signal item belongs to the Call Progress Tone Generator
 * package.
 */
public final class CPToneGenSitSignal extends PkgSignalItem {

	/**
	 * Identifies Special Information tone signal of the MEGACO Call Progress
	 * Tone Generator Package. Its value shall be set equal to 0x0034.
	 */
	public static final int CPTONE_GEN_SIT_SIGNAL = 0x0034;


	/**
	 * Constructs a Jain MEGACO Object representing signal Item of the MEGACO
	 * Package for signal Ringing Tone and Package as Call Progress Tone
	 * Generator.
	 */
	public CPToneGenSitSignal() {
		super();
        super.packageId = CPToneGenPkg.PACKAGE_INSTANCE;
		super.signalId = CPTONE_GEN_SIT_SIGNAL;
		super.itemId = CPTONE_GEN_SIT_SIGNAL;
	}

	/**
	 *This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the
	 * Special Information Tone signal of Call Progress Tone Generator Package.
	 * 
	 * @return It shall return {@link CPTONE_GEN_SIT_SIGNAL}.
	 */
	public int getItemId() {

		return super.itemId;
	}

	/**
	 * This method is used to get the signal identifier from an Signal Item
	 * object. The implementations of this method in this class returns the id
	 * of the Ringing Tone signal of Call Progress Tone Generator Package.
	 * 
	 * @return It shall return {@link CPTONE_GEN_SIT_SIGNAL}.
	 */
	public int getSignalId() {
		return super.signalId;
	}











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("CPToneGenSitSignal:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.CPToneGenPkg.CPToneGenSitSignal o = (javax.megaco.pkg.CPToneGenPkg.CPToneGenSitSignal)oo;
if (!super.equals(o)) return false;

return true;
}

}


















