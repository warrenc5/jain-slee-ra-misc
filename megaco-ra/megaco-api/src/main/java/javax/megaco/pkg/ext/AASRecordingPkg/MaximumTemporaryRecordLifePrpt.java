package javax.megaco.pkg.ext.AASRecordingPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgPrptyItem;
import javax.annotation.Generated;

//Determines the maximum life of a temporary recording, in seconds, following
@Generated({"warren crossing"})
public final class MaximumTemporaryRecordLifePrpt extends PkgPrptyItem {

	public static final int MAXIMUM_TEMPORARY_RECORD_LIFE = 0x0003;
	public static final String TOKEN = "maxtrl";

	protected int[] itemsDescriptorIds = null;

	public MaximumTemporaryRecordLifePrpt() {
		super();
		super.itemId = MAXIMUM_TEMPORARY_RECORD_LIFE;
		super.propertyId = 0x0003; //maxtrl
        super.packageId = AASRecordingPkg.PACKAGE_INSTANCE;
 //0x0035		super.itemValueType = ParamValueType.M_INTEGER;
		itemsDescriptorIds = new int[] {};
	}

	public int getItemId() {
		return super.itemId;
	}

	public int getItemValueType() {
		return itemValueType;
	}

	public int getPropertyId() {
		return super.propertyId;
	}

	public int[] getItemsDescriptorIds() {
		return this.itemsDescriptorIds;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("MaximumTemporaryRecordLifePrpt:");
bob.append(super.toString());

if (itemsDescriptorIds !=null && itemsDescriptorIds.length > 0) { bob.append("itemsDescriptorIds=["); 
 for(int i = 0 ; i < itemsDescriptorIds.length; i ++ )
bob.append(itemsDescriptorIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}


}
