package javax.megaco.pkg.ext.AASDigitCollectionPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Indicates for how long the playout of a message is paused when a pause key is 
@Generated({"warren crossing"})
public class PauseIntervalParam extends PkgItemParam {
	public static final int PAUSE_INTERVAL = 0x0023;
	public static final String TOKEN = "pseint";

	protected int[] paramsItemIds = null;

	public PauseIntervalParam() {
		super();
		super.paramId = PAUSE_INTERVAL; //pseint
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
bob.append("PauseIntervalParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
