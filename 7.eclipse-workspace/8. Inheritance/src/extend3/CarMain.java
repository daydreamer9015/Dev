package extend3;

public class CarMain{
	public static void main(String[] args) {
		ElectricCar electricCar = new ElectricCar();
		electricCar.move();		// 원래는 부모클래스인 Car에서 move를 따와야 하는데 자식클래스인 ElectricCar에서도 move를 오버라이딩해서 만들어두었기 때문에 부모클래스가 아닌 자식클래스에서 값을 따옴
		
		PickupCar pickupCar = new PickupCar();
		pickupCar.move();
	}
}
