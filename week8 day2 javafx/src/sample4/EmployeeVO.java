package sample4;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeVO {
	private int employeeId;
	private String employeeName;
	private String jobId;
	private Date hireDate;
	private int salary;
	private String departmentId;
	private String email;
	
	public EmployeeVO() {}
	
	public EmployeeVO(int employeeId, String employeeName, String jobId, Date hireDate, int salary,
			String departmentId, String email) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.jobId = jobId;
		this.hireDate = hireDate;
		this.salary = salary;
		this.departmentId = departmentId;
		this.email = email;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Date getHireDate() {
		return hireDate;
	}
	
	public String getPrettyHireDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(hireDate);
		return date;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}
	
	public String getPrettySalary() {
		DecimalFormat df = new DecimalFormat("###,###.###");
		String prettySalary = df.format(salary);
		return prettySalary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
