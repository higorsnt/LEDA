package oddEvenBubbleSort;

import sorting.AbstractSorting;
import static util.Util.swap;

public class OddEvenBubbleSort <T extends Comparable<T>> extends AbstractSorting<T> {

    /**
     * This algorithm simulates a logical partitioning of the input array by considering
     * different indexing, that is, the first sub-array is indexed by even elements and
     * the second sub-array is indexed by add elements. Then, ip applies a complete bubblesort
     * in the first sub-array considering neighbours (even). After that,
     * it applies a complete bubblesort in the second sub-array considering
     * neighbours (odd). After that, the algorithm performs a merge between elements indexed
     * by even and odd numbers.
     */
    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        boolean swapped = true;

        while (swapped){
            swapped = false;

            for (int i = leftIndex; i < rightIndex - 1; i += 2) {
                if (array[i].compareTo(array[i + 1]) > 0){
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }

            for (int i = leftIndex + 1; i < rightIndex - 1; i += 2) {
                if (array[i].compareTo(array[i + 1]) > 0){
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
        }
    }
}
