package sample4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionUtil;

public class EmployeeDAO {
	public EmployeeVO searchEmployeeDao(int no) throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ? ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		EmployeeVO employee = new EmployeeVO();
		
		rs.next();
		
		employee.setEmployeeId(no);
		employee.setEmployeeName(rs.getString("FIRST_NAME"));
		employee.setJobId(rs.getString("JOB_ID"));
		employee.setHireDate(rs.getDate("HIRE_DATE"));
		employee.setSalary(rs.getInt("SALARY"));
		employee.setDepartmentId(rs.getString("DEPARTMENT_ID"));
		employee.setEmail(rs.getString("EMAIL") + "@oracle.com");
		
		rs.close();
		pstmt.close();
		con.close();
		
		return employee;
	}
}
