package comparator;

public class Movie {
	private String title;
	private String genre;
	private int no;
	private int price;
	
	public Movie() {}

	public Movie(String title, String genre, int no, int price) {
		super();
		this.title = title;
		this.genre = genre;
		this.no = no;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", genre=" + genre + ", no=" + no + ", price=" + price + "]";
	}
	
	
}
