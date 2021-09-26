package com.greatlearning.Stockers.Main;

import java.util.Scanner;
import java.util.InputMismatchException;
import com.greatlearning.Stockers.SearchAndSortImplementations.*;

public class Driver {

	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InputMismatchException {

		try {

			// Get the input and Initializing the parameters.

			System.out.println("Enter the no of companies");
			int Companies = sc.nextInt();

			double[] StockPrice = new double[Companies];
			boolean[] Status = new boolean[Companies];

			// Start loop to enter the input values in the initialized arrays.

			for (int i = 0; i < Companies; i++) {
				// Input for Stock Price Array.
				System.out.println("Enter current stock price of the company " + (i + 1) + ":");
				StockPrice[i] = sc.nextDouble();

				// Input for Stock Comparison.
				System.out.println("Whether company's stock price rose today compare to yesterday?");
				Status[i] = sc.nextBoolean();
			}

			// Initializing sorting and searching algorithms.

			MergeSortImplementation ms = new MergeSortImplementation();

			BinarySearchImplementation si = new BinarySearchImplementation();

			int StockRose = 0;
			int StockDecline = 0;

			for (int i = 0; i < Companies; i++) {
				if (Status[i] == true) {
					StockRose++;
				} else {
					StockDecline++;
				}
			}

			while (true) {

				// User Operations Menu Display
				System.out.println("-----------------------------------------------");
				System.out.println("Enter the operation that you want to perform");
				System.out.println("1. Display the companies stock prices in ascending order");
				System.out.println("2. Display the companies stock prices in descending order");
				System.out.println("3. Display the total no of companies for which stock prices rose today");
				System.out.println("4. Display the total no of companies for which stock prices declined today");
				System.out.println("5. Search a specific stock price");
				System.out.println("6. press 0 to exit");
				System.out.println("-----------------------------------------------");

				// getting input from user to select from the above Menu.

				int option1 = sc.nextInt();

				// Condition to Exit the While Loop.

				if (option1 == 0) {
					System.out.println("Exited Successfully");
					break;
				}

				// Switch Case.

				switch (option1) {

				case 1:
					System.out.println("stock prices in ascending order are:");
					ms.sort(StockPrice, 0, StockPrice.length - 1, 1);
					ms.displayArray(StockPrice);
					break;
				case 2:
					System.out.println("stock prices in descending order are:");
					ms.sort(StockPrice, 0, StockPrice.length - 1, 2);
					ms.displayArray(StockPrice);
					break;
				case 3:
					System.out.println("Total no of companies whose stock price rose today : " + StockRose);
					break;
				case 4:
					System.out.println("Total no of companies whose stock price declined today : " + StockDecline);
					break;
				case 5:
					System.out.println("enter the key value :");
					double searchValue = sc.nextDouble();
					si.searchValue(StockPrice, searchValue);
					break;

				default:
					System.out.println("You have entered invalid option!!");
				}

			}

		} catch (InputMismatchException e) {
			System.out.println("Incorrect Input!! Please enter valid value.\n"); // Exception if input provided by user
																					// is different than initialized.

		}
	}
}
