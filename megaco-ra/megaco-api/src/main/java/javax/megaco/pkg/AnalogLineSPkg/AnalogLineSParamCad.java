package javax.megaco.pkg.AnalogLineSPkg;

import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgItemParam;

/**
 * The MEGACO parameter class for the Cadence Parameter is associated with Ring
 * signal of Analog Line Supervision Package. This class defines all the static
 * information for this parameter.
 */
public class AnalogLineSParamCad extends PkgItemParam {

	/**
	 *Identifies Cadence parameter of the MEGACO Analog Line Supervision
	 * Package. Its value shall be set equal to 0x0006.
	 */
	public static final int ANALOG_LINE_PARAM_CAD = 0x0006;

	protected int[] paramsItemIds = null;

	/**
	 * Constructs a parameter class for Analog Line Supervision package that
	 * specifies the parameter as Cadence.
	 */
	public AnalogLineSParamCad() {
		super();
		super.paramId = ANALOG_LINE_PARAM_CAD;
        super.packageId = AnalogLineSPkg.PACKAGE_INSTANCE;
		super.itemValueType = ParamValueType.M_INTEGER;
		super.paramsDescriptorIds = new int[] { DescriptorType.M_SIGNAL_DESC };

		// FIXME: ANALOG_LINE_RING_SIGNAL ??
		this.paramsItemIds = new int[] {AnalogLineSRingSignal.ANALOG_LINE_S_RING_SIGNAL};
	}

	/**
	 * The method can be used to get the parameter identifier as defined in the
	 * MEGACO packages. The implementation of this method in this class returns
	 * Id of Cadence parameter.
	 * 
	 * @return paramId - Returns param id as {@link ANALOG_LINE_PARAM_CAD}.
	 */
	public int getParamId() {

		return super.paramId;
	}

	/**
	 * The method can be used to get the type of the parameter as defined in the
	 * MEGACO packages. These could be one of string or enumerated value or
	 * integer or double value or boolean.
	 * 
	 * @return It returns {@link ParamValueType.M_INTEGER}
	 *         indicating that the parameter is a string.
	 */
	public int getParamValueType() {

		return super.itemValueType;
	}

	/**
	 * The method can be used to get the item ids corresponding to the
	 * parameters to which the parameter can be set. This method specifies the
	 * valid item (event/signal) ids to which the parameter can belong to.
	 * 
	 * @return The integer value corresponding to Ring. Thus this shall return
	 *         {@link ANALOG_LINE_RING_SIGNAL}.
	 */
	public int[] getParamsItemIds() {
		return this.paramsItemIds;
	}

	/**
	 * The method can be used to get the package id corresponding to the to
	 * which the parameter can be set. This method specifies the package for
	 * which the parameter is valid. Even though the parameter may be set for an
	 * item, but the parameter may not be valid for package to which the item
	 * belongs, but may be valid for a package which has extended this package.
	 * 
	 * @return This shall return {@link PkgConsts.ANALOG_LINE_PACKAGE} as the
	 *         integer value. The integer values are defined in
	 *         {@link PkgConsts}.
	 */
	public int getParamsPkgId() {
		return PkgConsts.ANALOG_LINE_PACKAGE;
	}

	/**
	 * The method can be used to get the descriptor ids corresponding to the
	 * parameters to which the parameter can be set.
	 * 
	 * @return This parameter can be present in Event descriptor. It shall thus
	 *         return a value {@link DescriptorType.M_SIGNAL_DESC}
	 */
	public int[] getParamsDescriptorIds() {
		return super.paramsDescriptorIds;
	}










public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("AnalogLineSParamCad:");
bob.append(super.toString());

if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamCad o = (javax.megaco.pkg.AnalogLineSPkg.AnalogLineSParamCad)oo;
if (!super.equals(o)) return false;
if((paramsItemIds !=null && o.paramsItemIds == null) ||(paramsItemIds == null && o.paramsItemIds != null) ) return false;
if (paramsItemIds ==null && o.paramsItemIds == null) return true; else if (paramsItemIds.length != o.paramsItemIds.length) return false;
if (paramsItemIds.length == o.paramsItemIds.length) for(int i = 0 ; i < paramsItemIds.length; i ++ )
if (paramsItemIds[i] != o.paramsItemIds[i]) return false;

return true;
}

}


















