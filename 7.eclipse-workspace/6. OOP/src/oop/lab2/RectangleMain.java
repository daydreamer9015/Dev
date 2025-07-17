package oop.lab2;

public class RectangleMain {
	public static void main(String[] args) { 
	
	Rectangle rectangle = new Rectangle();
	rectangle.width = 5;
	rectangle.height = 8;
	
	int area = rectangle.calculateArea();
	System.out.println("넓이: " + area);
	
	int circumference = rectangle.calculateCircumference();
	System.out.println("둘레: " + circumference);
	
	boolean square = rectangle.isSquare();
	System.out.println("정사각형 여부: " + square);
	}	
}
