package javax.megaco.pkg.DTMFDetPkg;

import javax.megaco.pkg.PkgEventItem;

/**
 * The MEGACO Digitmap Completion event class extends the PkgEventItem class.
 * This is a final class. This class defines Digitmap Completion event of MEGACO
 * DTMF Detection package. The methods shall define that this event item belongs
 * to the DTMF Detection package.
 */
public final class DTMFDetCeEvt extends PkgEventItem {

	/**
	 * Identifies Digitmap Completion Event of the MEGACO DTMF Detection
	 * Package. Its value shall be set equal to 0x0001.
	 */
	public static final int DTMF_DET_CE_EVENT = 0x0001;


	public DTMFDetCeEvt() {
		super();
	super.packageId = DTMFDetPkg.PACKAGE_INSTANCE;
		super.itemId = DTMF_DET_CE_EVENT;
		super.eventId = DTMF_DET_CE_EVENT;
	}

	/**
	 * This method is used to get the event identifier from an Event Item
	 * object. The implementations of this method in this class returns the id
	 * of the Completion event of DTMF Detect Package.
	 * 
	 * @return It shall return {@link DTMF_DET_CE_EVENT}.
	 */
	public int getEventId() {

		return super.eventId;
	}

	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the
	 * Completion event of DTMF Detect Package.
	 * 
	 * @return It shall return {@link DTMF_DET_CE_EVENT}.
	 */
	public int getItemId() {

		return super.itemId;
	}

	/**
	 * This method gets the package to which the item belongs. Since the
	 * Completion event is defined in the DTMF Detect Package of MEGACO
	 * protocol, this method returns the DTMFDetPkg class object.
	 * 
	 * @return
	 */











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DTMFDetCeEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.DTMFDetPkg.DTMFDetCeEvt o = (javax.megaco.pkg.DTMFDetPkg.DTMFDetCeEvt)oo;
if (!super.equals(o)) return false;

return true;
}

}


















