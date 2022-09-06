package com.ssafy.exception;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager{

	List<Book> books = new ArrayList<>();
	
	private static BookManagerImpl bm = new BookManagerImpl();
	
	private BookManagerImpl() {};
	
	public static BookManagerImpl getInstance() {
		return bm;
	}
	
	public void add(Book book) {
		books.add(book);
	}
	
	public void remove(String isbn) {
		
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) books.remove(i);
		}
	}
	
	public Book[] getList() {
		
		Book[] newArr = new Book[books.size()];
		
		books.toArray(newArr);
		
		return newArr;
	}
	
	public Book searchByIsbn(String isbn) {
		
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) return b;
		}
		
		return null;
	}
	
	public Book[] searchByTitle(String title) {
		
		List<Book> newArr = new ArrayList<>();
		
		for(Book b : books) {
			if(b.getTitle().contains(title)) newArr.add(b);
		}
		
		Book[] answer = new Book[newArr.size()];
		
		newArr.toArray(answer);
		
		return answer;
	}
	
	public Magazine[] getMagazines() {
		
		List<Book> newArr= new ArrayList<>();
		
		for(Book b : books) {
			if(b instanceof Magazine) newArr.add(b);
		}
		
		Magazine[] answer = new Magazine[newArr.size()];
		
		newArr.toArray(answer);
		
		return answer;

	}
	
	public Book[] getBooks() {
		
		List<Book> newArr = new ArrayList<>();
		
		for(Book b : books) {
			if(!(b instanceof Magazine)) newArr.add(b);
		}
		
		Book[] answer = new Book[newArr.size()];
		
		newArr.toArray(answer);
		
		return answer;
	}
	
	public int getTotalPrice() {
		int sum = 0;
		
		for(Book b : books) sum += b.getPrice();
		
		return sum;
	}
	
	public double getPriceAvg() {
		
		return (double)this.getTotalPrice()/books.size();
	}
	
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException{ // 예외가 너무 많을 때는 Exception 하나로 퉁 쳐도 된다.
		// 여기서 Exception하고 인터페이스에서 ISBNNotFoundException, QuantityException을 쓰면 안되지만
		// 상위에서 Exception에서 쓰고 여기서 ISBNNotFoundException, QuantityException쓰는건 상관없다.
		
		Book book = searchByIsbn(isbn);
		
		if(book == null) {
			throw new ISBNNotFoundException(isbn);
		}else {
			if((book.getQuantity()-quantity)>=0){
				book.setQuantity(book.getQuantity()-quantity);
				return;
			}else {
				throw new QuantityException(isbn, quantity);
			}
			
		}
		
		
//		for(Book b : books) {
//			if(b.getIsbn().equals(isbn) ) {
//				if((b.getQuantity()-quantity)>=0){
//					b.setQuantity(b.getQuantity()-quantity);
//					return;
//				}else {
//					throw new QuantityException(isbn, quantity);
//				}
//			}else {
//				throw new ISBNNotFoundException(isbn);
//			}
//		}
		
	}
	
	public void buy(String isbn, int quantity) throws ISBNNotFoundException{
		
		Book book = searchByIsbn(isbn);
		
		if(book == null) {
			throw new ISBNNotFoundException(isbn);
		}else { // 굳이 else 안 해도 됨!
			book.setQuantity(book.getQuantity()+quantity);
		}
		
//		for(Book b : books) {
//			if(b.getIsbn().equals(isbn)) {
//				b.setQuantity(b.getQuantity()+quantity);
//				return;
//			}
//		}
		
	}
	
}
