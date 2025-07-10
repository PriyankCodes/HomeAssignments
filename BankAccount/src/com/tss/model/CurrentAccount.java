package com.tss.model;

import com.tss.exception.OverdraftLimitReachedException;

public class CurrentAccount extends Account {

	private double overdraftLimit;

	public CurrentAccount(int accNo, String name, double balance, double overdraftLimit) {
		super(accNo, name, balance);
		this.overdraftLimit = overdraftLimit;
	}

	public void debit(double amount) {
		if (balance - amount >= -overdraftLimit) {
			balance -= amount;
			System.out.println("Amount debited new balance: " + balance);

		} else {
			throw new OverdraftLimitReachedException(balance);
		}
	}

	public void credit(double amount) {
		balance += amount;
		System.out.println("Amount credited new balance: " + balance);
	}

	public void displayDetails() {
		super.displayDetails();
		System.out.println("Overdraft Limit: " + overdraftLimit);
	}

}
