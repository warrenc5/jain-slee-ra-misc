package javax.megaco.pkg.RTPPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;

/**
 * The MEGACO Payload Transition event class extends the PkgEventItem class.
 * This is a final class. This class defines Payload Transition event of MEGACO
 * RTP package. The methods shall define that this event item belongs to the RTP
 * package.
 */
public class RTPPltransEvt extends PkgEventItem {

	/**
	 * Identifies Payload Transition event of the MEGACO RTP Package. Its value
	 * shall be set equal to 0x0001.
	 */
	public static final int RTP_PLTRANS_EVENT = 0x0001;

	/**
	 * Constructs a Jain MEGACO Object representing event Item of the MEGACO
	 * Package for event Payload Transition and package as RTP.
	 */
	public RTPPltransEvt() {
		super();
		super.eventId = RTP_PLTRANS_EVENT;
		super.itemId = RTP_PLTRANS_EVENT;
		super.packageId = RTPPkg.PACKAGE_INSTANCE;
	}

	/**
	 * This method is used to get the event identifier from an Event Item
	 * object. The implementations of this method in this class returns the id
	 * of the Payload Transition event of RTP Package.
	 * 
	 * @return It shall return {@link RTP_PLTRANS_EVENT}.
	 */
	public int getEventId() {
		return super.eventId;
	}

	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the
	 * Payload Transition event of RTP Package.
	 * 
	 * @return It shall return {@link RTP_PLTRANS_EVENT}.
	 */
	public int getItemId() {
		return super.itemId;
	}

	/**
	 * This method gets the package id to which the item belongs. Since the
	 * Payload Transition event is defined in the RTP Package of MEGACO
	 * protocol, this method returns the RTPPkg class object.
	 * 
	 * @return The package is RTPPkg.
	 */
	public MegacoPkg getItemsPkgId() {

		return super.getItemsPkgId();
	}











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("RTPPltransEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.RTPPkg.RTPPltransEvt o = (javax.megaco.pkg.RTPPkg.RTPPltransEvt)oo;
if (!super.equals(o)) return false;

return true;
}

}


















