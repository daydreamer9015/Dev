package loop;

public class Nested2 {
	public static void main(String[] args) {
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.println(i + " * " + j +" = " + i*j);
			}
			System.out.println("---------------------------");
		}
	}
}
