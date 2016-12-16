package employ161212;

public class Employee {
	private String no;
	private String name;
	private int salary;
	
	public Employee() {}
	
	public Employee(String no, String name, int salary) {
		super();
		this.no = no;
		this.name = name;
		this.salary = salary;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}