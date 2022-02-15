package javax.megaco.pkg.ext.DynamicToneDefinitionPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgPrptyItem;
import javax.annotation.Generated;

//
@Generated({"warren crossing"})
public final class ToneIDPrpt extends PkgPrptyItem {

	public static final int TONE_ID = 0x0001;
	public static final String TOKEN = "tid";

	protected int[] itemsDescriptorIds = null;

	public ToneIDPrpt() {
		super();
		super.itemId = TONE_ID;
		super.propertyId = 0x0001; //tid
        super.packageId = DynamicToneDefinitionPkg.PACKAGE_INSTANCE;
 //0x001c		super.itemValueType = ParamValueType.M_STRING;
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
bob.append("ToneIDPrpt:");
bob.append(super.toString());

if (itemsDescriptorIds !=null && itemsDescriptorIds.length > 0) { bob.append("itemsDescriptorIds=["); 
 for(int i = 0 ; i < itemsDescriptorIds.length; i ++ )
bob.append(itemsDescriptorIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}


}
