package sorting.divideAndConquer;

import sorting.AbstractSorting;
import static util.Util.swap;

import java.util.Arrays;

/**
 * A mediana de uma colecao/array de valores é o valor que divide a coleção na metade.
 * A forma mais custosa de encontrar a mediana seria ordenar o array completo e
 * escolher o elemento do meio do array. Essa abordagem limita o tempo de execucao ao
 * tempo do algoritmo de ordenacao utilizado. Sabe-se que a mediana é um
 * excelente pivot para garantir um bom tempo de execução do quicksort.
 *
 * Voce deve implementar o algoritmo do quicksort que seleciona a mediana dos
 * dados a serem ordenados como pivot. Utilize a estrategia de selection sort
 * para encontrar a mediana (sem modificar o array original). Depois use-a
 * como o pivot do quicksort.
 *
 * Requisitos:
 * - Voce nao pode ordenar o array e escolher o elemento da metade
 * - Voce nao pode utilizar array extra (tem que ser in-place)
 * - O uso do selection eh apenas para encontrar a mediana, mas nao deve
 *   modificar o array de forma alguma.
 */
public class QuickSortComMediana<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int indexPivot = getPivot(array, leftIndex, rightIndex);
		T pivot = array[indexPivot];

		partition(array, pivot, leftIndex, rightIndex);

		this.sort(array, leftIndex, indexPivot -1);
		this.sort(array, indexPivot + 1, rightIndex);
	}

	private void partition(T[] array,T pivot, int leftIndex, int rightIndex){
		int i = leftIndex;
		int j = rightIndex;

		while (true){
			while (array[i].compareTo(pivot) > 0){
				i++;
			}

			while (array[j].compareTo(pivot) < 0){
				j--;
			}
            swap(array, j, i);
		}
	}

	private int getPivot(T[] array, int leftIndex, int rightIndex){
		int eo = (rightIndex - leftIndex) / 2;

		T menor = array[0];
		int indexBigger = 0;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (menor.compareTo(array[i]) > 0) {
				menor = array[i];
			}
			if (array[i].compareTo(array[indexBigger]) > 0) {
				indexBigger = i;
			}
		}

		int index = 0;
		for (int i = 1; i <= eo - 1; i++) {
			index = getOrdersStatistics(array, menor, indexBigger, leftIndex, rightIndex);
		}

		return index;
	}

	private int getOrdersStatistics(T[] array, T menor, int indexBigger, int leftIndex, int rightIndex){
		T lower = array[indexBigger];
		int index;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if ((menor.compareTo(array[i])) > 0 && array[i].compareTo(lower) > 0){
				lower = array[i];
				index = i;
			}
		}
		return index;
	}

}
