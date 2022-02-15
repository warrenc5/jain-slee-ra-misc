package javax.megaco.pkg.ext.MultimediaPlayPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//The direction parameter can be used to indicate the direction that the 
@Generated({"warren crossing"})
public class AnnouncementDirectionParam extends PkgItemParam {
	public static final int ANNOUNCEMENT_DIRECTION = 0x0006;
	public static final String TOKEN = "di";

	protected int[] paramsItemIds = null;

	public AnnouncementDirectionParam() {
		super();
		super.paramId = ANNOUNCEMENT_DIRECTION; //di
		super.itemValueType = ParamValueType.M_STRING; //M_STRING
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
bob.append("AnnouncementDirectionParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
