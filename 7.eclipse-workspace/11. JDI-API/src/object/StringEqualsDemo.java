package object;

public class StringEqualsDemo {
	public static void main(String[] args) {
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		
		System.out.println(str1 == str2);	// 두 인스턴스 주소값 같은지 비교
		System.out.println(str1.equals(str2));	// 두 인스턴스의 문자열값이 같은지 비교
	}
}
