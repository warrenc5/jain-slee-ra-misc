package javax.megaco.pkg.DTMFDetPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;

/**
 * The MEGACO DTMF Detect Package inherits all methods of the Package, but
 * overrides the getPkgId and getPkgName to define packageid corresponding to
 * the DTMF Detect Package. This class also overrides the getExtendedPkgIds to
 * define that this package extends MEGACO Tone Detect package.
 */
public class DTMFDetPkg extends javax.megaco.pkg.MegacoPkg {
  static final MegacoPkg PACKAGE_INSTANCE = new DTMFDetPkg(); 

	private int[] extendedPkgIds = new int[] { PkgConsts.TONE_DET_PACKAGE };

	/**
	 * This method gets the package ids of all the package which the package had
	 * directly or indirectly extended. Package ids are defined in
	 * {@link PkgConsts}.
	 * 
	 * @return Since this packge extends MEGACO Tone Detect package, this shall
	 *         return value {@link PkgConsts.TONE_DET_PACKAGE}.
	 */
	public int[] getExtendedPkgIds() {

		return extendedPkgIds;
	}

	/**
	 * This method return the package Id of the MEGACO package for which the
	 * object is created. For DTMF Detection Package constant value
	 * {@link PkgConsts.DTMF_DET_PACKAGE} shall be returned.
	 * 
	 * @return Constant value {@link PkgConsts.DTMF_DET_PACKAGE} indicating DTMF
	 *         Detection Package.
	 */
	public int getPkgId() {

		return PkgConsts.DTMF_DET_PACKAGE;
	}

    @Override
    public String getPackageName() {
        return "dd";
    }











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DTMFDetPkg:");
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
javax.megaco.pkg.DTMFDetPkg.DTMFDetPkg o = (javax.megaco.pkg.DTMFDetPkg.DTMFDetPkg)oo;
if (!super.equals(o)) return false;
if((extendedPkgIds !=null && o.extendedPkgIds == null) ||(extendedPkgIds == null && o.extendedPkgIds != null) ) return false;
if (extendedPkgIds ==null && o.extendedPkgIds == null) return true; else if (extendedPkgIds.length != o.extendedPkgIds.length) return false;
if (extendedPkgIds.length == o.extendedPkgIds.length) for(int i = 0 ; i < extendedPkgIds.length; i ++ )
if (extendedPkgIds[i] != o.extendedPkgIds[i]) return false;

return true;
}

}


















