package student_manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
	// 새로운 학생 정보 저장
	public void addStudent(StudentVO student) throws SQLException {
		String sql = "INSERT INTO TB_STUDENT(NO, NAME, MAJOR, GRADE, PHONE, ID, PASSWORD) "
				+ "VALUES (SCHOOL_SEQ.NEXTVAL, ?,?,?,?,?,?) ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, student.getName());
		pstmt.setString(2, student.getMajor());
		pstmt.setInt(3, student.getGrade());
		pstmt.setString(4, student.getPhone());
		pstmt.setString(5, student.getId());
		pstmt.setString(6, student.getPassword());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	// 학생번호로 학생 정보 찾기
	public StudentVO searchStudentByStudentNo(int id) throws SQLException {
		StudentVO student = null;
		
		String sql = "SELECT NO, NAME, MAJOR, GRADE, PHONE, ID FROM TB_STUDENT WHERE NO = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			student = new StudentVO(rs.getInt("NO"), rs.getString("NAME"), rs.getString("MAJOR"), rs.getInt("GRADE"),
					rs.getString("PHONE"), rs.getString("ID"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return student;
	}
	// 학생 아이디로 학생 정보 찾기
	public StudentVO searchByStudentByStudentId(String id) throws SQLException {
		StudentVO student = null;
		
		String sql = "SELECT NO, NAME, MAJOR, GRADE, PHONE, ID FROM TB_STUDENT WHERE ID = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			student = new StudentVO(rs.getInt("NO"), rs.getString("NAME"), rs.getString("MAJOR"), rs.getInt("GRADE"), rs.getString("PHONE"), rs.getString("ID"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return student;
	}
}
