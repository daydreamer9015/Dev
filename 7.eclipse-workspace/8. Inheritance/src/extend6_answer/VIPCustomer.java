package extend6_answer;
/*
 * 기본적인 것은 Customer에서 상속 받아서 사용
 * 제품 구매 시 10% 할인
 * 포인트는 제품 가격의 5% 적립 * 0.05
 * 담당 전문 상담원이 배정됨 agent
 */
public class VIPCustomer extends Customer{
	private double salesRatio;
	private int agentID;
	
	public VIPCustomer(int customerID, String customerName, int agentID) {
        super(customerID, customerName);
        this.customerGrade = "VIP";
        this.bonusPoint = 10000;
        this.bonusRatio = 0.05;
        this.salesRatio = 0.1;
        this.agentID = agentID;
    }

	@Override
	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "이고, 담당 상담원 번호는 " + agentID + "입니다." ;
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint += (int)(price * bonusRatio);
		return price - (int)(price * salesRatio);
	}

	@Override
	public String showInfoAfterPurchase() {
		return "구매 후 정보: " + customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
	}

	public double getSalesRatio() {
		return bonusRatio ;
	}

	public void setSalesRatio(double salesRatio) {
		this.salesRatio = salesRatio;
	}

	public int getAgentID() {
		return agentID;
	}

	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}	
	
}
