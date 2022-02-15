package javax.megaco.pkg.ext.ASRPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class ASRRecognitionWithGrammarScriptSig extends PkgSignalItem {

	public static final int ASR_RECOGNITION_WITH_GRAMMAR_SCRIPT = 0x0001;
	public static final String TOKEN = "asrwgs";


	public ASRRecognitionWithGrammarScriptSig() {
		super();
        super.packageId = ASRPkg.PACKAGE_INSTANCE;
		super.signalId = ASR_RECOGNITION_WITH_GRAMMAR_SCRIPT;
		super.itemId = ASR_RECOGNITION_WITH_GRAMMAR_SCRIPT;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ASRRecognitionWithGrammarScriptSig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
