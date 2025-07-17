package casting;

public class Casting2 {
	public static void main(String[] args) {
		double doubleValue = 1.5;		// 8 byte
		int intValue = 0;		// 4 byte
		
		// intValue = doubleValue;		// 컴파일 오류 발생
		intValue = (int) doubleValue;	// 괄호연산자 사용하여 형변환
		System.out.println(intValue);
	}
}
