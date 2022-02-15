package javax.megaco.pkg.ext.ASRPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//The parameter indicates the ASR grammar identifier. The identifier conforms 
@Generated({"warren crossing"})
public class RecognitionGrammarIdentifierParam extends PkgItemParam {
	public static final int RECOGNITION_GRAMMAR_IDENTIFIER = 0x0002;
	public static final String TOKEN = "rgid";

	protected int[] paramsItemIds = null;

	public RecognitionGrammarIdentifierParam() {
		super();
		super.paramId = RECOGNITION_GRAMMAR_IDENTIFIER; //rgid
		super.itemValueType = ParamValueType.M_STRING; //M_STRING
		super.paramsDescriptorIds = new int[] {};
        super.packageId = ASRPkg.PACKAGE_INSTANCE;
 //0x00a6		this.paramsItemIds = new int[] {}; 
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
bob.append("RecognitionGrammarIdentifierParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
