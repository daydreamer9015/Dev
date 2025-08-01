package main;

import java.time.LocalDate;
import java.util.Scanner;

import exception.LibraryException;
import service.Library;

/*
 * 도서 관리 시스템의 메인 클래스
 * 사용자 인터페이스와 프로그램 실행 담당
 */
public class LibraryManagementSystem {
	private Library library;		// 도서관 서비스 객체
	private Scanner scanner;		// 사용자 입력
	
	public LibraryManagementSystem() throws LibraryException {
		this.library = new Library("중앙도서관");
		this.scanner = new Scanner(System.in);
		initializeData();		// 초기 데이터 설정
	}
// 초기 데이터 설정
	private void initializeData() throws LibraryException{
		// 기본 책 데이터 추가
		library.addBook("2025-1", "혼공자", "이순신", "프로그래밍", LocalDate.of(2025, 01, 01));
		library.addBook("2025-2", "혼공자바", "이순신", "프로그래밍", LocalDate.of(2025, 01, 01));
		library.addBook("2025-3", "혼공파", "이순신", "프로그래밍", LocalDate.of(2025, 01, 01));
		library.addBook("2025-4", "혼공오", "이순신", "프로그래밍", LocalDate.of(2025, 01, 01));
		library.addBook("2025-5", "혼공씨", "이순신", "프로그래밍", LocalDate.of(2025, 01, 01));
		
		// 기본 회원 데이터 추가
		library.addMember("M001", "이순신", "010-1111-3456");
		library.addMember("M002", "신사임당", "010-1111-3456");
		library.addMember("M003", "류성룡", "010-1111-3456");
		
		// 사서 데이터 추기
		library.addLibrarian("L001", "중사서", "010-1234-5678", "대출반납팀", "팀장");
	}


	public static void main(String[] args) throws LibraryException{
		LibraryManagementSystem system = new LibraryManagementSystem();
		system.run();
	}
	
	public void run() {
		System.out.println("==== 도서관 관리 시스템에 오신 걸 환영합니다. ====\n");
		while(true) {
			displayMainMenu();
			
			int choice = Integer.parseInt(scanner.nextLine());
			// 사용자 선택에 따른 메서드 호출
			switch(choice) {
				case 0 :
					System.out.println("도서관 관리 시스템을 종료합니다.");
					scanner.close();
					return;
					default:
						System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
						break;
				case 1:		// 도서 관리
					handleBookManagement();
					break;
				
				case 5:
					library.displayLibraryStatics();
					break;
			}
		}
	}
	// 도서 관리 서브메뉴 처리
	public void handleBookManagement() {
		while(true) {
			System.out.println("\n==== 도서 관리 ====");
			System.out.println("1. 도서 추가");
			System.out.println("2. 전체 도서 목록");
			System.out.println("3. 대출 가능한 도서");
			System.out.println("4. 연체된 도서");
			System.out.println("5. 통계 정보");
			System.out.println("0. 종료");
			System.out.print("선택하세요: ");
			
			int choice = Integer.parseInt(scanner.nextLine());
			
			switch(choice) {
			case 1:	// 도서 추가
				addNewBook();
				break;
			case 0:	// 메인 메뉴
				return;
				default:
					System.out.println("잘못된 선택입니다.");
					break;
			}
		}				
	}
	// 새 도서 추가
	private void addNewBook() {
		System.out.println("ISBN을 입력하세요: ");
		String isbn = scanner.nextLine().trim();
		
		System.out.println("제목을 입력하세요: ");
		String title = scanner.nextLine().trim();
		
		System.out.println("저자를 입력하세요: ");
		String author = scanner.nextLine().trim();
		
		System.out.println("카테고리를 입력하세요: ");
		String category = scanner.nextLine().trim();
		
		System.out.println("출판일을 입력하세요: ");
		String dateStr = scanner.nextLine().trim();		
		
		// 입력값 유효성 검사
		if(isbn.isEmpty() || title.isEmpty() || author.isEmpty() || category.isEmpty() || dateStr.isEmpty()) {
			System.out.println("모든 필드를 입력해주세요.");
			return;
		}
		// 날짜 파싱
		LocalDate publishDate = LocalDate.parse(dateStr);
		
		// 도서 추가
		try {
			library.addBook(isbn, title, author, category, publishDate);
		} catch (LibraryException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	// 메인 메뉴 출력
	public void displayMainMenu() {
		System.out.println("\n==== 메인 메뉴 ====");
		System.out.println("1. 도서 관리");
		System.out.println("2. 회원 관리");
		System.out.println("3. 대출/반납 관리");
		System.out.println("4. 검색 및 조회");
		System.out.println("5. 통계 정보");
		System.out.println("0. 종료");
		System.out.print("메뉴를 선택하세요.");
				
	}
}
