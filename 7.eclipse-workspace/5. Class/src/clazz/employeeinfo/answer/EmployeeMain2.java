package clazz.employeeinfo.answer;

import java.util.Scanner;

public class EmployeeMain2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("등록할 직원 수를 입력하세요: ");
		int n  = scanner.nextInt();
		scanner.nextLine();
		
		Employee[] employees = new Employee[n];
		for(int i = 0; i < employees.length; i++) {
        	System.out.println((i+1) + "번째 직원 정보를 입력하세요.");
        	System.out.print("이름: ");
        	String name = scanner.nextLine();
        	
        	System.out.print("사번: ");
        	int employeeId = scanner.nextInt();
        	
        	System.out.print("급여: ");
        	int salary = scanner.nextInt();
        	
        	System.out.print("성과 점수 (0.0 ~ 10.0): ");
        	double performanceScore = scanner.nextDouble();
        	
        	System.out.print("정규직 여부(true/false): ");
        	boolean isFullTime = scanner.nextBoolean();
        	
        	System.out.print("부서 코드 (A: 개발, B: 마케팅, C: 영업): ");
        	char department = scanner.next().charAt(0);
        	System.out.println();
        	scanner.nextLine();
        	
        	employees[i] = createList(name, employeeId, salary, performanceScore, isFullTime, department);
        }
		printList(employees);
		printStatic(employees);
	}

	public static void printStatic(Employee[] employees) {
		System.out.println("=== 통계 정보 ===");
	        
	        int sum = 0;
	        int fullTimeCount = 0;
	        double totalScore = 0.0;
	        for(Employee employee : employees) {
	            sum += employee.salary;
	            totalScore += employee.performanceScore;
	            if(employee.isFullTime) fullTimeCount++;
	        }
	        int avgSalary = sum / employees.length;
	        double avgScore = totalScore / employees.length;
	        double fullTimeRatio = (double)fullTimeCount / employees.length * 100.0;
	
	        System.out.println("전체 급여 총합: " + sum + "원");
	        System.out.println("평균 급여: " + avgSalary + "원");
	        System.out.println("평균 성과 점수: " + String.format("%.1f", avgScore) + "점");
	        System.out.println("정규직 비율: " + String.format("%.1f", fullTimeRatio) + "%");
	    }
	
	public static void printList(Employee[] employees) {
		System.out.println("=== 등록된 직원 정보 ==="); 
		for(int i = 0; i < employees.length; i++) {
	        Employee employee = employees[i];
	        System.out.println((i+1) + ". " + employee.name + "(사번: " + employee.employeeId + ")");
			System.out.println("   급여: " + employee.salary + "원");
			System.out.println("   성과점수: " + employee.performanceScore + "점");
			System.out.println("   고용형태: " + (employee.isFullTime ? "정규직" : "비정규직"));
			System.out.println("   부서: " + getDepartmentName(employee.department));
			System.out.println();
		}
		
	}

	public static String getDepartmentName(char deptCode) {
		switch(deptCode) {
		case 'A':
			return "개발팀";
		case 'B':
			return "마케팅팀";
		case 'C':
			return "영업팀";
		default:
			return "아직 팀 배정이 되지 않았습니다.";			
		}
	}

	public static Employee createList(String name, int employeeId, int salary, double performanceScore,
			boolean isFullTime, char department) {
		Employee employee = new Employee();
		employee.name = name;
		employee.employeeId = employeeId;
		employee.salary = salary;
		employee.performanceScore = performanceScore;
		employee.isFullTime = isFullTime;
		employee.department = department;
		return employee;
	}
}
