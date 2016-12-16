package file.demo;

public class Book {
	private String name;
	private String author;
	private String publisher;
	private int price;
	
	public Book() {}

	public Book(String name, String author, String publisher, int price) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name + "," + author + "," + publisher + "," + price;
	}
	
}
