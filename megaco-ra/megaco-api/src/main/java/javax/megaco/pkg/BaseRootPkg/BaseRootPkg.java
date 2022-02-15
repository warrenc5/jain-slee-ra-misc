package javax.megaco.pkg.BaseRootPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.PkgConsts;

/**
 * The MEGACO Base Root inherits all methods of the Package, but overrides the
 * getPkgId and getPkgName to define packageid corresponding to the Base Root
 * Package. This class also overrides the getExtendedPkgIds to define that there
 * are no packages that this package extends.
 * 
 */
public class BaseRootPkg extends MegacoPkg {
    static final MegacoPkg PACKAGE_INSTANCE = new BaseRootPkg();

	/**
	 * Constructs a derived class of Base Root Package that extends the Package
	 */
	public BaseRootPkg() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method gets the package ids of all the package which the package had
	 * directly or indirectly extended. Package ids are defined in
	 * {@link PkgConsts}.
	 */
	public final int[] getExtendedPkgIds() {

		return null;
	}

	/**
	 * This method return the package Id of the MEGACO package for which the
	 * object is created. For Base ROOT Package constant value
	 * {@link BASE_ROOT_PACKAGE} shall be returned.
	 * 
	 * @return Constant value {@link BASE_ROOT_PACKAGE} indicating Base ROOT
	 *         Package.
	 */
	public final int getPkgId() {
		return PkgConsts.BASE_ROOT_PACKAGE;
	}

    @Override
    public String getPackageName() {
        return "root";
    }











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("BaseRootPkg:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.BaseRootPkg.BaseRootPkg o = (javax.megaco.pkg.BaseRootPkg.BaseRootPkg)oo;
if (!super.equals(o)) return false;

return true;
}

}


















