package student_manager;

import java.util.ArrayList;

public class Display {
	
	public void displayStudentPersonalInfo(StudentVO student) {
		try {
			System.out.println("::::"+student.getName()+"::::");
			System.out.println("학  번 : " + student.getNo());
			System.out.println("전  공 : " + student.getMajor());
			System.out.println("학  년 : " + student.getGrade());
			System.out.println("연락처 : " + student.getPhone());
			System.out.println("아이디 : " + student.getId());
			System.out.println("::::::::::::::::::");
		} catch (NullPointerException e) {
			System.out.println("::::::::::::::::::");
			System.out.println("사용자가 없습니다.");
			System.out.println("::::::::::::::::::");
		}
	}
	
	public void displayCurrentCourseCircumstance(ArrayList<CourseVO> courseList) {
		try {
			for (CourseVO course : courseList) {
				StudentVO st = course.getStudent();
				SubjectVO su = course.getSubject();
				
				System.out.println("::::::::::::::::::");
				System.out.println("학번 : "+st.getNo());
				System.out.println("이름 : "+st.getName());
				System.out.println("전공 : "+ st.getMajor());
				System.out.println("학년 : "+st.getGrade());
				System.out.println("과정번호 : "+su.getNo());
				System.out.println("과정명 : "+su.getName());
				System.out.println("과정타입 : "+su.getType());
				System.out.println("정원수 : "+su.getLimit());
				System.out.println("::::::::::::::::::");
			}
		} catch (Exception e) {
			System.out.println("::::::::::::::::::");
			System.out.println("사용자가 없습니다.");
			System.out.println("::::::::::::::::::");
		}
			
	}
	public void displayCurrentCourseCircumstanceByStudentId(ArrayList<CourseVO> courseList) {
		for (CourseVO course : courseList) {
			SubjectVO su = course.getSubject();
			ProfessorVO pr = su.getProfessor();
			System.out.println("::::::::::::::::::");
			System.out.println("과정번호 : "+su.getNo());
			System.out.println("과정명 : "+su.getName());
			System.out.println("정원수 : "+su.getLimit());
			System.out.println("교수번호 : "+pr.getNo());
			System.out.println("교수이름 : "+pr.getName());			
			System.out.println("::::::::::::::::::");
		}	
	}

	public void displayCurrentCourseCircumstanceBySubjectId(ArrayList<CourseVO> courseList) {
		for (CourseVO course : courseList) {
			SubjectVO su = course.getSubject();
			ProfessorVO pr = su.getProfessor();
			System.out.println("::::::::::::::::::");
			System.out.println("과정번호 : "+su.getNo());
			System.out.println("과정명 : "+su.getName());
			System.out.println("정원수 : "+su.getLimit());
			System.out.println("현재인원 : "+course.getCnt());
			System.out.println("교수번호 : "+pr.getNo());
			System.out.println("교수이름 : "+pr.getName());
			System.out.println("교수직위 : "+pr.getPosition());
			System.out.println("담당교수 연락처 : "+pr.getPhone());			
			System.out.println("::::::::::::::::::");
		}	
	}
	
	public void displayCurrentCourseCircumstanceByProfessorNo(ArrayList<CourseVO> courseList) {
		for (CourseVO course : courseList) {
			SubjectVO su = course.getSubject();
			System.out.println("::::::::::::::::::");
			System.out.println("과정번호 : "+su.getNo());
			System.out.println("과정명 : "+su.getName());
			System.out.println("정원수 : "+su.getLimit());
			System.out.println("현재인원 : "+course.getCnt());			
			System.out.println("::::::::::::::::::");
		}	
	}
}
