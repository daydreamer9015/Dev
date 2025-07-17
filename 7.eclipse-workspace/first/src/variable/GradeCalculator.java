package variable;

public class GradeCalculator {
	public static void main(String[] args) {
		System.out.println("=== 성적 계산기 ===");
		System.out.println("학생명: 신사임당");
		System.out.println("학번: 202501");
		System.out.println();
		System.out.println("--- 과목별 점수 ---");
		
		int math = 85;
		int english = 92;
		int science = 78;
		int korean = 88;
		int history = 90;
		
		System.out.println("수학: " + math + "점");
		System.out.println("영어: " + english + "점");
		System.out.println("과학: " + science + "점");
		System.out.println("국어: " + korean + "점");
		System.out.println("역사: " + history + "점\n");
		
		int totalScore = math + english + science + korean + history;
		int avgScore = (math + english + science + korean + history) / 5;
		
		System.out.println("총점: " + totalScore + "점");
		System.out.println("평균: " + avgScore + "점");
		
		int max = math;
		int min = math;
		
		if(english > max) max = english;
		if(science > max) max = science;
		if(korean > max) max = korean;
		if(history > max) max = history;
		
		if(english < min) min = english;
		if(science < min) min = science;
		if(korean < min) min = korean;
		if(history < min) min = history;
		
		System.out.println("최고점: " + max + "점");
		System.out.println("최저점: " + min + "점");
		
		int gapBetweenMaxMin = max - min;
		System.out.println("최고 최저 점수 차이: " + gapBetweenMaxMin + "점");
		System.out.println();
		
		String avgGrade;
		if (avgScore >= 90) {
		    avgGrade = "A (우수)";
		} else if (avgScore >= 80) {
		    avgGrade = "B (양호)";
		} else if (avgScore >= 70) {
		    avgGrade = "C (보통)";
		} else if (avgScore >= 60) {
		    avgGrade = "D (노력필요)";
		} else {
		    avgGrade = "F (미달)";
		}
		System.out.println("--- 등급 판정 ---");
		System.out.println("등급: " + avgGrade);
		
	}
}
