package com.tss.model;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getAuthor().compareToIgnoreCase(o2.getAuthor());
	}

}
