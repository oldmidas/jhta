package practice1;

import java.util.ArrayList;

public class Display {
	public void displayResult(ArrayList<EmployeeVO> employees) {
		for (EmployeeVO emp : employees) {
			System.out.println(":::::::::::::::::");
			System.out.println("사원번호 : " + emp.getEmployee_id());
			System.out.println("부서번호 : " + emp.getDepartment_id());
			System.out.println("이    름 : " + emp.getFirst_name());
			System.out.println("직업코드 : " + emp.getJob_id());
			System.out.println("월    급 : " + emp.getSalary());
		}
	}
}
