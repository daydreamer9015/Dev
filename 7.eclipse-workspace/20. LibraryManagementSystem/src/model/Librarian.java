package model;

public class Librarian extends Person {
	private String department;
	private String position;
	
	public Librarian(String id, String name, String phone, String department, String position) {
		super(id, name, phone);
		this.department = department;
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public String getPosition() {
		return position;
	}
	
	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return "사서";
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", 부서: %s, 직책: %s", department, position);
	}

	
	
}
