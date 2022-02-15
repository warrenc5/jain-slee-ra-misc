package javax.megaco.pkg.ext.MultimediaPlayPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//The relative playback contrast of video in multimedia, specifiable as a positive 
@Generated({"warren crossing"})
public class ContrastParam extends PkgItemParam {
	public static final int CONTRAST = 0x0008;
	public static final String TOKEN = "ctn";

	protected int[] paramsItemIds = null;

	public ContrastParam() {
		super();
		super.paramId = CONTRAST; //ctn
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
bob.append("ContrastParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
