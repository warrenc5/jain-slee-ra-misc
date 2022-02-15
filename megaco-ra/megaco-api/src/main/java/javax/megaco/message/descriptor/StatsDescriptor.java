package javax.megaco.message.descriptor;

import java.io.Serializable;


import javax.megaco.message.Descriptor;
import javax.megaco.message.DescriptorType;
import javax.megaco.pkg.PkgItemStr;
import javax.megaco.pkg.PkgStatsItem;

/**
 * The class extends JAIN MEGACO Descriptor. This class describes the statistics
 * descriptor. It stores the statistics values against a statistics identity.
 */
public class StatsDescriptor extends Descriptor implements Serializable {
	private PkgStatsItem[] pkgStatsItem;
	private PkgItemStr[] pkgItemStr;

	/**
	 * Constructs a Statistics Descriptor. This contains the statistics id and
	 * its associated value.
	 * 
	 * @param statsItem
	 * @throws IllegalArgumentException
	 *             - Thrown if an invalid statistics id is set.
	 */
	public StatsDescriptor(PkgStatsItem[] statsItem) throws IllegalArgumentException {
		super.descriptorId = DescriptorType.M_STATISTICS_DESC;

		if (statsItem == null) {
			throw new IllegalArgumentException("PkgStatsItem[] must not be null.");
		}

		if (statsItem.length == 0) {
			throw new IllegalArgumentException("PkgStatsItem[] must not be empty.");
		}

		this.pkgStatsItem = statsItem;
	}

	/**
	 * Constructs Statistics descriptor object with the PkgItemStr object. This
	 * method would be used if the package parameters are to be conveyed in the
	 * string format.
	 * 
	 * @param statsItemStr
	 * @throws IllegalArgumentException
	 *             - Thrown if an invalid statsItemStr object reference is set.
	 */
	public StatsDescriptor(PkgItemStr[] statsItemStr) throws IllegalArgumentException {
		super.descriptorId = DescriptorType.M_STATISTICS_DESC;

		if (statsItemStr == null) {
			throw new IllegalArgumentException("PkgItemStr[] must not be null.");
		}

		if (statsItemStr.length == 0) {
			throw new IllegalArgumentException("PkgItemStr[] must not be empty.");
		}

		this.pkgItemStr = statsItemStr;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * returns that the descriptor identifier is of type Statistics descriptor.
	 * This method overrides the corresponding method of the base class
	 * Descriptor.
	 * 
	 * @return Returns an integer value that identifies this object as the type
	 *         of Statistics descriptor. It returns that it is Statistics
	 *         Descriptor i.e., M_STATISTICS_DESC.
	 */
	public int getDescriptorId() {
		return super.descriptorId;
	}

	/**
	 * The method can be used to get the statistics id and its associated value.
	 * 
	 * @return stats - The object reference for the megaco statistics identity
	 *         and the associated value.
	 */
	public PkgStatsItem[] getMegacoPkgStatsItem() {
		return this.pkgStatsItem;
	}

	/**
	 * The method can be used to get the pkdgName as set in the statistics
	 * descriptor. This method gives the package information, the attached event
	 * information and the parameter name and value. As comapres to the
	 * getMegacoPkgStatsItem() method, this method returnes the package
	 * parameters in the string format.
	 * 
	 * @return The object reference for the megaco package item. This class
	 *         holds information about package name, item name and the
	 *         parameters in the string format. If the parameter has not been
	 *         set, then this method shall return NULL.
	 */
	public PkgItemStr[] getMegacoPkgItemStr() {
		return this.pkgItemStr;

	}

















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("StatsDescriptor:");
bob.append(super.toString());

if (pkgStatsItem !=null && pkgStatsItem.length > 0) { bob.append("pkgStatsItem=["); 
 for(int i = 0 ; i < pkgStatsItem.length; i ++ )
if(pkgStatsItem[i] !=null)
bob.append(pkgStatsItem[i]).append(",");
bob.append("]");}
if (pkgItemStr !=null && pkgItemStr.length > 0) { bob.append("pkgItemStr=["); 
 for(int i = 0 ; i < pkgItemStr.length; i ++ )
if(pkgItemStr[i] !=null)
bob.append(pkgItemStr[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.StatsDescriptor o = (javax.megaco.message.descriptor.StatsDescriptor)oo;
if (!super.equals(o)) return false;
if((pkgStatsItem !=null && o.pkgStatsItem == null) ||(pkgStatsItem == null && o.pkgStatsItem != null) ) return false;
if(pkgStatsItem ==null && o.pkgStatsItem == null) return true ; else if(pkgStatsItem !=null && o.pkgStatsItem != null)
{
if (pkgStatsItem ==null && o.pkgStatsItem == null) return true; else if (pkgStatsItem.length != o.pkgStatsItem.length) return false;
if (pkgStatsItem.length == o.pkgStatsItem.length) for(int i = 0 ; i < pkgStatsItem.length; i ++ )
{
if((pkgStatsItem[i] !=null && o.pkgStatsItem[i] == null) ||(pkgStatsItem[i] == null && o.pkgStatsItem[i] != null) ) return false;
if(pkgStatsItem[i] !=null && o.pkgStatsItem[i] != null)
if (!pkgStatsItem[i].equals(o.pkgStatsItem[i])) return false;
}
}
if((pkgItemStr !=null && o.pkgItemStr == null) ||(pkgItemStr == null && o.pkgItemStr != null) ) return false;
if(pkgItemStr ==null && o.pkgItemStr == null) return true ; else if(pkgItemStr !=null && o.pkgItemStr != null)
{
if (pkgItemStr ==null && o.pkgItemStr == null) return true; else if (pkgItemStr.length != o.pkgItemStr.length) return false;
if (pkgItemStr.length == o.pkgItemStr.length) for(int i = 0 ; i < pkgItemStr.length; i ++ )
{
if((pkgItemStr[i] !=null && o.pkgItemStr[i] == null) ||(pkgItemStr[i] == null && o.pkgItemStr[i] != null) ) return false;
if(pkgItemStr[i] !=null && o.pkgItemStr[i] != null)
if (!pkgItemStr[i].equals(o.pkgItemStr[i])) return false;
}
}

return true;
}

}
























