package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer extends Person{
	private LocalDateTime joinDate;

	public Customer(String id, String name, String email) {
		super(id, name, email);
		this.joinDate = LocalDateTime.now();
	}

	@Override
	public String getUserType() {
		return "고객";
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return super.toString() + 
               String.format(", 가입일: %s", joinDate.format(formatter));
	}
}