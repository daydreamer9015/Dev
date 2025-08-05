package main;

import java.util.ArrayList;
import java.util.Scanner;

import exception.CustomerNotFoundException;
import exception.ProductNotFoundException;
import exception.ShopException;
import model.Product;
import service.ShoppingMall;

public class ShoppingMallSystem {
	private ShoppingMall mall;
	private Scanner scanner;
	
	public ShoppingMallSystem() throws ShopException {
		this.mall = new ShoppingMall("자바 쇼핑몰");
		this.scanner = new Scanner(System.in);
		initializeData();
	}
	private void initializeData() throws ShopException {
	    // 기본 상품 데이터
        mall.addProduct("P001", "갤럭시 스마트폰", 800000, 10, "전자제품");
        mall.addProduct("P002", "애플 노트북", 1500000, 5, "전자제품");
        mall.addProduct("P003", "무선 이어폰", 150000, 20, "전자제품");
        mall.addProduct("P004", "게이밍 키보드", 120000, 8, "컴퓨터");
        mall.addProduct("P005", "모니터", 300000, 3, "컴퓨터");
        mall.addProduct("P006", "운동화", 89000, 15, "의류");
        mall.addProduct("P007", "청바지", 65000, 12, "의류");
        mall.addProduct("P008", "백팩", 45000, 7, "가방");
        
        // 기본 고객 데이터
        mall.addCustomer("C001", "김철수", "kim@email.com");
        mall.addCustomer("C002", "이영희", "lee@email.com");
        mall.addCustomer("C003", "박민수", "park@email.com");
        
        // 기본 관리자 데이터
        mall.addManager("M001", "정관리", "admin@mall.com", "운영팀", 1001);		
	}
	
	public static void main(String[] args) throws ShopException {
		 try {
            ShoppingMallSystem system = new ShoppingMallSystem();
            system.run();
        } catch (ShopException e) {
            System.out.println("시스템 초기화 오류: " + e.getMessage());
        }
    }
	
	private void run() {
		System.out.println("\n=== 자바 쇼핑몰에 오신 것을 환영합니다! ===\n");
		while(true) {
			printMainMenu();
			System.out.print("메뉴를 선택하세요: ");
			int choice = Integer.parseInt(scanner.nextLine());
			switch(choice) {
				case 0 :
					System.out.println("\n쇼핑몰 시스템을 종료합니다. 감사합니다!");
					return;
					default:
						System.out.print("잘못된 선택입니다. 번호를 다시 선택해주세요: ");
				case 1:
					productMenu();
					break;
//				case 2:
//					customerMenu();
//					break;
				case 3:
					cartMenu();
					break;
				case 4:
					orderMenu();
					break;
				case 5:
					mall.displayMallStatistics();
					break;
			}
		}
	}
	private void orderMenu() {
		while (true) {
            System.out.println();
            System.out.println("=== 주문 관리 ===");
            System.out.println("1. 주문하기");
            System.out.println("2. 고객 주문 내역 보기");
            System.out.println("0. 메인 메뉴로 돌아가기");
            System.out.print("선택하세요: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
			switch(choice) {
			    case 1:
			        placeOrder();
			        break;
			    case 2:
			        displayCustomerOrders();
			        break;
			    case 0:
			        return;
			    default:
			        System.out.println("잘못된 입력입니다.");
			}
        }
    }
	
	private void displayCustomerOrders() {
		try {
	        System.out.print("고객 ID를 입력하세요: ");
	        String customerId = scanner.nextLine().trim();
	        mall.displayCustomerOrders(customerId);
	    } catch (CustomerNotFoundException e) {
	        System.out.println("오류: " + e.getMessage());
	    }
	}
	
	private void placeOrder() {
        try {
		System.out.print("고객 ID를 입력하세요: ");
        String customerId = scanner.nextLine().trim();
        mall.displayCart(customerId); // 장바구니 보여주고
        mall.placeOrder(customerId);
	    } catch (CustomerNotFoundException e) {
	        System.out.println("주문 처리 중 오류: " + e.getMessage());
	    } catch (ShopException e) {
	        System.out.println("주문 처리 중 오류: " + e.getMessage());
	    }
	}
	
	private void cartMenu() {
		while (true) {
            System.out.println();
            System.out.println("=== 장바구니 관리 ===");
            System.out.println("1. 장바구니에 상품 추가");
            System.out.println("2. 장바구니 보기");
            System.out.println("0. 메인 메뉴로 돌아가기");
            System.out.print("선택하세요: ");
           
            try {
            	int choice = Integer.parseInt(scanner.nextLine());
				switch(choice) {
                    case 1:
                        addToCart();
                        break;
                    case 2:
                        displayCart();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("수량은 숫자로 입력해주세요.");
            } catch (Exception e) {
                System.out.println("장바구니 추가 중 오류: " + e.getMessage());
            }
        }
    }

	private void displayCart() {
	    try {
	        System.out.print("고객 ID를 입력하세요: ");
	        String customerId = scanner.nextLine().trim();
	        mall.displayCart(customerId);
	    } catch (CustomerNotFoundException e) {
	        System.out.println("오류: " + e.getMessage());
	    }
	}
	
	private void addToCart() {
	    try {
	        System.out.print("고객 ID를 입력하세요: ");
	        String customerId = scanner.nextLine().trim();
	        System.out.print("상품 ID를 입력하세요: ");
	        String productId = scanner.nextLine().trim();
	        System.out.print("수량을 입력하세요: ");
	        int quantity = Integer.parseInt(scanner.nextLine().trim());
	        mall.addToCart(customerId, productId, quantity);
	    } catch (CustomerNotFoundException | ProductNotFoundException e) {
	        System.out.println("장바구니 추가 중 오류: " + e.getMessage());
	    } catch (NumberFormatException e) {
	        System.out.println("수량은 숫자로 입력해주세요.");
	    }
	}
	
	private void productMenu() {
		while(true) {
			System.out.println();
			System.out.println("=== 상품 관리 ===");
			System.out.println("1. 상품 추가");
			System.out.println("2. 전체 상품 보기");
			System.out.println("3. 구매 가능한 상품 보기");
			System.out.println("4. 상품 검색(이름)");
			System.out.println("5. 카테고리별 상품 보기");
			System.out.println("6. 재고 부족 상품 보기");
			System.out.println("0. 메인 메뉴로 돌아가기");
			System.out.print("선택하세요: ");
			try {
				int choice = Integer.parseInt(scanner.nextLine());
				switch(choice) {
				case 1:
					addProduct();
					break;
				case 2:
	                mall.displayAllProducts();
	                break;
	            case 3:
	                mall.displayAvailableProducts();
	                break;
	            case 4:
	            	searchProductByName();
	            	break;
	            case 6:
	            	displayLowStockProducts();
	            	break;
	            case 0:
	                return;
	            default:
	                System.out.println("잘못된 입력입니다.");
				}
			} catch (Exception e) {
				System.out.println("오류: " + e.getMessage());
			}
		}
	}
	
	private void displayLowStockProducts() {
		ArrayList<Product> found = mall.getLowStockProducts();
        System.out.println("\n=== 재고 부족 상품 (5개 이하) ===");
        if (found.isEmpty()) {
            System.out.println("재고 부족 상품이 없습니다.");
        } else {
            for (Product product : found) System.out.println(product);
        }
	}
	private void searchProductByName() {
		System.out.print("검색할 상품명을 입력하세요: ");
        String name = scanner.nextLine().trim();
        ArrayList<Product> found = mall.searchProductByName(name);
        System.out.println("\n=== 상품명 '" + name + "' 검색 결과 ===");
        if (found.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            for (Product product : found) System.out.println(product);
            System.out.println("총 " + found.size() + "개의 상품을 찾았습니다.");
        }
	}
	private void addProduct() {
		try {
            System.out.print("\n상품 ID를 입력하세요: ");
            String id = scanner.nextLine().trim();
            System.out.print("상품명을 입력하세요: ");
            String name = scanner.nextLine().trim();
            System.out.print("가격을 입력하세요: ");
            int price = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("재고 수량을 입력하세요: ");
            int stock = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("카테고리를 입력하세요: ");
            String category = scanner.nextLine().trim();
            mall.addProduct(id, name, price, stock, category);
        } catch (NumberFormatException e) {
            System.out.println("가격/재고는 숫자로 입력하세요.");
        } catch (ShopException e) {
            System.out.println("오류: " + e.getMessage());
        }
	}
	private void printMainMenu() {
		System.out.println("=== 메인 메뉴 ===");
	    System.out.println("1. 상품 관리");
	    System.out.println("2. 고객 관리");
	    System.out.println("3. 장바구니 관리");
	    System.out.println("4. 주문 관리");
	    System.out.println("5. 통계 정보");
	    System.out.println("0. 종료");
	}
}
