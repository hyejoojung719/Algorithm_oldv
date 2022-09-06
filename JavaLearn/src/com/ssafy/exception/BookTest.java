package com.ssafy.exception;

public class BookTest {
	public static void main(String[] args) throws ISBNNotFoundException, QuantityException {
		
		Book b1 = new Book("21424", "Java pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 10);
		Book b2 = new Book("21425", "Java pro2", "김하나", "jaen.kr", 25000, "Java 응용", 20);
		Book b3 = new Book("35355", "분석 설계", "소나무", "jaen.kr", 30000, "SW 모델링", 30);
		Magazine m1 = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 40, 2021, 1);
	
		BookManagerImpl bm = BookManagerImpl.getInstance();
		
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		bm.add(m1);
		
		System.out.println("*********************도서 전체 목록*********************");
		Book[] books = bm.getList();
		
		for(Book b : books) {
			System.out.println(b);
		}
		
		System.out.println("*********************일반 도서 목록*********************");
		Book[] books2 = bm.getBooks();
		
		for(Book b : books2) {
			System.out.println(b);
		}
		
		System.out.println("*********************잡지 목록*********************");
		Magazine[] magas = bm.getMagazines();
		
		for(Magazine m : magas) {
			System.out.println(m);
		}
		
		System.out.println("*********************도서 제목 포함검색*********************");
		Book[] books3 = bm.searchByTitle("Java");
		
		for(Book b : books3) {
			System.out.println(b);
		}
		
		System.out.printf("도서 가격 총합 : %d\n", bm.getTotalPrice());
		System.out.printf("도서 가격 평균 : %.1f\n", bm.getPriceAvg());
		
		System.out.println("*********************도서 판매: 21424, 11개*********************");
		try {
			bm.sell("21424", 11);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("*********************도서 구매:  21424, 10개*********************");
		try {
			bm.buy("21424", 10);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		System.out.println("*********************도서 판매: 21424, 11개*********************");
		
//		System.out.println(bm.searchByIsbn("21424"));
		try {
			bm.sell("21424", 11);
		} catch (/*ISBNNotFoundExceptionException | QuantityException e*/ Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
}
