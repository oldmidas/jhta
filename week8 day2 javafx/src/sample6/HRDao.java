package sample6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

public class HRDao {
	
	static final String GET_ALL_DEPTS = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ";
	static final String GET_EMP_BY_DEPT = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = ? ORDER BY EMPLOYEE_ID ";
	static final String GET_EMP_BY_ID = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ? ";
	
	public ArrayList<Dept> getAllDepts() throws SQLException {
		ArrayList<Dept> deptList = new ArrayList<>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_ALL_DEPTS);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Dept dept = new Dept();
			dept.setId(rs.getInt("DEPARTMENT_ID"));
			dept.setName(rs.getString("DEPARTMENT_NAME"));
			
			deptList.add(dept);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return deptList;
	}
	
	public ArrayList<Emp> getEmplByDept(int deptId) throws SQLException {
		ArrayList<Emp> empList = new ArrayList<>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_EMP_BY_DEPT);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Emp emp = new Emp();
			emp.setId(rs.getInt("EMPLOYEE_ID"));
			emp.setName(rs.getString("FIRST_NAME"));
			emp.setJob(rs.getString("JOB_ID"));
			emp.setSalary(rs.getInt("SALARY"));
			
			empList.add(emp);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return empList;
	}
	
	public Emp getEmpById(int empId) throws SQLException {
		Emp emp = null;
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_EMP_BY_ID);
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			emp = new Emp();
			emp.setId(rs.getInt("EMPLOYEE_ID"));
			emp.setName(rs.getString("FIRST_NAME"));
			emp.setJob(rs.getString("JOB_ID"));
			emp.setSalary(rs.getInt("SALARY"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return emp;
	}
}
