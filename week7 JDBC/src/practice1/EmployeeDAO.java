package practice1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

public class EmployeeDAO {
	public ArrayList<EmployeeVO> searchByEmployeeID(int no) throws SQLException {
		ArrayList<EmployeeVO> result = new ArrayList<>();
		String sql = "SELECT EMPLOYEE_ID, DEPARTMENT_ID, FIRST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE EMPLOYEE_ID = ? ";
		
		Connection con = ConnectionUtil.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			result.add(new EmployeeVO(rs.getInt("EMPLOYEE_ID"), rs.getInt("DEPARTMENT_ID"), rs.getString("FIRST_NAME"), rs.getString("JOB_ID"), rs.getInt("SALARY")));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return result;
	}
	
	public ArrayList<EmployeeVO> searchByDepartmentID(int no) throws SQLException {		
		ArrayList<EmployeeVO> result = new ArrayList<>();
		String sql = "SELECT EMPLOYEE_ID, DEPARTMENT_ID, FIRST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE DEPARTMENT_ID = ? ";
		
		Connection con = ConnectionUtil.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			result.add(new EmployeeVO(rs.getInt("EMPLOYEE_ID"), rs.getInt("DEPARTMENT_ID"), rs.getString("FIRST_NAME"), rs.getString("JOB_ID"), rs.getInt("SALARY")));
		}		
		rs.close();
		pstmt.close();
		con.close();
		
		return result;
	}
	
	public ArrayList<EmployeeVO> searchByJobID(String id) throws Exception {
		ArrayList<EmployeeVO> result = new ArrayList<>();
		String sql = "SELECT EMPLOYEE_ID, DEPARTMENT_ID, FIRST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE JOB_ID LIKE '%' || ? || '%' ";
		
		Connection con = ConnectionUtil.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			result.add(new EmployeeVO(rs.getInt("EMPLOYEE_ID"), rs.getInt("DEPARTMENT_ID"), rs.getString("FIRST_NAME"), rs.getString("JOB_ID"), rs.getInt("SALARY")));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return result;
	}
	
	public ArrayList<EmployeeVO> searchBySalary(int min, int max) throws Exception {
		ArrayList<EmployeeVO> result = new ArrayList<>();
		String sql = "SELECT EMPLOYEE_ID, DEPARTMENT_ID, FIRST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE SALARY >= ? AND SALARY <= ? ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, min);
		pstmt.setInt(2, max);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			result.add(new EmployeeVO(rs.getInt("EMPLOYEE_ID"), rs.getInt("DEPARTMENT_ID"), rs.getString("FIRST_NAME"), rs.getString("JOB_ID"), rs.getInt("SALARY")));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return result;
	}
	
	public double searchAvgByDepartmentID(int id) throws Exception {
		double avg = 0.0;
		
		String sql = "SELECT ROUND(AVG(SALARY),2) AS SALARY FROM EMPLOYEES WHERE DEPARTMENT_ID = ? ";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			avg = rs.getDouble("SALARY");
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return avg;
	}
}
