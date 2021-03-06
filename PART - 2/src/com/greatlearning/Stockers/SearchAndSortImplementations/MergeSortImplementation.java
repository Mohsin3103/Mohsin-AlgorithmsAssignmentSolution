package com.greatlearning.Stockers.SearchAndSortImplementations;

public class MergeSortImplementation {
	void merge(double arr[], int left, int mid, int right, int option) {
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temporary arrays */
		double leftArray[] = new double[n1];
		double rightArray[] = new double[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		while (i < n1 && j < n2) {

			// Descending order condition

			if (option == 2) {
				if (leftArray[i] >= rightArray[j]) {
					arr[k] = leftArray[i];
					i++;
				} else {
					arr[k] = rightArray[j];
					j++;
				}
				k++;
			}
			// Ascending order condition

			if (option == 1) {
				if (leftArray[i] <= rightArray[j]) {
					arr[k] = leftArray[i];
					i++;
				} else {
					arr[k] = rightArray[j];
					j++;
				}
				k++;
			}

		}
		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	// Main function that sorts array[left...right] using merge()
	public void sort(double[] arr, int left, int right, int option) {
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			sort(arr, left, mid, option);
			sort(arr, mid + 1, right, option);

			// Merge the sorted halves
			merge(arr, left, mid, right, option);
		}

	}

	public void displayArray(double[] arr) {
		int number = arr.length;
		for (int a = 0; a < number; ++a)
			System.out.print(arr[a] + " ");
		System.out.println();
	}
}
