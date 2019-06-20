package main.sorting.divideAndConquer;

import main.sorting.AbstractSorting;
import static util.Util.swap;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int pivot;

		if (validation(array, leftIndex, rightIndex)) {
			pivot = this.partition(array, leftIndex, rightIndex);
			this.sort(array, leftIndex, pivot - 1);
			this.sort(array, pivot + 1, rightIndex);
		}
	}

	private boolean validation(T[] array, int leftIndex, int rightIndex) {
		boolean isValid = true;

		if (array == null || array.length <= 0) {
			isValid = false;
		} else if ((leftIndex >= rightIndex) || (leftIndex < 0) || (rightIndex <= 0)) {
			isValid = false;
		} else if ((rightIndex > array.length - 1) || leftIndex >= array.length) {
			isValid = false;
		}

		return isValid;
	}

	private int partition(T[] array, int leftIndex, int rightIndex){
		T pivot = array[leftIndex];

		int start = leftIndex;

		for (int i = start + 1; i <= rightIndex; i++) {
			if (array[i].compareTo(pivot) <= 0) {
				start++;
				swap(array, start, i);
			}
		}

		swap(array, leftIndex, start);
		return start;
	}
}
