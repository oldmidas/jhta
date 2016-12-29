package sample3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionUtil;

public class BookDAO {
	public void insertBook(BookVO book) throws SQLException {
		String sql = "INSERT INTO TB_BOOK(NO, TITLE, AUTHOR, PUBLISHER, PRICE, PUBDATE) "
				+ "VALUES(BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getPublisher());
		pstmt.setInt(4, book.getPrice());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
}
