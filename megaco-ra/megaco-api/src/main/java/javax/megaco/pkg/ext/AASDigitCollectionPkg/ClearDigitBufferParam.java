package javax.megaco.pkg.ext.AASDigitCollectionPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//If set to TRUE, the MG clears the digit collection buffer before playing any 
@Generated({"warren crossing"})
public class ClearDigitBufferParam extends PkgItemParam {
	public static final int CLEARDIGITBUFFER = 0x0008;
	public static final String TOKEN = "cb";

	protected int[] paramsItemIds = null;

	public ClearDigitBufferParam() {
		super();
		super.paramId = CLEARDIGITBUFFER; //cb
		super.itemValueType = ParamValueType.M_BOOLEAN; //M_BOOLEAN
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
bob.append("ClearDigitBufferParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
