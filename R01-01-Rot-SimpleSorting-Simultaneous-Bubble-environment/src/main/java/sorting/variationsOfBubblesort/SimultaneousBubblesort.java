package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import static util.Util.swap;

/**
 * This algorithm applies two bubblesorts simultaneously. In a same iteration, a
 * bubblesort pushes the greatest elements to the right and another bubblesort
 * pushes the smallest elements to the left. At the end of the first iteration,
 * the smallest element is in the first position (index 0) and the greatest
 * element is the last position (index N-1). The next iteration does the same
 * from index 1 to index N-2. And so on. The execution continues until the array
 * is completely ordered.
 */
public class SimultaneousBubblesort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean swapped = true;

		while (swapped) {
			swapped = false;

			for (int i = leftIndex; i <= rightIndex - 1; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					swap(array, i, i + 1);
					swapped = true;
				}
			}

			rightIndex--;

			for (int i = rightIndex; i > leftIndex; i--) {
				if (array[i].compareTo(array[i - 1]) < 0) {
					swap(array, i, i - 1);
					swapped = true;
				}
			}

			leftIndex++;
		}
	}
}
