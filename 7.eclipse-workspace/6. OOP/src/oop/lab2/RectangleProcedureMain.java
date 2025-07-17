package oop.lab2;

public class RectangleProcedureMain {
	public static void main(String[] args) {
		int width = 5;
		int height = 8;
		int area = calculateArea(width, height);
		System.out.println("넓이: " + area);
		
		int circumference = calculateCircumference(width, height);
		System.out.println("둘레: " + circumference);
		
		boolean square = isSquare(width, height);
		System.out.println("정사각형 여부: " + square);
	}

	static boolean isSquare(int width, int height) {
		return width == height;
	}

	static int calculateCircumference(int width, int height) {
		return 2 * (width + height);
	}

	static int calculateArea(int width, int height) {
		return width * height;
	}
}
