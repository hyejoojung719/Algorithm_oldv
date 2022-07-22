package com.ssafy.inheritance2;

public class BookTest {
	
	public static void main(String[] args) {
	
		Book  b1 = new Book("21424","Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book  b2 = new Book("21425","Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
		Book  b3 = new Book("35355","분석 설계", "소나무", "jaen.kr", 30000, "SW 모델링");
		Megazine  m = new Megazine("45678","월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1);
		
		BookManager bm = new BookManager();
		
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		bm.add(m);
		
		System.out.println("**************** 도서 전체 목록 ****************");
		for(Book b : bm.getList()) System.out.println(b);

		System.out.println("**************** 일반 전체 목록 ****************");
		for(Book b : bm.getBooks()) System.out.println(b);
		
		System.out.println("**************** 잡지 목록 ****************");
		for(Book b : bm.getMagazines()) System.out.println(b);
		
		System.out.println("**************** 도서 제목 포함검색 : JAVA ****************");
		for(Book b : bm.searchByTitle("Java")) System.out.println(b);
		
		System.out.print("도서 가격 총합 : " + bm.getTotalPrice());
		System.out.println("도서 가격 평균 : " + bm.getPriceAvg());
		
		
	
	}

}
