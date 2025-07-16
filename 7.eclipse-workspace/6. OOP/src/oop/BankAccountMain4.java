package oop;

public class BankAccountMain4 {
	public static void main(String[] args) {
		// BankAccountData 객체 생성
		BankAccount account = new BankAccount();
		
		// 계좌 개설
		account.open();		// open이라는 method를 생성하고 호출함
		
		// 입금
		account.deposit(5000);
		
		// 입금
		account.deposit(3000);
		
		// 출금
		account.withdraw(2000);
		System.out.println();
		
		// 계좌 정보 확인
		account.showStatus();		
		
		// 계좌 닫기
		account.close();
	}
}
