package constructor4;

public class SimpleAccount {
	String accountNumber;
	String ownerName;
	long balance;
	
	/*
	 * 생성자를 개발자가 명시적으로 정의(추가)하지 않으면 컴파일러가 자동으로 기본 생성자를 생성함
	 * 기본생성자 : public SimpleAccount() {}
	 */
	
	void printInfo() {
		System.out.println("계좌번호: " + accountNumber + ", 예금주: " + ownerName + ", 잔액: " + balance + "원");
	}
}