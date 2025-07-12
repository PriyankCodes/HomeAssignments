package com.tss.model;

public class Book {

	private String title;
	private String author;
	private int bookId;
	private boolean isIssued;

	public Book(int bookId, String title, String author, boolean isIssued) {
		super();
		this.title = title;
		this.author = author;
		this.bookId = bookId;
		this.isIssued = isIssued;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	@Override
	public String toString() {

		return String.format("| %-10s | %-20s | %-20s |", bookId, title, author);
	}

}
