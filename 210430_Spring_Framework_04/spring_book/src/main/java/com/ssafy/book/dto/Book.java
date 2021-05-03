package com.ssafy.book.dto;

public class Book {
	private String isbn;
	private String title;
	private int price;
	private String author;
	private String dcpt;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDcpt() {
		return dcpt;
	}
	public void setDcpt(String dcpt) {
		this.dcpt = dcpt;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", author=" + author + ", dcpt=" + dcpt
				+ "]";
	}
	
}
