package javax.megaco.pkg.ext.AASRecordingPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//The maximum number of prompts the user is given to speak. Prompts resulting 
@Generated({"warren crossing"})
public class MaxAttemptsParam extends PkgItemParam {
	public static final int MAXATTEMPTS = 0x0005;
	public static final String TOKEN = "mxatt";

	protected int[] paramsItemIds = null;

	public MaxAttemptsParam() {
		super();
		super.paramId = MAXATTEMPTS; //mxatt
		super.itemValueType = ParamValueType.M_INTEGER; //M_INTEGER
		super.paramsDescriptorIds = new int[] {};
        super.packageId = AASRecordingPkg.PACKAGE_INSTANCE;
 //0x0035		this.paramsItemIds = new int[] {}; 
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
bob.append("MaxAttemptsParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
