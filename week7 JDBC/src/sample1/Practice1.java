package sample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("========");
				System.out.println("1.학생등록");
				System.out.println("2.교수등록");
				System.out.println("3.과목등록");
				System.out.println("4.학생조회");
				System.out.println("5.교수조회");
				System.out.println("6.과목조회");
				System.out.println("7.학생삭제");
				System.out.println("8.교수삭제");
				System.out.println("9.과목삭제");				
				System.out.println("0.종료");				
				System.out.println("========");
				int menu = Integer.parseInt(sc.nextLine());
				
				if (menu == 1) {
					studentReg();
				} else if (menu == 2) {
					professorReg();
				} else if (menu == 3) {
					subjectReg();
				} else if (menu == 4) {
					displayStudent();
				} else if (menu == 5) {
					displayProfessor();
				} else if (menu == 6) {
					displayCourse();
				} else if (menu == 7) {
					studentRemove();
				} else if (menu == 8) {
					professorRemove();
				} else if (menu == 9) {
					subjectRemove();
				} else if (menu == 0) {
					sc.close();
					break;
				} else {
					System.out.println("올바른 메뉴를 선택하세요.");
				}		
			}	
	}
	public static void studentReg() throws Exception {
		Scanner sc1 = new Scanner(System.in);
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		System.out.println("번호를 입력하세요>");
		int no = Integer.parseInt(sc1.nextLine());
		System.out.println("이름을 입력하세요>");
		String name = sc1.nextLine();
		System.out.println("전공을 입력하세요>");
		String major = sc1.nextLine();
		System.out.println("학년을 입력하세요>");
		int grade = Integer.parseInt(sc1.nextLine());
		System.out.println("핸드폰번호를 입력하세요>");
		String phone = sc1.nextLine();
		
		String sql = "INSERT INTO TB_STUDENT VALUES("+no+", '"+name+"', '"+major+"', "+grade+", '"+phone+"')";
		Statement stmt = con.createStatement();
		
		int result = stmt.executeUpdate(sql);
		System.out.println(result + "개의 행이 업데이트 되었습니다.");
		stmt.close();
		con.close();
	}
	
	public static void professorReg() throws Exception {
		Scanner sc = new Scanner(System.in);
		//1. 레지스트리 등록
		Class.forName("oracle.jdbc.OracleDriver");
		//2. 코넥션 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. 스테이트먼트 얻어오기
		Statement stmt = con.createStatement();
		
		//4. 업데이트하기
		System.out.println("번호를 입력하세요>");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("이름을 입력하세요>");
		String name = sc.nextLine();
		System.out.println("전공을 입력하세요>");
		String major = sc.nextLine();
		System.out.println("직위를 입력하세요>");
		String position = sc.nextLine();
		System.out.println("핸드폰번호를 입력하세요>");
		String phone = sc.nextLine();
		
		String sql = "INSERT INTO TB_PROFESSOR VALUES("+no+", '"+name+"', '"+major+"', '"+position+"', '"+phone+"')";
		
		int result = stmt.executeUpdate(sql);
		System.out.println(result+"개의 행이 추가되었습니다.");
		
		//연결끊기
		stmt.close();
		con.close();
	}
	
	public static void subjectReg() throws Exception {
		Scanner sc = new Scanner(System.in);
		//1. 드라이버 등록
		Class.forName("oracle.jdbc.OracleDriver");
		//2. 코넥션연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		Connection con = DriverManager.getConnection(url, user, password);
		//3. 스테이트먼트 생성
		Statement stmt = con.createStatement();
		//4. 쿼리등록
		System.out.println("번호를 입력하세요>");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("과정명을 입력하세요>");
		String title = sc.nextLine();
		System.out.println("정원수를 입력하세요>");
		int limit = Integer.parseInt(sc.nextLine());
		System.out.println("교수번호를 입력하세요>");
		int profNo = Integer.parseInt(sc.nextLine());
		System.out.println("분야를 선택하세요.(전공/교양)");
		String type = sc.nextLine();
		
		String sql = "INSERT INTO TB_SUBJECT VALUES("+no+", '"+title+"', "+limit+", "+profNo+", '"+type+"')";
		int result = stmt.executeUpdate(sql);
		System.out.println(result+"개의 행이 추가되었습니다.");
		//5.연결해제
		stmt.close();
		con.close();
	}
	
	public static void displayStudent() throws Exception {
		//학생번호, 이름, 전공, 학년, 전화번호
		//1.드라이버 불러오기
		Class.forName("oracle.jdbc.OracleDriver");
		//2.코넥션
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		Connection con = DriverManager.getConnection(url, user, password);
		//3.스테이트먼트
		Statement stmt = con.createStatement();
		//4. 쿼리요청
		String sql = "SELECT NO, NAME, MAJOR, GRADE, PHONE FROM TB_STUDENT";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			String major = rs.getString("MAJOR");
			int grade = rs.getInt("GRADE");
			String phone = rs.getString("PHONE");
			System.out.println("학번 : "+no+" 이름 : "+name+" 전공 : "+major+" 학년 : "+grade+" 연락처 : "+phone+"");
		}
		rs.close();
		stmt.close();
		con.close();
	}
	
	public static void displayProfessor() throws Exception {
		//교수번호, 이름, 전공, 직위
		//1.드라이버 불러오기
		Class.forName("oracle.jdbc.OracleDriver");
		//2.커넥션
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		//3.스테이트먼트
		Statement stmt = con.createStatement();
		//4.쿼리요청
		ResultSet rs = stmt.executeQuery("SELECT NO, NAME, MAJOR, POSITION FROM TB_PROFESSOR");
		while (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			String major = rs.getString("MAJOR");
			String position = rs.getString("POSITION");
			System.out.println("교번 : "+no+" 이름 : "+name+" 전공 : "+major+" 직위 : "+position+"");
		}
		rs.close();
		stmt.close();
		con.close();
	}
	
	public static void displayCourse() throws Exception {
		//과정번호, 과정명, 담당교수, 종류, 정원
		//1.드라이버
		Class.forName("oracle.jdbc.OracleDriver");
		//2.코넥션
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		//3.스테이트먼트
		Statement stmt = con.createStatement();
		//4.쿼리요청
		String sql = "SELECT S.NO AS NO, S.NAME AS NAME, P.NAME AS PROF_NAME, S.TYPE AS TYPE, S.LIMIT AS LIMIT FROM TB_SUBJECT S, TB_PROFESSOR P WHERE S.PROF_NO=P.NO ORDER BY NO";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			int no = rs.getInt("NO");
			String title = rs.getString("NAME");
			String profName = rs.getString("PROF_NAME");
			String type = rs.getString("TYPE");
			int limit = rs.getInt("LIMIT");
			System.out.println("과정번호 : "+no+" 과정명 : "+title+" 담당교수 : "+profName+" 종류 : "+type+" 정원 : "+limit+"");
		}		
	}
		
	public static void studentRemove() throws Exception {
		Scanner sc = new Scanner(System.in);
		//1. 드라이버 등록
		Class.forName("oracle.jdbc.OracleDriver");
		//2. 코넥션
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		Connection con = DriverManager.getConnection(url, user, password);
		//3. 스테이트먼트
		Statement stmt = con.createStatement();
		//4. 쿼리요청
		System.out.println("지울 학생의 학번을 입력하세요.");
		int no = Integer.parseInt(sc.nextLine());
		String sql = "DELETE FROM TB_STUDENT WHERE NO="+no+"";
		int result = stmt.executeUpdate(sql);
		System.out.println(result+"개의 행이 삭제되었습니다.");
		//5.연결해제
		stmt.close();
		con.close();
	}
	
	public static void professorRemove() throws Exception {
		Scanner sc = new Scanner(System.in);
		//1. 드라이버 등록
		Class.forName("oracle.jdbc.OracleDriver");
		//2. 코넥션
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		//3. 스테이트먼트
		Statement stmt = con.createStatement();
		//4. 쿼리요청
		System.out.println("지울 교수의 교번을 입력하세요.");
		int result = stmt.executeUpdate("DELETE FROM TB_PROFESSOR WHERE NO="+Integer.parseInt(sc.nextLine())+"");
		System.out.println(result+"개의 행이 삭제되었습니다.");
		//5. 해제
		stmt.close();
		con.close();
	}
	
	public static void subjectRemove() throws Exception {
		Scanner sc = new Scanner(System.in);
		//1.드라이버 등록
		Class.forName("oracle.jdbc.OracleDriver");
		//2.코넥션
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:xe","hr","zxcv1234");
		//3.스테이트먼트
		Statement stmt = con.createStatement();
		//4.쿼리요청
		System.out.println("지울 과정의 번호를 입력하세요");
		int result = stmt.executeUpdate("DELETE FROM TB_SUBJECT WHERE NO ="+Integer.parseInt(sc.nextLine())+"");
		System.out.println(result+"개의 행이 삭제되었습니다.");
		//5.연결끊기
		stmt.close();
		con.close();
	}
}
