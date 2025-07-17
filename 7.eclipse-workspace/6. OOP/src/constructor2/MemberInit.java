package constructor2;

public class MemberInit {
	String name;
	int age;
	int grade;

	void initMember(String name, int age, int grade) {
		this.name = name;		// 오른쪽의 name은 매개변수값 
		this.age = age;			// this.은 인스턴스 자신의 참조값. 이름이 다르면 this 삭제해도 되지만 변수 이름이 같을 때는 this를 반드시 써줘야함
		this.grade = grade;		// this를 통해 인스턴스 멤버변수에 접근한 것
	}
}
