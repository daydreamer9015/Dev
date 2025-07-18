package basic;

public class PolyMain {
	public static void main(String[] args) {
		//부모타입 변수가 부모 인스턴스 참조
		Parent parent = new Parent();
		parent.parentMethod();
		
		//자식타입 변수가 자식 인스턴스 참조
		Child child = new Child();
		child.childMethod();
		child.parentMethod();		// Child는 Parent에서 상속받은 것이 있기 때문에 호출 가능함
		
		//부모 타입 변수가 자식 인스턴스 참조 (다형적 참조)
		Parent poly = new Child();
		poly.parentMethod();
		//poly.childMethod();			// poly라는 변수는 부모 타입에 있는 Parent에서 받아오기 때문에 자식 타입 Child에 있는 childMethod를 메모리 상에는 존재하나 불러올 수 없음  
	}
}
