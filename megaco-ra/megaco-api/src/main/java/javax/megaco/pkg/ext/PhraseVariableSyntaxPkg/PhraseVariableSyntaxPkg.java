package javax.megaco.pkg.ext.PhraseVariableSyntaxPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.ToneGenPkg.ToneGenPkg;
import javax.annotation.Generated;

/**
 * This package exists only to indicate that the MG is capable of processing the 
 */
@Generated({"warren crossing"})
public class PhraseVariableSyntaxPkg extends MegacoPkg { 
	public static final int PACKAGE_VERSION = 2;

    static final MegacoPkg PACKAGE_INSTANCE = new PhraseVariableSyntaxPkg(); 

	private static int[] extendedPkgIds = new int[] { 72 }; 

	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	public int getPkgId() {
		return 0x004a ; 
	}

	public String getPackageName() {
		return "phrsyx" ;
	}


public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("PhraseVariableSyntaxPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}



}
