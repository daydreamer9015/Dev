package casting;

public class Casting {
	public static void main(String[] args) {
		int intValue = 10;
		long longValue;
		double doubleValue;
		
		longValue = intValue;	// int 타입이 long 타입으로 자동 변환된 후 casting
		System.out.println("longValue = " + longValue);
		doubleValue = intValue;	// int 타입이 double 타입으로 자동 변환된 후 casting
		System.out.println("doubleValue = " + doubleValue);	// 소수점 있음
		
		doubleValue = 20L;		// long 형이 double 형으로 casting 됨 (long < double)
		System.out.println("doubleValue = " + doubleValue);
	}
}
