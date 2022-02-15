package javax.megaco.pkg.ext.MultimediaPlayPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//The relative playback brightness of video in multimedia, specifiable as a 
@Generated({"warren crossing"})
public class BrightnessParam extends PkgItemParam {
	public static final int BRIGHTNESS = 0x0007;
	public static final String TOKEN = "btn";

	protected int[] paramsItemIds = null;

	public BrightnessParam() {
		super();
		super.paramId = BRIGHTNESS; //btn
		super.itemValueType = ParamValueType.M_INTEGER; //M_INTEGER
		super.paramsDescriptorIds = new int[] {};
        super.packageId = MultimediaPlayPkg.PACKAGE_INSTANCE;
 //0x00a9		this.paramsItemIds = new int[] {}; 
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
bob.append("BrightnessParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
