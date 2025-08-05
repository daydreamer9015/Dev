package model;

public class CartItem {
	private Product product;
	private int quantity;	
	
	public CartItem(Product product, int quantity) {
		//super();
		this.product = product;
		this.quantity = quantity;
	}
	
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void addQuantity(int amount) {
		quantity += amount; 
	}
	
	public int getTotalPrice() {
		return product.getPrice() * quantity;
	}

	@Override
	public String toString() {
		return String.format("%s x %d개 = %,d원", product.getName(), quantity, getTotalPrice());
	}
	
}
