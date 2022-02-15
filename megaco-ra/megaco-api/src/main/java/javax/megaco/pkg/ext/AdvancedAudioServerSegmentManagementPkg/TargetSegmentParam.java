package javax.megaco.pkg.ext.AdvancedAudioServerSegmentManagementPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Identifies the segment from which any overlay is to be removed. 
@Generated({"warren crossing"})
public class TargetSegmentParam extends PkgItemParam {
	public static final int TARGET_SEGMENT = 0x0001;
	public static final String TOKEN = "tgtsid";

	protected int[] paramsItemIds = null;

	public TargetSegmentParam() {
		super();
		super.paramId = TARGET_SEGMENT; //tgtsid
		super.itemValueType = ParamValueType.M_STRING; //M_STRING
		super.paramsDescriptorIds = new int[] {};
        super.packageId = AdvancedAudioServerSegmentManagementPkg.PACKAGE_INSTANCE;
 //0x0036		this.paramsItemIds = new int[] {}; 
	}

	public int getParamId() {

		return super.paramId;
	}

	public int getParamValueType() {

		return super.itemValueType;
	}

	public int[] getParamsItemIds() {
		return this.paramsItemIds;
	}

	public int[] getParamsDescriptorIds() {
		return super.paramsDescriptorIds;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("TargetSegmentParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
