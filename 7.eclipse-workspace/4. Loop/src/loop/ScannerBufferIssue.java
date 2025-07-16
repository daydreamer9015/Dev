package loop;

import java.util.Scanner;

public class ScannerBufferIssue {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("📌 숫자 입력 후 문자열 입력 시도 케이스 📌");
		System.out.print("나이를 입력하세요: ");
		int age = scanner.nextInt();	// 정수만 입력받고 끝. 줄바꿈(\n)은 남아있음
		
		System.out.print("이름을 입력하세요: ");
		String name = scanner.nextLine();	// 버퍼에 남아있는 \n 을 읽어들여서 name이 빈 문자열이 되어버림
		
		System.out.println("⛔ 입력된 이름: '"+name+"' ");
		System.out.println();
		
		//1: nextLine()을 한번 더 써서 줄바꿈 문자 제거
		System.out.println("✅[이슈 해결 방법 1] nextLine() 줄바꿈 제거 후 입력 ✅");
		System.out.print("나이를 입력하세요: ");
		age = scanner.nextInt();
		scanner.nextLine();		// 사용 용도가 아닌 그냥 줄바꿈을 제거하고 처리하기 위함
		
		System.out.print("이름을 입력하세요: ");
		name = scanner.nextLine();
		System.out.println("🎉 입력된 이름: '"+name+"' ");
		System.out.println();
		
		//2: nextLine()만 사용하고 필요한 타입으로 직접 casting(parsing) 
		System.out.println("✅[이슈 해결 방법 2] nextLine()만 사용하고 해당 타입으로 parsing ✅");
		System.out.print("나이를 입력하세요: ");
		String ageInput = scanner.nextLine();
		// string 통해 받은 문자열을 숫자 int로 변환
		int parsedAge = Integer.parseInt(ageInput);
		
		System.out.print("이름을 입력하세요: ");
		name = scanner.nextLine();
		
		System.out.println("🎉 입력된 이름: '"+name+"', 나이: "+parsedAge);
	}
}
