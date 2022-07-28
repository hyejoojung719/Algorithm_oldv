package com.ssafy.exceptionhw;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.exception.Book;
import com.ssafy.exception.BookManagerImpl;
import com.ssafy.exception.Magazine;

public class ProductTest {
	public static void main(String[] args) throws ReviewNotFoundException, NameNotFoundException, QuantityException, ProductCodeNotFoundException {
		Product p1 = new Product("21424", "에어컨", 1000000, 50, "삼성", "10");
		Product p2 = new Product("21425", "에어컨", 1500000, 10, "Lg", "11");
		Product p3 = new Product("21426", "청소기", 100000, 30, "삼성", "1");
		Refrigerator r1 = new Refrigerator("21427", "냉장고", 200000, 15, "삼성", "3", "스마트", 5, true, 2022);

		Review rv1 = new Review(1234, "21424", "홍길동", "굳굳");

		ProductManagerImpl pm = ProductManagerImpl.getInstance();

		pm.addProduct(p1);
		pm.addProduct(p2);
		pm.addProduct(p3);
		pm.addProduct(r1);
		pm.addReview(rv1);

		System.out.println("************* 상품 조회 *******************");
		Product[] prods = pm.searchByName("에어z");

		for(Product p : prods) {
			System.out.println(p);
		}

		System.out.println("************* 판매 *******************");
		try {
			pm.sell("21429", 60);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			pm.sell("21424", 60);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("************* 상품 리뷰 조회*******************");
		List<Review> review = new ArrayList<>();
		review = pm.getProductReview("21426");
		
		for(Review r : review) {
			System.out.println(r);
		}
	}
}
