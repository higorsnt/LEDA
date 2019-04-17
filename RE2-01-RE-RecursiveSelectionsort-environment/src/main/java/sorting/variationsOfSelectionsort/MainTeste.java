package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

import java.util.Arrays;

public class MainTeste {

    public static void main(String[] args) {
        AbstractSorting<Integer> as = new RecursiveSelectionSort<>();
        Integer[] a = {10,9,8,7,6,5,4,3,2,1,0};
        as.sort(a, 3, 8);
        System.out.println(Arrays.toString(a));
    }

}
