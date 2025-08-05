package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
	private String orderId;
	private Customer customer;
	private ArrayList<CartItem> items;
	private LocalDateTime orderDate;
	private int totalAmount;
	private String status;
	
	
	
	public Order(String orderId, Customer customer, ArrayList<CartItem> items, LocalDateTime orderDate, int totalAmount,
			String status) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.items = new ArrayList<>(items);
		this.orderDate = LocalDateTime.now();
		this.totalAmount = items.stream().mapToInt(CartItem::getTotalPrice).sum();
		this.status = "주문완료";
	}
	
	public String getOrderId() {
		return orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public ArrayList<CartItem> getItems() {
		return items;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void updateStatus(String newStatus) {
		this.status = newStatus;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append(String.format("주문번호: %s, 주문자: %s, 주문일: %s, 총금액: %,d원, 상태: %s\n", 
            orderId, customer.getName(), orderDate.toLocalDate(), totalAmount, status));
        for (CartItem item : items) {
            sb.append("- ").append(item).append("\n");
        }
        return sb.toString();
	}
}
