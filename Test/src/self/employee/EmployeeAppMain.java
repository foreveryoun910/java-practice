package self.employee;

import java.util.Scanner;

public class EmployeeAppMain {
	public static void main(String[] args) {
		EmployeeApp app = new EmployeeApp();
		Scanner scanner = new Scanner(System.in);
		int selectNum = 0;
		boolean run = true;
		while(run) {
			System.out.println("============================================================");
			System.out.println("1.사원수 | 2.사원정보입력 | 3.사원리스트 | 4.검색 | 5.급여합계 | 6.종료");
			System.out.println("============================================================");
			System.out.print("선택> ");
			selectNum = scanner.nextInt();
			
			if(selectNum == 1) {
				//사원수 -> init
				app.init();
			}
			else if(selectNum == 2) {
				//사원입력 -> input
				app.input();
			}
			else if(selectNum == 3) {
				//사원리스트(전체조회) -> print
				app.print();
			}
			else if(selectNum == 4) {
				//검색(단건조회) -> search
				app.search();
			}
			else if(selectNum == 5) {
				//급여합계 -> sum
				app.sum();
			}
			else if(selectNum == 6) {
				//종료
				run = false;
				System.out.println("프로그램 종료");
			}
		}
		
	}
}
