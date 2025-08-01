package test;

import model.Librarian;

public class LibrarianTest {
	public static void main(String[] args) {
		Librarian librarian = new Librarian("L001", "중사서", "010-9876-5432", "대출팀", "팀장");
	System.out.println("사서 생성: " + librarian.toString());
	System.out.println("역할: " + librarian.getRole());
	}
}
