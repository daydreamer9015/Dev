package model;

import exception.InsufficientStockException;

public class Product {
	private String productId;
	private String name;
	private int price;
	private int stock;
	private String category;
	private double rating = 0.0;
	private int reviewCount = 0;
	private static final int MIN_QUANTITY = 5;
	
	
	public Product(String productId, String name, int price, int stock, String category, double rating,
			int reviewCount) {
		//super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
		this.rating = rating;
		this.reviewCount = reviewCount;
	}
	
	
	public String getProductId() {
		return productId;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public String getCategory() {
		return category;
	}

	public double getRating() {
		return rating;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void reduceStock(int quantity) throws InsufficientStockException {
		if (quantity > stock) {
            throw new InsufficientStockException(String.format(
                "재고 부족: %s (요청: %d, 현재: %d)", name, quantity, stock));
        }
		stock -= quantity;
	}
	
	public void addStock(int quantity) {
		stock += quantity;
	}
	public boolean isInStock() {
		return stock > 0;
	}
	public boolean isLowStock() {
		return stock > 0 && stock <= MIN_QUANTITY;
	}
	public void addReview(double newRating) {
		rating = (rating * reviewCount + newRating) / (reviewCount + 1);
        reviewCount++;
	}

	@Override
	public String toString() {
		String status = !isInStock() ? "품절" : (isLowStock() ? "재고 부족" : "재고 충분");
        return String.format("ID: %s, 상품명: %s, 가격: %,d원, 재고: %d개, 카테고리: %s, 평점: %.1f(%d리뷰), 상태: %s",
                productId, name, price, stock, category, rating, reviewCount, status);
	}
}
