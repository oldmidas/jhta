package sample3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookApp3 {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요.");
		String keyword = sc.nextLine();
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> bookList = dao.searchBooksByTitle(keyword);
		
		for (BookVO book : bookList) {
			System.out.println(":::::::::::::::");
			System.out.println("번    호:" + book.getNo());
			System.out.println("제    목:" + book.getTitle());
			System.out.println("저    자:" + book.getAuthor());
			System.out.println("출 판 사:" + book.getPublisher());
			System.out.println("가    격:" + book.getPrice());
			System.out.println("출 판 일:" + book.getPubdate());
			System.out.println(":::::::::::::::");
		}
		sc.close();
	}
}
