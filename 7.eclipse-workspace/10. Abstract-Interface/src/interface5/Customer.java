package interface5;

public class Customer implements Buyer, Seller{

	public void sell() {
		System.out.println("판매하기");
	}

	public void buy() {
		System.out.println("구매하기");
		
	}
	
	
	// 중복된 order() 디폴트 메서드를 재정의
	public void order() {
		System.out.println("customer order");
	}


}


// 