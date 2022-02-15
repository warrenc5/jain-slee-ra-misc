package javax.megaco.pkg.ext.AASDigitCollectionPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Indicates which DTMF digits map to an external key operation. Its function on 
@Generated({"warren crossing"})
public class ExternalControlKeyParam extends PkgItemParam {
	public static final int EXTERNAL_CONTROL_KEY = 0x0028;
	public static final String TOKEN = "extkey";

	protected int[] paramsItemIds = null;

	public ExternalControlKeyParam() {
		super();
		super.paramId = EXTERNAL_CONTROL_KEY; //extkey
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
bob.append("ExternalControlKeyParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
