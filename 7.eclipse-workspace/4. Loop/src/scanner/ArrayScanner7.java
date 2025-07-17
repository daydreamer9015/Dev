package scanner;

import java.util.Scanner;
/*
    학생수를 입력하세요: 4
	1번 학생의 성적을 입력하세요:
	국어 점수:100
	영어 점수:80
	수학 점수:70
	2번 학생의 성적을 입력하세요:
	국어 점수:30
	영어 점수:40
	수학 점수:50
	3번 학생의 성적을 입력하세요:
	국어 점수:60
	영어 점수:70
	수학 점수:50
	4번 학생의 성적을 입력하세요:
	국어 점수:90
	영어 점수:100
	수학 점수:80
	1번 학생의 총점 : 250, 평균: 83.3
	2번 학생의 총점 : 120, 평균: 40.0
	3번 학생의 총점 : 180, 평균: 60.0
	4번 학생의 총점 : 270, 평균: 90.0

 */
public class ArrayScanner7 {
	public static void main(String[] args) {
		// 콘솔에서 사용자 입력 받기 위한 Scanner 객체 생성
		Scanner scanner = new Scanner(System.in);
		System.out.print("학생수를 입력하세요: ");
		
		// 학생 수 동적으로 입력받음
		int n = scanner.nextInt();
		
		// 2차원 배열 선언 - n명, 3개 과목 점수 저장
		int[][] scores = new int[n][3];
		
		// 과목명 저장할 배열
		String[] subjects = {"국어", "영어", "수학"};
		
		// 4명의 학생에 대한 반복
		for(int i = 0; i < n; i++) {
			System.out.println((i+1)+"번 학생의 성적을 입력하세요: ");
			
			// 3개 과목에 대해 반복처리
			for(int j = 0; j < 3; j++) {
				System.out.print(subjects[j] + " 점수: ");
				// 2차원 배열 점수 저장
				scores[i][j] = scanner.nextInt();
			}
		}
		// 입력받은 점수를 기반으로 총점과 평균값 계산
		for(int i = 0; i < n; i++) {
			// 현재 학생의 총점 저장 변수
			int total = 0;
			// 현재 학생의 3개 과목 점수 모두 더하기
			for(int j = 0; j < 3; j++) {
				total += scores[i][j];
			}
			// 평균
			double average = total / 3.0;
			
			// 출력
			System.out.println((i + 1)+"번 학생의 총점 : "+total+", 평균 : "+String.format("%.1f", average));
		}
	}
}
