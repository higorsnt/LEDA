package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import static util.Util.swap;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validation(array, leftIndex, rightIndex)){
			partition(array, leftIndex, rightIndex);
		}
	}

	public void partition(T[]array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int start = leftIndex;
			int end = rightIndex;
			int i = leftIndex;
			T pivot = array[leftIndex];

			while(i <= end) {
				if(array[i].compareTo(pivot) < 0){
					swap(array, start, i);
					start++;
					i++;
				} else if(array[i].compareTo(pivot) > 0){
					swap(array,  i, end);
					end--;
				} else {
					i++;
				}
			}

			sort(array, leftIndex, start - 1);
			sort(array, end + 1, rightIndex);
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
