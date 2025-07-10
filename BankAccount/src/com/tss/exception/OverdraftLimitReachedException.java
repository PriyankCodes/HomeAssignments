package com.tss.exception;

public class OverdraftLimitReachedException extends RuntimeException {

	private double balance;

	public OverdraftLimitReachedException(double balance) {
		super();
		this.balance = balance;
	}

	public String getMessage() {
		return "Exception !!! Overdraft Limit Reached : Balace Left is " + balance;
	}

}
