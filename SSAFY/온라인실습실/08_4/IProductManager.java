package com.ssafy.hw.step4;

import java.util.List;

/**
 * 상품리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 *
 */
public interface IProductManager {
	//코드를 작성하세요.
	default boolean addProduct(Product product) {
		return true;
	}
	
	default boolean updateProduct(Product product) {
		return true;
	}
	
	boolean removeProduct(String pCode);
	
	int sell(String pCode, int cnt);
	
	Product[] getProductList();
	
	Product searchByCode(String pCode);
	
	boolean addReview(Review review);
	
	boolean removeReview(Review review);
	
	List<Review> getProductReview(String pCode);
	
	Product[] searchByName(String name);
	
	long getTotalPrice();
	
	Product[] getProducts();
	
	Refrigerator[] getRefrigerator();
	
	Refrigerator[] getRefrigeratorFreezer(boolean freezer);
}
