package practice1;

public class EmployeeVO {
	private int employee_id;
	private int department_id;
	private String first_name;
	private String job_id;
	private int salary;
	
	public EmployeeVO() {}

	public EmployeeVO(int employee_id, int department_id, String first_name, String job_id, int salary) {
		this.employee_id = employee_id;
		this.department_id = department_id;
		this.first_name = first_name;
		this.job_id = job_id;
		this.salary = salary;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
