package scanner;

import java.util.Scanner;

/* 
	사용자로부터 n개의 정수를 입력받아 배열에 저장한 후, 배열 내에서 가장 작은 수와 가장 큰 수를 출력하시오.
        - minNum, maxNum 변수 설정
        
        입력받을 숫자의 개수를 입력하세요: 3
        1
        2
        4
        가장 작은 정수: 1
        가장 큰 정수: 5
 */
public class ArrayScanner5 {
	public static void main(String[] args) {
		// 콘솔에서 사용자 입력 받기 위한 Scanner 객체 생성
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력받을 숫자의 개수를 입력하세요: ");
		
		// 배열의 크기를 동적으로 할당받을 변수
		int n = scanner.nextInt();
		
		// n에 들어가는 수=사용자가 입력한 수만큼 배열이 설정됨
		int[] numbers = new int[n];
		
		//최소값, 최대값 저장할 변수
		int minNum, maxNum;
		
		// 배열에 값 저장
		for(int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();		// 정수 입력받아 배열에 저장
		}
		// 최소값과 최대값 찾기위한 초기화 - 첫번째 요소로 설정
		minNum = maxNum = numbers[0];
		
		// 두번째 요소부터 마지막 요소까지 비교하여 최소값, 최대값 할당
		for(int i = 1; i < n; i++) {
			// 현재 요소가 최소값보다 작으면 현재 요소가 최소값이 됨
			if(numbers[i] < minNum) {
				minNum = numbers[i];
			}
			
			// 현재 요소가 최대값보다 크면 현재 요소가 최대값이 됨
			if(numbers[i] > maxNum) {
				maxNum = numbers[i];
			}
		}
		// 출력
		System.out.println("가장 작은 정수: "+minNum);
		System.out.println("가장 큰 정수: "+maxNum);
	}
}
