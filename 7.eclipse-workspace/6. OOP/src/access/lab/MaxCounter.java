package access.lab;

public class MaxCounter {
	private int count = 0;
	private int max;		// 생성자에서 어떤 값을 받느냐에 따라 초기화가 달라질 수 있기 때문에 최대 허용한 카운터 값을 저장하는 용도로만 필드 설정
	
	// 객체 생성 시에 최대값을 설정하는 생성자로 만들어짐
	public MaxCounter(int max) {		// 매개변수로 받는 max 값을 인스턴스 생성할 때 인스턴스 변수에 값이 초기화(저장) 이렇게 하면 기본 생성자는 포함이 안 됨
		this.max = max;
	}
	
	// public 메서드 : 같은 패키지가 아니어도 접근 허용. 외부에서도 멤버변수인 카운터를 증가시킬 수 있도록 허용
	public void increment() {
		if(count >= max) {
			System.out.println("최대값을 초과할 수 없습니다.");
			return;		// 메서드 종료(증가 안됨)
		}
		count++;		// 카운터 증가
	}
	
	public int getCount() {		// count 자체는 private 라서 보이지 않지만 getCount 함수를 통해 private 필드 값을 안전하게 반환할 수 있음
		return count;
	}
}