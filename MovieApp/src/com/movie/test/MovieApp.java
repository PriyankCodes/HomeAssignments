package com.movie.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.movie.model.Movie;
import com.movie.model.MovieEmptyException;
import com.movie.model.MoviesFullException;

public class MovieApp {

	static Scanner scanner = new Scanner(System.in);
	static int movieCount = 0;

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		List<Movie> movies = new ArrayList<>();
		try {
			while (true) {
				System.out.println();
				System.out.println("1. Display Movies");
				System.out.println("2. Add Movies");
				System.out.println("3. Delete a Movie");
				System.out.println("4. Clear all");
				System.out.println("5. Exit");

				System.out.print("Enter Choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {

				case 1:
					displayMovies(movies);
					break;

				case 2:
					addMovies(movies);
					break;

				case 3:
					deleteMovie(movies);
					break;

				case 4:
					clearAll(movies);
					break;

				case 5:
					System.exit(0);
					break;

				default:
					System.out.println();
				}
			}
		} catch (MoviesFullException e) {
			System.out.println(e.getMessage());
		} catch (MovieEmptyException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void clearAll(List<Movie> movies) {
		movies.clear();
		System.out.println("All Movies deleted succesfully...");

		try (FileOutputStream fileOut = new FileOutputStream("movies.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(movies);
		} catch (IOException e) {
			System.out.println("Error while saving the updated movie list: " + e.getMessage());
		}

	}

	private static void deleteMovie(List<Movie> movies) {

		if (movies.isEmpty()) {
			throw new MovieEmptyException();
		}

		System.out.print("Enter Movie Id to delete: ");
		String Id = scanner.nextLine();

		boolean isRemoved = movies.removeIf(movie -> movie.getMovieId().equalsIgnoreCase(Id));

		if (isRemoved) {
			System.out.println("Movie deleted successfully...");

			try (FileOutputStream fileOut = new FileOutputStream("movies.ser");
					ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
				out.writeObject(movies);
			} catch (IOException e) {
				System.out.println("Error while saving the updated movie list: " + e.getMessage());
			}

		} else {
			System.out.println("Movie Not Found...");
		}
	}

	private static void addMovies(List<Movie> movies) throws FileNotFoundException, IOException {

		if (movieCount > 5) {
			throw new MoviesFullException();
		}

		System.out.print("Enter Movie Name : ");
		String name = scanner.nextLine();

		System.out.print("Enetr Movie Genre : ");
		String genre = scanner.nextLine();

		System.out.print("Enter Movie release year : ");
		String year = scanner.nextLine();

		String Id = "";

		Id = (name.substring(0, 2) + genre.substring(0, 2) + year.substring(year.length() - 2));

		movies.add(new Movie(Id, name, genre, year));
		try (FileOutputStream fileOut = new FileOutputStream("movies.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

			out.writeObject(movies);
		}
		movieCount += 1;

	}

	private static void displayMovies(List<Movie> movies)
			throws FileNotFoundException, IOException, ClassNotFoundException {

		try (FileInputStream fileIn = new FileInputStream("movies.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn)) {

			List<Movie> savedMovies = (List<Movie>) in.readObject();

			if (savedMovies.isEmpty()) {
				throw new MovieEmptyException();
			} else {
				for (Movie movie : savedMovies) {
					System.out.println(movie);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No saved movies found.");
		}
	}

}
