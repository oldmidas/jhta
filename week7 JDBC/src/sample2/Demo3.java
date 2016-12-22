package sample2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		String sql = "SELECT COUNT(*) CNT FROM EMPLOYEES ";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.println("행의 개수 : " + rs.getInt("cnt"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
	}
}
