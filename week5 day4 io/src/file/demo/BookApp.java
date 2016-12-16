package file.demo;

public class BookApp {
	public static void main(String[] args) throws Exception {
		BookStore store = new BookStore();
		Book book = new Book("자바","제임스 고슬링","썬마이크로즈",20000);
		store.addBook(book);
		store.displayBooks();
		store.saveBooks();	
	}
}