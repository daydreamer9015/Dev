package smartcar2;
/*
 * 추상 클래스 Car
 * 	- 모든 차량이 공통적으로 가져야 할 기능을 정의함
 * 	- 연료 기능 추가
 */
public abstract class Car {
	protected String name;
	protected int fuel = 100;	// 초기 연료량 (0~100)

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
	//연료 감소 메서드
	protected void consumeFuel(int amount) {
		fuel -= amount;
		if(fuel < 0) fuel = 0;
		System.out.println(name + " : 현재 연료량 = " + fuel + "%");
	}
	//연료 증가 메서드
	protected void reFuel(int amount) {
		fuel += amount;
		if(fuel > 100) fuel = 100;
		System.out.println(name + " : 연료가 " + amount + "% 충전되었습니다. 현재 연료량 = " + fuel + "%");
	}
}