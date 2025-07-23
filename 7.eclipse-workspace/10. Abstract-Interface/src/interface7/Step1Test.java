package interface7;

public class Step1Test {
	public static void main(String[] args) {
		printHeader("   1단계: 기본 인터페이스 설계 완료 확인");
		interfaceCharacteristics();
		interfaceInfo();
		printCompletion();
	}

	private static void printCompletion() {
		printSection("🎉 1단계 완료!");
		
		System.out.println("☑️ 완료된 내용: ");
		System.out.println("   * 추상 메서드 vs 디폴트 메서드 차이점 이해");
		System.out.println("   * 단일 책임 원칙에 따라 인터페이스 분리 설계");
		System.out.println("   * 디폴트 메서드 충돌 상황 인식");
		System.out.println("   * 인터페이스의 기본 특성 확인");
		System.out.println();
		
		System.out.println("🚀 다음 단계 preview");
		System.out.println("   2단계: PremiumPayable extends Payable (인터페이스 상속)");
		System.out.println();
	}

	private static void interfaceInfo() {
		printSection("🗒️ 생성된 인터페이스 정보");
		
		// Payable interface 정보 구현
		System.out.println("⚪ Payable Interface");
		System.out.println("  📍목적 : 기본 결제 기능 정의");
		System.out.println("  📍추상 메서드 : ");
		System.out.println("    - processPayment(double amount) : boolean");
		System.out.println("     |--- 결제 처리 핵심 로직 (구현 필수)");
		System.out.println("  📍디폴트 메서드 : ");
		System.out.println("    - calculateFee(double amount) : double");
		System.out.println("     |--- 기본 수수료 2% 적용 (오버라이딩 가능)");
		System.out.println("    - getPaymentMethod() : String");
		System.out.println("     |--- 결제 방법명 반환 (오버라이딩 가능)");
		System.out.println();
		
		// Refundable interface 정보 구현
		System.out.println("⚪ Refundable Interface");
		System.out.println("  📍목적 : 환불 기능 정의");
		System.out.println("  📍추상 메서드 : ");
		System.out.println("    - processRefund(double amount) : boolean");
		System.out.println("     |--- 환불 처리 핵심 로직 (구현 필수)");
		System.out.println("  📍디폴트 메서드 : ");
		System.out.println("    - calculateFee(double amount) : double");
		System.out.println("     |--- 환불 수수료 1% 적용 (오버라이딩 가능)");
		System.out.println("    - getRefundPeriod() : int");
		System.out.println("     |--- 환불 가능 기간 7일 (오버라이딩 가능)");
		System.out.println();
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
