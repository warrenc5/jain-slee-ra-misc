package javax.megaco.pkg.CPToneDetPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;

/**
 * The MEGACO Congestion Tone event class extends the PkgEventItem class. This
 * is a final class. This class defines Congestion Tone event of MEGACO Call
 * Progress Tone Detect package. The methods shall define that this event item
 * belongs to the Call Progress Tone Detect package.
 */
public final class CPToneDetCtEvt extends PkgEventItem {

	/**
	 * Identifies Congestion Tone event of the MEGACO Call Progress Tone Detect
	 * Package. Its value shall be set equal to 0x0033.
	 */
	public static final int CP_TONE_DET_CT_EVENT = 0x0033;


	/**
	 * Constructs a Jain MEGACO Object representing event Item of the MEGACO
	 * Package for event Congestion Tone and Package as Call Progress Tone
	 * Detect.
	 */
	public CPToneDetCtEvt() {
		super();
	super.packageId = CPToneDetPkg.PACKAGE_INSTANCE;
		super.itemId = CP_TONE_DET_CT_EVENT;
		super.eventId = CP_TONE_DET_CT_EVENT;
	}

	/**
	 * This method is used to get the event identifier from an Event Item
	 * object. The implementations of this method in this class returns the id
	 * of the Congestion Tone event of Call Progress Tone Detect Package.
	 * 
	 * @return It shall return {@link CP_TONE_DET_CT_EVENT}.
	 */
	public int getEventId() {

		return super.eventId;
	}

	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the
	 * Congestion Tone event of Call Progress Tone Detect Package.
	 * 
	 * @return It shall return {@link CP_TONE_DET_CT_EVENT}.
	 */
	public int getItemId() {

		return super.itemId;
	}










public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("CPToneDetCtEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.CPToneDetPkg.CPToneDetCtEvt o = (javax.megaco.pkg.CPToneDetPkg.CPToneDetCtEvt)oo;
if (!super.equals(o)) return false;

return true;
}

}


















