package object;

public class StringHashCodeDemo {
	public static void main(String[] args) {
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		
		System.out.println(str1.hashCode());	//"Hello" 문자열의 해시코드값
		System.out.println(str2.hashCode());
	}
}
