package main.sorting.simpleSorting;

import main.sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (this.validation(array, leftIndex, rightIndex)) {
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				T element = array[i];

				int j = i - 1;

				while (j >= leftIndex && element.compareTo(array[j]) < 0) {
					array[j + 1] = array[j];
					j--;
				}

				array[j + 1] = element;
			}
		}
	}

	private boolean validation(T[] array, int leftIndex, int rightIndex) {
		boolean isValid = true;

		if (array == null || array.length == 0) {
			isValid = false;
		} else if ((leftIndex >= rightIndex) || (leftIndex < 0) || (rightIndex <= 0)) {
			isValid = false;
		} else if ((rightIndex > array.length - 1) || leftIndex >= array.length) {
			isValid = false;
		}

		return isValid;
	}
}
