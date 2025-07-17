package extend6;
/*
 * * 멤버십 프로그램 구현하시오.
 * 		- 회사에서 고객 정보를 활용하여 맞춤형 서비스를 제공하고자 함
 * 		- 일반 고객(Customer), 우수 고객(VIPCustomer)에 맞춘 서비스를 제공하고자 함
 * 		- 물품을 구매할 때 적용되는 할인율과 적립되는 포인트 비율이 다름
 * 		- 클래스 상속을 활용하여 멤버십 구현하기 
 */
public class CustomerMain {
	public static void main(String[] args) {
		int price = 10000;
		
		Customer customer1 = new Customer(1001, "이순신");
		System.out.println("=== 일반 고객 정보 ===");
		System.out.println(customer1.showCustomerInfo());
		System.out.println("상품 가격: " + price + "원");
		int paid = customer1.calcPrice(price);
		System.out.println("지불 금액: " + paid + "원");
		System.out.println(customer1.showInfoAfterPurchase());
		System.out.println();
		
		VIPCustomer customer2 = new VIPCustomer(1002, "신사임당", 12345);
		System.out.println("=== VIP 고객 정보 ===");
		System.out.println(customer2.showCustomerInfo());
		System.out.println("상품 가격: " + price + "원");
		int paidVIP = customer2.calcPrice(price);
		System.out.println("할인 적용 지불 금액: " + paidVIP + "원 (10% 할인)" );
		System.out.println(customer2.showInfoAfterPurchase());
		System.out.println();
		
		System.out.println("=== 혜택 비교 ===");
		System.out.println("일반 고객 지불액: " + customer1.calcPrice(price) + "원");
		System.out.println("VIP 고객 지불액: " + customer2.calcPrice(price) + "원");
		System.out.println("VIP 할인 혜택: " + (int)(price*0.1) + "원");
	}
}
