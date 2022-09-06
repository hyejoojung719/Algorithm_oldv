package com.ssafy.interfacehw2;

import java.util.Arrays;

import com.ssafy.inheritance2.Megazine;

public class BookTest {

	public static void main(String[] args) {

		Book book1 = new Book("1b", "정의란 무엇인가", "마이크센델", "싸피", 10000, "2022-01");
		Book book2 = new Book("2b", "정의란 무엇인가2", "마이크센델2", "싸피2", 20000, "2022-02");
		Book book3 = new Book("3b", "자바의 정석", "남궁성", "싸피3", 30000, "2022-03");
		Magazine book4 = new Magazine("2m", "정의란 무엇인가2", "마이크센델2", "싸피2", 20000, "2022-02", 2022, 02);

		BookManagerImpl bm = BookManagerImpl.getInstance();
		BookManagerImpl bm2 = BookManagerImpl.getInstance();

		bm.add(book1);
		bm.add(book2);
		bm.add(book3);
		bm.add(book4);

		// 동일하게 동작하는지 테스트
		System.out.println(Arrays.toString(bm.searchByTitle("정의")));
		System.out.println(Arrays.toString(bm.getMagazines()));
		System.out.println(Arrays.toString(bm.getList()));
		System.out.println(Arrays.toString(bm.getBooks()));
		System.out.println(bm.getTotalPrice());
		System.out.println(bm.getPriceAvg());

	}

}
