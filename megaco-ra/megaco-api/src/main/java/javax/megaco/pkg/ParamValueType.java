package javax.megaco.pkg;

import java.io.Serializable;

/**
 * 
 * @author wozza
 */
public final class ParamValueType implements Serializable {
    /**
     * 
     */
    public static final int M_STRING = 1;
    /**
     * 
     */
    public static final int M_INTEGER = 2;
    /**
     * 
     */
    public static final int M_BOOLEAN = 3;
    /**
     * 
     */
    public static final int M_DOUBLE = 4;

    /**
     * 
     */
    public static final ParamValueType STRING = new ParamValueType(M_STRING);
    /**
     * 
     */
    public static final ParamValueType INTEGER = new ParamValueType(M_INTEGER);
    /**
     * 
     */
    public static final ParamValueType BOOLEAN = new ParamValueType(M_BOOLEAN);
    /**
     * 
     */
    public static final ParamValueType DOUBLE = new ParamValueType(M_DOUBLE);

	private int value_type;

	private ParamValueType(int value_type) {
		this.value_type = value_type;
	}

    /**
     * 
     * @return
     */
    public int getParamValueType() {
		return this.value_type;
	}

    /**
     * 
     * @param value
     * @return
     * @throws IllegalArgumentException
     */
    public static final ParamValueType getObject(int value) throws IllegalArgumentException {
		ParamValueType p = null;
		switch (value) {
		case M_STRING:
			p = STRING;
			break;

		case M_INTEGER:
			p = INTEGER;
			break;

		case M_BOOLEAN:
			p = BOOLEAN;
			break;

		case M_DOUBLE:
			p = DOUBLE;
			break;

		default:
			throw new IllegalArgumentException("No ParamValueType for passed value " + value);
		}
		return p;
	}

	private Object readResolve() {
		return this.getObject(this.value_type);
	}

	@Override










public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ParamValueType:");

bob.append("value_type=").append(value_type).append(",");

return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.ParamValueType o = (javax.megaco.pkg.ParamValueType)oo;
if (value_type != o.value_type) return false;

return true;
}

}




















