package com.ssafy.objarray2;

import java.util.Arrays;

public class BookManager {
	
	final int MAX_SIZE = 100;
	
	Book[] books = new Book[MAX_SIZE];
	
	int size;
	
	public void add(Book book) {
		books[size++] = book;
	}
	
	
	public void remove(String isbn) {
		for(int i=0; i < size; i++) {
			if(books[i].isbn.equals(isbn)) {
				books[i] = books[size-1];
				books[size-1] = null;
				size--;
				break;
				
			}
		}
	}
	
	public Book[] getList() {
		return Arrays.copyOf(books, size);
	}
	
	public Book searchByIsbn(String isbn) {
		for(int i=0; i<size; i++) {
			if(books[i].isbn.equals(isbn)) return books[i] ;
		}
		
		return null;
	}
}
