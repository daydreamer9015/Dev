package exception3;

public class UserService {
	// 회원 가입 메서드
	public void registerUser(String userId, String password, String email)
		throws UserValidationException {
		System.out.println("사용자 등록 프로세스 시작");
		System.out.println("입력값 - ID: " + userId + ", PWD: " + password + ", Email: " + email);
		
		// 1단계: 사용자 ID 검증
		System.out.println("\n1단계 : 사용자 ID 검증 중...");
		validateUserId(userId);
		System.out.println("사용자 ID 검증 통과");
		
		// 2단계: 패스워드 검증
		System.out.println("\n2단계 : 사용자 패스워드 검증 중...");
		validatePassword(password);
		System.out.println("패스워드 검증 통과");
		
		// 3단계: 이메일 검증
		System.out.println("\n3단계 : 이메일 검증 중...");
		validateEmail(email);
		System.out.println("이메일 검증 통과");
		
		// 4단계: 실제 사용자 등록 --> DB에 저장(insert 쿼리 구동중)
		System.out.println("\n4단계 : 데이터베이스에 사용자 정보 저장");
		System.out.println("사용자 등록이 완료되었습니다. " + userId);
	}
	
	private void validateEmail(String email) throws UserValidationException{
		// null 체크
		if(email == null) throw new UserValidationException("EML001", "이메일은 필수 입력 항목입니다.");
		
		// 이메일 형식 체크
		if(!email.contains("@")) {
			throw new UserValidationException("EML002", "올바른 이메일 형식이 아닙니다. (@ 없음)");
		}
		
		// 이메일 길이 체크
		if(email.length() > 100) {
			throw new UserValidationException("EML003", "이메일은 최대 100자 이하여야 합니다. (현재: " + email.length() + "자)");
		}
	}
	/*
	 * 패스워드 검증 메서드
	 */
	private void validatePassword(String password) throws UserValidationException{

		// null 체크
		if(password == null) {
			throw new UserValidationException("PWD001", "비밀번호는 필수 입력 항목입니다.");
		}
		// 길이 체크
		if(password.length() < 8) {
			throw new UserValidationException("PWD002", "비밀번호는 최소 8자리 이상이어야 합니다. (현재 : " + password.length() + ")");
		}
		if(password.length() > 20) {
			throw new UserValidationException("PWD003", "비밀번호는 최대 20자리 입니다. (현재 : " + password.length() + ")");
		}
		// 영문 대소문자, 숫자 포함 여부 체크
		boolean hasUpper = password.matches(".*[A-Z].*");	// 대문자 포함
		boolean hasLower = password.matches(".*[a-z].*");	// 소문자 포함
		boolean hasDigit = password.matches(".*[0-9].*");	// 숫자 포함
		
		if(!hasUpper | !hasLower | !hasDigit) {
			throw new UserValidationException("PWD004", "패스워드는 대문자, 소문자, 숫자를 모두 포함해야 합니다.");
		}
	}

	private void validateUserId(String userId) throws UserValidationException {
		/*
		 * 사용자 ID 검증 메서드
		 */
		// null 체크
		if(userId == null) {
			throw new UserValidationException("USR001", "사용자 ID는 필수 입력 항목입니다.");
		}
		// 빈 문자열 체크(공백 제거 후)
		if(userId.trim().isEmpty()) {
			throw new UserValidationException("USR002", "사용자 ID는 필수 입력 항목입니다.");
		}
		
		// 최소 길이 체크
		if(userId.length() < 5) {
			throw new UserValidationException("USR003", "사용자 ID는 최소 5자 이상이어야 합니다.");
		}
		// 최대 길이 체크
		if(userId.length() > 20) {
			throw new UserValidationException("USR004", "사용자 ID는 최대 20자 이하여야 합니다. (현재 : " + userId.length() + ")");
		}
	}

}
