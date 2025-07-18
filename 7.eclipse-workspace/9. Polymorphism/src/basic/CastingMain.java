package basic;

public class CastingMain {
	public static void main(String[] args) {
		// 부모 타입 변수가 자식 인스턴스 참조(다형적 참조)
		Parent poly = new Child();	// 업 캐스팅(자동형변환)
		//poly.childMethod();		// 자식의 기능은 호출 불가. 컴파일 오류 발생
		
		//다운 캐스팅 (부모 타입을 자식 타입으로)
		Child child = (Child)poly;	//원래 Parent 급에서 형성된 poly가 (Child)를 통해 자식 타입으로 다운 캐스팅 됨. 타입을 지정하면 참조 대상을 특정 타입으로 변경
		child.childMethod();
	}
}