package miniProject;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	private String no;
	private String name;
	private String major;
	private String grade;
	private String id;
	private String pw;
	private ArrayList<String> courseList = new ArrayList<>(); 
	
	public Student() {}

	public Student(String no, String name, String major, String grade, String id, String pw) {
		this.no = no;
		this.name = name;
		this.major = major;
		this.grade = grade;
		this.id = id;
		this.pw = pw;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public ArrayList<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<String> courseList) {
		this.courseList = courseList;
	}
	
}