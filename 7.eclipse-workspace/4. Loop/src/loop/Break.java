package loop;

public class Break {
	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		
		while(true) {
			sum += i;
			if(sum > 10 ) {
				System.out.println("합이 10보다 크면 종료: i = "+i+", sum = "+sum);
				break;
			}
			i++;
		}
	}
}
