package access.a;

public class AccessDataMain {
	public static void main(String[] args) {
		AccessData data = new AccessData();
		
		// public 호출 가능 
		data.publicField = 1;
		data.publicMethod();
		
		// 같은 패키지에 있는 default 호출 가능
		data.defaultField = 2;
		data.defaultMethod();
		System.out.println();
		
		// private은 같은 패키지여도 호출 불가함
		// data.privateField = 3;
		// data.privateMethod();
		
		data.innerAccess();		// innerAccess 안에 private 요소가 있어도 그 요소는 같은 패키지 내에서 호출된 것이기 때문에 이곳에서도 출력이 가능함
	}
	
}
