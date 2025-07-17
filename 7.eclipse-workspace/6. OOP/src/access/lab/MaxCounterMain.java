package access.lab;
/*
 * (출력)
 * 		최대값을 초과할 수 없습니다.
 * 		3
 */

public class MaxCounterMain {
	public static void main(String[] args) {
		MaxCounter counter = new MaxCounter(3);		// 최대값 3으로 설정
		
		// 카운터 4번 증가 시도
		counter.increment();		// 변수를 count로 두고 increment라는 함수가 실행되면 count = 1
		counter.increment();		// count = 2
		counter.increment();		// count = 3
		counter.increment();		// count = 4가 나올 차례인데 위에서 최대값을 3으로 설정했기 때문에 최대값 초과 메시지가 출력되고 최대값은 3으로 유지
		int count = counter.getCount();
		System.out.println(count);
	}
}