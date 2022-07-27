package com.ssafy.interfacehw2;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager{

	private List<Book> books = new ArrayList<Book>();
	
	// 객체 생성
	private static BookManagerImpl bm = new BookManagerImpl();
	
	// 기본 생성자 생성
	private BookManagerImpl() {};
	
	// 접근 가능한 get메소드 생성
	public static BookManagerImpl getInstance() {
		return bm;
	}
	
	// 추가 add
	public void add(Book book) {
		books.add(book);
	}
	
	// 삭제 remove
	public void remove(String isbn) {
		
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) books.remove(i);
		}
	}
	
	// 전체 조회 getList
	public Book[] getList() {
		
		Book[] newArr = new Book[books.size()];
		
		books.toArray(newArr);
		
		return newArr;
	}
	
	// 특정 조회 searchByIsbn
	public Book searchByIsbn(String isbn) {
		for(Book b : books ) {
			if(b.getIsbn().equals("isbn")) return b;
		}
		
		return null;
	}
	
	// 특정 조회2 searchByTitle -> 여러개 출력
	public Book[] searchByTitle(String title) {
		Book[] newArr = new Book[books.size()];
		
		for(int i=0, index=0; i<books.size(); i++) {
			if(books.get(i).getTitle().contains(title)) newArr[index++] = books.get(i);
		}
		
		return newArr;
	}
	
	// 잡지 조회 getMagazines
	public Magazine[] getMagazines() {
		int cnt = 0;
		
		for(Book b : books) {
			if(b instanceof Magazine) cnt++;
		}
		
		if (cnt == 0)
			return null;
		
		Magazine[] newArr = new Magazine[cnt];
		
		for(int i=0, index=0; i<books.size(); i++) {
			if(books.get(i) instanceof Magazine) newArr[index++] = (Magazine) books.get(i);
		}
		
		/*
		 * 또는 리스트로 담고
		 * Magazine[] 배열을 새로 만들어서 toArray로 담고 반환해도 된다(굳이 cnt안 세고)
		 * */
		
		return newArr;
	}
	
	// 일반 책 조회 getBooks
	public Book[] getBooks() {
		int cnt = 0;
		
		for(Book b : books) {
			if(!(b instanceof Magazine)) cnt++;
		}
		
		if (cnt == 0)
			return null;
		
		Book[] newArr = new Book[cnt];
		
		for(int i=0, index=0; i<books.size(); i++) {
			if(!(books.get(i) instanceof Magazine)) newArr[index++] =  books.get(i);
		}
		
		return newArr;
	}
	
	// 총 가격  getTotalPrice()
	public int getTotalPrice() {
		int sum=0;
		
		for(Book b : books) sum += b.getPrice();
		
		return sum;
	}
	
	// 가격 평균 getPriceAvg() 
	public double getPriceAvg() {
		
		double avg = (double)this.getTotalPrice()/books.size();
		
		return avg;
	}
	
	
}
