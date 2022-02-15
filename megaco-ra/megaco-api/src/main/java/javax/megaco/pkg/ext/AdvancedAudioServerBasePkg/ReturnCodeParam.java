package javax.megaco.pkg.ext.AdvancedAudioServerBasePkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//A return code indicating why an advanced audio server operation failed. 
@Generated({"warren crossing"})
public class ReturnCodeParam extends PkgItemParam {
	public static final int RETURN_CODE = 0x0001;
	public static final String TOKEN = "rc";

	protected int[] paramsItemIds = null;

	public ReturnCodeParam() {
		super();
		super.paramId = RETURN_CODE; //rc
		super.itemValueType = ParamValueType.M_INTEGER; //M_INTEGER
		super.paramsDescriptorIds = new int[] {};
        super.packageId = AdvancedAudioServerBasePkg.PACKAGE_INSTANCE;
 //0x0033		this.paramsItemIds = new int[] {}; 
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
bob.append("ReturnCodeParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
