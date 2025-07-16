package scanner;

import java.util.Scanner;

public class ScannerLab {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요:");
		// nextLine() : 엔터(\n)를 입력할 때까지 그 문자를 읽어와서 가져오는 기눙
		String str = scanner.nextLine();
		System.out.println("입력한 문자열 : " + str);
		
		System.out.print("정수를 입력하세요: ");
		// nextInt() : 입력을 int형으로 받음. 정수 입력에 사용함
		int intValue = scanner.nextInt();
		System.out.println("입력한 정수 : " + intValue);
		
		System.out.print("실수를 입력하세요: ");
		// nextDouble() : 입력을 double형으로 받음. 실수 입력에 사용함
		double doubleValue = scanner.nextDouble();
		System.out.println("입력한 실수 : " + doubleValue);
	}
}
