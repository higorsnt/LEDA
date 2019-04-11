package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex - 1){
			int menor = leftIndex;
			for (int i = leftIndex; i < rightIndex; i++) {
				if (array[i].compareTo(array[menor]) < 0) {
					menor = i;
				}
			}
			swap(array, leftIndex, menor);
			this.sort(array, leftIndex + 1, rightIndex);
		}
	}

	public void swap(T[] array, int i, int j){
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
