package smartcar;

import java.util.ArrayList;
import java.util.List;

/*
 * 차량을 등록하고 운행하는 클래스
 */
public class CarManager {
	// 차량 목록을 저장하는 리스트 <> 안에 리스트에 들어갈 것을 넣음
	private List<Car> carList;

	public CarManager() {
		carList = new ArrayList<>();
	}
	// 차량 추가
	public void registerCar(Car car) {
		carList.add(car);
		System.out.println(car.getName() + " 차량이 등록되었습니다.");
	}
	// 차량 운행
	public void runAllCars() {
		System.out.println("\n[차량 운행 시작]");
		for(Car car : carList) {
			car.startEngine();
			car.drive();
			car.stop();
			System.out.println();
		}
	}
}
