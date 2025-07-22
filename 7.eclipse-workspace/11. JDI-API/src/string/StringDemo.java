package string;

public class StringDemo {
	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1 == str2);	// 인스턴스(new String)는 매번 힙에 주소번지가 새로 생성되기 때문에 주소값이 다름
		System.out.println(str1.equals(str2));
		System.out.println();
		
		String str3 = "abc";	// 문자열 abc는 상수풀에 저장되어 있음 so 주소값이 같음
		String str4 = "abc";
		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
	}
}
