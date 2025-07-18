package super2;

public class ClassB extends ClassA{
	public ClassB(int a) {
		//super();		기본 생성자 생략 가능
		this(a, 0);		//super() 대신에 this()를 한번 쓸 수는 있지만 결과적으로 super()를 써줘야함
		System.out.println("ClassB 생성자 a= " + a);
	}
	public ClassB(int a, int b) {
		//super();		기본 생성자 생략 가능
		System.out.println("ClassB 생성자 a= " + a + ", b= " + b);
	}
}
