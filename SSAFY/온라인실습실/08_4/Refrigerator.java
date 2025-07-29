package com.ssafy.hw.step4;

public class Refrigerator extends Product {
	//코드를 작성하세요.
	private String category;
	private int liter;
	private boolean freeaer;
	private int year;
	
	public Refrigerator() {
		super();
	}

	public Refrigerator(String pCode, String pName, int price, int quantity, String brand, String desc, String category,
			int liter, boolean freeaer, int year) {
		super(pCode, pName, price, quantity, brand, desc);
		this.category = category;
		this.liter = liter;
		this.freeaer = freeaer;
		this.year = year;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}

	public boolean isFreeaer() {
		return freeaer;
	}

	public void setFreeaer(boolean freeaer) {
		this.freeaer = freeaer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Refrigerator [category=" + category + ", liter=" + liter + ", freeaer=" + freeaer + ", year=" + year
				+ "]";
	}
}
