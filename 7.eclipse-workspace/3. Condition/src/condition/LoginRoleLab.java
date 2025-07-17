package condition;
/*
 * 간단한 로그인 검증 시스템
 * 사용자 인증 로직
 * if-else 조건문 활용한 입력값 검증
 * 역할에 해당하는 것을 입력받는 문자열을 추가하여 코드 작성
 * 역할(role): 관리자, 사용자, 손님
 */
	public class LoginRoleLab {
		public static void main(String[] args) {
			// 사용자가 입력한 로그인 정보
			String inputId = "admin";
			String inputPassword = "0703";
			String inputRole = "게스트";
			
			//시스템에 저장된 실제 로그인 정보
			String correctID = "admin";
			String correctPassword = "0703";
			String correctRole = "관리자";
			
			System.out.println("=== 역할 기반 로그인 시스템 ===");
			System.out.println("입력된 아이디 : " + inputId);
			System.out.println("입력된 비밀번호 : "  + "*".repeat(inputPassword.length()));
			System.out.println("입력된 역할 : " + inputRole);		
			
			// 로그인 검증 로직
			// 1단계 : 아이디 입력되어 있는지 여부 체크
			if (inputId.isEmpty()) {     // 문자열이 비어있는지 확인
				System.out.println("❌  로그인 실패 : 아이디를 입력해주세요.");
			} // 2단계 : 비밀번호가 입력되어 있는지 확인
			  else if (inputPassword.isEmpty()) {
				System.out.println("❌  로그인 실패 : 비밀번호를 입력해주세요.");
				} 
			  // 3단계 : 아이디가 일치하는지 확인
			  else if(!inputId.equals(correctID)) {
					System.out.println("❌  로그인 실패 : 아이디가 올바르지 않습니다.");
				}
			  // 4단계 : 비밀번호가 일치하는지 확인
			  else if(!inputPassword.equals(correctPassword)) {
					System.out.println("❌  로그인 실패 : 비밀번호가 올바르지 않습니다.");
			  }
			  // 5단계 : 모든 검증을 다 통과한 경우
			  else {
				  System.out.println("\n✅ 로그인 성공!");
				  System.out.println("환영합니다. "+ inputRole + "님!");

				  System.out.println(				  
						  switch (inputRole) {
							  case "관리자" -> "관리자 페이지";
							  case "사용자" -> "사용자 대시보드";
							  case "게스트" -> "게스트 페이지";
							  default  -> "게스트 페이지";
							  } 
									  + "로 이동합니다.");



			  }
			
			
			
			
		}
	}
	
