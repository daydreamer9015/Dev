package thread;

public class JoinTest extends Thread {
	int start, end, sum;

	public JoinTest(int start, int end) {
		//super();
		this.start = start;
		this.end = end;
	}
	@Override
	public void run() {
		for(int i = start; i <= end; i++) {
			sum += i;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		JoinTest joinA = new JoinTest(1, 50);
		JoinTest joinB = new JoinTest(51, 100);
		
		joinA.start();
		joinB.start();
		
		joinA.join();
		joinB.join();
		
		int total = joinA.sum + joinB.sum;
		System.out.println(joinA.sum + " + " + joinB.sum + " = " + total);
	}
}