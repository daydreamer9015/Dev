package array;

public class ArrayRef2 {
	public static void main(String[] args) {
		int[] students;			// 배열 변수 선언
		students = new int[5];	// 배열 생성, 5개의 int 공간 생성, 0으로 자동 초기화가 되어있는 상태
		
		// 변수 값 대입
		students[0] = 90;
		students[1] = 80;
		students[2] = 70;
		students[3] = 60;
		students[4] = 50;
		
		// 변수 값 사용
		for(int i = 0; i < students.length; i++) {
			System.out.println("학생"+(i+1)+" 점수: "+students[i]);
		}
	}
}
