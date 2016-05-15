
public class PriceSummary {
	private Double avarage;
	private Double minPrice;
	private Double maxPrice;
	public final Double getAvarage() {
		return avarage;
	}
	public final void setAvarage(Double avarage) {
		this.avarage = avarage;
	}
	public final Double getMinPrice() {
		return minPrice;
	}
	public final void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public final Double getMaxPrice() {
		return maxPrice;
	}
	public final void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	@Override
	public String toString() {
		return "PriceSummary [avarage=" + avarage + ", minPrice=" + minPrice
				+ ", maxPrice=" + maxPrice + "]";
	}
	
	

}
