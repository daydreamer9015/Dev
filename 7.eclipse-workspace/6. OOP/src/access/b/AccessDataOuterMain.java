package access.b;

import access.a.AccessData;

public class AccessDataOuterMain {
	public static void main(String[] args) {
		AccessData data = new AccessData();
		
		// public 호출 가능
		data.publicField = 11;
		data.publicMethod();
		System.out.println();
		
		// 다른 패키지의 default 호출 불가
		// data.defaultField = 22;
		// data.defaultMethod();
		
		// 다른 패키지의 private 호출 불가
		// data.privateField = 33;
		// data.privateMethod();
		
		data.innerAccess();
	}
}
