package javax.megaco.pkg.BaseRootPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgPrptyItem;

/**
 * The MEGACO MaxTermsPerCtxt property class extends the PkgPrptyItem class.
 * This is a final class. This class defines MaxTermsPerCtxt property of MEGACO
 * Root package. The methods shall define that this property item belongs to the
 * Root package.
 */
public final class RootMaxTermsPerCtxtPrpt extends PkgPrptyItem {

	/**
	 * Identifies MaxTermsPerCtxt property of the MEGACO Base Root Package. Its
	 * value shall be set equal to 0x0002.
	 */
	public static final int ROOT_MAX_TERMS_PER_CTXT_PRPT = 0x0002;

	protected int[] itemsDescriptorIds = null;

	public RootMaxTermsPerCtxtPrpt() {
		super();
		super.propertyId = ROOT_MAX_TERMS_PER_CTXT_PRPT;
		super.itemId = ROOT_MAX_TERMS_PER_CTXT_PRPT;
		super.packageId = BaseRootPkg.PACKAGE_INSTANCE;
		super.itemValueType = ParamValueType.M_INTEGER;
		this.itemsDescriptorIds = new int[] { DescriptorType.M_TERMINATION_STATE_DESC };
	}

	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the
	 * Maximum Terminations per Context property of ROOT Package.
	 * 
	 * @return It shall return {@link ROOT_MAX_TERMS_PER_CTXT_PRPT}
	 */
	public int getItemId() {
		return super.itemId;
	}

	/**
	 * The method can be used to get the type of the value as defined in the
	 * MEGACO packages. These could be one of string or enumerated value or
	 * integer or double value or boolean.
	 * 
	 * @return It returns {@link INTEGER} indicating that the
	 *         parameter is a double.
	 */
	public int getItemValueType() {

		return super.itemValueType;
	}

	/**
	 * This method is used to get the property identifier from an Property Item
	 * object. The implementations of this method in this class returns the id
	 * of the Maximum Termination per Context property of ROOT Package.
	 * 
	 * @return It shall return {@link ROOT_MAX_TERMS_PER_CTXT_PRPT}
	 */
	public int getPropertyId() {

		return super.propertyId;
	}

	/**
	 * The method can be used to get the descriptor ids corresponding to the
	 * parameters to which the parameter can be set.
	 * 
	 * @return This parameter can be present in Event descriptor. It shall thus
	 *         return a value {@link M_TERMINATION_STATE_DESC} as a part of
	 *         integer vector.
	 */
	public int[] getItemsDescriptorIds() {
		return itemsDescriptorIds;
	}











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("RootMaxTermsPerCtxtPrpt:");
bob.append(super.toString());

if (itemsDescriptorIds !=null && itemsDescriptorIds.length > 0) { bob.append("itemsDescriptorIds=["); 
 for(int i = 0 ; i < itemsDescriptorIds.length; i ++ )
bob.append(itemsDescriptorIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.BaseRootPkg.RootMaxTermsPerCtxtPrpt o = (javax.megaco.pkg.BaseRootPkg.RootMaxTermsPerCtxtPrpt)oo;
if (!super.equals(o)) return false;
if((itemsDescriptorIds !=null && o.itemsDescriptorIds == null) ||(itemsDescriptorIds == null && o.itemsDescriptorIds != null) ) return false;
if (itemsDescriptorIds ==null && o.itemsDescriptorIds == null) return true; else if (itemsDescriptorIds.length != o.itemsDescriptorIds.length) return false;
if (itemsDescriptorIds.length == o.itemsDescriptorIds.length) for(int i = 0 ; i < itemsDescriptorIds.length; i ++ )
if (itemsDescriptorIds[i] != o.itemsDescriptorIds[i]) return false;

return true;
}

}


















