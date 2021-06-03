package self.employee;

import java.util.Scanner;

public class EmployeeApp {
	Employee[] emp = new Employee[1000];
	Scanner scanner = new Scanner(System.in);
	int count = 0;
	
	void init() {
		//사원수
		System.out.println(count);
	}
	
	void input() {
		//사원입력
		System.out.print("사번> ");
		int employeeId = scanner.nextInt();
		System.out.print("이름> ");
		String name = scanner.next();
		System.out.print("급여> ");
		int salary = scanner.nextInt();
		
		emp[count] = new Employee(employeeId, name, salary);
		count++;		
	}
	
	void print() {
		//전체조회
		for(Employee e : emp) {
			System.out.printf("%d\t %s\t %d\n", e.getEmployeeId(), e.getName(), e.getSalary());
		}
	}
	
	String search() {
		//검색(단건조회)
		//사번으로 검색해서 사원 이름 찾기
		System.out.println("사번 입력> ");
		int num = scanner.nextInt();
		String name = "";
		for(Employee e : emp) {
			if(num == e.getEmployeeId()) {
				name = e.getName();
			}
			else if(num != e.getEmployeeId()) {
				System.out.println("일치하는 사원이 없습니다.");
			}
		}
		return name;
	}
	
	int sum() {
		//급여합계
		int total = 0;
		for(Employee e : emp) {
			total += e.getSalary();
		}
		return total;
	}
}
