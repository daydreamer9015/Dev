package clazz;

public class ShopStart4 {
	public static void main(String[] args) {
		// 클래스를 사용하여 상품 객체 생성
		Product iphone = new Product();		// 새로운 상품 생성. 실제 메모리에 올라간 상태 (메모리 주소: 0x100)
		
		// 아이폰 상품 정보 설정(초기화)
		iphone.name = "아이폰 17";
		iphone.price = 1200000;
		iphone.stock = 50;
		iphone.category = "전자제품";
		
		// 신발 상품 생성과 변수 선언
		Product sneakers = new Product();	// 새로운 상품 생성 (메모리 주소: 0x200)
		
		// 신발 상품 정보 설정(초기화)
		sneakers.name = "나이키 에어맥스";
		sneakers.price = 150000;
		sneakers.stock = 30;
		sneakers.category = "신발";
		
		// 상품 객체들을 배열로 관리
		// 객체 배열을 사용하면 여러 상품을 좀 더 체계적으로 관리 가능함
		Product[] inventory = new Product[2];
		inventory[0] = iphone;		// 첫번째 상품 assign
		inventory[1] = sneakers;	// 두번째 상품 assign
		
		// 배열을 통해 재고 상품 목록 출력
		
		System.out.println("=== 쇼핑몰 상품 정보(클래스 사용) ===");
		
		for(int i = 0; i <inventory.length; i++) {
			System.out.println("상품 " + (i+1) + "- 상품명: " + inventory[i].name + " | 가격: " + inventory[i].price + "원 | 재고: " + inventory[i].stock + "개 | 카테고리: " + inventory[i].category);
		}
		
				
		// 클래스 사용하면 관련 데이터가 하나로 묶여있기 때문에 관리가 용이해짐
//		System.out.println("=== 쇼핑몰 상품 정보(클래스 사용) ===");
//		System.out.println("상품명: "+iphone.name+" | 가격: "+iphone.price+"원 | 재고: "+iphone.stock+"개 | 카테고리: "+iphone.category);
//		System.out.println("상품명: "+sneakers.name+" | 가격: "+sneakers.price+"원 | 재고: "+sneakers.stock+"개 | 카테고리: "+sneakers.category);
//		
//		System.out.println();
//		System.out.println(inventory[0].name);
//		System.out.println(inventory[1].name);
	}
}