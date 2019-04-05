package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;
import java.util.Collections;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (validation(array, leftIndex, rightIndex)){
			// creating a copy of the array, whose given interval will be sorted
			Integer[] copy = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);

			// taking the largest element of the array copy
			Integer max = Collections.max(Arrays.asList(copy));

			// creating and initializing the occurrences array
			Integer[] occurrences = new Integer[max + 1];
			Arrays.fill(occurrences, 0);

			countOcurrences(copy, occurrences);
			cumulativeSum(occurrences);

			Integer[] result = new Integer[array.length];
			for (int i = rightIndex; i >= leftIndex; i--) {
				Integer element = array[i];

				result[--occurrences[element]] = element;
			}

			for (int i = 0; i < result.length; i++) {
				array[i] = result[i];
			}
		}
	}

	private void countOcurrences(Integer[] array, Integer[] occurrences){
		for (int i = 0; i < array.length; i++) {
				occurrences[array[i]]++;
		}
	}

	private void cumulativeSum (Integer[] occurrences){
		for (int i = 0; i < occurrences.length - 1; i++) {
			occurrences[i + 1] += occurrences[i];
		}
	}

	private boolean validation(Integer[] array, int leftIndex, int rightIndex) {
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
