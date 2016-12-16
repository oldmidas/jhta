package file.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BookStore {
	ArrayList<Book> bookList = new ArrayList<>();
	
	
	public BookStore() throws IOException {
		loadBookData();
	}
	
	void loadBookData() throws IOException {
		// books.txt 파일을 읽어서 책정보를 ArrayList에 담기
		// BufferedReader를 사용해서 파일내용 읽기
		BufferedReader bf = new BufferedReader(new FileReader("books.txt"));
		String count = null;
		while ((count=bf.readLine()) != null) {
			String[] datas = count.split(",");
			Book book = new Book(datas[0], datas[1], datas[2], Integer.parseInt(datas[3]));
			bookList.add(book);
		}
		bf.close();
	}
	
	public void displayBooks() {
		// ArrayList에 저장된 책정보를 화면에 출력하기
		for (Book book : bookList) {
			System.out.println(book.toString());
		}
	}
	
	public void addBook(Book book) {
		// 전달받은 책정보를 ArrayList에 저장하기
		bookList.add(book);
	}
	
	public void saveBooks() throws IOException {
		// ArrayList에 저장된 책정보를 books.txt 파일에 저장하기(덮어쓰기)
		PrintWriter bw = new PrintWriter(new FileWriter("Books.txt", true));
		for (Book book : bookList) {
			bw.println(book.toString());
		}
		bw.close();
	}
}