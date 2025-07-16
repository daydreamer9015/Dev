package clazz;

/*
 * 메가 커피 관리 - 기본 객체 생성과 사용
 */
public class MegacoffeeMain1 {
	public static void main(String[] args) {
		
		// 첫번째 메뉴 아이템 객체 - 아메리카노
		MegacoffeeItem coffee = new MegacoffeeItem();		
		coffee.name = "아메리카노";
		coffee.price = 4500;
		coffee.category = "커피";
		coffee.temp = true;
		// 두번째 메뉴 아이템 객체 - 디저트
		MegacoffeeItem cake = new MegacoffeeItem();		
		cake.name = "뉴욕 치즈케이크";
		cake.price = 6800;
		cake.category = "디저트";
		cake.temp = false;
	
		// 메뉴 출력
		System.out.println("=== ☕ 메가 커피 인기 메뉴 ===");
		
		MegacoffeeItem[] items = new MegacoffeeItem[2];
		items[0] = coffee;
		items[1] = cake;
		
		for(MegacoffeeItem item : items) {
			System.out.println("메뉴: "+item.name+" | 가격: "+item.price+" | 분류: "+item.category+" | 온도: "+(item.temp ? "HOT 🔥" : "COLD ❄️"));
		}
	}
}
