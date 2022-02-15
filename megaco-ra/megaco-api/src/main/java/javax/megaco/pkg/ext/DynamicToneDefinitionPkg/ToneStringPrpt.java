package javax.megaco.pkg.ext.DynamicToneDefinitionPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgPrptyItem;
import javax.annotation.Generated;

//Tone description string. See procedures ,
@Generated({"warren crossing"})
public final class ToneStringPrpt extends PkgPrptyItem {

	public static final int TONE_STRING = 0x0002;
	public static final String TOKEN = "tst";

	protected int[] itemsDescriptorIds = null;

	public ToneStringPrpt() {
		super();
		super.itemId = TONE_STRING;
		super.propertyId = 0x0002; //tst
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
bob.append("ToneStringPrpt:");
bob.append(super.toString());

if (itemsDescriptorIds !=null && itemsDescriptorIds.length > 0) { bob.append("itemsDescriptorIds=["); 
 for(int i = 0 ; i < itemsDescriptorIds.length; i ++ )
bob.append(itemsDescriptorIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}


}
