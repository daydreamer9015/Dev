package clazz;

public class Person {
	private String name;
	private int age;
	
	public Person() {
		
	}

	public Person(String name) {
		//super();
		this.name = name;
	}

	public Person(String name, int age) {
		//super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
