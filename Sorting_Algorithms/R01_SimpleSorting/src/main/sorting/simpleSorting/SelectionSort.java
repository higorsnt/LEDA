package main.sorting.simpleSorting;

import main.sorting.AbstractSorting;

import static main.util.Util.swap;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (this.validation(array, leftIndex, rightIndex)) {
			for (int i = leftIndex; i <= rightIndex; i++) {
				int smallerElement = i;

				for (int j = i + 1; j <= rightIndex; j++) {
					if (array[smallerElement].compareTo(array[j]) > 0) {
						smallerElement = j;
					}
				}
				swap(array, i, smallerElement);
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
