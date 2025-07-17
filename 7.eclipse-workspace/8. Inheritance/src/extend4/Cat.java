package extend4;

public class Cat extends Animal{
	private boolean isIndoor;	// 실내 고양이 여부

	public Cat(String name, int age, boolean isIndoor) {
		super(name, age);
		this.isIndoor = isIndoor;
		System.out.println("Cat 생성자 호출: " + (isIndoor ? "실내" : "야외") + "고양이");
	}
	public void meow( ) {
		System.out.println(name + "이(가) 냥냥냥!");
	}
	
	public void groom() {
		System.out.println(name + "이(가) 그루밍을 합니다.");
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("실내 고양이 : " + (isIndoor ? "예" : "아니오"));
	}

}
