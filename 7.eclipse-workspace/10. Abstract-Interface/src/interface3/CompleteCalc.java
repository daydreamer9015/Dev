package interface3;

public class CompleteCalc extends Calculator{
	@Override
	public int times(int num1, int num2) {
		
		return num1 * num2;
	}
	@Override
	public int divide(int num1, int num2) {
		if(num2 != 0)
			return num1 / num2;
		else
			return Calc.ERROR;
	}
	@Override
	public void description() {
		System.out.println("정수 계산기를 구현합니다.");
	}
}
