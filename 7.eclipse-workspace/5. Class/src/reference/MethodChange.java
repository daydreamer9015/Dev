package reference;

public class MethodChange {
	public static void main(String[] args) {
		int a = 10;
		System.out.println("메서드 호출 전: a = "+a);
		changePrimitive(a);
		System.out.println("메서드 호출 후: a = "+a);
	}

	public static void changePrimitive(int x) {
		x = 20;
		// 원본에 영향을 주지 않음
	}
	
}
