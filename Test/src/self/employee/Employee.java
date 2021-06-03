package self.employee;
/*
 * 사원관리를 위한 사원정보 클래스
 */
public class Employee {
	private int employeeId; //사번
	private String name; //이름
	private int departmentId; 
				//부서번호	-> 10: 인사, 20: 개발, 30: 영업(기본값)
	private String departmentName; //부서명
	private int salary; //급여
	private String email; //이메일
	
	
	public Employee() {}	//기본생성자(매개변수가 없다)
	
	//모든 필드를 초기화하는 생성자
	public Employee(int employeeId, String name, int departmentId, int salary, String email) {
		this.employeeId = employeeId;
		this.name = name;
		this.departmentId = departmentId;
		this.salary = salary;
		this.email = email;
		
		//최저연봉 정의
		if(salary > 2300) {
			this.salary = salary;
		} else {
			this.salary = 2300;
		}
		
		//departmentId를 이용해 departmentName을 정의
		if(this.departmentId == 0) {
			this.departmentId = 30;
		}
		
		if(this.departmentId == 10) {
			this.departmentName = "인사";
		}
		else if(this.departmentId == 20) {
			this.departmentName = "개발";
		}
		else {
			this.departmentName = "영업";
		}
		
	}
	
	
	//this()를 이용해서 초기화, 사번 이름 급여를 이용함
	//모든 필드를 초기화하는 생성자의 this?를 빌려왔기 때문에
	//해당 생성자가 사용하지 않는 부분은 기본값?초기값?을 입력해놓는다
	//this. 를 이용해서 하나하나 초기화시켜도 되긴 함
	public Employee(int employeeId, String name, int salary) {
		this(employeeId, name, 0, salary, null);
	}
	

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", salary=" + salary + ", email=" + email + "]";
	}

	
	
	
	
	//get은 조회, set은 변경
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
