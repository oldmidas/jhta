package miniProject;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
	private String code;
	private String title;
	private Professor prof;
	private int limit;
	private ArrayList<Student> students = new ArrayList<> ();
	
	public Course() {}

	public Course(String code, String title, Professor prof, int limit, ArrayList<Student> students) {
		this.code = code;
		this.title = title;
		this.prof = prof;
		this.limit = limit;
		this.students = students;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
}
