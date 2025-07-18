package basic;

public class CastingMain2 {
	public static void main(String[] args) {
		Parent poly = new Child();
		
		((Child)poly).childMethod();		//poly는 여전히 Parent 타입인데 (Child)를 붙여 해당 메서드를 호출하는 순간만 일시적 다운캐스팅을 함 
	}
}
