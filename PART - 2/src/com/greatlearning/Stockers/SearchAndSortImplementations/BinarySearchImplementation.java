package com.greatlearning.Stockers.SearchAndSortImplementations;

public class BinarySearchImplementation {
	public void searchValue(double[] array, double searchValue) {
		// variable initialization
		int left, right, mid;
		left = 0;
		right = array.length - 1;
		mid = left + (right - left) / 2;

		// Binary Search Condition.
		while (left <= right) {
			if (searchValue < array[mid]) {
				right = mid - 1;
			} else if (searchValue > array[mid]) {
				left = mid + 1;
			} else {
				System.out.println("Stock of value " + searchValue + " is present");
				break;

			}
			mid = left + (right - left) / 2;
		}

		if (left > right) {
			System.out.println("Value not found");

		}

	}
}
