package interface4;

public class CustomerTest {
	public static void main(String[] args) {
		Customer customer = new Customer();
		
		Buyer buyer = customer;
		buyer.buy();
		
		Seller seller = customer;
		seller.sell();
		System.out.println();
		
		if(seller instanceof Customer) {
			Customer customer2 = (Customer)seller;
			customer2.buy();
			customer2.sell();
		}
	}
}
