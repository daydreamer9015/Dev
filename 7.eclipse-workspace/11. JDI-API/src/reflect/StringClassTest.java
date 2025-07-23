package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StringClassTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Class strClass = Class.forName("java.lang.Math");	//java.lang.Object, java.lang.String 등 다양하게 넣어서 확인 가능
		
		Constructor[] constructors = strClass.getConstructors();
		for(Constructor c : constructors) {
			System.out.println(c);
		}
		System.out.println();
		
		Field[] fields = strClass.getFields();
		for(Field f : fields) {
			System.out.println(f);
		}
		System.out.println();
		
		// 모든 메서드 가져오기
		Method[] methods = strClass.getMethods();
		for(Method m : methods) {
			System.out.println(m);
		}
	}
}
