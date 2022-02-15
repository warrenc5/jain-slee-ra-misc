package javax.megaco.pkg.CPToneGenPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;

/**
 * The MEGACO Call Progress Tone Generator Package inherits all methods of the
 * Package, but overrides the getPkgId and getPkgName to define packageid
 * corresponding to the Call Progress Tone Generator Package. This class also
 * overrides the getExtendedPkgIds to define that this package extends MEGACO
 * Tone Generator Package.
 */
public class CPToneGenPkg extends MegacoPkg {
  static final MegacoPkg PACKAGE_INSTANCE = new CPToneGenPkg(); 

	private int[] extendedPkgIds = new int[] { PkgConsts.TONE_GEN_PACKAGE };

	
	
	public CPToneGenPkg() {
		super();
		
	}

	/**
	 * This method gets the package ids of all the package which the package had
	 * directly or indirectly extended. Package ids are defined in
	 * {@link PkgConsts}.
	 * 
	 * @return Since this packge extends MEGACO Tone Generator package, this
	 *         shall return value {@link PkgConsts.TONE_GEN_PACKAGE}.
	 */
	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	/**
	 * This method return the package Id of the MEGACO package for which the
	 * object is created. For Call Progress Tone Generator Package constant
	 * value {@link PkgConsts.CALL_PROG_TONE_GEN_PACKAGE} shall be returned.
	 * 
	 * @return Constant value {@link PkgConsts.CALL_PROG_TONE_GEN_PACKAGE}
	 *         indicating DTMF Generator Package.
	 */
	public int getPkgId() {
		// FIXME: jdoc says: DTMF_GEN_PACKAGE
		return PkgConsts.CALL_PROG_TONE_GEN_PACKAGE;
	}

    @Override
    public String getPackageName() {
        return "cg";
    }











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("CPToneGenPkg:");
bob.append(super.toString());

if (extendedPkgIds !=null && extendedPkgIds.length > 0) { bob.append("extendedPkgIds=["); 
 for(int i = 0 ; i < extendedPkgIds.length; i ++ )
bob.append(extendedPkgIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.CPToneGenPkg.CPToneGenPkg o = (javax.megaco.pkg.CPToneGenPkg.CPToneGenPkg)oo;
if (!super.equals(o)) return false;
if((extendedPkgIds !=null && o.extendedPkgIds == null) ||(extendedPkgIds == null && o.extendedPkgIds != null) ) return false;
if (extendedPkgIds ==null && o.extendedPkgIds == null) return true; else if (extendedPkgIds.length != o.extendedPkgIds.length) return false;
if (extendedPkgIds.length == o.extendedPkgIds.length) for(int i = 0 ; i < extendedPkgIds.length; i ++ )
if (extendedPkgIds[i] != o.extendedPkgIds[i]) return false;

return true;
}

}


















