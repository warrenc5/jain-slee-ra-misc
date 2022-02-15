package javax.megaco.pkg.TDMCktPkg;

import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgPrptyItem;

/**
 * The MEGACO Echo Cancellation property class extends the PkgPrptyItem class.
 * This is a final class. This class defines Echo Cancellation property of
 * MEGACO TDM Circuit package. The methods shall define that this property item
 * belongs to the TDM Circuit package.
 */
public class TDMCktEcPrpt extends PkgPrptyItem {

	/**
	 * Identifies Echo cancellation property of the MEGACO TDM Circuit Package. Its value shall be set equal to 0x0008.
	 */
	public static final int TDMC_EC_PRPT = 0x0008;

     
	
	/**
	 * Constructs a Jain MEGACO Object representing property Item of the MEGACO
	 * Package for property Echo Cancellation and Package as TDM Circuit.
	 */
	public TDMCktEcPrpt() {
		super();
        super.packageId = TDMCktPkg.PACKAGE_INSTANCE;
		super.itemId = TDMC_EC_PRPT;
		super.propertyId = TDMC_EC_PRPT;
		super.itemValueType = ParamValueType.M_BOOLEAN;
		
	}

	@Override
	public int getItemId() {
		return itemId;
	}

	@Override
	public int getItemValueType() {
		return itemValueType;
	}

	@Override
	public int getPropertyId() {
		return propertyId;
	}











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("TDMCktEcPrpt:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.TDMCktPkg.TDMCktEcPrpt o = (javax.megaco.pkg.TDMCktPkg.TDMCktEcPrpt)oo;
if (!super.equals(o)) return false;

return true;
}

}


















