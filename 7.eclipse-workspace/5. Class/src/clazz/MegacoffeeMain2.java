package clazz;

/*
 * 메가 커피 관리 - 배열을 이용한 여러 메뉴 관리하기
 * - 배열과 향상된 for문 사용하기
 */
public class MegacoffeeMain2 {
	public static void main(String[] args) {
		
		// 첫번째 메뉴 아이템 객체 - 아메리카노
		MegacoffeeItem coffee = new MegacoffeeItem();		
		coffee.name = "아메리카노";
		coffee.price = 4500;
		coffee.category = "커피";
		coffee.temp = true;
		
		// 두번째 메뉴 아이템 객체 - 카페라떼
		MegacoffeeItem latte = new MegacoffeeItem();		
		latte.name = "카페라떼";
		latte.price = 5500;
		latte.category = "커피";
		latte.temp = true;
		
		// 세번째 메뉴 아이템 객체 - 딸기 에이드
		MegacoffeeItem ade = new MegacoffeeItem();
		ade.name = "딸기 에이드";
		ade.price = 6000;
		ade.category = "음료";
		ade.temp = false;
		// 메뉴 출력
		System.out.println("=== ☕ 메가 커피 전체 메뉴 ===");
		
		MegacoffeeItem[] items = new MegacoffeeItem[3];
		items[0] = coffee;
		items[1] = latte;
		items[2] = ade;
		
		for(MegacoffeeItem item : items) {
			System.out.println("메뉴: "+item.name+" | 가격: "+item.price+" | 분류: "+item.category+" | 온도: "+(item.temp ? "HOT 🔥" : "COLD ❄️"));
		}
	}
}
