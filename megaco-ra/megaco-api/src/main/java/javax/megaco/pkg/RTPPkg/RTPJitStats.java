package javax.megaco.pkg.RTPPkg;

import javax.megaco.pkg.MegacoPkg;
import javax.megaco.pkg.ParamValueType;
import javax.megaco.pkg.PkgStatsItem;

/**
 * 
 * The MEGACO Jitter statistics class extends the PkgStatsItem class. This is a
 * final class. This class defines Jitter statistics of MEGACO RTP package. The
 * methods shall define that this statistics item belongs to the RTP package.
 */
public final class RTPJitStats extends PkgStatsItem {

	/**
	 * Identifies Jitter statistics of the MEGACO RTP Package. Its value shall
	 * be set equal to 0x0007.
	 */
	public static final int RTP_JIT_STATS = 0x0007;
    private int[] itemsDescriptorIds = new int[]{};

	/**
	 * Constructs a Jain MEGACO Object representing statistics item of the
	 * MEGACO Package for statistics Jitter and Package as RTP.
	 */
	public RTPJitStats() {
		super();
		super.statisticsId = RTP_JIT_STATS;
		super.itemId = RTP_JIT_STATS;
		super.packageId = RTPPkg.PACKAGE_INSTANCE;
        super.itemValueType = ParamValueType.M_INTEGER;
	}

	/**
	 * This method is used to get the item identifier from an Item object. The
	 * implementations of this method in this class returns the id of the Jitter
	 * statistics of RTP Package.
	 * 
	 * @return It shall return {@link RTP_JIT_STATS}.
	 */
	public int getItemId() {
		return super.itemId;
	}

	/**
	 * This method gets the package id to which the item belongs. Since the
	 * Jitter statistics is defined in the RTP Package of MEGACO protocol, this
	 * method returns the value {@link PkgConsts.RTP_PACKAGE} constant. This
	 * constant is defined in the PkgConsts class.
	 * 
	 * 
	 * 
	 * @return The package id RTP_PACKAGE.
	 */
	public MegacoPkg getItemsPkgId() {
		return super.packageId;
	}

	/**
	 * This method is used to get the statistics identifier from an Statistics
	 * Item object. The implementations of this method in this class returns the
	 * id of the Jitter statistics of RTP Package.
	 * 
	 * @return It shall return {@link RTP_JIT_STATS}.
	 */
	public int getStatisticsId() {
		return super.statisticsId;
	}

	@Override
	public int getItemValueType() {
		return itemValueType;
	}

	@Override
	public int[] getItemsDescriptorIds() {
		return itemsDescriptorIds;
	}











public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("RTPJitStats:");
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
javax.megaco.pkg.RTPPkg.RTPJitStats o = (javax.megaco.pkg.RTPPkg.RTPJitStats)oo;
if (!super.equals(o)) return false;
if((itemsDescriptorIds !=null && o.itemsDescriptorIds == null) ||(itemsDescriptorIds == null && o.itemsDescriptorIds != null) ) return false;
if (itemsDescriptorIds ==null && o.itemsDescriptorIds == null) return true; else if (itemsDescriptorIds.length != o.itemsDescriptorIds.length) return false;
if (itemsDescriptorIds.length == o.itemsDescriptorIds.length) for(int i = 0 ; i < itemsDescriptorIds.length; i ++ )
if (itemsDescriptorIds[i] != o.itemsDescriptorIds[i]) return false;

return true;
}

}


















