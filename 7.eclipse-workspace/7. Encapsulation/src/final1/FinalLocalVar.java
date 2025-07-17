package final1;

public class FinalLocalVar {
	public static void main(String[] args) {
		final int data1;
		data1 = 100;		// 최초 한번만 할당 가능
		//data1 = 10;			// 컴파일 오류. final 붙은 건 한번만 할당 가능하기 때문에
		
		final int data2 = 200;
		//data2 = 20;			// 컴파일 오류. final 붙으면 한번만 값 할당 가능
		
		method(300);
	}

	// final 매개변수
	private static void method(final int parameter) {
		//parameter = 200;		// 이미 호출하면서 값이 정해진 것이라서 다시 값을 넣으면 컴파일 오류 발생함
		
	}
}
