package basic;

public class CastingMain3 {
	public static void main(String[] args) {
		Child child = new Child();
		Parent parent1 = (Parent)child;		//부모 타입은 자식 타입을 이미 참조하고 있으므로 업캐스팅((Parent))을 생략해도 형변환이 가능하고 이 생략을 권장함
		Parent parent2 = child;				//업캐스팅 생략한 상태
		Parent parent3 = new Child();
		
		parent1.parentMethod();
		parent2.parentMethod();
		parent3.parentMethod();
	}
}
