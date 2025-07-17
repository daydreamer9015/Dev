package method;

import java.util.Scanner;

public class SimpleCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n==== 간단한 계산기 ====");
			System.out.print("첫번째 숫자를 입력하세요: ");
			double num1 = scanner.nextDouble();
			
			System.out.print("연산자를 입력하세요 (+, -, *, /): ");
			String op = scanner.next();
			
			System.out.print("두번째 숫자를 입력하세요: ");
			double num2 = scanner.nextDouble();
			
			double result = 0;
			boolean valid = true;
			
			// 연산자에 따른 메서드 분기
			switch(op) {
			case "+":
				result = add(num1, num2);
				break;
			case "-":
				result = minus(num1, num2);
				break;
			case "*":
				result = multiply(num1, num2);
				break;
			case "/":
				result = divide(num1, num2);
				break;
			default:
				System.out.println("🚫 지원하지 않는 연산자입니다.");
				valid = false;	
			}
			// 결과 출력
			if(valid) {
				divideResult(num1, op, num2, result);
			} else if(valid) {
				printResult(num1, op, num2, result);	// 출력하는 메서드를 호출하는 것
			}
			System.out.print("계속 하시겠습니까? (y/n)");
			String cont = scanner.next();
			if(!cont.equalsIgnoreCase("y")) {
				break;	// 사용자가 y가 아닌 값을 입력하면 종료
			}
		}
		scanner.close();
		System.out.println("👏🏼 계산기를 종료합니다.");
	}

	private static void divideResult(double num1, String op, double num2, double result) {
		// TODO Auto-generated method stub
		if(num2 == 0) {
			System.out.println("✖️ 0으로 나눌 수 없습니다.");
		}
		
	}

	private static double divide(double num1, double num2) {
		// TODO Auto-generated method stub
		return num1 / num2;
	}

	private static double multiply(double num1, double num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

	private static double minus(double num1, double num2) {
		// TODO Auto-generated method stub
		return num1 - num2;
	}

	private static void printResult(double num1, String op, double num2, double result) {
		System.out.printf("✅ 계산 결과 : %.2f %s %.2f = %.2f\n", num1, op, num2, result);
		
	}

	private static double add(double num1, double num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}
}
