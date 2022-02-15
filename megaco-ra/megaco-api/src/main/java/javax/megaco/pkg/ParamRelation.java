package javax.megaco.pkg;

import java.io.Serializable;

/**
 * 
 * @author wozza
 */
public class ParamRelation implements Serializable {

	private int relation_type;

    /**
     * 
     */
    public static final int M_SET = 1;
    /**
     * 
     */
    public static final int M_SUBLIST = 2;
    /**
     * 
     */
    public static final int M_RANGE = 3;
    /**
     * 
     */
    public static final int M_EQUAL = 4;
    /**
     * 
     */
    public static final int M_NOT_EQUAL = 5;
    /**
     * 
     */
    public static final int M_GREATER = 6;
    /**
     * 
     */
    public static final int M_LESS = 7;

    /**
     * 
     */
    public static final ParamRelation SET = new ParamRelation(M_SET);
    /**
     * 
     */
    public static final ParamRelation SUBLIST = new ParamRelation(M_SUBLIST);
    /**
     * 
     */
    public static final ParamRelation RANGE = new ParamRelation(M_RANGE);
    /**
     * 
     */
    public static final ParamRelation EQUAL = new ParamRelation(M_EQUAL);
    /**
     * 
     */
    public static final ParamRelation NOT_EQUAL = new ParamRelation(M_NOT_EQUAL);
    /**
     * 
     */
    public static final ParamRelation GREATER = new ParamRelation(M_GREATER);
    /**
     * 
     */
    public static final ParamRelation LESS = new ParamRelation(M_LESS);

	private ParamRelation(int relation_type) {
		this.relation_type = relation_type;
	}

    /**
     * 
     * @return
     */
    public int getParamRelation() {
		return this.relation_type;
	}

    /**
     * 
     * @param value
     * @return
     * @throws IllegalArgumentException
     */
    public static final ParamRelation getObject(int value) throws IllegalArgumentException {
		ParamRelation p = null;
		switch (value) {
		case (M_SET):
			p = SET;
			break;

		case (M_SUBLIST):
			p = SUBLIST;
			break;

		case (M_RANGE):
			p = RANGE;
			break;

		case (M_EQUAL):
			p = EQUAL;
			break;

		case (M_NOT_EQUAL):
			p = NOT_EQUAL;
			break;

		case (M_GREATER):
			p = GREATER;
			break;

		case (M_LESS):
			p = LESS;
		default:
			throw new IllegalArgumentException("There is no ParamRelation for passed value = " + value);
		}
		return p;
	}

	private Object readResolve() {
		return this.getObject(this.relation_type);
	}

	@Override










public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("ParamRelation:");

bob.append("relation_type=").append(relation_type).append(",");

return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.ParamRelation o = (javax.megaco.pkg.ParamRelation)oo;
if (relation_type != o.relation_type) return false;

return true;
}

}




















