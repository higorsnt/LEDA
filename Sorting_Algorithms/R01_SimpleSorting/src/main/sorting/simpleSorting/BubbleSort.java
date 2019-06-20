package main.sorting.simpleSorting;

import main.sorting.AbstractSorting;

import static main.util.Util.swap;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (this.validation(array, leftIndex, rightIndex)) {
			for (int i = leftIndex; i <= rightIndex; i++) {
				for (int j = leftIndex; j < rightIndex; j++) {
					if (array[j].compareTo(array[j + 1]) > 0) {
						swap(array, j, j + 1);
					}
				}
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