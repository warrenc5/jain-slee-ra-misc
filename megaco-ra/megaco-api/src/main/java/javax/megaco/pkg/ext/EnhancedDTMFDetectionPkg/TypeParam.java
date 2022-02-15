package javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Indicates whether DTMF digits were detected during a prompt phase (i.e., 
@Generated({"warren crossing"})
public class TypeParam extends PkgItemParam {
	public static final int TYPE = 0x0003;
	public static final String TOKEN = "type";

	protected int[] paramsItemIds = null;

	public TypeParam() {
		super();
		super.paramId = TYPE; //type
		super.itemValueType = ParamValueType.M_STRING; //M_STRING
		super.paramsDescriptorIds = new int[] {};
        super.packageId = EnhancedDTMFDetectionPkg.PACKAGE_INSTANCE;
 //0x0100		this.paramsItemIds = new int[] {}; 
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
bob.append("TypeParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
