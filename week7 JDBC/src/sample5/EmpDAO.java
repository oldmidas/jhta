package sample5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sample2.ConnectionUtil;
import util.QueryUtil;

public class EmpDAO {
	public ArrayList<Emp> getAllEmployees() throws SQLException {
		ArrayList<Emp> employees = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionUtil.getConnection();
			pstmt = con.prepareStatement(QueryUtil.getSql("getAllEmployees"));
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setJobId(rs.getString("JOB_ID"));
				emp.setSalary(rs.getInt("SALARY"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));
				
				employees.add(emp);
			}
			
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();			
		}
		
		return employees;
	}
}
