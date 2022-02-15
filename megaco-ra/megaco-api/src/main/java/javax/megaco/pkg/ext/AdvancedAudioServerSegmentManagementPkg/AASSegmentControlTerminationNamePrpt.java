package javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgPrptyItem;
import javax.annotation.Generated;

//Name of the AAS Segment Control Termination, if any, supported by the MG.
@Generated({"warren crossing"})
public final class AASSegmentControlTerminationNamePrpt extends PkgPrptyItem {

	public static final int AAS_SEGMENT_CONTROL_TERMINATION_NAME = 0x0001;
	public static final String TOKEN = "ctlnam";

	protected int[] itemsDescriptorIds = null;

	public AASSegmentControlTerminationNamePrpt() {
		super();
		super.itemId = AAS_SEGMENT_CONTROL_TERMINATION_NAME;
		super.propertyId = 0x0001; //ctlnam
        super.packageId = AdvancedAudioServerSegmentManagementPkg.PACKAGE_INSTANCE;
 //0x0036		super.itemValueType = ParamValueType.M_INTEGER;
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
bob.append("AASSegmentControlTerminationNamePrpt:");
bob.append(super.toString());

if (itemsDescriptorIds !=null && itemsDescriptorIds.length > 0) { bob.append("itemsDescriptorIds=["); 
 for(int i = 0 ; i < itemsDescriptorIds.length; i ++ )
bob.append(itemsDescriptorIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}


}
