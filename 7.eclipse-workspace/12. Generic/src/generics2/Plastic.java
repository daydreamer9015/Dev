package generics2;
/*
 * 플라스틱 재료 클래스
 * 	- ABS, PLA, PETG 등 필라멘트 사용
 */
public class Plastic implements Material{
	private String name;		// 재료명
	private double price;		// 가격
	private String colour;		// 색상
	private double diameter;	// 필라멘트 직경(mm)
	private int meltingPoint;	// 융점(섭씨)
	
	public Plastic(String name, double price, String colour, double diameter, int meltingPoint) {
		//super();
		this.name = name;
		this.price = price;
		this.colour = colour;
		this.diameter = diameter;
		this.meltingPoint = meltingPoint;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getColour() {
		return colour;
	}

	@Override
	public void printInfo() {
		System.out.printf("파우더 재료 - 이름: %s, 가격: %.2f원, 색상: %s, 직경: %.1fmm, 융점: %d°C\n", name, price, colour, diameter, meltingPoint);
		
	}
	
}
