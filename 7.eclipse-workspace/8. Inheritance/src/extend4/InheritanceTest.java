package extend4;

public class InheritanceTest {
	public static void main(String[] args) {
		testObjectCreate();
		testInheritedMethod();
	}

	private static void testInheritedMethod() {
		// TODO Auto-generated method stub
		
	}

	private static void testObjectCreate() {
		System.out.println("=== 1. 객체 생성 ===");
		
		System.out.println("Dog 객체 생성");
		Dog dog = new Dog("루피", 9, "말티즈");
		
		System.out.println("\nCat 객체 생성");
		Cat cat = new Cat("남구", 10, true);
		System.out.println();
		cat.showInfo();
		
		System.out.println("\n부모 Animal 객체 생성");
		Animal animal = new Animal("동물", 5);
		
		System.out.println("\n");
	}
}
