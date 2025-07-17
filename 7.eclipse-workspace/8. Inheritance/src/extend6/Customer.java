package extend6;
/*
 * 속성 : ID, 이름, 등급, 포인트, 포인트 적립 비율 ID, name, grade, point, pointRatio
 * 기능 : showInfo() 안에서 속성값 출력 - 생성자 필요
 * 		물품 구매시 1% 포인트 적립 - 변수 선언해서 값 부여하기 (생성자에서 * 0.01)
 */
public class Customer {
	protected String customerGrade;
	protected int customerID;
	protected int bonusPoint;
	protected String customerName;
	protected double bonusRatio;
	
	public Customer() {
		this.customerGrade = "SILVER";
		this.bonusPoint = 1000;
		this.bonusRatio = 0.01;
	}
	
	public Customer(int customerID, String customerName) {
		this();
		this.customerID = customerID;
		this.customerName = customerName;
	}
	
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	public String showInfoAfterPurchase() {
		return "구매 후 정보: " + customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
	}
	
	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
	}
	
	public int calcPrice(int price) {
		bonusPoint += (int)(price * bonusRatio);
		return price;
	}
}
