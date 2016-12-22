package sample5;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpApp {
	public static void main(String[] args) throws SQLException {
		EmpDAO dao = new EmpDAO();
		ArrayList<Emp> employees = dao.getAllEmployees();
		System.out.printf("%-15s %-10s %-10s\n","First_Name", "Salary", "Hire_Date");
		System.out.println("====================================");
		for (Emp e : employees) {
			System.out.printf("%-15s %-10s %ty/%tM/%td-10tY\n",e.getFirstName(), e.getSalaryWithComma(), e.getHireDate());
		}
		
	}
}
