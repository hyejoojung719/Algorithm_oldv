package com.ssafy.exceptionhw;

import java.util.List;

public interface IProductManager {
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean removeProduct(String pCode);
	int sell(String pCode, int cnt) throws ProductCodeNotFoundException, QuantityException;
	Product[] getProducList();
	Product searchByCode(String pCode);
	boolean addReview(Review review);
	boolean removeReview(Review review);
	List<Review> getProductReview(String pCode) throws ReviewNotFoundException;
	Product[] searchByName(String name) throws NameNotFoundException;
	long getTotalPrice();
	Product[] getProducts();
	Refrigerator[] getRefirigerators();
	Refrigerator[] getRefrigeratorsFreezer(boolean freezer);
}
