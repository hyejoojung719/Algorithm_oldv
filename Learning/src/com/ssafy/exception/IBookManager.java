package com.ssafy.exception;

public interface IBookManager {

	void add(Book book);
	
	void remove(String isbn);
	
	Book[] getList();
	
	Book searchByIsbn(String Isbn);
	
	Book[] searchByTitle(String title);
	
	Magazine[] getMagazines();
	
	Book[] getBooks();
	
	int getTotalPrice();
	
	double getPriceAvg();
	
	void sell(String isbn, int quantity) throws Exception;
	
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
}
