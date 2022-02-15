package javax.megaco.pkg.ext.ASRPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;
import javax.annotation.Generated;

//The recognition grammar script format indicates the grammar script form, 
@Generated({"warren crossing"})
public class RecognitionGrammarScriptFormatParam extends PkgItemParam {
	public static final int RECOGNITION_GRAMMAR_SCRIPT_FORMAT = 0x0004;
	public static final String TOKEN = "rgsf";

	protected int[] paramsItemIds = null;

	public RecognitionGrammarScriptFormatParam() {
		super();
		super.paramId = RECOGNITION_GRAMMAR_SCRIPT_FORMAT; //rgsf
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
bob.append("RecognitionGrammarScriptFormatParam:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



}
