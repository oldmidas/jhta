package sample3;

import java.util.ArrayList;
import java.util.Scanner;

public class BookApp2 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("최소가격을 입력하세요.");
		int minPrice = Integer.parseInt(sc.nextLine());
		System.out.println("최대가격을 입력하세요.");
		int maxPrice = Integer.parseInt(sc.nextLine());
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> bookList = dao.searchBooksByPrice(minPrice, maxPrice);
		
		for(BookVO book : bookList) {
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
