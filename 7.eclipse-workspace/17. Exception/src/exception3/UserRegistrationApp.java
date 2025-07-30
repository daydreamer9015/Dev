package exception3;

public class UserRegistrationApp {
	public static void main(String[] args) {
		System.out.println("사용자 ID, 패스워드, 이메일 등록 검증");
		UserService userService = new UserService();
		
		// 2차원 배열 -- [사용자 ID, 패스워드, 이메일, 설명]
		String[][] registerCase = {
				{"dev001", "Securepass123", "dev001@gmail.com", "정상 케이스"},
				{"dev002", "TestPass123", "dev002@gmail.com", "정상 케이스"},
				{null, "dev00333", "dev003@gmail.com", "ID가 null"},
				{"dev004", null, "dev004@gmail.com", "패스워드가 null"},
				{"dev005", "Testpass123", null, "이메일이 null"},
				{"dev006", "abcdefghijk", "dev006@gmail.com", "패스워드에 대문자, 숫자 없음"},
				{"dev007", "Securepass123", "dev007gmail.com", "이메일에 @ 없음"}
		}; 
		// 각각의 케이스를 순서대로 실행
		for(int i = 0; i < registerCase.length; i++) {
			String userId = registerCase[i][0];
			String password = registerCase[i][1];
			String email = registerCase[i][2];
			String description = registerCase[i][3];
			
			System.out.println("\n테스트 케이스 " + (i + 1) + "/" + registerCase.length);
			System.out.println("테스트 시나리오: " + description);
			
			try {
				userService.registerUser(userId, password, email);
				System.out.println("결과 : 등록 성공");
			} catch (UserValidationException e) {
				
				// e.printStackTrace();
				// 커스텀 예외 처리
				System.out.println("결과 : 등록 실패");
				System.out.println("에러 코드 : " + e.getErrorCode());
				System.out.println("에러 메세지 : " + e.getMessage());
				
				// 에러 코드별 다른 처리
				handleErrorCode(e.getErrorCode(), e.getMessage());
			}
			System.out.println("-".repeat(60));
		}
		System.out.println("테스트 케이스 실행 완료");
	}
	/*
	 * 에러 코드별 처리 메서드
	 * 에러 코드에 따라 다른 로직을 수행할 수 있음
	 */
	private static void handleErrorCode(String errorCode, String message) {
		System.out.println("에러 코드별 후속 처리: ");
		// 에러 코드 앞 세 자리로 구분
		String category = errorCode.substring(0, 3);
		
		switch(category) {
		// 여기에서 로그 기록, 알림 발송 등을 할 수 있음
		case "USR" : 
			System.out.println("카테고리: 사용자 ID 관련 오류"); 
			System.out.println("권장 조치: 사용자에게 ID 입력 가이드 제공");
			logUserIdError(errorCode, message);
			break;
		case "PWD" : 
			System.out.println("카테고리: 패스워드 관련 오류");
			System.out.println("권장 조리: 사용자에게 패스워드 입력 가이드 제공");
			logUserPwdError(errorCode, message);
			break;
		case "EML" : 
			System.out.println("카테고리: 이메일 관련 오류");
			System.out.println("권장 조치: 사용자에게 이메일 입력 가이드 제공");
			logUserEmailError(errorCode, message);
			break;
		
			default:
				System.out.println("카테고리: 알 수 없는 오류");
				System.out.println("권장 조치: 시스템 관리자에게 문의하세요.");
				break;
		}
	}
	private static void logUserEmailError(String errorCode, String message) {
		System.out.println("로그 기록: [USER_EML_ERROR] " + errorCode + " - " + message);
	}
	private static void logUserPwdError(String errorCode, String message) {
		System.out.println("로그 기록: [USER_PWD_ERROR] " + errorCode + " - " + message);
	}
	/*
	 * 사용자 ID 관련 오류 로깅
	 */
	private static void logUserIdError(String errorCode, String message) {
		// log4j, logback
		System.out.println("로그 기록: [USER_ID_ERROR] " + errorCode + " - " + message);
	}
}
