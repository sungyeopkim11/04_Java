package list.dto;

public class CafeDTO {
	
	private String store;
	private String coffee;
	private int price;
	public CafeDTO(String store, String coffee, int price) {
		super();
		this.store = store;
		this.coffee = coffee;
		this.price = price;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getCoffee() {
		return coffee;
	}
	public void setCoffee(String coffee) {
		this.coffee = coffee;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CafeDTO [store=" + store + ", coffee=" + coffee + ", price=" + price + "]";
	}
	

}
