package student_manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAO {
	// 전체 수강신청 현황 조회하기
	public ArrayList<CourseVO> getAllCourseList() throws SQLException {
		String sql = "SELECT * FROM COURSE_DETAIL_VIEW";
	
		ArrayList<CourseVO> courseList = new ArrayList<>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			CourseVO course = new CourseVO();
			StudentVO student = new StudentVO();
			student.setNo(rs.getInt("STUD_NO"));
			student.setName(rs.getString("STUD_NAME"));
			student.setMajor(rs.getString("STUD_MAJOR"));
			student.setGrade(rs.getInt("STUD_GRADE"));
			
			SubjectVO subject = new SubjectVO();
			subject.setNo(rs.getInt("SUBJECT_NO"));
			subject.setName(rs.getString("SUBJECT_NAME"));
			subject.setType(rs.getString("SUBJECT_TYPE"));
			subject.setLimit(rs.getInt("SUBJECT_LIMIT"));
			
			course.setSubject(subject);
			course.setStudent(student);
			courseList.add(course);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return courseList;
	}
	
	// 학생번호를 전달받아서 그 학생의 수강신청 현황 조회하기
	public ArrayList<CourseVO> searchCourseByStudentNo(int no) throws SQLException {
		String sql = "SELECT ST.NO AS STUD_NO, SJ.NO AS NO, SJ.NAME AS NAME, SJ.LIMIT AS LIMIT, P.NAME AS PROF_NAME, SJ.PROF_NO AS PROF_NO "
				+ "FROM TB_STUDENT ST, TB_SUBJECT SJ, TB_COURSE C, TB_PROFESSOR P "
				+ "WHERE C.STUD_NO = ST.NO "
				+ "AND C.SUBJ_NO = SJ.NO "
				+ "AND P.NO = SJ.PROF_NO "
				+ "AND ST.NO = ?";
		ArrayList<CourseVO> courseList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
	
		while (rs.next()) {
			CourseVO course = new CourseVO();
			SubjectVO subject = new SubjectVO();
			ProfessorVO professor = new ProfessorVO();
			subject.setNo(rs.getInt("NO"));
			subject.setName(rs.getString("NAME"));
			subject.setLimit(rs.getInt("LIMIT"));
			professor.setName(rs.getString("PROF_NAME"));
			professor.setNo(rs.getInt("PROF_NO"));
			subject.setProfessor(professor);
			course.setSubject(subject);
			courseList.add(course);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return courseList;
	}
	// 과목번호를 전달받아서 그 과목의 수강신청 현황 조회하기
	public ArrayList<CourseVO> searchCourseBySubjectNo(int no) throws Exception {
		ArrayList<CourseVO> courseList = new ArrayList<>();
		String sql = "SELECT DISTINCT * "
				+ "FROM COURSE_DETAIL_VIEW2 "
				+ "WHERE NO = ? ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			CourseVO course = new CourseVO();
			SubjectVO subject = new SubjectVO();
			ProfessorVO professor = new ProfessorVO();
			professor.setNo(rs.getInt("PROF_NO"));					
			professor.setName(rs.getString("PROF_NAME"));					
			professor.setPosition(rs.getString("PROF_POS"));					
			professor.setPhone(rs.getString("PROF_PHONE"));					
			subject.setNo(rs.getInt("NO"));
			subject.setName(rs.getString("NAME"));
			subject.setLimit(rs.getInt("LIMIT"));
			subject.setProfessor(professor);
			course.setSubject(subject);
				
			courseList.add(course);
		}

		
		rs.close();
		pstmt.close();
		con.close();
		
		return courseList;
	}
	// 교수번호를 전달받아서 그 교수의 개설과목에 대한 수강신청 현황을 조회하기
	public ArrayList<CourseVO> searchCourseByProfessorNo(int no) throws Exception {
		ArrayList<CourseVO> courseList = new ArrayList<>();
		String sql = "SELECT DISTINCT NO, NAME, LIMIT, CNT "
				+ "FROM COURSE_DETAIL_VIEW2 "
				+ "WHERE PROF_NO = ? ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			CourseVO course = new CourseVO();
			SubjectVO subject = new SubjectVO();
			subject.setNo(rs.getInt("NO"));
			subject.setName(rs.getString("NAME"));
			subject.setLimit(rs.getInt("Limit"));
			course.setCnt(rs.getInt("CNT"));
			course.setSubject(subject);
			
			courseList.add(course);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return courseList;
	}
}
