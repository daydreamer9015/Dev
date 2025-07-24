package list2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 학생 관리 시스템
 * 	- ArrayList를 활용한 CRUD 작업
 */
public class StudentManagementLab {
	//전역변수
	private static List<Student> students = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 초기 데이터 생성(DB에서 가져올 데이터)
		initializeData();
		
		int choice = 0;
		do {
			// 메뉴 출력
			printMenu();
			choice = scanner.nextInt();
			scanner.nextLine();		//버퍼 비우기
			switch(choice) {
			case 2 : viewAllStudents(); break;
			case 0 : System.out.println("프로그램을 종료합니다."); break;
			default: System.out.println("잘못된 선택입니다.");
			}
		} while(choice != 0);
		scanner.close();
	}

	private static void viewAllStudents() {
		System.out.println();
		System.out.println("==== 전체 학생 목록 ====");
		System.out.println("이름\t나이\t전공\t학점");
		System.out.println("-----------------------------");
		
		for(Student student : students) {
			System.out.println(student.getName()+"\t"+student.getAge()+"\t"+student.getMajor()+"\t"+student.getGpa());
		}
		System.out.println();
		System.out.printf("총 %d명의 학생이 등록되어 있습니다.", students.size());
		System.out.println();
		
	}

	private static void printMenu() {
		System.out.println("\n==== 학생 관리 시스템 ====");
		System.out.println("1. 학생 추가");
		System.out.println("2. 전체 학생 조회");
		System.out.println("3. 학생 검색");
		System.out.println("4. 학생 정보 수정");
		System.out.println("5. 학생 삭제");
		System.out.println("6. 통계 정보");
		System.out.println("0. 종료");
		System.out.print("선택: ");
	}

	private static void initializeData() {
		students.add(new Student("이순신", 20, "컴퓨터공학", 3.8));
		students.add(new Student("신사임당", 21, "경제학과", 3.9));
		students.add(new Student("류성룡", 19, "전자공학과", 4.0));
		students.add(new Student("유관순", 22, "디자인", 4.0));
		students.add(new Student("손흥민", 20, "컴퓨터공학", 3.7));
	}
}
