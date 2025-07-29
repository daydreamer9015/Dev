package lambda;

public class MyNumberTest {
	public static void main(String[] args) {
		// 람다식을 인터페이스형 변수 max에 대입
		// 함수형 인터페이스로 사용하려면 추상메서드는 반드시 하나만 있어야 함
		// 여러 개 있으면 어떤 걸 실행할 지 오류남
		MyNumber max = (x, y) -> (x >= y) ? x : y;
		// 인터페이스형 변수로 해당 메서드 호출
		System.out.println(max.getMax(10, 20));
	}
}
