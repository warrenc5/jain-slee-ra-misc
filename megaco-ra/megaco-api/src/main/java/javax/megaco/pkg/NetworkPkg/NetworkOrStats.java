package javax.megaco.pkg.NetworkPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgStatsItem;

/**
 * The MEGACO Octet received statistics class extends the PkgStatsItem class.
 * This is a final class. This class defines Octet received statistics of MEGACO
 * Network package. The methods shall define that this statistics item belongs
 * to the Network package.
 */
public final class NetworkOrStats extends PkgStatsItem {

	/**
	 * Identifies Octets received statistics of the MEGACO Network Package. Its
	 * value shall be set equal to 0x0003.
	 */
	public static final int NETWORK_OR_STATS = 0x0003;

	/**
	 * Constructs a Jain MEGACO Object representing statistics Item of the
	 * MEGACO Package for statistics Duration and Package as Network.
	 */
	public NetworkOrStats() {
		super();
		super.itemId = NETWORK_OR_STATS;
		super.statisticsId = NETWORK_OR_STATS;
		super.packageId = NetworkPkg.PACKAGE_INSTANCE;
		super.itemValueType = ParamValueType.M_STRING;
	}

	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the Octets
	 * Received statistics of Network Package.
	 * 
	 * @return It shall return {@link NETWORK_OR_STATS}.
	 */
	public int getItemId() {
		return super.itemId;
	}

	/**
	 * This method is used to get the statistics identifier from an Statistics
	 * Item object. The implementations of this method in this class returns the
	 * id of the Octets Received statistics of Network Package
	 * 
	 * @return It shall return {@link NETWORK_OR_STATS}.
	 */
	public int getStatisticsId() {
		return super.statisticsId;
	}

	/**
	 * This method gets the package id to which the item belongs. Since the
	 * Octet Received statistics is defined in the Network Package of MEGACO
	 * protocol, this method returns the value {@link PkgConsts.NETWORK_PACKAGE}
	 * constant. This constant is defined in the PkgConsts class.
	 * 
	 * @return The package id {@link PkgConsts.NETWORK_PACKAGE}.
	 */
	public MegacoPkg getItemsPkgId() {
		return super.packageId;
	}

	// FIXME: add jdoc ? those are not present

	public int getItemValueType() {

		return super.itemValueType;
	}

	@Override
	public int[] getItemsDescriptorIds() {

		return new int[] {};
	}











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("NetworkOrStats:");
bob.append(super.toString());


return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.NetworkPkg.NetworkOrStats o = (javax.megaco.pkg.NetworkPkg.NetworkOrStats)oo;
if (!super.equals(o)) return false;

return true;
}

}


















