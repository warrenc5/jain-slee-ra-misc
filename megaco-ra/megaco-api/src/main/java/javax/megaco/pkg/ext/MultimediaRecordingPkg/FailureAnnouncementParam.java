package javax.megaco.pkg.ext.MultimediaRecordingPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Played when all recording attempts have failed. Consists of one or more 
@Generated({"warren crossing"})
public class FailureAnnouncementParam extends PkgItemParam {
	public static final int FAILUREANNOUNCEMENT = 0x0004;
	public static final String TOKEN = "fa";

	protected int[] paramsItemIds = null;

	public FailureAnnouncementParam() {
		super();
		super.paramId = FAILUREANNOUNCEMENT; //fa
		super.itemValueType = ParamValueType.M_STRING; //M_STRING
		super.paramsDescriptorIds = new int[] {};
        super.packageId = MultimediaRecordingPkg.PACKAGE_INSTANCE;
 //0x00b3		this.paramsItemIds = new int[] {}; 
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
bob.append("FailureAnnouncementParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
