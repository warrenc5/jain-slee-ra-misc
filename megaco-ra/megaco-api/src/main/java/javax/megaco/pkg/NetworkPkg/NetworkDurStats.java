package javax.megaco.pkg.NetworkPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgConsts;
import javax.megaco.pkg.PkgStatsItem;

/**
 * The MEGACO Duration statistics class extends the PkgStatsItem class. This is
 * a final class. This class defines Duration statistics of MEGACO Network
 * package. The methods shall define that this statistics item belongs to the
 * Network package.
 */
public final class NetworkDurStats extends PkgStatsItem {

	/**
	 * Identifies Duration statistics of the MEGACO Network Package. Its value
	 * shall be set equal to 0x0001.
	 */
	public static final int NETWORK_DUR_STATS = 0x0001;
    private int[] itemsDescriptorIds = new int[]{};

	/**
	 * Constructs a Jain MEGACO Object representing statistics Item of the
	 * MEGACO Package for statistics Duration and Package as Network.
	 */
	public NetworkDurStats() {
		super();
		super.itemId = NETWORK_DUR_STATS;
    super.statisticsId = NETWORK_DUR_STATS;

    super.itemValueType = ParamValueType.M_DOUBLE;
    super.packageId = NetworkPkg.PACKAGE_INSTANCE;
	}

	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the
	 * Duration statistics of Network Package.
	 * 
	 * @return It shall return {@link NETWORK_DUR_STATS}.
	 */
	public int getItemId() {
		return super.itemId;
	}

	/**
	 * This method is used to get the statistics identifier from an Statistics
	 * Item object. The implementations of this method in this class returns the
	 * id of the Duration statistics of Network Package.
	 * 
	 * @return It shall return {@link NETWORK_DUR_STATS}.
	 */
	public int getStatisticsId() {
		return super.statisticsId;
	}

	/**
	 * This method gets the package id to which the item belongs. Since the
	 * Octet Sent statistics is defined in the Network Package of MEGACO
	 * protocol, this method returns the value {@link PkgConsts.NETWORK_PACKAGE}
	 * constant. This constant is defined in the PkgConsts class.
	 * 
	 * @return The package id {@link PkgConsts.NETWORK_PACKAGE}.
	 */
	public MegacoPkg getItemsPkgId() {
		return super.packageId;
	}

	@Override
	public int getItemValueType() {
		return super.itemValueType;
	}

	@Override
	public int[] getItemsDescriptorIds() {
		return itemsDescriptorIds;
	}











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("NetworkDurStats:");
bob.append(super.toString());

if (itemsDescriptorIds !=null && itemsDescriptorIds.length > 0) { bob.append("itemsDescriptorIds=["); 
 for(int i = 0 ; i < itemsDescriptorIds.length; i ++ )
bob.append(itemsDescriptorIds[i]).append(",");
bob.append("]");}

return bob.append(";").toString(); 
}
















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.pkg.NetworkPkg.NetworkDurStats o = (javax.megaco.pkg.NetworkPkg.NetworkDurStats)oo;
if (!super.equals(o)) return false;
if((itemsDescriptorIds !=null && o.itemsDescriptorIds == null) ||(itemsDescriptorIds == null && o.itemsDescriptorIds != null) ) return false;
if (itemsDescriptorIds ==null && o.itemsDescriptorIds == null) return true; else if (itemsDescriptorIds.length != o.itemsDescriptorIds.length) return false;
if (itemsDescriptorIds.length == o.itemsDescriptorIds.length) for(int i = 0 ; i < itemsDescriptorIds.length; i ++ )
if (itemsDescriptorIds[i] != o.itemsDescriptorIds[i]) return false;

return true;
}

}


















