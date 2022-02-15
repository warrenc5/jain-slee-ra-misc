package javax.megaco.pkg.ContinuityPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgEventItem;

/**
 * The MEGACO Completion event class extends the PkgEventItem class. This is a
 * final class. This class defines Completion event of MEGACO Continuity
 * package. The methods shall define that this event item belongs to the
 * Continuity package.
 */
public final class ContComplEvt extends PkgEventItem {

	/**
	 * Identifies Completion event of the MEGACO Continuity Package. Its value
	 * shall be set equal to 0x0005.
	 */
	public static final int CONT_COMPL_EVENT = 0x0005;


	/**
	 * Constructs a Jain MEGACO Object representing event item of the MEGACO
	 * Package for Event Completion and Package as Continuity.
	 */
	public ContComplEvt() {
		super();
	super.packageId = ContinuityPkg.PACKAGE_INSTANCE;
		super.itemId = CONT_COMPL_EVENT;
		super.eventId = CONT_COMPL_EVENT;
	}

	/**
	 * This method is used to get the event identifier from an Event Item
	 * object. The implementations of this method in this class returns the id
	 * of the Completion event of Continuity Package.
	 * 
	 * @return It shall return {@link CONT_COMPL_EVENT}.
	 */
	public int getEventId() {

		return super.eventId;
	}

	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the
	 * Completion event of Continuity Package.
	 * 
	 * @return It shall return {@link CONT_COMPL_EVENT}.
	 */
	public int getItemId() {

		return super.itemId;
	}










public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ContComplEvt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.ContinuityPkg.ContComplEvt o = (javax.megaco.pkg.ContinuityPkg.ContComplEvt)oo;
if (!super.equals(o)) return false;

return true;
}

}


















