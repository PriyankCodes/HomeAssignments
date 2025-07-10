package com.tss.basics.assignment1;

import java.util.Random;
import java.util.Scanner;

public class PIGGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int turn = 1;
		String choice;
		int points = 0;

		System.out.println("Welcome to PIG Game ");
		System.out.println("Turn " + turn+" -------------");

		while (turn <= 5) {

			if (points >= 20) {
				System.out.println("------------------------------------");
				System.out.println("Congratulations...You won the Game in " + turn + " Turns");
				System.out.println("Total Score : " + points);
				break;
			}

			System.out.print("Roll or Hold (R/H) : ");
			choice = scanner.next();

			if (choice.equalsIgnoreCase("R")) {

				int die = generateDieValue();
				if (die == 1) {
					points = 0;
					System.out.println("Turn Over.. You Lost all points....\n");
					turn++;
					if (turn <= 5) {
						System.out.println("Turn " + turn+" -------------");
					}
				} else {
					points += die;
				}

			} else if (choice.equalsIgnoreCase("H")) {
				turn++;
				System.out.println();
				if (turn <= 5) {
					System.out.println("Turn " + turn+" -------------");
				}
			} else {
				System.out.println("Invalid choice, Try Again...");
			}
		}
		if (turn > 5) {
			System.out.println("You Lost The Game....");
		}

	}

	private static int generateDieValue() {
		Random random = new Random();
		int min = 1;
		int max = 6;
		int die = random.nextInt(max - min + 1) + min;
		System.out.println("Die - " + die);
		return die;
	}

}
