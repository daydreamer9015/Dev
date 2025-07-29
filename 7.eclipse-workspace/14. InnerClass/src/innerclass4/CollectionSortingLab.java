package innerclass4;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class CollectionSortingLab {
	// Employee 클래스 - static inner class로 생성하기
	static class Employee {
		private String name;
		private int age;
		private String department;
		private double salary;
		private Date hireDate;
		
		public Employee(String name, int age, String department, double salary, Date hireDate) {
			//super();
			this.name = name;
			this.age = age;
			this.department = department;
			this.salary = salary;
			this.hireDate = hireDate;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public String getDepartment() {
			return department;
		}

		public double getSalary() {
			return salary;
		}

		public Date getHireDate() {
			return hireDate;
		}

		@Override
		public String toString() {
			return String.format("Employee{name='%s', age='%d', dept='%s', salary='%.0f'}", name, age, department, salary);
		}
	}
	public static void main(String[] args) {
		System.out.println("🏢 컬렉션 정렬 - 직원 데이터 관리 시스템\n");
		
		// DB 조회했다고 가정(일반적으로는 DB에서 데이터 끌어와서 조회)
		List<Employee> employees = createEmployees();
		System.out.println("🗂️ 원본 직원 데이터");
		printEmployee(employees);
		
		// 나이순 정렬
		sortByAge(employees);
	}
	private static void sortByAge(List<Employee> employees) {
		System.out.println("\n나이순 정렬 (오름차순)");
		List<Employee> sorted = new ArrayList<>(employees);		// 새 리스트 생성
		
		// 익명 내부 클래스로 구현
//		sorted.sort(new Comparator<Employee>() {
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				// 나이비교
//				return Integer.compare(o1.getAge(), o2.getAge());
//			}
//		});
//		
//		printEmployee(sorted);
//		System.out.println();
		
		// 람다식으로 표현 가능
		sorted.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
		
		printEmployee(sorted);
	}
	
	private static void printEmployee(List<Employee> employees) {
		for(int i = 0; i < employees.size(); i++) {
			System.out.printf("%d. %s\n", i+1, employees.get(i));
		}
	}
	private static List<Employee> createEmployees() {
		/*
		 * - Data.from(Instant instant)로 Date 객체 생성
		 * - 시간대, 시점 정보가 필요한 경우가 있어서 LocalDate.of()로 날짜 생성
		 */
		
		return Arrays.asList(
				new Employee("김개발", 28, "개발팀", 45000000, Date.from(LocalDate.of(2022, 3, 13).atStartOfDay(ZoneId.systemDefault()).toInstant())),
				new Employee("박기획", 32, "기획팀", 50000000, Date.from(LocalDate.of(2020, 6, 10).atStartOfDay(ZoneId.systemDefault()).toInstant())),
				new Employee("이디자인", 25, "디자인팀", 40000000, Date.from(LocalDate.of(2023, 1, 20).atStartOfDay(ZoneId.systemDefault()).toInstant())),
				new Employee("최마케팅", 30, "마케팅팀", 48000000, Date.from(LocalDate.of(2021, 9, 5).atStartOfDay(ZoneId.systemDefault()).toInstant())),
				new Employee("정개발", 26, "개발팀", 45000000, Date.from(LocalDate.of(2023, 4, 12).atStartOfDay(ZoneId.systemDefault()).toInstant())),
				new Employee("한디자인", 28, "디자인팀", 43000000, Date.from(LocalDate.of(2019, 12, 3).atStartOfDay(ZoneId.systemDefault()).toInstant()))
				);
		
	}
}