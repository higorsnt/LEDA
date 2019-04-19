package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;
import java.util.Collections;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (validation(array, leftIndex, rightIndex)){
			Integer max = array[leftIndex];
			Integer min = array[leftIndex];

			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i].compareTo(max) > 0) {
					max = array[i];
				}

				if (array[i].compareTo(min) < 0) {
					min = array[i];
				}
			}

			// creating and initializing the occurrences array
			Integer[] occurrences = new Integer[max - min + 1];
			Arrays.fill(occurrences, 0);

			for (int i = leftIndex; i <= rightIndex; i++) {
				occurrences[array[i] - min]++;
			}

			for (int i = 0; i < occurrences.length - 1; i++) {
				occurrences[i + 1] += occurrences[i];
			}

			Integer[] result = new Integer[rightIndex - leftIndex + 1];

			for (int i = rightIndex; i >= leftIndex; i--) {
				Integer element = array[i];
				result[--occurrences[element - min]] = element;
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
		} else if ((leftIndex >= rightIndex) || (leftIndex < 0)
				|| (rightIndex <= 0)) {
			isValid = false;
		} else if ((rightIndex > array.length - 1)
				|| leftIndex >= array.length) {
			isValid = false;
		}

		return isValid;
	}

}
