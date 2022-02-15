package javax.megaco.pkg.ext.MultimediaPlayPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//The absolute playback volume of announcement specified in decibels. The 
@Generated({"warren crossing"})
public class AbsoluteVolumeParam extends PkgItemParam {
	public static final int ABSOLUTE_VOLUME = 0x000a;
	public static final String TOKEN = "absvl";

	protected int[] paramsItemIds = null;

	public AbsoluteVolumeParam() {
		super();
		super.paramId = ABSOLUTE_VOLUME; //absvl
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
bob.append("AbsoluteVolumeParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
