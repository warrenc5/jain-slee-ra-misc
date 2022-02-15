package javax.megaco.pkg.ext.ASRPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Defines the maximum time to wait for recognition of speech, specified in units 
@Generated({"warren crossing"})
public class MaximumRecognitionTimeParam extends PkgItemParam {
	public static final int MAXIMUM_RECOGNITION_TIME = 0x0007;
	public static final String TOKEN = "mrt";

	protected int[] paramsItemIds = null;

	public MaximumRecognitionTimeParam() {
		super();
		super.paramId = MAXIMUM_RECOGNITION_TIME; //mrt
		super.itemValueType = ParamValueType.M_INTEGER; //M_INTEGER
		super.paramsDescriptorIds = new int[] {};
        super.packageId = ASRPkg.PACKAGE_INSTANCE;
 //0x00a6		this.paramsItemIds = new int[] {}; 
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
bob.append("MaximumRecognitionTimeParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
