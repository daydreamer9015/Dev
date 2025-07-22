package interface7;

public class Step1Test {
	public static void main(String[] args) {
		printHeader("   1단계: 기본 인터페이스 설계 완료 확인");
		interfaceCharacteristics();
	}

	private static void interfaceCharacteristics() {
		printSection("  	  인터페이스 특성 확인");
		System.out.println("💡 인터페이스 기본 특성: ");
		System.out.println("   1. 직접 인스턴스화 불가능");
		System.out.println("   2. 추상 메서드와 디폴트 메서드 포함 가능");
		System.out.println("   3. 구현 클래스에서 추상 메서드는 반드시 구현되어야 함");
		System.out.println("   4. 디폴트 메서드는 선택적으로 오버라이드");
		System.out.println();
	}

	private static void printHeader(String title) {
		System.out.println("🟩".repeat(20));
		System.out.println(" " + title);
		System.out.println("🟩".repeat(20));
	}
	
	private static void printSection(String title) {
		System.out.println("--".repeat(18));
		System.out.println(" " + title);
		System.out.println("--".repeat(18));
	}
}
