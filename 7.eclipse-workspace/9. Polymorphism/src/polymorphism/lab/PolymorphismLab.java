package polymorphism.lab;

//직원 관리(급여) 시스템

//부모 클래스
class Employee {
	protected String name;		//직원 이름
	protected int baseSalary;	//기본 급여
	
	public Employee(String name, int baseSalary) {
		//super();
		this.name = name;
		this.baseSalary = baseSalary;
	}
	//급여 계산 메서드
	public int calculateSalary() {
		return baseSalary;  	//기본 급여 반환
	}
	//직원 정보 출력 메서드
	public void printEmployeeInfo() {
		System.out.println("직원명: " + name);
		System.out.println("기본 급여: " + baseSalary +"만원");
	}
}

//자식 클래스
//정규직 직원 클래스
class FullTimeEmployee extends Employee {
	private int bonus;

	public FullTimeEmployee(String name, int baseSalary, int bonus) {
		super(name, baseSalary);		//부모 생성자 호출
		this.bonus = bonus;
	}
	@Override
	public int calculateSalary() {
		return baseSalary + bonus;		//기본급 + 보너스
	}
	
	@Override
	public void printEmployeeInfo() {
		super.printEmployeeInfo();
		System.out.println("보너스: " + bonus + "만원");
		System.out.println("총 급여: " + calculateSalary() + "만원" );
		System.out.println("고용 형태: 정규직");
	}
}

class PartTimeEmployee extends Employee {
	private int workHours;		//근무시간
	private int hourlyRate;		//시간당 급여
	
	public PartTimeEmployee(String name, int workHours, int hourlyRate) {
		super(name, 0);
		this.workHours = workHours;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public int calculateSalary() {
		return hourlyRate * workHours;
	}

	@Override
	public void printEmployeeInfo() {
		System.out.println("직원명: " + name);
		System.out.println("시간당 급여: " + hourlyRate + "만원");
		System.out.println("근무시간: " + workHours + "시간");
		System.out.println("총 급여: " + calculateSalary() + "만원");
		System.out.println("고용 형태: 파트타임");
	}
}
//프리랜서 클래스
//속성 : 프로젝트 갯수, 프로젝트 당 수수료
class Freelancer extends Employee {
	private int projectNum;
	private int projectRate;
	
	public Freelancer(String name, int projectNum, int projectRate) {
		super(name, 0);
		this.projectNum = projectNum;
		this.projectRate = projectRate;
	}

	@Override
	public int calculateSalary() {
		return projectNum * projectRate;
	}

	@Override
	public void printEmployeeInfo() {
		System.out.println("직원명: " + name);
		System.out.println("프로젝트 수: " + projectNum + "만원");
		System.out.println("프로젝트 당 수수료: " + projectRate + "시간");
		System.out.println("총 급여: " + calculateSalary() + "만원");
		System.out.println("고용 형태: 프리랜서");
	}	
}
//인턴 직원 클래스
//속성 : 인턴십 기간
//급여 계산 : 기본급 * 0.8
class internEmployee extends Employee {
	private String internshipPeriod;

	public internEmployee(String name, int baseSalary, String internshipPeriod) {
		super(name, baseSalary);
		this.internshipPeriod = internshipPeriod;
	}

	@Override
	public int calculateSalary() {
		return (int)(baseSalary * 0.8);
	}

	@Override
	public void printEmployeeInfo() {
		System.out.println("직원명: " + name);
		System.out.println("인턴십 기간: " + internshipPeriod);
		System.out.println("총 급여: " + calculateSalary() + "만원");
	}	
}
//계약직 직원 클래스
//속성 : 계약 개월 수 contractMonth, 계약 완료 보너스 contractBonus
//급여 계산 : 기본급 + (계약 개월 수 따른 보너스)
//                 ------------------
//                contractMonth >= 12 ? contractBonus : 0
class contractEmployee extends Employee{
	private int contractMonth;
	private int contractBonus;
	
	public contractEmployee(String name, int baseSalary, int contractMonth, int contractBonus) {
		super(name, baseSalary);
		this.contractMonth = contractMonth;
		this.contractBonus = contractBonus;
	}

	@Override
	public int calculateSalary() {
		return baseSalary + (contractMonth >= 12 ? contractBonus : 0);
	}
	@Override
	public void printEmployeeInfo() {
        System.out.println("직원명: " + name);
        System.out.println("계약 개월 수: " + contractMonth + "개월");
        System.out.println("계약 보너스: " + contractBonus + "만원");
        System.out.println("총 급여: " + calculateSalary() + "만원");
	    }
	
}


public class PolymorphismLab {
	public static void main(String[] args) {
		System.out.println("🏢다형성 연습 - 직원 관리 시스템");
		System.out.println("=========================");
		System.out.println("📊개별 급여 계산 테스트");
		System.out.println("=========================");
		System.out.println();
		
		//1. 다양한 직원 객체 생성
		Employee emp1 = new FullTimeEmployee("이순신", 400, 100);
		Employee emp2 = new PartTimeEmployee("이아르바이트", 10, 80);
		Employee emp3 = new Freelancer("박프리", 200, 3);
		Employee emp4 = new FullTimeEmployee("최매니저", 600, 200);
		
		//2. 배열에 저장(다형성 활용)
		Employee[] employees = {emp1, emp2, emp3, emp4};
		
		//3. 개별 급여 계산 (다형성 활용)
		int totalSalary = 0;
		for(Employee emp : employees) {			
			System.out.println("=== 급여 계산서 ===");
			emp.printEmployeeInfo();
			totalSalary += emp.calculateSalary();
			System.out.println("=========================");
			System.out.println();
		}
		//4. 전체 급여 통계
		System.out.println("📈급여 통계");
		System.out.println("=========================");
		System.out.println("총 직원 수: " + employees.length + "명");
		System.out.println("총 급여 지출: " + totalSalary + "원");
	}
}
