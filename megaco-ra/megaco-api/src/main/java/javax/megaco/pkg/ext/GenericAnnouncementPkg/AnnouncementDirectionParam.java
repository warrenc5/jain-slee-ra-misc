package javax.megaco.pkg.ext.GenericAnnouncementPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Initiates the play of a variable announcement 
@Generated({"warren crossing"})
public class AnnouncementDirectionParam extends PkgItemParam {
	public static final int ANNOUNCEMENT_DIRECTION = 0x0007;
	public static final String TOKEN = "di";

	protected int[] paramsItemIds = null;

	public AnnouncementDirectionParam() {
		super();
		super.paramId = ANNOUNCEMENT_DIRECTION; //di
		super.itemValueType = ParamValueType.M_STRING;
		super.paramsDescriptorIds = new int[] {};
        super.packageId = GenericAnnouncementPkg.PACKAGE_INSTANCE;
 //0x001d		this.paramsItemIds = new int[] {}; 
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
}

