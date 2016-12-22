package student_manager;

public class ProfessorVO {
	
	private int no;
	private String name;
	private String major;
	private String position;
	private String phone;
	
	public ProfessorVO() {}
	
	public ProfessorVO(int no, String name, String major, String position, String phone) {
		super();
		this.no = no;
		this.name = name;
		this.major = major;
		this.position = position;
		this.phone = phone;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	
}
