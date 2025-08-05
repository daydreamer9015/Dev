package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import exception.CustomerNotFoundException;
import exception.InsufficientStockException;
import exception.ProductNotFoundException;
import exception.ShopException;
import model.CartItem;
import model.Customer;
import model.Manager;
import model.Order;
import model.Product;

public class ShoppingMall {
	private HashMap<String, Product> products = new HashMap<>();      // 상품 관리
    private HashMap<String, Customer> customers = new HashMap<>();    // 고객 관리  
    private HashMap<String, Manager> managers = new HashMap<>();      // 관리자 관리
    private ArrayList<Order> orders = new ArrayList<>(); //주문 내역
    private HashMap<String, ArrayList<CartItem>> carts = new HashMap<>(); // 고객별 장바구니
    private String mallName;
    private int orderCounter = 1; // 주문 번호 생성용
    
    public ShoppingMall(String mallName) {
    	this.mallName = mallName;
    }
    // 상품 추가 메서드
	public void addProduct(String productId, String name, int price, int stock, String category) throws ShopException {
		if(products.containsKey(productId)) {
			throw new ShopException("\n이미 존재하는 상품 ID입니다: " + productId);
		}
		Product product = new Product(productId, name, price, stock, category, 0.0, 0);
		products.put(productId, product);
		System.out.println("\n상품이 추가되었습니다: " + name);
	}

	// 고객 추가 메서드
	public void addCustomer(String id, String name, String email) throws ShopException{
		if(customers.containsKey(id)) {
			throw new ShopException("\n이미 존재하는 고객ID입니다: " + id);
		}
		Customer customer = new Customer(id, name, email);
		customers.put(id, customer);
		System.out.println("\n고객이 추가되었습니다: " + name);
	}

	// 관리자 추가 메서드
	public void addManager(String id, String name, String email, String department, int employeeId) throws ShopException{
		if(managers.containsKey(id)) {
			throw new ShopException("\n이미 존재하는 관리자ID입니다: " + id);
		}
		Manager manager = new Manager(id, name, email, department, employeeId);
		managers.put(id, manager);
		System.out.println("\n관리자가 추가되었습니다: " + name);
	}
	
	// 전체 상품 보기 메서드
	public void displayAllProducts() {
	    if (products.isEmpty()) {
	    	System.out.println("\n등록된 상품이 없습니다.");
	    	return;
	    }
	    for(Product product : products.values())
	    	System.out.println(product);
	}
	
	// 재고 있는 상품만 보기 메서드
	public void displayAvailableProducts() {
		for(Product product : products.values())
		if(product.isInStock()) {
			System.out.println(product);
		}
	}
	
	// 상품 이름으로 검색 메서드
	public ArrayList<Product> searchProductByName(String name) {
		ArrayList<Product> result = new ArrayList<>();
		for(Product product : products.values())
			if(product.getName().contains(name)) {
				result.add(product);
			}
		return result;
	}
	
	// 상품 카테고리로 검색 메서드
	public ArrayList<Product> searchProductByCategory(String category) {
		ArrayList<Product> result = new ArrayList<>();
		for(Product product : products.values())
			if(product.getCategory().contains(category)) {
				result.add(product);
			}
		return result;
	}
	
	// 재고 부족 상품 반환 메서드
	public ArrayList<Product> getLowStockProducts() {
		ArrayList<Product> result = new ArrayList<>();
		for(Product product : products.values())
			if(product.isLowStock()) {
				result.add(product);
			}
		return result;
	}
	
	// 특정 고객 주문 내역 확인 메서드
	public void displayCustomerOrders(String customerId) throws CustomerNotFoundException {
	    Customer customer = customers.get(customerId);
	    if (customer == null) throw new CustomerNotFoundException("\n존재하지 않는 고객입니다: " + customerId);
	    boolean found = false;
	    for (Order order : orders) {
	        if (order.getCustomer().getId().equals(customerId)) {
	            System.out.println(order);
	            found = true;
	        }
	    }
	    if (!found) {
	    	System.out.println("\n주문 내역이 없습니다.");
	    }
	}
	
	// 장바구니에 물품 추가 메서드
	public void addToCart(String customerId, String productId, int quantity) throws CustomerNotFoundException, ProductNotFoundException {
		Customer customer = customers.get(customerId);
		if(customer == null) throw new CustomerNotFoundException("\n존재하지 않는 고객입니다: " + customerId);
		
		Product product = products.get(productId);
		if(product == null) throw new ProductNotFoundException("\n존재하지 않는 상품입니다: " + productId);
		if(!carts.containsKey(customerId)) 
			carts.put(customerId, new ArrayList<>());
			ArrayList<CartItem> cart = carts.get(customerId);		
		
		for(CartItem item : cart) {
			if(item.getProduct().getProductId().equals(productId)) {
				item.addQuantity(quantity);
				System.out.println("\n장바구니에 상품이 추가되었습니다: " + product.getName() + "(" + item.getQuantity() + "개)");
				return;
			}
		}
		cart.add(new CartItem(product, quantity));
	    System.out.println("\n장바구니에 상품이 추가되었습니다: " + product.getName() + " (" + quantity+"개)");
	}
	
	// 장바구니 확인 메서드
	public void displayCart(String customerId) throws CustomerNotFoundException {
		Customer customer = customers.get(customerId);
	    if (customer == null) throw new CustomerNotFoundException("\n존재하지 않는 고객입니다: " + customerId);
	    
	    ArrayList<CartItem> cart = carts.get(customerId);
	    System.out.println("=== " + customer.getName() + "님의 장바구니 ===");
	    if (cart == null || cart.isEmpty()) {
	    	System.out.println("\n장바구니가 비어있습니다.");
	    	return;
	    }
	    int sum = 0;
	    for (CartItem item : cart) {
	        System.out.println("- "+item);
	        sum += item.getTotalPrice();
	    }
	    System.out.println("\n장바구니 합계: " + String.format("%,d원", sum));
	}
	
	// 주문 처리 메서드
	public void placeOrder(String customerId) throws ShopException {
		 Customer customer = customers.get(customerId);
		    if (customer == null) throw new CustomerNotFoundException("\n존재하지 않는 고객입니다: " + customerId);
		    
		    ArrayList<CartItem> cart = carts.get(customerId);
		    if (cart == null || cart.isEmpty()) throw new ShopException("\n장바구니가 비어있습니다.");

		    // 재고 확인 및 차감
		    for(CartItem item : cart) {
		        try {
		            item.getProduct().reduceStock(item.getQuantity());
		        } catch (InsufficientStockException e) {
		            throw new ShopException("\n주문 실패: "+e.getMessage());
		        }
		    }

		    int total = cart.stream().mapToInt(CartItem::getTotalPrice).sum();
		    String orderId = String.format("ORD%04d", orderCounter++);
		    Order order = new Order(orderId, customer, cart, LocalDateTime.now(), total, "주문완료");
		    orders.add(order);

		    System.out.println("\n=== 주문이 완료되었습니다! ===");
		    System.out.println("주문번호: " + orderId);
		    System.out.println("결제금액: " + String.format("%,d원", total));

		    cart.clear(); // 장바구니 비우기
	}
	
	// 통계 정보 확인 메서드
	public void displayMallStatistics() {
		System.out.println("=== " + mallName + " 통계 정보 ===");
		System.out.println("총 상품 수: " + products.size() + "개");
		long availableCount = products.values().stream().filter(Product::isInStock).count();
		System.out.println("구매 가능한 상품: " + availableCount +"개");
		long lowStockCount = products.values().stream().filter(Product::isLowStock).count();
		System.out.println("재고 부족 상품: " + lowStockCount + "개");
		System.out.println("등록 고객 수: " + customers.size() + "명");
		System.out.println("총 주문 수: " + orders.size() + "건");
		int totalSales = orders.stream().mapToInt(order -> order.getTotalAmount()).sum();
		System.out.println("총 매출: " + String.format("%d원", totalSales));
	
		// 카테고리별 상품 수
		Map<String, Long> categoryCount = new HashMap<>();
		for(Product product : products.values())
				categoryCount.put(product.getCategory(), categoryCount.getOrDefault(product.getCategory(),0L)+1);
		System.out.println("\n카테고리별 상품 수: ");
		for (Map.Entry<String, Long> e : categoryCount.entrySet())
	        System.out.println("  "+e.getKey()+": "+e.getValue()+"개");
	}
}