package javax.megaco.pkg.ext.AASDigitCollectionPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Specifies how recognized digits are played back to the user in case of voice 
@Generated({"warren crossing"})
public class VoiceBackParam extends PkgItemParam {
	public static final int VOICEBACK = 0x0016;
	public static final String TOKEN = "vc";

	protected int[] paramsItemIds = null;

	public VoiceBackParam() {
		super();
		super.paramId = VOICEBACK; //vc
		super.itemValueType = ParamValueType.M_STRING; //M_STRING
		super.paramsDescriptorIds = new int[] {};
        super.packageId = AASDigitCollectionPkg.PACKAGE_INSTANCE;
 //0x0034		this.paramsItemIds = new int[] {}; 
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
bob.append("VoiceBackParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
