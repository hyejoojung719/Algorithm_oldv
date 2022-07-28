package com.ssafy.exceptionhw;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.exception.Book;
import com.ssafy.exception.Magazine;

public class ProductManagerImpl implements IProductManager{

	List<Product> products = new ArrayList<>();
	List<Review> reviews = new ArrayList<>();

	private static ProductManagerImpl pm = new ProductManagerImpl();

	private ProductManagerImpl() {};

	public static ProductManagerImpl getInstance() {
		return pm;
	}

	@Override
	public boolean addProduct(Product product) {
		products.add(product);
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		products.add(product);
		return true;
	}

	@Override
	public boolean removeProduct(String pCode) {
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getpCode().equals(pCode)) {
				products.remove(i);
				return true;
			}
		}
		return false;
	}

	//판매 -> 예외(quantity, productnotfound)
	@Override
	public int sell(String pCode, int cnt) throws ProductCodeNotFoundException, QuantityException{
		Product product = searchByCode(pCode);

		if(product == null) {
			throw new ProductCodeNotFoundException(pCode);
		}else {
			if((product.getQuantity()-cnt)>=0) {
				product.setQuantity(product.getQuantity()-cnt);
				return 0;
			}else {
				throw new QuantityException();
			}
		}
	}

	//상품 리스트 조회
	@Override
	public Product[] getProducList() {
		Product[] newArr = new Product[products.size()];
		products.toArray(newArr);
		return newArr;

	}

	//상품 조회
	@Override
	public Product searchByCode(String pCode) {
		for(Product p : products) {
			if(p.getpCode().equals(pCode)) return p;
		}
		return null;
	}

	// 리뷰 추가
	@Override
	public boolean addReview(Review review) {
		reviews.add(review);
		return true;
	}

	// 리뷰 제거 
	@Override
	public boolean removeReview(Review review) {
		for(int i=0; i<reviews.size(); i++) {
			if(reviews.get(i).equals(review)) {
				products.remove(i);
				return true;
			}
		}
		return false;
	}

	// 리뷰 리스트 조회 -> 예외(리뷰)
	@Override
	public List<Review> getProductReview(String pCode) throws ReviewNotFoundException{
		List<Review> newArr = new ArrayList<>();
		boolean flag = false;

		for(int i=0; i<reviews.size(); i++) {
			if(reviews.get(i).getpCode().equals(pCode)) {
				newArr.add(reviews.get(i));
				if(flag==false) flag = true;
			}
		}

		if(flag==false) throw new ReviewNotFoundException(pCode);

		return newArr;

	}

	// 상품 조회 -> name예외
	@Override
	public Product[] searchByName(String name) throws NameNotFoundException{
		List<Product> newArr = new ArrayList<>();
		boolean flag = false;


		for(Product p : products) {
			if(p.getpName().contains(name)) {
				newArr.add(p);
				if(flag==false) flag= true;
			}
		}

		if(flag==false) throw new NameNotFoundException(name);

		Product[] answer = new Product[newArr.size()];

		newArr.toArray(answer);

		return answer;
	}

	// 총 가격 조회 
	@Override
	public long getTotalPrice() {
		long sum = 0;
		for(Product p : products) sum += p.getPrice();
		return sum;
	}

	// 상품 조회
	@Override
	public Product[] getProducts() {
		Product[] newArr = new Product[products.size()];
		products.toArray(newArr);
		return newArr;

	}

	// 냉장고 조회
	@Override
	public Refrigerator[] getRefirigerators() {
		List<Product> newArr = new ArrayList<>();

		for(Product p : products) {
			if(p instanceof Refrigerator) newArr.add(p);
		}

		Refrigerator[] answer = new Refrigerator[newArr.size()];

		newArr.toArray(answer);

		return answer;

	}

	@Override
	public Refrigerator[] getRefrigeratorsFreezer(boolean freezer) {
		List<Product> newArr = new ArrayList<>();

		for(Product p : products) {
			if(p instanceof Refrigerator && ((Refrigerator) p).isFreezer()==true) newArr.add(p);
		}

		Refrigerator[] answer = new Refrigerator[newArr.size()];

		newArr.toArray(answer);

		return answer;
	}

}
