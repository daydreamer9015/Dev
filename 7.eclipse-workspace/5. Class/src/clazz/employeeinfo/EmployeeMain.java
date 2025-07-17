package clazz.employeeinfo;

public class EmployeeMain {
	public static void main(String[] args) {
		System.out.println("=== 직원 정보 목록 ===");
		Employee[] list = new Employee[3];
		
		list[0] = createList("이개발", 1001, 4500000, 8.5, "정규직", "개발팀");
		list[1] = createList("유마케팅", 1002, 4000000, 7.8, "정규직", "마케팅팀");
		list[2] = createList("신영업", 1003, 3800000, 9.2, "비정규직", "영업팀");

		printList(list);
		
		int totalWage = getTotalWage(list);
		System.out.println("전체 급여 총합: " + totalWage + "원");
		
		double avgGrade = getAvgGrade(list);
		System.out.println("평균 성과 점수: " + avgGrade + "점");
	}

	public static double getAvgGrade(Employee[] list) {
		double sum = 0;
	    for(Employee emp : list) {
	        sum += emp.grade;
	    }
	    return sum / list.length;
	}

	public static int getTotalWage(Employee[] list) {
		int totalWage = 0;
		for(Employee lists : list) {
			totalWage += lists.wage;
		}
		return totalWage;
	}

	public static void printList(Employee[] list) {
		for(Employee lists : list) {
			System.out.println("이름: " + lists.name + ", 사번: " + lists.number + ", 급여: " + lists.wage + "원, 성과점수: " + lists.grade + "점, 고용형태: " 
								+ lists.position + ", 부서: " + lists.team);
		}
		
	}

	public static Employee createList(String name, int number, int wage, double grade, String position, String team) {
		Employee list = new Employee();
		list.name = name;
		list.number = number;
		list.wage = wage;
		list.grade = grade;
		list.position = position;
		list.team = team;
		
		return list;
	}
}
