package com.tss.model;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o2.getTitle().compareToIgnoreCase(o1.getTitle());
	}

}
