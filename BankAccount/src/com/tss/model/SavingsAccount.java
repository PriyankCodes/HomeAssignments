package com.tss.model;

import com.tss.exception.MinimumBalanceViolationException;

public class SavingsAccount extends Account {
	private double minBalance;

	public SavingsAccount(int accNo, String name, double balance, double minBalance) {
		super(accNo, name, balance);
		this.minBalance = minBalance;
	}

	public void debit(double amount) {
		if (balance - amount >= minBalance) {
			balance -= amount;
			System.out.println("Amount debited new balance: " + balance);
		} else {
			throw new MinimumBalanceViolationException(minBalance);
		}
	}

	public void credit(double amount) {
		balance += amount;
		System.out.println("Amount credited new balance: " + balance);
	}

	public void displayDetails() {
		super.displayDetails();
		System.out.println("Minimum Balance Required: " + minBalance);
	}
}