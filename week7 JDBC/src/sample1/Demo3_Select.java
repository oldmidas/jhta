package sample1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo3_Select {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@192.168.10.101:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		String sql = "SELECT * FROM TB_BOOK ORDER BY NO ASC";
		
		ResultSet rs = stmt.executeQuery(sql);
				
		while (rs.next()) {
			int no = rs.getInt("NO"); 
			String title = rs.getString("TITLE"); 
			String author = rs.getString("AUTHOR"); 
			String publisher = rs.getString("PUBLISHER");
			int price = rs.getInt("PRICE");
			Date date = rs.getDate("PUBDATE");
			System.out.println(no + ", " + title + ", " + author + ", " + publisher + ", " + price + ", " + date);
		}
		
		rs.close();
		stmt.close();
		con.close();
		
	}
}