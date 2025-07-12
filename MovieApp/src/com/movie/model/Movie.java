package com.movie.model;

import java.io.Serializable;

public class Movie implements Serializable {

	private String movieId, name, genre, year;

	public Movie(String movieId, String name, String genre, String year) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.genre = genre;
		this.year = year;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
	    return String.format("Movie ID: %s, Name: %s, Genre: %s, Year: %s", movieId, name, genre, year);
	}


}
