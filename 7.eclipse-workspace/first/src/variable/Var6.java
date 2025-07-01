package variable;

public class Var6 {
	public static void main(String[] args) {
		
		int a = 10, b = 3;
		
		System.out.println("=== 간단한 계산기 ===");		
		System.out.println("숫자1: "+ a);
		System.out.println("숫자2: "+ b);
		System.out.println();
		
		int addition = a + b;
		System.out.println("덧셈: "+a+" + "+b+" = "+addition);
		int substraction = a - b;
		System.out.println("뺄셈: "+a+" - "+b+" = "+substraction);
		int multiplication = a * b;
		System.out.println("곱셈: "+a+" * "+b+" = "+multiplication);
		int division = a / b;
		System.out.println("나눗셈: "+a+" / "+b+" = "+division);
		int remainder = a % b;
		System.out.println("나머지: "+a+" % "+b+" = "+remainder);
	}
}
