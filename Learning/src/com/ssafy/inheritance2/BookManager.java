package com.ssafy.inheritance2;

import java.util.Arrays;

public class BookManager {

	final private int MAX_SIZE = 100;

	private Book[] books = new Book[MAX_SIZE];

	int size;

	public void add(Book book) {
		if(size < MAX_SIZE) {
			books[size++] = book;
		}else {
			System.out.println("책 100권을 초과하였습니다.");
		}
	}

	public void remove(String isbn) {

		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[size-1];
				books[size-1] = null;
				size--;
				break;
			}
		}
	}

	public Book[] getList() {
		return Arrays.copyOfRange(books,0, size );

	}

	public Book searchByIsbn(String isbn) {

		for(int i=0; i<this.size; i++) {
			if(books[i].getIsbn().equals(isbn)) return books[i];
		}

		return null;

	}

	public Book[] searchByTitle(String title) {

		int cnt = 0;

		for(int i=0; i<this.size; i++) {
			if(books[i].getTitle().contains(title)) cnt++;
		}

		if(cnt==0) return null;

		Book[] b2 = new Book[cnt];

		for(int i=0, index = 0; i<this.size; i++) {
			if(books[i].getTitle().contains(title)) b2[index++] = books[i];
		}

		return b2;
	}

	public Megazine[] getMagazines() {

		int cnt = 0;

		for(int i=0; i<this.size; i++) {
			if(books[i] instanceof Megazine) cnt++;
		}

		if(cnt == 0) return null;

		Megazine[] m = new Megazine[cnt];

		for(int i=0, index = 0; i<this.size; i++) {
			if(books[i] instanceof Megazine) m[index++] = (Megazine) books[i];
		}

		return m;

	}

	public Book[] getBooks() {

		int cnt = 0;

		for(int i=0; i<this.size; i++) {
			if(!(books[i] instanceof Megazine)) cnt++;
		}

		if(cnt == 0) return null;

		Book[] b = new Book[cnt];

		for(int i=0, index = 0; i<this.size; i++) {
			if(!(books[i] instanceof Megazine)) b[index++] =  books[i];
		}

		return b;
	}

	public int getTotalPrice() {
		int sum = 0;

		for(int i=0; i<this.size; i++) {
			sum += books[i].getPrice();
		}

		return sum;
	}

	public double getPriceAvg() {

		return this.getTotalPrice()/this.size;
	}


}
