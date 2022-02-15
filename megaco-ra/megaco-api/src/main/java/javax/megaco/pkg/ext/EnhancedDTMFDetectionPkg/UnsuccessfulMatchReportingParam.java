package javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//The MGC may use this parameter to control whether the DigitMap Completion 
@Generated({"warren crossing"})
public class UnsuccessfulMatchReportingParam extends PkgItemParam {
	public static final int UNSUCCESSFUL_MATCH_REPORTING = 0x0001;
	public static final String TOKEN = "umr";

	protected int[] paramsItemIds = null;

	public UnsuccessfulMatchReportingParam() {
		super();
		super.paramId = UNSUCCESSFUL_MATCH_REPORTING; //umr
		super.itemValueType = ParamValueType.M_BOOLEAN; //M_BOOLEAN
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
bob.append("UnsuccessfulMatchReportingParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
