package sorting.simpleSorting;

import sorting.AbstractSorting;
import static util.Util.swap;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			T element = array[i];

			int  isOrdered = i - 1;

			while (isOrdered > 0 && element.compareTo(array[isOrdered]) > 0){
				array[isOrdered + 1] = array[i];
				isOrdered--;
			}

			array[i] = element;
		}
	}
}
