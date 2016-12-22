package sample2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		String sql = "INSERT INTO TB_BOOK(NO,TITLE,AUTHOR,PUBLISHER,PRICE,PUBDATE) "
				+ "VALUES(BOOK_SEQ.NEXTVAL,?,?,?,?,SYSDATE)";
		
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "이것이 자바다");
		pstmt.setString(2, "신용권");
		pstmt.setString(3, "한빛미디어");
		pstmt.setInt(4, 35000);
		
		int result = pstmt.executeUpdate();
		System.out.println(result + "개의 행이 추가 되었습니다.");
		
		pstmt.close();
		con.close();		
	}
}
