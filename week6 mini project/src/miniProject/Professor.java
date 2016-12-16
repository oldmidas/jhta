package miniProject;

import java.io.Serializable;
import java.util.ArrayList;

public class Professor implements Serializable {
	private String no;
	private String name;
	private String major;
	private String position;
	private String id;
	private String pw;
	private ArrayList<String> courseList = new ArrayList<>(); 
	
	public Professor() {}

	public Professor(String no, String name, String major, String position, String id, String pw) {
		super();
		this.no = no;
		this.name = name;
		this.major = major;
		this.position = position;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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