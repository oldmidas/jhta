package student_manager;

public class SubjectVO {
	private int no;
	private String name;
	private int limit;
	private String type;
	private ProfessorVO professor;
	
	public SubjectVO() {}

	public SubjectVO(int no, String name, int limit, String type, ProfessorVO professor) {
		super();
		this.no = no;
		this.name = name;
		this.limit = limit;
		this.type = type;
		this.professor = professor;
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

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProfessorVO getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorVO professor) {
		this.professor = professor;
	}
		
}
