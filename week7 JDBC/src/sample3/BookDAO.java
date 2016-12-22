package sample3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

/**
 * TB_BOOK 테이블을 대상으로하는 엑세스 작업이 구현된 클래스이다.
 * @author 윤용학
 *
 */
public class BookDAO {
	/**
	 * 새로운 책정보를 전달받아서 TB_BOOK 테이블에 저장한다.
	 * @param book 추가할 책정보를 포함하는 Book 객체
	 * @throws SQLException
	 */
	public void addBook(BookVO book) throws SQLException {
		String sql = "INSERT INTO TB_BOOK(NO, TITLE, AUTHOR, PUBLISHER, PRICE, PUBDATE) "
				+ "VALUES(BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		
		//1,2.드라이브연결, 커넥션 연결
		Connection con = ConnectionUtil.getConnection();
		
		//3. 스테이트먼트 생성, 쿼리 작성, 값 입력
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getPublisher());
		pstmt.setInt(4, book.getPrice());
		
		//4. 값 전송
		pstmt.executeUpdate();
		
		//5. 연결해제
		pstmt.close();
		con.close();
	}
	
	public ArrayList<BookVO> searchBooksByPrice(int min, int max) throws SQLException {
		ArrayList<BookVO> booklist = new ArrayList<>();
		
		String sql = "SELECT NO, TITLE, AUTHOR, PUBLISHER, PRICE, PUBDATE "
				+ "FROM TB_BOOK "
				+ "WHERE PRICE>=? AND PRICE<=?";

		Connection con = ConnectionUtil.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, min);
		pstmt.setInt(2, max);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			booklist.add(new BookVO(rs.getInt("NO"), rs.getString("TITLE"), rs.getString("AUTHOR"), rs.getString("PUBLISHER"), rs.getInt("PRICE"), rs.getDate("PUBDATE")));
		}
	
		//5. 해제
		rs.close();
		pstmt.close();
		con.close();
		
		return booklist;
	}
	
	public ArrayList<BookVO> searchBooksByTitle(String keyword) throws SQLException {
		ArrayList<BookVO> booklist = new ArrayList<>();
		
		String sql = "SELECT NO, TITLE, AUTHOR, PUBLISHER, PRICE, PUBDATE "
				+ "FROM TB_BOOK "
				+ "WHERE TITLE LIKE '%' || ? || '%'";
				
		Connection con = ConnectionUtil.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, keyword);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			booklist.add(new BookVO(rs.getInt("NO"),rs.getString("TITLE"),rs.getString("AUTHOR"),rs.getString("PUBLISHER"),rs.getInt("PRICE"), rs.getDate("PUBDATE")));	
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return booklist;
	}
}
