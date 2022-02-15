package javax.megaco.pkg.CPToneGenPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.megaco.pkg.DTMFGenPkg.DTMFGenPkg;

/**
 * The MEGACO Congestion Tone signal class extends the PkgSignalItem class. This
 * is a final class. This class defines Congestion Tone signal of MEGACO Call
 * Progress Tone Generator package. The methods shall define that this signal
 * item belongs to the Call Progress Tone Generator package.
 */
public final class CPToneGenCtSignal extends PkgSignalItem {

	/**
	 * Identifies Congestion tone signal of the MEGACO Call Progress Tone
	 * Generator Package. Its value shall be set equal to 0x0033.
	 */
	public static final int CP_TONE_GEN_CT_SIGNAL = 0x0033;

	

	/**
	 * This method is used to get the signal identifier from an Signal Item
	 * object. The implementations of this method in this class returns the id
	 * of the Congestion Tone signal of Call Progress Tone Generator Package.
	 */
	public CPToneGenCtSignal() {
		super();
    super.packageId = CPToneGenPkg.PACKAGE_INSTANCE;
		super.signalId = CP_TONE_GEN_CT_SIGNAL;
		super.itemId = CP_TONE_GEN_CT_SIGNAL;
	}

	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the
	 * Congestion Tone signal of Call Progress Tone Generator Package.
	 * 
	 * @return It shall return {@link CP_TONE_GEN_CT_SIGNAL}.
	 */
	public int getItemId() {

		return super.itemId;
	}

	/**
	 * This method is used to get the signal identifier from an Signal Item
	 * object. The implementations of this method in this class returns the id
	 * of the Congestion Tone signal of Call Progress Tone Generator Package.
	 * 
	 * @return It shall return {@link CP_TONE_GEN_CT_SIGNAL}.
	 */
	public int getSignalId() {
		return super.signalId;
	}











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("CPToneGenCtSignal:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.CPToneGenPkg.CPToneGenCtSignal o = (javax.megaco.pkg.CPToneGenPkg.CPToneGenCtSignal)oo;
if (!super.equals(o)) return false;

return true;
}

}


















