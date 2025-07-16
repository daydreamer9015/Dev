package clazz.productorder.step3;

import java.util.Scanner;

public class ProductOrderMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int count = Integer.parseInt(scanner.nextLine());

        ProductOrder[] orders = new ProductOrder[count];

        for (int i = 0; i < count; i++) {
            System.out.printf("%d번째 주문 정보를 입력하세요.\n", i + 1);

            System.out.print("상품명: ");
            String product = scanner.nextLine();

            System.out.print("가격: ");
            int price = Integer.parseInt(scanner.nextLine());

            System.out.print("수량: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            orders[i] = new ProductOrder(product, price, quantity);
        }

        int total = 0;
        for (ProductOrder order : orders) {
            System.out.printf("상품명: %s, 가격: %d, 수량: %d\n", order.product, order.price, order.quantity);
            total += order.price * order.quantity;
        }

        System.out.printf("총 결제 금액: %d\n", total);
    }
}
