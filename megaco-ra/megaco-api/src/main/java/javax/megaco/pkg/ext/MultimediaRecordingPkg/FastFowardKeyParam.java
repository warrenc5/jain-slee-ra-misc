package javax.megaco.pkg.ext.MultimediaRecordingPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Indicates which DTMF digits maps to a fast forward operation. On detection of 
@Generated({"warren crossing"})
public class FastFowardKeyParam extends PkgItemParam {
	public static final int FAST_FOWARD_KEY = 0x0015;
	public static final String TOKEN = "ffk";

	protected int[] paramsItemIds = null;

	public FastFowardKeyParam() {
		super();
		super.paramId = FAST_FOWARD_KEY; //ffk
		super.itemValueType = ParamValueType.M_STRING; //M_STRING
		super.paramsDescriptorIds = new int[] {};
        super.packageId = MultimediaRecordingPkg.PACKAGE_INSTANCE;
 //0x00b3		this.paramsItemIds = new int[] {}; 
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
bob.append("FastFowardKeyParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
