package student_manager;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StudentDAO studentDAO = new StudentDAO();
		CourseDAO courseDAO = new CourseDAO();
		Display display = new Display();
		RegisterStudent register = new RegisterStudent();
		
		while(true) {		
			System.out.println("==============");
			System.out.println("1.학생 등록하기");
			System.out.println("2.학번으로 학생찾기");
			System.out.println("3.아이디로 학생찾기");
			System.out.println("4.수강 현황 조회하기");
			System.out.println("5.학생 번호로 수강 조회하기");
			System.out.println("6.과정 번호로 조회하기");
			System.out.println("7.교수 번호로 과정 조회하기");
			System.out.println("0.종료");
			System.out.println("==============");
			
			int menu = Integer.parseInt(sc.nextLine());	
			
			if (menu == 1) {
				studentDAO.addStudent(register.studentRegister(sc));
				
			} else if (menu == 2) {
				System.out.println("검색할 학생번호를 입력하세요.");
				display.displayStudentPersonalInfo(studentDAO.searchStudentByStudentNo(Integer.parseInt(sc.nextLine())));
				
			} else if (menu == 3) {
				System.out.println("검색할 학생아이디를 입력하세요.");
				display.displayStudentPersonalInfo(studentDAO.searchByStudentByStudentId(sc.nextLine()));
				
			} else if (menu == 4) {
				display.displayCurrentCourseCircumstance(courseDAO.getAllCourseList());
				
			} else if (menu == 5) {
				System.out.println("수강조회할 학생의 번호를 입력하세요.");
				display.displayCurrentCourseCircumstanceByStudentId(courseDAO.searchCourseByStudentNo(Integer.parseInt(sc.nextLine())));
				
			} else if (menu == 6) {
				System.out.println("조회할 과정번호를 입력하세요.");
				display.displayCurrentCourseCircumstanceBySubjectId(courseDAO.searchCourseBySubjectNo(Integer.parseInt(sc.nextLine())));
				
			} else if (menu == 7) {
				System.out.println("과정조회할 교수의 번호를 입력하세요.");
				display.displayCurrentCourseCircumstanceByProfessorNo(courseDAO.searchCourseByProfessorNo(Integer.parseInt(sc.nextLine())));
				
			} else if (menu == 0) {
				sc.close();
				break;
				
			} else {
				System.out.println("잘못된 번호입니다.");
			}
		}
		
	}
}
