package array;

public class ArrayDimen {
	public static void main(String[] args) {
		
		// 2*3 (2행 3열) 2차원 배열 생성
		int[][] arr = new int[2][3];		// [행(row)][열(column)]
		arr[0][0] = 1;		// 0행, 0열
		arr[0][1] = 2;		// 0행, 1열
		arr[0][2] = 3;		// 0행, 2열
		arr[1][0] = 4;		// 1행, 0열
		arr[1][1] = 5;		// 1행, 1열
		arr[1][2] = 6;		// 1행, 2열
		
		// 0행 출력
		System.out.print(arr[0][0] + " ");	//0열 출력
		System.out.print(arr[0][1] + " ");	//1열 출력
		System.out.print(arr[0][2] + " ");	//2열 출력
		System.out.println();		// 한 행 끝나면 라인 변경
		// 1행 출력
		System.out.print(arr[1][0] + " ");	//0열 출력
		System.out.print(arr[1][1] + " ");	//1열 출력
		System.out.print(arr[1][2] + " ");	//2열 출력
		System.out.println();		// 한 행 끝나면 라인 변경		
	}
}
