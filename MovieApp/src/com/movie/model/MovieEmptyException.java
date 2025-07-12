package com.movie.model;

public class MovieEmptyException extends RuntimeException {
	
	public String getMessage() {
		return "Exception !!! There are no Movies in the list ";
	}

}
