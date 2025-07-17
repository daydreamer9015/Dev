package array;

import java.util.Scanner;

public class PracticeArrayDemo {
	
	// Scanner 객체를 전역으로 선언하여 모든 메서드에서 사용 가능해짐
	private static Scanner scanner = new Scanner(System.in);	// 멤버 객체가 됨
	
	public static void main(String[] args) {
		System.out.println("=== 배열 프로그램 ===");
		System.out.println("데이터 처리 프로그램입니다. 다양한 기능을 제공합니다.");
		System.out.println();
		
		while (true) {
			// 메뉴 출력
			displayMenu();
			
			// 사용자 선택에 따른 기능 실행
			int choice = scanner.nextInt();
			switch(choice) {
				case 2:
					reverseArrayOutput();  
					break;
				case 1:
					basicArrayOutput();
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못된 선택입니다. 다시 입력해주세요.");			
			}
			
			System.out.println("\n\n계속하려면 Enter를 누르세요...");
			scanner.nextLine();		// 이전 nextInt()가 남긴 개행문자(\n) 제거
			
			scanner.nextLine(); 	// 버퍼가 비어있으므로 사용자의 새로운 Enter 입력을 기다리는 상태 => 프로그램이 계속 진행됨
        }
	}

	private static void reverseArrayOutput() {
		System.out.println("\n=== 배열 역순 출력 ===");
		
		System.out.print("배열 크기를 입력하세요: ");
		int reverseN = scanner.nextInt();
		
		int[] numbers = new int[reverseN];
		
		System.out.println(reverseN + "개의 정수를 입력하세요: ");
		for(int i = 0; i < reverseN; i++) {
			System.out.print((i+1)+"번째 수: ");
			numbers[i] = scanner.nextInt();
		}
		System.out.print("정순 출력: ");
		for(int i = 0; i < reverseN; i++) {
				System.out.print(numbers[i]);
				if(i < reverseN - 1) {
					System.out.print(", ");
			}
		}
		System.out.print("\n역순 출력: ");
		for(int i = 0; i < reverseN; i++) {
			System.out.print(numbers[numbers.length-1-i]);
			if(i < reverseN - 1) {
				System.out.print(", ");
			}
		}
	}

	private static void basicArrayOutput() {
		System.out.println("\n=== 배열 기본 출력 ===");
		
		// 배열 크기 입력
		System.out.print("배열 크기를 입력하세요: ");
		int n = scanner.nextInt();
		
		// 배열 동적 생성 - 입력받은만큼 만들어짐
		int[] numbers = new int[n];
		
		// 데이터 입력
		System.out.println(n + "개의 정수를 입력하세요: ");		
		for(int i = 0; i < n; i++) {
			System.out.print((i + 1) + "번째 수: ");
			numbers[i] = scanner.nextInt();
		}
		
		// 결과 출력 (입력한 순서대로)
		System.out.print("입력된 데이터 : ");
		for(int i = 0; i < n; i++) {
			System.out.print(numbers[i]);
			if(i < n-1) {
				System.out.print(", ");
			}
		}
	}

	private static void displayMenu() {
		System.out.println("\n=== 메뉴 선택 ===");
		System.out.println("1. 배열 기본 출력 (순차 출력)");
		System.out.println("2. 배열 역순 출력");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택: ");
		}
	
	
    

    
}
