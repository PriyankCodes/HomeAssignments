package com.tss.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.tss.model.Book;
import com.tss.model.BookAuthorComparator;
import com.tss.model.BookTitleComparator;

public class BookTest {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		List<Book> books = new ArrayList<Book>();

		while (true) {
			System.out.println("\n1. Add New Book");
			System.out.println("2. Issue Book");
			System.out.println("3. Display Available Book ");
			System.out.println("4. Display Issued Book");
			System.out.println("5. Return Book");
			System.out.println("6. Sort Books");
			System.out.println("7. Exit");

			System.out.print("Enter Choice : ");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				addNewBook(books);
				break;

			case 2:
				issueBook(books);
				break;

			case 3:
				displayAvailableBooks(books);
				break;

			case 4:
				displayIssuedBooks(books);
				break;

			case 5:
				returnBook(books);
				break;

			case 6:
				Collections.sort(books, new BookAuthorComparator());
				System.out.println("\nBooks sorted by Author (Ascending):");
				displayAllBooks(books);

				Collections.sort(books, new BookTitleComparator());
				System.out.println("\nBooks sorted by Title (Descending):");
				displayAllBooks(books);
				break;

			case 7:
				System.out.println("Thank you for visisting");
				System.exit(0);

			}

		}
	}

	private static void displayAllBooks(List<Book> books) {
		for (Book book : books) {
			System.out.println(book);
		}
	}

	private static void returnBook(List<Book> books) {

		System.out.print("Enter Book Id to Return : ");
		int bookId = scanner.nextInt();

		for (Book book : books) {
			if (book.getBookId() == bookId) {
				if (book.isIssued()) {
					book.setIssued(false);
					System.out.println("Book Returned successfully.");
				} else {
					System.out.println("Book is not issued");
				}
				return;
			}
		}

		System.out.println("Book not found.");
	}

	private static void displayIssuedBooks(List<Book> books) {
		for (Book book : books) {

			if (book.isIssued() == true) {
				System.out.println(book);
			}
		}
	}

	private static void displayAvailableBooks(List<Book> books) {

		for (Book book : books) {
			if (book.isIssued() == false) {
				System.out.println(book);
			}
		}
	}

	private static void issueBook(List<Book> books) {

		System.out.print("Enter Book Id to Issue : ");
		int bookId = scanner.nextInt();

		for (Book book : books) {
			if (book.getBookId() == bookId) {
				if (book.isIssued()) {
					System.out.println("Book is already issued.");
				} else {
					book.setIssued(true);
					System.out.println("Book issued successfully.");
				}
				return;
			}
		}

		System.out.println("Book not found.");

	}

	private static void addNewBook(List<Book> books) {

		System.out.print("Enter Book Id : ");
		int bookId = scanner.nextInt();

		System.out.print("Enter Book Author : ");
		String author = scanner.next();

		System.out.print("Enter Title");
		String title = scanner.next();

		books.add(new Book(bookId, title, author, false));
	}

}
