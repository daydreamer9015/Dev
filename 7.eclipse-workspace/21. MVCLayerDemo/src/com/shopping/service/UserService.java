package com.shopping.service;

import com.shopping.model.User;
import com.shopping.repository.UserRepository;
import com.shopping.util.ValidationUtils;

/*
 * 사용자 관련된 비즈니스 로직을 처리하는 서비스 클래스
 * 	- 로그인 인증 처리
 * 	- 잔액 관리
 */
public class UserService {
	// 데이터 접근
	private UserRepository userRepository;
	
	// UserService 생성자 : UserRepository 인스턴스 생성
	public UserService() {
		userRepository = new UserRepository();
	}
	/*
	 * 회원 가입 처리 메서드 - ID 중복 불가, 패스워드 최소 4자리, 이름 필수, 초기 잔액 10000원 부여
	 */
	public User register(String id, String password, String name) {
		// 입력값 검증 (한 곳에 모아서 처리)
		
		 validateRegisterInput(id, password, name);
		
		// 비즈니스 로직1. ID 중복 불가
		if(userRepository.existsById(id)) {
			throw new RuntimeException("이미 존재하는 ID입니다: " + id);
		}

		// 비즈니스 로직5. 회원가입하고자 하는 User 객체 생성
		User user = new User(id, password, name.trim());
		
		// Repository 기능 호출
		User savedUser = userRepository.save(user);
		System.out.println("새 사용자 등록: " + savedUser.getId());
		return savedUser;
	}
	/*
	 * 회원 가입 입력값 검증
	 */
	private void validateRegisterInput(String id, String password, String name) {
		ValidationUtils.requireNonEmpty(id, "ID를 입력해주세요.");
		ValidationUtils.requireMinLength(password, 4, "패스워드는 최소 4자리 이상이어야 합니다.");
		ValidationUtils.requireNonEmpty(name, "이름을 입력해주세요.");
		ValidationUtils.requireMinLength(name.trim(), 2, "이름은 2글자 이상이어야 합니다.");
	}
}
