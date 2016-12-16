package kr.jhta.bookstore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Rental {
	/*
	 * Rental 객체생성
	 * Rental에 고객정보저장
	 * 책번호에 해당하는 책정보를 찾아서 Rental에 저장
	 * 대여일을 Rental에 저장
	 * 반납여부를 false로 저장
	 * Rental 객체를 rentalList에 저장
	 */
	private Customer customer;
	private Book book;
	private Date date;
	private boolean isBack;

	
	public Rental() {}
	
	public Rental(Customer customer, Book book, Date date, boolean isBack) {
		super();
		this.customer = customer;
		this.book = book;
		this.date = date;
		this.isBack = isBack;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isBack() {
		return isBack;
	}

	public void setBack(boolean isBack) {
		this.isBack = isBack;
	}
	
	public String getGoodDate() {
		String pattern = "yyyy년 MM월 dd일";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public String getIsBack() {
		if (isBack) {
			return "반납완료";
		} else {
			return "미반납";
		}
	}

	@Override
	public String toString() {
		return "대여내역조회 >>>" + book + ", 대여일: " + getGoodDate() + ", 반납여부: " + getIsBack();
	}
}