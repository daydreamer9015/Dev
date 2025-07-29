package lambda3;

public class PrintStringMain {
	public static void main(String[] args) {
		// 매개변수로 전달되는 람다식 만들기
		PrintString lambdaStr = s -> System.out.println(s);
		lambdaStr.showString("Hello, Choongang!");
		
		showString2(lambdaStr);
		
		PrintString prStr = showString3();
		prStr.showString("Hello, ");
	}
	
	public static void showString2(PrintString p) {
		p.showString("Hello, Choongang2!");
	}
	
	public static PrintString showString3() {
		return s -> System.out.println(s + "Choongang3!");
	}
}
