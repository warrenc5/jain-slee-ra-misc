package javax.megaco.pkg.ext.AASRecordingPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Indicates which DTMF digits map to a speed down operation. On detection of 
@Generated({"warren crossing"})
public class SpeedDownKeyParam extends PkgItemParam {
	public static final int SPEED_DOWN_KEY = 0x001c;
	public static final String TOKEN = "spddwn";

	protected int[] paramsItemIds = null;

	public SpeedDownKeyParam() {
		super();
		super.paramId = SPEED_DOWN_KEY; //spddwn
		super.itemValueType = ParamValueType.M_STRING; //M_STRING
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
bob.append("SpeedDownKeyParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
