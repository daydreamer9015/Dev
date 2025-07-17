package array;

public class ArrayDimen4 {
	public static void main(String[] args) {
		
		// 2*3 (2행 3열) 2차원 배열 생성
		int[][] arr = {		// 배열 안에 배열을 넣을 수 있음
				{1, 2, 3},
				{4, 5, 6}
		};
		
		for(int row = 0; row < 2; row++) {
			for(int column = 0; column < 3; column++) {
				System.out.print(arr[row][column] + " ");	// System.out.println(); <= println 사용하지 않도록 주의. 옆으로 나오려면 print
			}
			System.out.println();	// 한 행이 끝나면 라인 변경함
		}
	}
}
