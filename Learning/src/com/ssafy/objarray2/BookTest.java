package com.ssafy.objarray2;

public class BookTest {
	public static void main(String[] args) {
		
		BookManager bm = new BookManager();
		
		bm.add(new Book("21424","Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bm.add(new Book("21425","Java Pro2", "김하나", "jaen.kr", 15000, "Java 응용"));
		bm.add(new Book("35355","분석 설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
		
		System.out.println("======== 도서목록 =======");
		Book[] copyBook = bm.getList();
		for(Book b : copyBook) {
			System.out.println(b);
		}
		
		System.out.println("======== 도서조회 : 21424 =======");
		Book searchb = bm.searchByIsbn("21424");
		System.out.println(searchb);
		
		System.out.println("======== 도서삭제 : 21424 =======");
		bm.remove("21424");
		
		System.out.println("======== 도서목록 =======");
		copyBook = bm.getList();
		for(Book b : copyBook) {
			System.out.println(b);
		}
	}
}
