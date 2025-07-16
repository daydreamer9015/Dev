package clazz.productorder.step3;

import java.util.Scanner;

public class ProductOrderMainAnswer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int n = scanner.nextInt();	// 정수값 입력받음
        scanner.nextLine();		// nextInt() 후 남아있는 줄바꿈 문자(\n) 제거하기 위해
        
        // 여러 상품의 주문 정보를 담는 배열 생성
        ProductOrder2[] orders = new ProductOrder2[n];
        for(int i = 0; i < orders.length; i++) {
        	System.out.println((i+1) + "번째 주문 정보를 입력하세요.");
        	System.out.print("상품명: ");
        	String product = scanner.nextLine();
        	
        	System.out.print("가격: ");
        	int price = scanner.nextInt();
        	
        	System.out.print("수량: ");
        	int quantity = scanner.nextInt();
        	scanner.nextLine();
        	
        	orders[i] = createOrder(product, price, quantity);
        }
          	// printOrder()를 사용해서 상품 주문 정보 출력
     		printOrder(orders);
     		// getTotalAmount()를 사용해서 총 결제 금액 계산
     		int totalAmount = getTotalAmount(orders);
     		System.out.println("총 결제 금액: " + totalAmount);
    }
		public static int getTotalAmount(ProductOrder2[] orders) {
			int totalAmount = 0;
			for(ProductOrder2 order : orders) {
				totalAmount += order.price * order.quantity;
			}
			return totalAmount;
			
		}
	
		public static void printOrder(ProductOrder2[] orders) {
			for(ProductOrder2 order : orders) {
				System.out.println("상품명: " + order.product + ", 가격: " + order.price + ", 수량: " + order.quantity);
			}
		}
		public static ProductOrder2 createOrder(String productName, int price, int quantity) {
			ProductOrder2 order = new ProductOrder2();
			order.product = productName;
			order.price = price;
			order.quantity = quantity;
			return order;
		}
}
