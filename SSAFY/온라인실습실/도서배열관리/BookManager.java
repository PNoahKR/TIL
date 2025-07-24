package com.ssafy.ws.step3;

import java.util.Iterator;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class BookManager {
	// 코드를 작성해주세요.
	final static int MAX_SIZE = 100;
	Book[] books = new Book[MAX_SIZE];
	int size = 0;

	private BookManager() {

	}

	private static BookManager manager = new BookManager();

	public static BookManager getManager() {
		return manager;
	}

	public void add(Book book) {
		if (size < MAX_SIZE) {
			books[size++] = book;
		}
	}

	public void remove(String isbn) {
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				books[i] = books[size - 1];
				size--;
			}
		}
	}

	public Book[] getList() {
		Book[] tmp = new Book[size];
		for (int i = 0; i < size; i++) {
			tmp[i] = books[i];
		}
		return tmp;
	}

	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < size; i++) {
			Book tmp = books[i];
			if (tmp.getIsbn().equals(isbn)) {
				return tmp;
			}
		}
		return null;

	}
}
