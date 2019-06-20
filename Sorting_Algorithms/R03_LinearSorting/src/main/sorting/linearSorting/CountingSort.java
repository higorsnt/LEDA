package main.sorting.linearSorting;

import main.sorting.AbstractSorting;

import java.util.Arrays;

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
			Integer max = array[leftIndex];

			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i].compareTo(max) > 0) {
					max = array[i];
				}
			}

			// creating and initializing the occurrences array
			Integer[] occurrences = new Integer[max + 1];
			Arrays.fill(occurrences, 0);

			for (int i = leftIndex; i <= rightIndex; i++) {
				occurrences[array[i]]++;
			}

			for (int i = 0; i < occurrences.length - 1; i++) {
				occurrences[i + 1] += occurrences[i];
			}

			Integer[] result = new Integer[rightIndex - leftIndex + 1];

			for (int i = rightIndex; i >= leftIndex; i--) {
				Integer element = array[i];

				result[--occurrences[element]] = element;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = result[i - leftIndex];
			}
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
