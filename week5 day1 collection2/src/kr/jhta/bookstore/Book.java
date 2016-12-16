package kr.jhta.bookstore;

public class Book {
	private int no;
	private String title;
	private int price;
	
	public Book() {}

	public Book(int no, String title, int price) {
		super();
		this.no = no;
		this.title = title;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "번호: " + no + ", 제목: " + title + ", 가격: " + price;
	}
	
	

}
