package javax.megaco.pkg.ext.AdvancedAudioServerBasePkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//Specifies the offset into the announcement at which to start playing. A positive 
@Generated({"warren crossing"})
public class OffsetParam extends PkgItemParam {
	public static final int OFFSET = 0x0009;
	public static final String TOKEN = "off";

	protected int[] paramsItemIds = null;

	public OffsetParam() {
		super();
		super.paramId = OFFSET; //off
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
bob.append("OffsetParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
