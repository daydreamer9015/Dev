package operator;
/*
 * * 증감 연산자
 * - 1만큼 증가시키거나 1만큼 감소시킴
 * - 값이 1씩 증가하거나 1씩 감소할 때가 아주 많기 때문에 이런 편의 기능을 제공함
 */
public class Operator3 {
	public static void main(String[] args) {
		int a = 0;
		
		a = a + 1;
		System.out.println("a = "+ a);
		a = a + 1;
		System.out.println("a = "+ a);
		
		// 증감 연산자 테스트
		++a; // = (a = a + 1)
		System.out.println("a = " + a);
		++a;
		System.out.println("a = " + a);
		
		// 앞에 있으면 전위, 뒤에 있으면 후위
		// 전위, 후위 증감 연산자
		a = 1;
		int b = 0;
		b = ++a;	// a의 값을 증가시키고 그 결과를 b에 대입
		System.out.println("a = " + a + ", b = " + b);
		
		a = 1;
		b = 0;
		b = a++;	// a의 현재값을 먼저 b에 할당하고 그 다음에 a가 증가됨
		System.out.println("a = " + a + ", b = " + b);
	}
}
