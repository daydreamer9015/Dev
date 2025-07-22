package interface5;

public interface Buyer {
	void buy();
	
	default void order() {
		System.out.println("판매 주문");
	}
}


// 