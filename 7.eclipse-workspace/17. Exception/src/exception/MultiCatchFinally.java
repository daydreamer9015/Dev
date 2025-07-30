package exception;

public class MultiCatchFinally {
	public static void main(String[] args) {
		String[] names = {"Alice", "Bob", null, "David"};
		try {
			for(int i = 0; i <= names.length; i++) {
				System.out.println("이름: " + names[i].toUpperCase());
			}
		} catch(NullPointerException e) {
			// null 참조에 대해 메서드 호출할 때 발생 => null이 들어가서 해당 값이 없는 경우
			System.out.println("\n📛 예외 발생: NullPointerException");
			System.out.println("예외 메세지: " + e.getMessage());
		} catch(ArrayIndexOutOfBoundsException e) {
			// 배열 범위를 초과하면 발생 => "null"이라는 문자열로 인식했을 경우
			System.out.println("\n📛 예외 발생: ArrayIndexOutOfBoundsException");
			System.out.println("예외 메세지: " + e.getMessage());
		} finally {
			// 예외 발생 여부와 관계없이 항상 실행되는 블록
			System.out.println("\n👌 finally 블록: 자원 정리 또는 로그 출력");
		}
		System.out.println("\n✅ 프로그램 정상 종료");
	}
}
