package innerclass4;

class Outer2 {
	
	Runnable getRunnable(int i) {
		int num = 100;
		
		return new Runnable() {
			
			@Override
			public void run() {
				// num += 10;
				// i += 10;
				System.out.println(i);
				System.out.println(num);
			}
		};
	}
	
	Runnable runner = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Runnable이 구현된 익명 클래스 변수 = runner");
		}
	};
}

public class AnonymousInnerTest {
	public static void main(String[] args) {
		Outer2 out = new Outer2();
		
		Runnable runnable = out.getRunnable(10);
		runnable.run();
		
		out.runner.run();
	}
}
