package smartcar;

public class ManualCar extends Car{

	public ManualCar(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void startEngine() {
		System.out.println("키를 돌려서 시동을 겁니다.");
		
	}

	@Override
	public void drive() {
		System.out.println("운전자가 핸들과 기어를 직접 조작합니다.");
		
	}

	@Override
	public void stop() {
		System.out.println("운전자가 브레이크를 밟아 차를 세웁니다.");
		
	}

}
