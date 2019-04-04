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
			Integer[] copy = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
			Integer max = Collections.max(Arrays.asList(copy));
			Integer[] occurrences = new Integer[max + 1];
			Arrays.fill(occurrences, 0);

			countOcurrences(array, occurrences, leftIndex, rightIndex);
			cumulativeSum(occurrences);
			coutingSort(array, occurrences, leftIndex, rightIndex);
		}
	}

	private void countOcurrences(Integer[] array, Integer[] ocurrences, int leftIndex, int rightIndex){
		for (int i = leftIndex; i <= rightIndex; i++) {
			ocurrences[array[i]]++;
		}
	}

	private void cumulativeSum (Integer[] ocurrences){
		for (int i = 0; i < ocurrences.length - 1; i++) {
			ocurrences[i + 1] += ocurrences[i];
		}
	}

	private void coutingSort(Integer[] array, Integer[] ocurrences, int leftIndex, int rightIndex){
		Integer[] result = new Integer[array.length];
		for (int i = rightIndex; i >= leftIndex; i--) {
			Integer element = array[i];
			result[--ocurrences[element]] = element;
		}

		for (int i = 0; i < result.length; i++) {
			array[i] = result[i];
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
