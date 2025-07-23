package generics;
// T : 자료형 매개변수 (Type Parameter) => 어떤 타입일지는 알 수 없음
public class GenericPrinter<T> {
	private T material;		// T 자료형으로 선언한 변수

	public T getMaterial() {	// T 자료형 변수 material을 반환하는 제너릭 메서드
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	@Override
	public String toString() {
		return material.toString();
	}
}
