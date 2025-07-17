package constructor8;

public class StudentMain {
	public static void main(String[] args) {
		
		//1. 기본 생성자 사용
		Student student1 = new Student();
		student1.displayInfo();
		
		//2. 이름만 매개변수로 받는 생성자 사용
		Student student2 = new Student("이순신");
		student2.displayInfo();
		
		//3. 이름과 나이를 매개변수로 받는 생성자 사용
		Student student3 = new Student("신사임당", 20);
		student3.displayInfo();
		
		//4. 모든 필드를 매개변수로 받는 생성자 사용
		Student student4 = new Student("류성룡", 22, "컴퓨터공학 LLM");
		student4.displayInfo();
		
		System.out.println();
		System.out.println("=== 생성자 오버로딩 완료 ===");
	}
}
