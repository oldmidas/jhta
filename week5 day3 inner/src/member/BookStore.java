package member;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.SimpleAttributeSet;

public class BookStore {
	private String userId;
	private int point;
	private Date loginDate;
	
	
	public void login() {
		userId = "hong";
		point = 1000000;
		loginDate = new Date();
	}
	
	public void display() {
		// 사용자 아이디, 포인트, 로그인 날짜가 표시된다.
		BookStoreUtil util = new BookStoreUtil();
		System.out.println("아이디	: " + userId);
		System.out.println("포인트	: " + util.getPointWithComma());
		System.out.println("로그인시간	: " + util.getStringDate());
		
	}
	
	public class BookStoreUtil {
		// 로그인한 날짜를 지정한 형식에 맞게 변환해서 반환하는 기능
		public String getStringDate() {
				if (loginDate == null) {
					return "";					
				}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss;");
			return sdf.format(loginDate);
		}
		// 포인트값을 ","가 포함된 텍스트로 변환해서 반환하는 기능
		public String getPointWithComma() {
			DecimalFormat df = new DecimalFormat("#,###");
			return df.format(point);
		}
	}
		
	public class Book {
		int x;
		//static int y; --> 정적 필드 선언불가
		public void m1() {}
		//public static void m2() {} --> 정적 메소드 선언불가
	}	
}

