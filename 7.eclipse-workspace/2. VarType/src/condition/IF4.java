package condition;
/*
 * 온라인 쇼핑몰 할인 시스템 개발
 * 	- 조건
 * 		- 한 사용자가 어떤 상품을 구매할 때, 할인 조건은 다음과 같음
 * 			- 아이템 가격이 10,000원 이상일 때, 1,000원 할인
 * 			- 나이가 20살일 때 1,000원 할인
 * 
 *  		=> 한 사용자가 동시에 여러 할인을 받을 수 있음
 *  	- 출력 결과 예시
 *  		- 10000원 이상 구매, 1000원 할인
 *  		- 성년 1000원 할인
 *  		- 총 할인 금액 : 2000원 할인
 */
public class IF4 {
	public static void main(String[] args) {
		// price, age, discount
		int price = 10000;
		int age = 20;
		int discount = 0;
		
		if(price >= 10000) {
			discount += 1000;
			System.out.println("10000원 이상 구매, 1000원 할인");
		}
		if(age == 20) {
			discount += 1000;
			System.out.println("성년 1000원 할인");
		}		
		System.out.println("총 할인 금액 : " + discount +"원 할인");
		
	}		
}
