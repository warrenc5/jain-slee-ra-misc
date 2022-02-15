package javax.megaco.pkg.ext.AdvancedAudioServerBasePkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//The relative playback speed of announcement specifiable as a positive (faster) 
@Generated({"warren crossing"})
public class SpeedParam extends PkgItemParam {
	public static final int SPEED = 0x0004;
	public static final String TOKEN = "sp";

	protected int[] paramsItemIds = null;

	public SpeedParam() {
		super();
		super.paramId = SPEED; //sp
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
bob.append("SpeedParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
