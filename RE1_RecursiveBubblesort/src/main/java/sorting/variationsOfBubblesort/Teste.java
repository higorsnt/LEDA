package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import sorting.Sorting;

import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {
        Integer[] array1 = new Integer[] {5, 6, 1, 0, 3, 5, 9, 10, -8,
                -100, 8, 15, 23, -44, 66, -8};

        Sorting<Integer> s = new RecursiveBubbleSort<>();
        System.out.println(Arrays.toString(array1));
        s.sort(array1);
        System.out.println(Arrays.toString(array1));

        Integer[] array2 = new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1,
                -2, -3, -4, -5, -6, -7, -8, -9, -10};

        AbstractSorting<Integer> as = new RecursiveBubbleSort<>();
        System.out.println(Arrays.toString(array2));
        as.sort(array2, 5, array2.length - 1);
        System.out.println(Arrays.toString(array2));

        array2 = new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1,
                -2, -3, -4, -5, -6, -7, -8, -9, -10};
        as.sort(array2, 15, array2.length - 1);
        System.out.println(Arrays.toString(array2));
    }
}
