package com.tss.exception;

public class MinimumBalanceViolationException extends RuntimeException {

	private double balance;

	public MinimumBalanceViolationException(double balance) {
		super();
		this.balance = balance;
	}

	public String getMessage() {
		return "Exception !!! Minimum Balance Limit Reached : Minimum Balance should be"+balance ;
	}

}
