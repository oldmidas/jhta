package miniProject;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseApp {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		CourseMgr mgr = new CourseMgr();

	//파일 불러오기
		
		try { 
			mgr.courseLoad();
			mgr.professorLoad();
			mgr.studentLoad();
		} catch (Exception e) {
			
		}
		
		while (true) {
			System.out.println("===============");
			System.out.println("1.교수 2.학생 0.종료");
			System.out.println("===============");
			System.out.println("메뉴를 선택하세요.");			
			int firstmenu = Integer.parseInt(sc.nextLine());
			
			//교수용
			if (firstmenu == 1) {
				while (true) {
					System.out.println("========교수전용=========");
					System.out.println("1.로그인 2.가입하기 0.이전메뉴");
					System.out.println("======================");
					System.out.println("메뉴를 선택하세요.");
					int profMenu = Integer.parseInt(sc.nextLine());
					if (profMenu == 1) {
						System.out.println("아이디를 입력하세요.");
						String id = sc.nextLine();						
						System.out.println("비밀번호를 입력하세요.");
						String pw = sc.nextLine();
						mgr.pLogin(id, pw);
						
						if (mgr.pLogon != null) {
							while (true) {
								System.out.println("================");
								System.out.println("1.새로운 과정 개설하기");
								System.out.println("2.내가 개설한 과정 조회");
								System.out.println("3.내 과정 등록학생 조회");
								System.out.println("0.로그아웃");
								System.out.println("================");
								int profSecondMenu = Integer.parseInt(sc.nextLine());
								
								if (profSecondMenu == 1) {
									System.out.println("개설과정의 코드를 입력하세요.");
									String code = sc.nextLine();
									boolean isExist = false;
									for (Course course : mgr.courses) {
										if (course.getCode().equals(code)) {
											System.out.println("이미 사용중인 과정코드입니다.");
											isExist = true;
											break;
										}
										break;
									}
									if (!isExist) {
										System.out.println("개설과정명을 입력하세요.");
										String title = sc.nextLine();
										System.out.println("최대 학생 정원수를 입력하세요");
										int limit = Integer.parseInt(sc.nextLine());
										Course c = new Course(code, title, mgr.pLogon, limit, new ArrayList<Student>());
										mgr.pRegCourse(c);
										mgr.pLogon.getCourseList().add(code);
										System.out.println("과정이 등록되었습니다.");
									}
									
								} else if (profSecondMenu == 2) {
									mgr.pCoursesDisplay();
								} else if (profSecondMenu == 3) { 
									mgr.pCoursesRegStud();
								} else if (profSecondMenu == 0) {
									System.out.println("로그아웃 합니다.");
									mgr.pLogout();
									break;
								} else {
									System.out.println("잘못된 번호입니다.");
								}
							}
						} else {
							System.out.println("아이디 혹은 비밀번호가 잘못되었습니다.");	
						}
						
					} else if (profMenu == 2) {
						System.out.println("아이디를 입력하세요.");
						String id = sc.nextLine();
						boolean isExist = false;
						for(Professor p : mgr.professors) {
							if (p.getId().equals(id)) {
								System.out.println("이미 사용중인 아이디입니다.");
								isExist = true;
								break;
							}
						}
						if (!isExist) {
							System.out.println("비밀번호를 입력하세요.");
							String pw = sc.nextLine();
							System.out.println("교수번호를 입력하세요.");
							String no = sc.nextLine();
							boolean isExist2 = false; 
							if (!isExist2) {
								for(Professor p : mgr.professors) {
									if (p.getNo().equals(no)) {
										System.out.println("이미 사용중인 교수번호입니다.");
										isExist2 = true;
										break;
									}
								}
								System.out.println("이름을 입력하세요.");
								String name = sc.nextLine();
								System.out.println("전공을 입력하세요.");
								String major = sc.nextLine();
								System.out.println("직위를 입력하세요.");
								String position = sc.nextLine();
								
								Professor prof = new Professor(no, name, major, position, id, pw);
								mgr.pReg(prof);
								System.out.println(prof.getName()+"님 등록되었습니다.");
							}
						}
					} else if (profMenu == 0) {
						break;
					} else {
						System.out.println("잘못된 번호입니다.");
					}
				}
	
				
			//학생용
			} else if (firstmenu == 2) {	
				while (true) {
					System.out.println("========학생전용=========");
					System.out.println("1.로그인 2.가입하기 0.이전메뉴");
					System.out.println("======================");
					System.out.println("메뉴를 선택하세요.");
					int studMenu = Integer.parseInt(sc.nextLine());
					if (studMenu == 1) {
						System.out.println("아이디를 입력하세요.");
						String id = sc.nextLine();						
						System.out.println("비밀번호를 입력하세요.");
						String pw = sc.nextLine();
						mgr.sLogin(id, pw);
						
						if (mgr.sLogon != null) {
							while (true) {
								System.out.println("================");
								System.out.println("1.개설된 과정 조회");
								System.out.println("2.수강 신청");
								System.out.println("3.수강 신청한 과정 조회");
								System.out.println("0.로그아웃");
								System.out.println("================");
								int studSecondMenu = Integer.parseInt(sc.nextLine());
								
								if (studSecondMenu == 1) {
									mgr.sDisplayCourses();
																		
								} else if (studSecondMenu == 2) {
									System.out.println("수강신청할 과정의 코드를 입력하세요.");
									String code = sc.nextLine();
									mgr.sRegCourse(code);
								} else if (studSecondMenu == 3) { 
									mgr.sDisplayRegCourses();
								} else if (studSecondMenu == 0) {
									System.out.println("로그아웃 합니다.");
									mgr.sLogout();
									break;
								} else {
									System.out.println("잘못된 번호입니다.");
								}
							}
						} else {
							System.out.println("아이디 혹은 비밀번호가 잘못되었습니다.");	
						}
						
					} else if (studMenu == 2) {

						System.out.println("아이디를 입력하세요.");
						String id = sc.nextLine();
						boolean isExist = false;
						for(Student s : mgr.students) {
							if (s.getId().equals(id)) {
								System.out.println("이미 사용중인 아이디입니다.");
								isExist = true;
								break;
							}
						}
						if (!isExist) {
							System.out.println("비밀번호를 입력하세요.");
							String pw = sc.nextLine();
							System.out.println("학생번호를 입력하세요.");
							String no = sc.nextLine();
							boolean isExist2 = false;
							if (!isExist2) {
								for(Student s : mgr.students) {
									if (s.getNo().equals(no)) {
										System.out.println("이미 사용중인 학생번호입니다.");
										break;
									}
								}
								System.out.println("이름을 입력하세요.");
								String name = sc.nextLine();
								System.out.println("전공을 입력하세요.");
								String major = sc.nextLine();
								System.out.println("학년을 입력하세요. 예)1학년");
								String grade = sc.nextLine();
								
								Student stud = new Student(no, name, major, grade, id, pw);
								mgr.sReg(stud);
								System.out.println(stud.getName()+"님 등록되었습니다.");
							}
						}
						
					} else if (studMenu == 0) {
						break;
					} else {
						System.out.println("잘못된 번호입니다.");
					}
				}
	
				
			} else if (firstmenu == 0) {
				// 파일 내보내기
				
				ObjectOutputStream oosStudent = new ObjectOutputStream(new FileOutputStream("students.sav"));
				ObjectOutputStream oosProfessor = new ObjectOutputStream(new FileOutputStream("professors.sav"));
				ObjectOutputStream oosCourse = new ObjectOutputStream(new FileOutputStream("courses.sav"));
				
				oosStudent.writeObject(mgr.students);
				oosProfessor.writeObject(mgr.professors);
				oosCourse.writeObject(mgr.courses);
				System.out.println("시스템이 종료됩니다.");
				oosStudent.close();
				oosProfessor.close();
				oosCourse.close();
				sc.close();
				break;
			} else {
				System.out.println("잘못된 번호입니다.");
			}
		}
		
		
	}
}
