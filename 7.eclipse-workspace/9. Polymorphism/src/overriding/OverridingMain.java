package overriding;

public class OverridingMain {
	public static void main(String[] args) {
		//자식변수가 자식인스턴스를 참조하는 형태
		Child child = new Child();
		child.method();
		
		//부모변수가 부모인스턴스를 참조하는 형태
		Parent parent = new Parent();
		parent.method();
		
		//다형적 참조 - 부모 변수가 자식 인스턴스를 참조한 경우
		Parent poly = new Child();
		System.out.println("Value = " + poly.value);	//변수는 오버라이딩과 무관함
		poly.method();	//메서드 오버라이딩
	}
}
