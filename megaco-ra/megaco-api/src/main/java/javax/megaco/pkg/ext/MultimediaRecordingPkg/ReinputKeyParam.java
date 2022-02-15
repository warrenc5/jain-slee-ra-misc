package javax.megaco.pkg.ext.MultimediaRecordingPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Defines a key sequence consisting of a command key optionally followed by 
@Generated({"warren crossing"})
public class ReinputKeyParam extends PkgItemParam {
	public static final int REINPUTKEY = 0x000e;
	public static final String TOKEN = "rik";

	protected int[] paramsItemIds = null;

	public ReinputKeyParam() {
		super();
		super.paramId = REINPUTKEY; //rik
		super.itemValueType = ParamValueType.M_INTEGER; //M_INTEGER
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
bob.append("ReinputKeyParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
