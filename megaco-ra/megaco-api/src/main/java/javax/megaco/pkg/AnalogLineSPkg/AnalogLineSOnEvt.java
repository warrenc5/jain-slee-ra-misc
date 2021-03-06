package javax.megaco.pkg.AnalogLineSPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;

/**
 * The MEGACO On Hook event class extends the PkgEventItem class. This is a
 * final class. This class defines On Hook event of Analog Line Supervision
 * package. The methods shall define that this event item belongs to the Analog
 * Line Supervision package.
 */
public final class AnalogLineSOnEvt extends PkgEventItem {
	/**
	 * Identifies On Hook event of the MEGACO Analog Line Supervision Package.
	 * Its value shall be set equal to 0x0004.
	 */
	public static final int ANALOG_LINE_ONHOOK_EVENT = 0x0004;

	/**
	 * Constructs a Jain MEGACO Object representing event Item of the MEGACO
	 * Package for event OnHook and package as Analog Line Supervision.
	 */
	public AnalogLineSOnEvt() {
		super();
		super.itemId = ANALOG_LINE_ONHOOK_EVENT;
		super.eventId = ANALOG_LINE_ONHOOK_EVENT;
		super.packageId = AnalogLineSPkg.PACKAGE_INSTANCE;

	}

	/**
	 * This method is used to get the event identifier from an Event Item
	 * object. The implementations of this method in this class returns the id
	 * of the On Hook event of Analog Line Supervision Package.
	 * 
	 * @return It shall {@link ANALOG_LINE_ONHOOK_EVENT}.
	 */
	public int getEventId() {

		return super.itemId;
	}

	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the On
	 * Hook event of Analog Line Supervision Package.
	 * 
	 * @return It shall return {@link ANALOG_LINE_ONHOOK_EVENT}.
	 */
	public int getItemId() {

		return super.itemId;
	}

	/**
	 * This method gets the package to which the item belongs. Since the On Hook
	 * event is defined in the Analog Line Supervision Package of MEGACO
	 * protocol, this method returns the AnalogLineSPkg class object.
	 * 
	 * @return The package is {@link AnalogLineSPkg}.
	 */
	public MegacoPkg getItemsPkgId() {
		return super.packageId;
	}










public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AnalogLineSOnEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOnEvt o = (javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOnEvt)oo;
if (!super.equals(o)) return false;

return true;
}

}


















