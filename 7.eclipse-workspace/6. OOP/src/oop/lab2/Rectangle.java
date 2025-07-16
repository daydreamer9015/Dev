package oop.lab2;

public class Rectangle {
	int width = 5;
	int height = 8;
	
	boolean isSquare () {
		return width == height;
	}
	
	int calculateCircumference () {
		return 2 * (width + height);
	}
	
	int calculateArea () {
		return width * height;
	}
}
