package super2;

public class ClassC extends ClassB{		// ClassB에 기본 생성자가 없어서 상속받을 수가 없기 때문에 ClassC에 빨간 밑줄이 생성됨
	public ClassC() {
		super(10, 20);
		System.out.println("ClassC 생성자");
		/*
		 * 생성자는 하나만 호출할 수 있음. 그런데 부모인 ClassB에 기본 생성자가 없음
		 * 원래는 기본생성자인 super();가 컴파일러에 의해 자동 생성되는데, ClassB에는 기본 생성자가 없으니 ClassB에 있는 생성자를 직접 호출하면 오류가 없어짐 
		 */
	}
}
