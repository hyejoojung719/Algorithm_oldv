package com.ssafy.interfacehw3;

public class Magazine extends Book{

	private int year;
	private int month;
	
	public Magazine() {
		super();
	}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
		super(isbn, title, author, publisher, price, desc );
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return this.getIsbn() + "		| " + this.getTitle() + "		| " + this.getAuthor() + "	| " + this.getPublisher() 
		+ "		| " + this.getPrice() + "		| " + this.getDesc() + "		| " + year + "		| " + month;
	}

	
	
	
}
