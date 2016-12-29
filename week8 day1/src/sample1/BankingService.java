package sample1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.ConnectionUtil;

public class BankingService {
	public void 이체(String from, String to, int amount) {
		String sql1 = "UPDATE TB_ACCOUNT SET BALANCE = balance - ? WHERE NO = ? ";
		String sql2 = "UPDATE TB_ACCOUNT SET BALANCE = balance + ? * 1000000 WHERE NO = ? ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// -- tx(transaction) begin
			con = ConnectionUtil.getConnection();
			// 자동 commit 해제
			con.setAutoCommit(false);


			// 송금계좌의 잔액을 변경하기
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, amount);
			pstmt.setString(2, from);
			pstmt.executeUpdate();
			
			pstmt.close();
			System.out.println("입금자 잔액 변경 완료");
			
			// 수신계좌의 잔액을 변경하기
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, amount);
			pstmt.setString(2, to);
			pstmt.executeUpdate();
			
			pstmt.close();
			System.out.println("수신자 잔액 변경 완료");
			
			//연결해제
			con.close();
			
			//현재 트랜잭션내의 DB ACCESS작업을 반영시키기
			con.commit();
			System.out.println("에러 없음, 모든 db access작업 반영됨");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			//현재 트랜잭션내의 DB ACCESS작업을 전부 취소시키기
			try { con.rollback(); } catch (SQLException e1) {};
			System.out.println("에러 발생, rollback 실행, 모든 db access작업 취소됨");
			
		} finally {
			
			//연결해제
			try {con.close();} catch (SQLException e) {};
		}
	}
}
