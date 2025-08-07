package com.shopping;

/*
 * == 메인 메뉴 ==
 * 로그인되지 않음
 * 
 * 1. 사용자 관리
 * 2. 상품 보기
 * 3. 주문 관리
 * 0. 종료
 * 
 * 선택 : 1
 * 
 * == 사용자 관리 메뉴 ==
 * 1. 회원 가입
 * 2. 로그인
 * 3. 로그아웃
 * 4. 내 정보 보기
 * 0. 돌아가기
 * 
 * 선택 : 1
 * 
 * == 회원 가입 ==
 * 아이디 (3자 이상, 영문/숫자):
 * 패스워드 (4자 이상):
 * 이름:
 * 
 * 새로 생성됩니다.
 * 새 사용자 등록!
 * 회원 가입 성공!
 * 
 * 	환영합니다. [사용자]님!
 * 	초기 잔액: 10000.0원
 */

/*
 * * 구현 완료 순서
 * 		1) Model Layer
 * 			- User.java
 * 			- Serializable 구현
 * 		2) Persistence Layer
 * 			- FileManager.java
 * 		3) Repository Layer
 * 			- UserRepository.java
 * 			- CRUD 메서드 구현 (쿼리문 요청에 대한 메서드)
 * 			- DAO (Data Access Object)
 * 		4) Service Layer (인증 관련된 것)
 * 			- UserService.java
 * 			- 비즈니스 로직 적용
 * 			- 예외 처리 구현
 * 		5) Util Layer
 * 			- Constants.java
 * 		6) Controller Layer
 * 			- UserController.java
 * 					- 회원 가입 테스트
 * 		7) Main Application
 * 			- Main.java
 */
public class Main {

}
