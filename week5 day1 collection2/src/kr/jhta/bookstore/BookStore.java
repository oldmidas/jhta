package kr.jhta.bookstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * <p>도서 대여점의 대여, 등의 기능을 구현하였습니다.
 * @author 윤용학
 *
 */
public class BookStore {
	
	private ArrayList<Customer> customerList = new ArrayList<>();
	private ArrayList<Book> bookList = new ArrayList<>();
	private Customer loginId = null;
	Scanner sc = new Scanner(System.in);
	
	/**
	 * <p>도서대여정의 기본생성자
	 * 
	 * <p>객체 생성시 기본적으로 고객 한명의 정보와 책 10권을 각각 등록한다.
	 * @author 윤용학
	 */
	
	public BookStore() {
		Customer customer = new Customer("yong", "yong", "0000", "010-xxxx-xxxx", "yong@yong.com", new Date() , 100000);
		customerList.add(customer);
		bookList.add(new Book(1, "설민석의 조선왕조 실록", 20000));
		bookList.add(new Book(2, "해리포터와 저주받은 아이", 15000));
		bookList.add(new Book(3, "그럴 때 있으시죠?", 15000));
		bookList.add(new Book(4, "그릿 Grit", 16000));
		bookList.add(new Book(5, "대통령의 글쓰기", 17000));
		bookList.add(new Book(6, "트랜드 코리아", 18000));
		bookList.add(new Book(7, "브루클린의 소녀", 13500));
		bookList.add(new Book(8, "강성태 66 공부법", 12500));
		bookList.add(new Book(9, "지대넓얕", 17000));
		bookList.add(new Book(10, "미움받을 용기", 13000));
	}
	
	
	private boolean isExistId(String id) {
		boolean isExist = false;
		
		for (Customer customer : customerList) {
			if (customer.getId().equals(id)) {
				isExist = true;
				break;
			}
		}
		return isExist;
	}
	/**
	 * <p> 회원가입 메소드
	 * @author 윤용학
	 */
	
	public void register() {
		if (loginId != null) {
			System.out.println("이미 로그인 되어있습니다.");
			return;
		}
		System.out.println("아이디를 입력하세요>");
		String id = sc.next();
		if (isExistId(id)) {
			System.out.println("이미 사용중인 아이디입니다.");
			return;
		}
		System.out.println("비밀번호를 입력하세요>");
		String pw = sc.next();

		System.out.println("이름을 입력하세요>");
		String name = sc.next();
						
		System.out.println("연락처를 입력하세요>");
		String tel = sc.next();
		
		System.out.println("이메일을 입력하세요>");
		String email = sc.next();
		
		Date now = new Date();
					
		int point = 0;
		
		Customer customer = new Customer(name, id, pw, tel, email, now , point);
		customerList.add(customer);
	}
	
	/**
	 * <p> 로그인 메소드
	 * @author 윤용학
	 */
	
	public void login() {
		if (loginId != null) {
			System.out.println("이미 로그인 중 입니다.");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디를 입력하세요>");
		String id = sc.next();
		
		System.out.println("비밀번호를 입력하세요>");
		String pw = sc.next();
		
		for (Customer customer : customerList) {
			if (id.equals(customer.getId()) && pw.equals(customer.getPw())) {
				loginId = customer;
				System.out.print("["+customer.getName()+"]님 환영합니다.");
			} 
//			else {
//				System.out.println("아이디 혹은 비밀번호가 잘못되었습니다.");				
//			}
		}
		if (loginId == null) {
			System.out.print("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
	}
	/**
	 * <p>로그아웃 메소드
	 * @author 윤용학
	 */
	public void logout() {
		if (loginId != null)
			System.out.println("["+loginId.getName()+"]님 bye~");
			loginId = null;
	}

	/**
	 * <p>도서대여점에 있는 도서를 표시하는 메솓,
	 * @author 윤용학
	 */

	public void displayBooks() {
		/*
		 * 번호		제목						가격
		 * --------------------------------------
		 * 1		해리포터와 저주받은 아이		18000
		 * 2		트랜드코리아				25000
		 */
		System.out.printf("%s\t%-20s\t%s\n","번호","제목","가격");
		System.out.println("--------------------------------------");
		for (Book book : bookList) {
			// 정규표현식을 사용할 수도 있다.
			System.out.printf("%d\t%-20s\t%d\n",book.getNo(),book.getTitle(),book.getPrice());
			
		}
	}
	
	public void rentBooks() {
		if (loginId != null) {
			System.out.print("책번호를 입력하세요>");
			int bookNo = Integer.parseInt(sc.next());
			boolean isExist = false;

			for (Book book : bookList) {
				if (bookNo == book.getNo()) {
					isExist = true;
					loginId.addRental(book);
					System.out.println("대여성공!");
					return;
				}
			}
			if (!isExist) {
				System.out.println("일치하는 책정보가 없습니다.");
			}
		} else {
			System.out.println("로그인부터 하세요.");			
		}
	}

	public void returnBooks() {
		if (loginId != null) {
			System.out.print("반납할 책번호를 입력하세요>");
			int bookNo = Integer.parseInt(sc.next());
			boolean isExist = false;
			for (Rental rental : loginId.returnRental()) {
				if (bookNo == rental.getBook().getNo()) {
					while (!rental.isBack()) {
						System.out.println("반납성공!");
						rental.setBack(true);
						return;						
					}					
				}					
			}
			if (!isExist) {
				System.out.println("일치하는 책정보가 없습니다.");
			}
		} else {
			System.out.println("로그인부터 하세요.");
		}
	}

	public void displayRental() {
		if (loginId != null) {
			System.out.println("=========대여내역==========");
			for (Rental rental : loginId.returnRental()) {
				System.out.println(rental.toString());
			}			
		} else {
			System.out.println("로그인부터 하세요.");
		}		
	}
}
