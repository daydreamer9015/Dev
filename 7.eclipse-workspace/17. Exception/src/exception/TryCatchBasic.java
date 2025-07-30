package exception;

public class TryCatchBasic {
	public static void main(String[] args) {
		// 정수형 배열 생성(크기 5)
		int[] arr = new int[5];
		try {
			for(int i = 0; i <= 5; i++) {
				arr[i] = i;		// i=5일 때 예외 발생
				System.out.println("arr[" + i + "] = " + arr[i]);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			// 예외가 발생했을 때 실행되는 블록
			System.out.println("📛 예외 발생: 배열 인덱스 초과");
			System.out.println("예외 메세지: " + e.getMessage());
		}
		
		System.out.println("✅ 프로그램 정상 종료");
	}
}
