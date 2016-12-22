package sample2;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("사원 아이디를 입력하세요.");
		int id = Integer.parseInt(sc.nextLine());
		
		String sql = "select * from employees where employee_id=?";
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int employee_id = rs.getInt("EMPLOYEE_ID");
			int manager_id = rs.getInt("MANAGER_ID");
			int department_id = rs.getInt("DEPARTMENT_ID");
			String first_name = rs.getString("FIRST_NAME");
			String last_name = rs.getString("LAST_NAME");
			String email = rs.getString("EMAIL");
			String phone_number =rs.getString("PHONE_NUMBER");
			Date hire_date = rs.getDate("HIRE_DATE");
			String job_id = rs.getString("JOB_ID");
			int salary = rs.getInt("SALARY");
			double commission = rs.getDouble("COMMISSION_PCT");
			System.out.printf("%d %d %d %s %s %s %s %s %d %f %tY",
					employee_id, manager_id, department_id, first_name, last_name, email, phone_number, job_id, salary, commission, hire_date);
		}
		
		pstmt.close();
		con.close();
		sc.close();
	}
}
