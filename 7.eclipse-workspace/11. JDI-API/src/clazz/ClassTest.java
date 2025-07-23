package clazz;

public class ClassTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Person person = new Person();
		Class pClass = person.getClass();	// getClass()는 슈퍼클래스인 Object의 멤버이므로 다 쓸 수 있음
		System.out.println(pClass.getName());
		
		Class pClass2 = Person.class;	//직접 class 파일을 assign
		System.out.println(pClass2.getName());
		
		Class pClass3 = Class.forName("clazz.Person");	// 클래스 이름으로 가져오기
		System.out.println(pClass3.getName());
	}
}
