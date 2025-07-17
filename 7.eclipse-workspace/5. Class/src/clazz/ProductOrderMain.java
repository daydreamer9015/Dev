package clazz;

public class ProductOrderMain {
	public static void main(String[] args) {
		ProductOrder tofu = new ProductOrder();
		tofu.productName = "두부";
		tofu.productPrice = 2000;
		tofu.productQuantity = 2;
		
		ProductOrder kimchi = new ProductOrder();
		kimchi.productName = "김치";
		kimchi.productPrice = 5000;
		kimchi.productQuantity = 1;
		
		ProductOrder cola = new ProductOrder();
		cola.productName = "콜라";
		cola.productPrice = 1500;
		cola.productQuantity = 2;
		
		ProductOrder[] items = new ProductOrder[3];
		items[0] = tofu;
		items[1] = kimchi;
		items[2] = cola;
		
		int total = 0;
		for(ProductOrder order : items) {
			System.out.println("상품명: "+order.productName+", 가격: "+order.productPrice+", 수량: "+order.productQuantity);
			total += order.productPrice * order.productQuantity;
		}
			System.out.println("총 결제 금액: "+total);
	}
}
