package javax.megaco.pkg.ext.ASRPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//To filter out background noise so that it is not mistaken for speech, the 
@Generated({"warren crossing"})
public class RecognitionSensitivityParam extends PkgItemParam {
	public static final int RECOGNITION_SENSITIVITY = 0x000a;
	public static final String TOKEN = "rs";

	protected int[] paramsItemIds = null;

	public RecognitionSensitivityParam() {
		super();
		super.paramId = RECOGNITION_SENSITIVITY; //rs
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
bob.append("RecognitionSensitivityParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
