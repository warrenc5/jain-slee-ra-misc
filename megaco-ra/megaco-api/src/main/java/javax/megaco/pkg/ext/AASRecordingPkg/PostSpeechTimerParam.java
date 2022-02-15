package javax.megaco.pkg.ext.AASRecordingPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//The amount of silence necessary after the end of the last speech segment for 
@Generated({"warren crossing"})
public class PostSpeechTimerParam extends PkgItemParam {
	public static final int POSTSPEECHTIMER = 0x0007;
	public static final String TOKEN = "pst";

	protected int[] paramsItemIds = null;

	public PostSpeechTimerParam() {
		super();
		super.paramId = POSTSPEECHTIMER; //pst
		super.itemValueType = ParamValueType.M_INTEGER; //M_INTEGER
		super.paramsDescriptorIds = new int[] {};
        super.packageId = AASRecordingPkg.PACKAGE_INSTANCE;
 //0x0035		this.paramsItemIds = new int[] {}; 
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
bob.append("PostSpeechTimerParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
