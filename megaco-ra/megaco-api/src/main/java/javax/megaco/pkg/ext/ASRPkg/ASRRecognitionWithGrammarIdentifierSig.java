package javax.megaco.pkg.ext.ASRPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgSignalItem;
import javax.annotation.Generated;

@Generated({"warren crossing"})
public final class ASRRecognitionWithGrammarIdentifierSig extends PkgSignalItem {

	public static final int ASR_RECOGNITION_WITH_GRAMMAR_IDENTIFIER = 0x0002;
	public static final String TOKEN = "asrid";


	public ASRRecognitionWithGrammarIdentifierSig() {
		super();
        super.packageId = ASRPkg.PACKAGE_INSTANCE;
		super.signalId = ASR_RECOGNITION_WITH_GRAMMAR_IDENTIFIER;
		super.itemId = ASR_RECOGNITION_WITH_GRAMMAR_IDENTIFIER;
	}

	public int getItemId() {

		return super.itemId;
	}

	public int getSignalId() {
		return super.signalId;
	}



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ASRRecognitionWithGrammarIdentifierSig:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
