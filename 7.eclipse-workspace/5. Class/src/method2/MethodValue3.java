package method2;

public class MethodValue3 {
	public static void main(String[] args) {
		int num1 = 5;
		System.out.println("1. changeNumber() 호출 전, num1: " + num1);
		num1 = changeNumber(num1);
		System.out.println("2. changeNumber() 호출 후, num1: " + num1);
	}

	private static int changeNumber(int num2) {
		num2 *= 2;
		return num2;
	}
	
}
