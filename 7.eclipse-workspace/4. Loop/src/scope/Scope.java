package scope;

public class Scope {
	public static void main(String[] args) {
		int m = 10;		// m 등장! 생존 시작
		if(true) {
			int x = 20;		// x 등장! 생존 시작
			System.out.println("if m = "+m);   	// 블록 내부에서 블록 외부는 접근 가능. 즉 m 호출 가능
			System.out.println("if x = "+x);  	// 블록 내부에서 설정한 변수인 x 접근 가능
		}	// x 주금 ㅠㅠ
		
		// System.out.println("main x = " + x);	// x 죽어서 없기 때문에 접근 불가! 오류 발생
		System.out.println("main m = " + m);  	// m 변수는 아직 살아있기 때문에 호출, 접근 가능
	}	// m 주금 ㅠㅠ
}
