package string;

public class StringDemo2 {
	public static void main(String[] args) {
		String javaStr = new String("java");
		String androidKotlin = new String("androidKotlin");
		System.out.println(javaStr);
		System.out.println("javaStr 문자열객체 주소값: " + System.identityHashCode(javaStr));
		
		// 문자열 javaStr과 문자열 androidKotlin 연결하여 javaStr에 다시 할당
		javaStr = javaStr.concat(androidKotlin);
		System.out.println(javaStr);
		System.out.println("연결 후 javaStr 문자열객체 주소값: " + System.identityHashCode(javaStr));
	}
}
