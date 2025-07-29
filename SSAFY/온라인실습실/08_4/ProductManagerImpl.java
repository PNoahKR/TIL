package com.ssafy.hw.step4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 상품리스트를 배열로 유지하며 관리하는 클래스
 */
public class ProductManagerImpl implements IProductManager{
	
	private List<Product> products = new ArrayList<>();
	private Map<String, List<Review>> reviews = new HashMap<>();
	private static int reviewNo = 0;
	
	private ProductManagerImpl() {
		
	}
	
	private static IProductManager instance = new ProductManagerImpl();
	
	public static IProductManager getInstance() {
		return instance;
	}

	@Override
	public boolean addProduct(Product product) {
		return products.add(product);
	}
	
	@Override
	public boolean updateProduct(Product product) {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getpCode().equals(product.getpCode())) {
				products.set(i, product);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean removeProduct(String pCode) {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getpCode().equals(pCode)) {
				products.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public int sell(String pCode, int cnt) {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getpCode().equals(pCode)) {
				Product tmp = products.get(i);
				tmp.setQuantity(products.get(i).getQuantity() - cnt);
				products.set(i, tmp);
				return products.get(i).getQuantity();
			}
		}
		return -1;
	}

	@Override
	public Product[] getProductList() {
		Product[] prod = new Product[products.size()];
		return this.products.toArray(prod);
	}

	@Override
	public Product searchByCode(String pCode) {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getpCode().equals(pCode)) {
				return products.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean addReview(Review review) {
		if(!reviews.containsKey(review.getpCode())) {
			return false;
		}
		List<Review> tmp = new ArrayList<>();
		tmp.add(review);
		reviews.put(review.getpCode(), tmp);
		return true;
	}

	@Override
	public boolean removeReview(Review review) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Review> getProductReview(String pCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product[] searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product[] getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Refrigerator[] getRefrigerator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Refrigerator[] getRefrigeratorFreezer(boolean freezer) {
		// TODO Auto-generated method stub
		return null;
	}
	//코드를 작성하세요.
}
