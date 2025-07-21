package smartcar;
/*
 * 추상 클래스 Car
 * 	- 모든 차량이 공통적으로 가져야 할 기능을 정의함
 */
public abstract class Car {
	protected String name;

	public Car(String name) {
		super();
		this.name = name;
	}
	
	public abstract void startEngine();
	public abstract void drive();
	public abstract void stop();

	public String getName() {
		return name;
	}
}