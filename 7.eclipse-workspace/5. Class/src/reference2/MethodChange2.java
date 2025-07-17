package reference2;

public class MethodChange2 {
	public static void main(String[] args) {
		Data dataA = new Data();
		dataA.value = 10;
		System.out.println("메서드 호출 전 : dataA.value = " + dataA.value);
		changeReference(dataA);
		System.out.println("메서드 호출 후 : dataA.value = " + dataA.value);
	}

	public static void changeReference(Data dataX) {		// 기본형이 아닌 참조형
		dataX.value = 20;
		
	}
}
