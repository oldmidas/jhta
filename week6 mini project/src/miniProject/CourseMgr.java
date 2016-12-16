package miniProject;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CourseMgr {
	ArrayList<Student> students = new ArrayList<>();
	ArrayList<Professor> professors = new ArrayList<>();
	ArrayList<Course> courses = new ArrayList<>();
	
	Professor pLogon = null;
	Student sLogon = null;
		
	// 가입하기
	public void pReg(Professor p) {
		professors.add(p);
	}
	
	public void sReg(Student s) {
		students.add(s);
	}
	
	
	// 로그인하기
	public void pLogin(String id, String pw) {
		if (pLogon != null) {
			System.out.println("이미 로그인 중입니다.");
			return;
		}
		for (Professor prof : professors) {
			if ((prof.getId().equals(id)) && (prof.getPw().equals(pw))) {
				pLogon = prof;
				System.out.println("로그인 되었습니다.");
				return;
			}	
		}
	}
	
	public void sLogin(String id, String pw) {
		if (sLogon != null) {
			System.out.println("이미 로그인 중입니다.");
			return;
		}
		for (Student stud : students) {
			if ((stud.getId().equals(id)) && (stud.getPw().equals(pw))) {
				sLogon = stud;
				System.out.println("로그인 되었습니다.");
				return;
			}
		}
	}
	
	
	// 로그아웃하기
	public void pLogout() {
		if (pLogon != null) {
			pLogon = null;
		} else {
			System.out.println("로그인부터 해주세요.");
		}
	}
	
	public void sLogout() {
		if (sLogon != null) {
			sLogon = null;
		} else {
			System.out.println("로그인부터 해주세요.");
		}
	}

	
	
	// 신규 과정 등록하기	
	public void pRegCourse(Course c) {
		courses.add(c);
	}
	
	
	// 내가 등록한 과정 조회하기	
	public void pCoursesDisplay () {
		for (Course c : courses) {
			if (pLogon.getCourseList().size() == 0) {
				System.out.println("등록하신 과정이 없습니다.");
				return;
			}
			for (String s : pLogon.getCourseList()) {
				if (c.getCode().equals(s)) {
					System.out.println("====================");
					System.out.println("과정코드" + c.getCode());
					System.out.println("과 정 명" + c.getTitle());
					System.out.println("담당교수" + c.getProf().getName());
					System.out.println("학생정원" + c.getStudents().size() + "/" + c.getLimit());
					System.out.println("====================");
				}
			}
		}
//			if (c.getProf().equals(pLogon)) {
//				System.out.println("====================");
//				System.out.println("과정코드" + c.getCode());
//				System.out.println("과 정 명" + c.getTitle());
//				System.out.println("담당교수" + c.getProf().getName());
//				System.out.println("학생정원" + c.getStudents().size() + "/" + c.getLimit());
//				System.out.println("====================");
//			} else {
//				System.out.println("등록하신 과정이 없습니다.");
//			}	
	}	
	
	
	// 내가 등록한 과정 신청한 학생 조회하기	
	
	public void pCoursesRegStud () {
		for (Course c : courses) {
			if (pLogon.getCourseList().size() == 0) {
				System.out.println("등록하신 과정이 없습니다.");
				return;
			}
			for (String s : pLogon.getCourseList()) {
				if (c.getCode().equals(s)) {
					System.out.println("====================");
					System.out.println("과정코드" + c.getCode());
					System.out.println("과 정 명" + c.getTitle());
					System.out.println("담당교수" + c.getProf().getName());
					System.out.println("등록학생 명단");
					if (c.getStudents() != null) {
						for (Student s2 : c.getStudents())
							 System.out.println(s2.getName());
					}
					System.out.println("====================");
				}
			}
		}
	}
	
//	public void pCoursesRegStud () {
//		if (pLogon == null) {
//			System.out.println("로그인부터 해주세요.");
//			return;
//		}
//		for (Course c : courses) {
//			if (c.getProf().equals(pLogon)) {
//				System.out.println("====================");
//				System.out.println("과정코드" + c.getCode());
//				System.out.println("과 정 명" + c.getTitle());
//				System.out.println("담당교수" + c.getProf().getName());
//				System.out.println("등록학생 명단");
//				if (c.getStudents() != null) {
//					for (Student s : c.getStudents())
//						 System.out.println(s.getName());
//				}
//				System.out.println("====================");
//			} else {
//				System.out.println("등록하신 과정이 없습니다.");
//			}
//		}
//	}
	
	
	// 열린 과정 조회하기	
	public void sDisplayCourses () {
		if (courses != null) {
			for (Course c : courses) {
				System.out.println("====================");
				System.out.println("과정코드" + c.getCode());
				System.out.println("과 정 명" + c.getTitle());
				System.out.println("담당교수" + c.getProf().getName());
				System.out.println("학생정원" + c.getStudents().size() + "/" + c.getLimit());
				System.out.println("====================");
			}
		} else {
			System.out.println("열린 과정 없음");
		}
	}
	
	// 수강 신청하기
	public void sRegCourse (String code) {
		for (Course c : courses) {
			if (c.getCode().equals(code)) {
				if (c.getStudents().size() == c.getLimit()) {
					System.out.println("정원이 꽉찼습니다.");
					return;
				}
			for (Student s : c.getStudents()) {
				if (s.getNo().equals(sLogon.getNo())) {
					System.out.println("이미 신청한 과정입니다.");
					return;
				}
			}
		} 
			
			if (c.getCode().equals(code)) {
				c.getStudents().add(sLogon);
				System.out.println("수강 신청 성공");
				sLogon.getCourseList().add(code);
				break;
			}
			
		}
	}
	
	// 내가 등록한 수강 조회하기
	public void sDisplayRegCourses () {
		for (Course c : courses) {
			if (sLogon.getCourseList().size() == 0) {
				System.out.println("등록하신 과정이 없습니다.");
				return;
			}
			for (String s : sLogon.getCourseList()) {
				if (c.getCode().equals(s)) {
					System.out.println("====================");
					System.out.println("과정코드" + c.getCode());
					System.out.println("과 정 명" + c.getTitle());
					System.out.println("담당교수" + c.getProf().getName());
					System.out.println("학생정원" + c.getStudents().size() + "/" + c.getLimit());
					System.out.println("====================");
				}
			}
		}
	}
	
	//객체 로드	
	public void studentLoad() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.sav"));
		students = (ArrayList<Student>)ois.readObject();
		ois.close();
	}
	
	public void professorLoad() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("professors.sav"));
		professors = (ArrayList<Professor>)ois.readObject();
		ois.close();
	}
	
	public void courseLoad() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("courses.sav"));
		courses = (ArrayList<Course>)ois.readObject();
		ois.close();
	}
}
