package polymorphism.ver2;

public class Cat extends Animal{
	//	@Override    시그니처가 같으면 오버라이드 표시가 없어도 이미 오버라이드 된 것
	public void sound() {
		System.out.println("냥냥");
	}
}
