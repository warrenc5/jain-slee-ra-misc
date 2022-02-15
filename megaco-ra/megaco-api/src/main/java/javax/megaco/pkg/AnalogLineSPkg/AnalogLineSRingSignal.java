package javax.megaco.pkg.AnalogLineSPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;

public final class AnalogLineSRingSignal extends PkgSignalItem {

	public static final int ANALOG_LINE_S_RING_SIGNAL = 0x002;

	public AnalogLineSRingSignal() {
		super();
		super.signalId = ANALOG_LINE_S_RING_SIGNAL;
		super.itemId = ANALOG_LINE_S_RING_SIGNAL;
        super.packageId = AnalogLineSPkg.PACKAGE_INSTANCE;
	}

	public int getItemId() {
		return super.itemId;
	}

	/**
	 * This method is used to get the signal identifier from an Signal Item
	 * object. The implementations of this method in this class returns the id
	 * of the Warning Tone signal of Call Progress Tone Generator Package.
	 * 
	 * @return It shall return {@link CPTONE_GEN_WT_SIGNAL}.
	 */
	public int getSignalId() {
		return super.signalId;
	}










public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AnalogLineSRingSignal:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.AnalogLineSPkg.AnalogLineSRingSignal o = (javax.megaco.pkg.AnalogLineSPkg.AnalogLineSRingSignal)oo;
if (!super.equals(o)) return false;

return true;
}

}


















