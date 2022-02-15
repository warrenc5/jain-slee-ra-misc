package javax.megaco.pkg.ext.EnhancedDTMFDetectionPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Indicates the reason for the generation of the event. See the procedures 
@Generated({"warren crossing"})
public class TerminationMethodParam extends PkgItemParam {
	public static final int TERMINATION_METHOD = 0x0002;
	public static final String TOKEN = "Meth";

	protected int[] paramsItemIds = null;

	public TerminationMethodParam() {
		super();
		super.paramId = TERMINATION_METHOD; //Meth
		super.itemValueType = ParamValueType.M_STRING; //M_STRING
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
bob.append("TerminationMethodParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
