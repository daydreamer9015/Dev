package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import exception.LibraryException;
import exception.MemberNotFoundException;
import model.Book;
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
				case 2:		// 회원 관리
					handleMemberManagement();
					break;
				case 3:
					handleBorrowReturnManagement();
					break;
				case 4:
					handleSearchAndInquiry();
					break;
				case 5:
					library.displayLibraryStatics();
					break;
			}
		}
	}
	private void handleSearchAndInquiry() {
		while(true) {
			System.out.println("\n==== 검색 및 조회 ====");
			System.out.println("1. 제목으로 도서 검색");
			System.out.println("2. 저자로 도서 검색");
			System.out.println("3. 카테고리별 도서 검색");
			System.out.println("0. 메인메뉴로 돌아가기");
			System.out.print("선택하세요: ");
			
			try {
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice) {
				case 1:
					searchBooksBytitle();
					break;
				case 2:
					searchBooksByAuthor();
					break;
				case 0:
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			}
		}
	}
	private void searchBooksByAuthor() {
		System.out.println("검색할 도서의 저자를 입력하세요: ");
		String author = scanner.nextLine().trim();
		
		// 검색 실행 후 결과 출력
		ArrayList<Book> results = library.searchBooksByAuthor(author);
		displaySearchResultsByAuthor("저자", author, results);
		
	}
	private void displaySearchResultsByAuthor(String searchType, String author, ArrayList<Book> results) {
		System.out.println("\n==== " + searchType + " '" + author + "' 검색 결과 ====");
		if(results.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			// 검색된 모든 정보 출력
			for(Book book : results) {
				System.out.println(book);
			}
			System.out.println("총 " + results.size() + "권의 책을 찾았습니다.");
		}
		System.out.println();
		
	}
	private void searchBooksBytitle() {
		System.out.print("검색할 도서의 제목을 입력하세요: ");
		String title = scanner.nextLine().trim();
		
		// 검색 실행 후 결과 출력
		ArrayList<Book> results = library.searchBooksByTitle(title);
		displaySearchResults("제목", title, results);
	}
	// 검색 결과 출력
	// 검색 유형 - 제목, 저자, 카테고리
	private void displaySearchResults(String searchType, String keyword, ArrayList<Book> results) {
		System.out.println("\n==== " + searchType + " '" + keyword + "' 검색 결과 ====");
		if(results.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			// 검색된 모든 책 정보 출력
			for(Book book : results) {
				System.out.println(book);
			}
			System.out.println("총 " + results.size() + "권의 책을 찾았습니다.");
		}
		System.out.println();
	}
	// 대출/반납 관리 서브메뉴 관리
	private void handleBorrowReturnManagement() {
		while(true) {
			System.out.println("\n==== 대출/반납 관리 ====");
			System.out.println("1. 도서 대출");
			System.out.println("2. 도서 반납");
			System.out.println("0. 메인 메뉴로 돌아가기");
			try {
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice) {
				case 1:		// 도서 대출
					borrowBook();
					break;
				case 2:		// 도서 반납
					returnBook();
					break;
				case 0:		// 메인 메뉴로 돌아가기
					return;
				default:
					System.out.println("잘못된 선택입니다.");
					break;
				}
			} catch(NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			} catch(Exception e) {
				System.out.println("오류가 발생했습니다. " + e.getMessage());
			}
		}
	}
	private void returnBook() {
		System.out.print("반납할 도서의 ISBN을 입력하세요: ");
		String isbn = scanner.nextLine().trim();
		
		try {
			library.returnBook(isbn);
		} catch (LibraryException e) {
			//e.printStackTrace();
			System.out.println("반납 처리 중 오류 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("예상치 못한 오류가 발생했습니다. " + e.getMessage());
		}		
	}
	// 도서 대출
	private void borrowBook() {
		System.out.print("대출할 도서의 ISBN을 입력하세요: ");
		String isbn = scanner.nextLine().trim();
		
		System.out.print("회원 ID를 입력하세요: ");
		String memberId = scanner.nextLine().trim();
		
		// 대출 처리 요청
		try {
			library.borrowBook(isbn, memberId);
		} catch (LibraryException e) {
			//e.printStackTrace();
			System.out.println("대출 처리 중 오류 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("예상치 못한 오류가 발생했습니다. " + e.getMessage());
		}
	}
	public void handleMemberManagement() {
		while(true) {
			System.out.println("\n==== 회원 관리 ====");
			System.out.println("1. 회원 등록");
			System.out.println("2. 사서 등록");
			System.out.println("3. 회원 대출 현황 조회");
			System.out.println("0. 메인 메뉴로 돌아가기");
			System.out.print("선택하세요: ");
			
			try {
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice) {
				case 1:
					addNewMember();
					break;
				case 2:
					addNewLibrarian();
					break;
				case 3:
					inquireMemberBorrowStatus();
					break;
				case 0:	// 메인 메뉴
					return;
				default:
					System.out.println("잘못된 선택입니다.");
					break;
				}
			} catch(NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			} catch(LibraryException e) {
				throw new RuntimeException();
			} catch(Exception e) {
				System.out.println("오류가 발생했습니다. " + e.getMessage());
			}
			
		}
		
	}
	// 회원 대출 현황 조회 처리
	private void inquireMemberBorrowStatus() {
		System.out.print("조회할 회원 ID를 입력하세요: ");
		String memberId = scanner.nextLine().trim();
		
		// 회원 대출 현황 조회 요청
		try {
			library.displayMemberBorrowStatus(memberId);
		} catch (MemberNotFoundException e) {
			//e.printStackTrace();
			System.out.println("오류 : " + e.getMessage());
		} catch(Exception e) {
			System.out.println("예상치 못한 오류가 발생했습니다. " + e.getMessage());
		}
		
		
	}
	private void addNewLibrarian() throws LibraryException{
		System.out.print("사서 ID를 입력하세요: ");
		String id = scanner.nextLine().trim();
		
		System.out.print("이름을 입력하세요: ");
		String name = scanner.nextLine().trim();
		
		System.out.print("전화번호를 입력하세요: ");
		String phone = scanner.nextLine().trim();
		
		System.out.print("부서를 입력하세요: ");
		String department = scanner.nextLine().trim();
		
		System.out.print("직책을 입력하세요: ");
		String position = scanner.nextLine().trim();
		
		if(id.isEmpty() || name.isEmpty() || phone.isEmpty() || department.isEmpty() || position.isEmpty()) {
			System.out.println("모든 필드를 입력해주세요.");
			return;
		}
		// 사서 등록 요청
		library.addLibrarian(id, name, phone, department, position);
		
	}
	private void addNewMember() throws LibraryException{
		System.out.println("회원 ID를 입력하세요: ");
		String id = scanner.nextLine().trim();
		
		System.out.println("이름을 입력하세요: ");
		String name = scanner.nextLine().trim();
		
		System.out.println("전화번호를 입력하세요: ");
		String phone = scanner.nextLine().trim();
		
		if(id.isEmpty() || name.isEmpty() || phone.isEmpty()) {
			System.out.println("모든 필드를 입력해주세요.");
			return;
		}
		// 회원 등록 요청
		library.addMember(id, name, phone);
		
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
			case 2:	// 전체 도서 목록
				library.displayAllBooks();
				break;
			case 3:	// 대출 가능한 도서
				library.displayAvailableBooks();
				break;
			case 4:	// 연체된 도서
				library.displayOverdueBooks();
				break;
			case 5:	// 통계 목록
				library.displayLibraryStatics();
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
		} catch (Exception e) {
			System.out.println("예상치 못한 오류가 발생했습니다! " + e.getMessage());
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
