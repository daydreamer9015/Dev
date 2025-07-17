package method;

import java.util.Scanner;

public class MethodTraining {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 프로그램 시작 메시지
		printHeader();
		
		// 메뉴 선택 기능 추가(반복문)
		while(true) {
			// 문제 목록 출력 메서드
			problemList();
			
			System.out.print("풀어볼 문제 번호를 선택하세요. (0: 종료): ");
			int choice = scanner.nextInt();
			
			// 종료 조건
			if(choice == 0) {
				System.out.println("수고하셨습니다! 취업 성공하세요!!");
				break;
			}
			
			// 선택한 문제를 실행하기
			solveProblem(choice, scanner);
		}
		// scanner.close();
	}
	public static void solveProblem(int choice, Scanner scanner) {
		switch(choice) {
			case 1:
				solveFindMax(scanner);
				break;
			case 2:
				solveIsPrime(scanner);
				break;
			case 3:
				reverseString(scanner);
				break;
			default:
				System.out.println("잘못된 번호입니다.");					
			}
	}
	public static void reverseString(Scanner scanner) {
		System.out.println("\n=== 문제 3: 문자열 뒤집기 ===");
		System.out.println("문자열을 입력하면 거꾸로 뒤집어 드립니다.");
		scanner.nextLine();		// 이전 입력의 개행문자 제거
		System.out.print("문자열을 입력하세요: ");
		String sentence = scanner.nextLine();
		String reversed = "";
		for(int i = sentence.length() - 1; i >= 0; i--) {
			reversed += sentence.charAt(i);
		}	
		
		System.out.println("원본: " + sentence);
		System.out.println("뒤집은 결과: " + reversed);
	    
	    printSeparator();
	}
	public static void solveIsPrime(Scanner scanner) {
		System.out.println("\n=== 문제 2: 소수 판별하기 ===");
		System.out.println("숫자를 입력하면 소수인지 판별해 드립니다.");
		System.out.print("숫자를 입력하세요: ");
		int number = scanner.nextInt();
		
		boolean isPrime = true;
		/* boolean result = isPrime(number); => 소수 판별 메서드 호출
		 * if(result) {
		 * 	System.out.println(number + "는 소수입니다.");
		 * } else {
		 * 	System.out.println(number + "는 소수가 아닙니다.");
		 * }
		 * printSeparator();
		 * }
			public static boolean isPrime(int number) {
			// 2보다 작은 수는 소수가 아님 (음수, 0, 1은 제외함)
			if(number < 2) {
			return false;
			}
			// 2부터 number-1까지 모든 수로 나누기
			for(int i = 2; i < number; i++) {
				// number를 i로 나눈 나머지가 0인지 체크
				if(number % i == 0) {
					// 나머지가 0이면 i는 number의 약수
					// 1과 자기 자신 외의 약수가 존재하므로 소수가 아님
					return false;
				}
			}
			// for문을 통과했다는 것은 2부터 number-1까지 어떤 수로도 나누어 떨어지지 않는다는 뜻(1과 자신만으로 나누어지기 때문에 소수임)
			return true;
			}
		*/
		if(number < 2) {
			isPrime = false;
		} else {
			for(int i = 2; i < number; i++) {
				if(number % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		
		if(isPrime) {
			System.out.println(number + "는 소수입니다.");
		} else {
			System.out.println(number + "는 소수가 아닙니다.");
		}
		
		printSeparator();
		
	}
	public static void solveFindMax(Scanner scanner) {
		System.out.println("\n=== 문제 1: 최대값 찾기 ===");
		System.out.println("여러 개의  숫자를 입력하여 최대값을 찾아보세요.");
		System.out.print("숫자 개수를 입력하세요: ");
		int count = scanner.nextInt();	// 입력받을 숫자의 개수
		// 최대값을 저장할 변수(가장 작은 값으로 초기화)
		int max = Integer.MIN_VALUE;
		
		// 반복문으로 숫자들을 하나씩 입력받기
		for(int i = 1; i <= count; i++) {
			System.out.print(i+"번째 숫자: ");
			int number = scanner.nextInt();
			// 비교해서 최대값 업데이트하는 메서드 호출
			max = findMax(max, number);
		}
		System.out.println("최대값: " + max);
		printSeparator();
	}
	public static void printSeparator() {
		System.out.println("----------------------------------");
		
	}
	public static int findMax(int a, int b) {
		if(a > b)
			return a;
		else
			return b;		
	}
	
	public static void problemList() {
		System.out.println("\n=== 문제 목록===");
		System.out.println("1. 최대값 찾기(배열 없이)");
		System.out.println("2. 소수 판별하기");
		System.out.println("3. 문자열 뒤집기");
		System.out.println("0. 프로그램 종료");
		System.out.println();		
	}
	/*
	 * 프로그램 헤더
	 */
	public static void printHeader() {
		System.out.println("========================================");
		System.out.println("             메서드 훈련");
		System.out.println("              면접 대비");
		System.out.println("========================================");
	}
	
}
