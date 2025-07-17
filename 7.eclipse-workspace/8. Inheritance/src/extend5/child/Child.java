package extend5.child;

import extend5.parent.Parent;

public class Child extends Parent{
	public void call() {
		publicValue = 1;
		protectedValue = 2;
		// defaultValue = 3;	// 부모 클래스와 패키지가 달라져서 접근이 불가해짐. 컴파일 오류 발생
		// privateValue = 4;	// 상동. 같은 클래스 내부에서만 접근 가능함
		
		publicMethod();
		protectedMethod();		// 위 두 메서드는 상속 관계이기때문에 패키지가 달라져도 확인 가능. 원래 메서드는 상속 관계이거나 같은 패키지 안에서만 확인 가능함
		//defaultMethod();		// 다른 패키지라서 접근 불가함. 컴파일 오류 발생
		//privateMethod();		// 상동. 같은 클래스 내부에서만 접근 가능함
		
		printParent();
	}
}
