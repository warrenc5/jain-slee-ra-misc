package javax.megaco.pkg;

import javax.megaco.ExceptionInfoCode;

/**
 * The MEGACO package item parameter class is an abstract and shall be used for
 * setting the parameter name and value attached to an event or a signal. The
 * derived class for this would specify the hard coded value for their identity,
 * name, type and other parameters, but the value for the parameter would be set
 * within this base class.
 * 
 * 
 */
public abstract class PkgItemParam extends PkgValueItem implements java.io.Serializable {

	// FIXME: jsr jdoc does not extend
	private ParamRelation paramRelation;

    /**
     * 
     */
    protected int paramId = -1;
    /**
     * 
     */
    protected int[] paramsDescriptorIds = null;
    /**
     * 
     */
    protected int[] paramsItemIds = null;

	/**
	 * Constructs a Jain MEGACO package item parameter Object. This is an
	 * abstract class and can be called only by the derived classes.
	 */
	public PkgItemParam() {

	}

	/**
	 * The method can be used to get the parameter identifier as defined in the
	 * MEGACO packages. A hardcoded value is returned by the derived class.
	 * 
	 * @return paramId - The integer corresponding to the parameter id.
	 */
	public abstract int getParamId();

	/**
	 * The method can be used to get the type of the parameter as defined in the
	 * MEGACO packages. These could be one of string or enumerated value or
	 * integer or double value or boolean.
	 * 
	 * @return paramType - The integer corresponding to the parameter type. The
	 *         values shall be defined in ParamValueType.
	 */
	public abstract int getParamValueType();

	/**
	 * The method can be used to get the relation set in the parameter for the
	 * parameter value as defined in the MEGACO packages. The relation operator
	 * can be one of equal, not equal, greater than or less than operator for
	 * single value. The MEGACO parameter is accompanied by a parameter value
	 * that can be single value or set of values or sublist of values or range
	 * of values. The relation operator can be equal when the value is set or
	 * sublist or range. This method specifies both the relation operator and
	 * also specifies whether the accompaning parameter value is single value or
	 * set of values or sublist of values or range of value. If the relation
	 * specifies set or range or sublist, it automatically assumes the relation
	 * to be "MEGACO_EQUAL".
	 * 
	 * @return paramRelation - The integer corresponding to the parameter
	 *         relation. The values shall be defined in ParamRelation.
	 */
	public final ParamRelation getParamsValueRelation() {
		return this.paramRelation;
	}

	/**
	 * The method can be used to set the relation of the value as defined in the
	 * MEGACO packages. The relation operator can be one of equal, not equal,
	 * greater than or less than operator for single value. The MEGACO parameter
	 * is accompanied by a parameter value that can be single value or set of
	 * values or sublist of values or range of values. The relation operator can
	 * be equal when the value is set or sublist or range. This method specifies
	 * both the relation operator and also specifies whether the accompaning
	 * parameter value is single value or set of values or sublist of values or
	 * range of value. If the relation specifies set or range or sublist, it
	 * automatically assumes the relation to be "MEGACO_EQUAL". The default
	 * value of the relation can be set in constructor of each class that
	 * derives this class.
	 * 
	 * @param paramRelation
	 *            - The integer corresponding to the value relation. The values
	 *            shall be defined in ParamRelation.
	 * @throws IllegalArgumentException
	 *             This exception is raised if the reference of Param Relation
	 *             passed to this method is NULL.
	 */
	public final void setParamsValueRelation(ParamRelation paramRelation) throws IllegalArgumentException {
		if (paramRelation == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException("ParamRelation cannot be null from PkgItemParam");
			// invalidArgumentException.setInfoCode(ExceptionInfoCode.INV_PARAM_RELATION);
			throw invalidArgumentException;
		}
		this.paramRelation = paramRelation;
	}

	@Override










public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("PkgItemParam:");
bob.append(super.toString());

if(paramRelation !=null)
bob.append("paramRelation=").append(paramRelation).append(",");
bob.append("paramId=").append(paramId).append(",");
if (paramsDescriptorIds !=null && paramsDescriptorIds.length > 0) { bob.append("paramsDescriptorIds=["); 
 for(int i = 0 ; i < paramsDescriptorIds.length; i ++ )
bob.append(paramsDescriptorIds[i]).append(",");
bob.append("]");}
if (paramsItemIds !=null && paramsItemIds.length > 0) { bob.append("paramsItemIds=["); 
 for(int i = 0 ; i < paramsItemIds.length; i ++ )
bob.append(paramsItemIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}


















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.PkgItemParam o = (javax.megaco.pkg.PkgItemParam)oo;
if (!super.equals(o)) return false;
if((paramRelation !=null && o.paramRelation == null) ||(paramRelation == null && o.paramRelation != null) ) return false;
if(paramRelation ==null && o.paramRelation == null) return true ; else if(paramRelation !=null && o.paramRelation != null)
if (paramRelation != null && o.paramRelation !=null && !paramRelation.equals(o.paramRelation)) return false;
if (paramId != o.paramId) return false;
if((paramsDescriptorIds !=null && o.paramsDescriptorIds == null) ||(paramsDescriptorIds == null && o.paramsDescriptorIds != null) ) return false;
if (paramsDescriptorIds ==null && o.paramsDescriptorIds == null) return true; else if (paramsDescriptorIds.length != o.paramsDescriptorIds.length) return false;
if (paramsDescriptorIds.length == o.paramsDescriptorIds.length) for(int i = 0 ; i < paramsDescriptorIds.length; i ++ )
if (paramsDescriptorIds[i] != o.paramsDescriptorIds[i]) return false;
if((paramsItemIds !=null && o.paramsItemIds == null) ||(paramsItemIds == null && o.paramsItemIds != null) ) return false;
if (paramsItemIds ==null && o.paramsItemIds == null) return true; else if (paramsItemIds.length != o.paramsItemIds.length) return false;
if (paramsItemIds.length == o.paramsItemIds.length) for(int i = 0 ; i < paramsItemIds.length; i ++ )
if (paramsItemIds[i] != o.paramsItemIds[i]) return false;

return true;
}

}


















