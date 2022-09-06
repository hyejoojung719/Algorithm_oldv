package com.ssafy.interfacehw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ssafy.inheritance2.Megazine;

public class BookManagerImpl implements IBookManager{

	private int MAX_SIZE = 100;
	
	private Book[] books = new Book[MAX_SIZE];
	
	private int size = 0;

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
		if(size < MAX_SIZE) {
			books[size++] = book;
		}else {
			System.out.println("공간 초과!");
		}
		
	}
	
	// 삭제 remove
	public void remove(String isbn) {
		
		for(int i=0; i<size; i++) {
			if(books[i].equals(isbn)) {
				books[i] = books[size-1];
				books[size-1] = null;
				size--;
			}
		}
	}
	
	// 전체 조회 getList
	public Book[] getList() {
		
		return Arrays.copyOfRange(books, 0, size);
		
	}
	
	// 특정 조회 searchByIsbn
	public Book searchByIsbn(String isbn) {
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) return books[i];
		}
		return null;
	}
	
	// 특정 조회2 searchByTitle -> 여러개 출력
	public Book[] searchByTitle(String title) {
		
		int cnt = 0;
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) cnt++;
		}
		
		if(cnt == 0 ) return null;
		
		Book[] newArr = new Book[cnt];
		
		for(int i=0, index=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) newArr[index++] = books[i];
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
		
		for(int i=0, index=0; i<size; i++) {
			if(books[i] instanceof Magazine) newArr[index++] = (Magazine) books[i];
		}
		
		return newArr;
	}
	
	// 일반 책 조회 getBooks
	public Book[] getBooks() {
		int cnt = 0;
		
		for(int i=0; i<this.size; i++) {
			if(!(books[i] instanceof Magazine)) cnt++;
		}
		
		if (cnt == 0)
			return null;
		
		Book[] newArr = new Book[cnt];
		
		for(int i=0, index=0; i<size; i++) {
			if(!(books[i] instanceof Magazine)) newArr[index++] =  books[i];
		}
		
		return newArr;
	}
	
	// 총 가격  getTotalPrice()
	public int getTotalPrice() {
		int sum=0;
		
		for(int i=0; i<this.size; i++) {
			sum += books[i].getPrice();
		}
		
		return sum;
	}
	
	// 가격 평균 getPriceAvg() 
	public double getPriceAvg() {
		
		double avg = (double)this.getTotalPrice()/this.size;
		
		return avg;
	}
	
	
}
