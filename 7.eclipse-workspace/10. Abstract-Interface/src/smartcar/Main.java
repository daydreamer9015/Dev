package smartcar;

public class Main {
	public static void main(String[] args) {
		CarManager manager = new CarManager();
		Car car1 = new ManualCar("Genesis 80");
		Car car2 = new AICar("Tesla Model 3 Zero");
		
		manager.registerCar(car1);
		manager.registerCar(car2);
		
		manager.runAllCars();
	}
}
