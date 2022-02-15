package javax.megaco.pkg.ext.AdvancedAudioServerBaseEnhancementPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Text to be played. Consists of one or more text Segment Identifier(s). The 
@Generated({"warren crossing"})
public class AnnouncementParam extends PkgItemParam {
	public static final int ANNOUNCEMENT = 0x0001;
	public static final String TOKEN = "an";

	protected int[] paramsItemIds = null;

	public AnnouncementParam() {
		super();
		super.paramId = ANNOUNCEMENT; //an
		super.itemValueType = ParamValueType.M_STRING; //M_STRING
		super.paramsDescriptorIds = new int[] {};
        super.packageId = AdvancedAudioServerBaseEnhancementPkg.PACKAGE_INSTANCE;
 //0x00a8		this.paramsItemIds = new int[] {}; 
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
bob.append("AnnouncementParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
