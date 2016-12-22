package student_manager;

import java.util.Date;

public class CourseVO {
	private StudentVO student;
	private SubjectVO subject;
	private Date regdate;
	private int cnt;
	
	public CourseVO() {}
	
	public CourseVO(StudentVO student, SubjectVO subject, Date regdate, int cnt) {
		this.student = student;
		this.subject = subject;
		this.regdate = regdate;
		this.cnt = cnt;
	}

	public StudentVO getStudent() {
		return student;
	}

	public void setStudent(StudentVO student) {
		this.student = student;
	}

	public SubjectVO getSubject() {
		return subject;
	}

	public void setSubject(SubjectVO subject) {
		this.subject = subject;
	}

	public Date getDate() {
		return regdate;
	}

	public void setDate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
