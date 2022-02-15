package javax.megaco.pkg.ToneDetPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;

/**
 * The MEGACO tone detection package inherits all methods of the Package, but
 * overrides the getPkgId and getPkgName to define packageid corresponding to
 * the Tone Detection Package. This class also overrides the getExtendedPkgIds
 * to define that there are no packages that this package extends.
 */
public class ToneDetPkg extends MegacoPkg {
  static final MegacoPkg PACKAGE_INSTANCE = new ToneDetPkg(); 

	/**
	 * This method gets the package ids of all the package which the package had
	 * directly or indirectly extended. Package ids are defined in
	 * {@link PkgConsts.TONE_DET_PACKAGE}.
	 * 
	 * @return Since this packge extends no other package, this shall return a
	 *         NULL value.
	 */
	public int[] getExtendedPkgIds() {

		return null;
	}

	/**
	 * This method return the package Id of the MEGACO package for which the
	 * object is created. For Tone Detection Package constant value
	 * {@link PkgConsts.TONE_DET_PACKAGE} shall be returned.
	 * 
	 * @return Constant value {@link PkgConsts.TONE_DET_PACKAGE} indicating Tone
	 *         Detection Package.
	 */
	public int getPkgId() {
		return PkgConsts.TONE_DET_PACKAGE;
	}

    @Override
    public String getPackageName() {
        return "tonedet";
    }











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ToneDetPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.ToneDetPkg.ToneDetPkg o = (javax.megaco.pkg.ToneDetPkg.ToneDetPkg)oo;
if (!super.equals(o)) return false;

return true;
}

}


















