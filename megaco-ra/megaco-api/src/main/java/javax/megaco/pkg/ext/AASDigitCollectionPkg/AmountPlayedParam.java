package javax.megaco.pkg.ext.AASDigitCollectionPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//The length played of the initial prompt, if that prompt was interrupted (i.e., by 
@Generated({"warren crossing"})
public class AmountPlayedParam extends PkgItemParam {
	public static final int AMOUNT_PLAYED = 0x0003;
	public static final String TOKEN = "ap";

	protected int[] paramsItemIds = null;

	public AmountPlayedParam() {
		super();
		super.paramId = AMOUNT_PLAYED; //ap
		super.itemValueType = ParamValueType.M_INTEGER; //M_INTEGER
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
bob.append("AmountPlayedParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
