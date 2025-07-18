package basic;

public class CastingMain4 {
	public static void main(String[] args) {
		Parent parent = new Child();
		Child child = (Child) parent;
		child.childMethod();	//문제 없음
		
		Parent parent2 = new Parent();
		Child child2 = (Child) parent2;
		child2.childMethod();	//런타임 오류 발생하여 실행 불가
		
		//자기 타입으로 다운캐스팅 하는 경우는 가능
	}
	
	
}
