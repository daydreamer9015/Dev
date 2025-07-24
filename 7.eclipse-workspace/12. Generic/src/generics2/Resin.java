package generics2;

public class Resin implements Material{
	private String name;
	private double price;
	private String colour;
	private int cureTime;	// 경화시간(초)
	private String uvType;	// UV 타입
		
	public Resin(String name, double price, String colour, int cureTime, String uvType) {
		super();
		this.name = name;
		this.price = price;
		this.colour = colour;
		this.cureTime = cureTime;
		this.uvType = uvType;
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
		System.out.printf("파우더 재료 - 이름: %s, 가격: %.2f원, 색상: %s, 경화시간: %d초, UV타입: %s\n", name, price, colour, cureTime, uvType);
	}
}