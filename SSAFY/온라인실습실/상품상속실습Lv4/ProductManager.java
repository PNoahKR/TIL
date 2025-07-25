package com.ssafy.hw.step4;

import java.util.Arrays;

/**
 * 상품리스트를 배열로 유지하며 관리하는 클래스
 */
public class ProductManager {
	//코드를 작성하세요.
	final static int MAX_PRODUCT_SIZE;
	final static int MAX_REVIEW_SIZE;
	Product[] products = new Product[MAX_PRODUCT_SIZE];
	Review[] reviews = new Review[MAX_REVIEW_SIZE];
	int pCount = 0;
	int rCount = 0;
	
	public boolean addProduct(Product product) {
		if(pCount < MAX_PRODUCT_SIZE) {
			products[pCount++] = product;
			return true;
		}
		return false;
	}

	public boolean updateProduct(Product product) {
		for(int i = 0; i < pCount; i++) {
			if(products[i].getpCode().equals(product.getpCode())) {
				products[i] = product;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeProduct(Product product) {
		for(int i = 0; i < pCount; i++) {
			if(products[i].getpCode().equals(product.getpCode())) {
				products[i] = products[pCount--];
				return true;
			}
		}
		return false;
		
	}
	
	public int sell(String pCode, int cnt) {
		for(int i = 0; i < pCount; i++) {
			if(products[i].getpCode().equals(pCode)) {
				products[i].setQuantity(products[i].getQuantity() - cnt);
				return products[i].getQuantity();
			}
		}
		return 0;
	}
	
	public Product[] getProductList() {
		Product[] tmp = new Product[pCount];
		for(int i = 0; i < pCount; i++) {
			tmp[i] = products[i];
		}
		return tmp;
	}
	
	public Product searchByCode(String pCode) {
		for(int i = 0; i < pCount; i++) {
			if(products[i].getpCode().equals(pCode)) {
				return products[i];
			}
		}
		return null;
	}
	
	public boolean addReview(Review review) {
		if(rCount < MAX_REVIEW_SIZE) {
			reviews[rCount++] = review;
			return true;
		}
		return false;
		
	}

	public boolean removeReview(int reviewId) {
		for(int i = 0; i < rCount; i++) {
			if(reviews[i].getReviewId() == reviewId) {
				reviews[i] = reviews[rCount--];
				return true;
			}
		}
		return false;
	}
	
	public Review[] getProductReview(String pCode) {
		Review[] tmp = new Review[rCount];
		for(int i = 0; i < rCount; i++) {
			tmp[i] = reviews[i];
		}
		return tmp;
	}
	
	public Product[] searchByName(String name) {
		Product[] tmp = new Product[pCount];
		for(int i = 0; i < pCount; i++) {
			if(products[i].getpName().equals(name)) {
				tmp = products[i];
			}
		}
		return tmp;
	}
	
	public long getTotalPrice() {
		long totalPrice = 0;
		
		for(int i = 0; i < pCount; i++) {
			totalPrice += products[i].getPrice();
		}
		
	}
	
	public Product[] getProducts() {
		
	}
	
	public Refrigerator[] getRefrigerators() {
		
	}
	
	public Refrigerator[] getRefrigeratorsFreezer(boolean freezer) {
		
	}
	
}
