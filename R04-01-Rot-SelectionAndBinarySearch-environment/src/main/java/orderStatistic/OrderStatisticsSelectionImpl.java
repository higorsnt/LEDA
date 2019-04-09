package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   como o selectionsort mas sem modificar nenhuma posicao do array).
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		T minor = null;

		if (array != null && array.length > 0 && k > 0 && k <= array.length){
			minor = array[0];
			int indexBigger = 0;
			for (int i = 1; i < array.length; i++) {
				if (array[i].compareTo(minor) <= 0){
					minor = array[i];
				}
				if (array[i].compareTo(array[indexBigger]) > 0){
					indexBigger = i;
				}
			}

			int index;

			for (int i = 1; i <= k - 1; i++) {
				index = this.selectionSort(array, minor, indexBigger);
				minor = array[index];
			}
		}
		return minor;
	}

	public int selectionSort(T[] array, T minor, int indexBigger){
		int indexMinor = indexBigger;

		for (int i = 0; i < array.length; i++) {
			if ((array[indexMinor].compareTo(array[i]) > 0) && (array[i].compareTo(minor) > 0)){
				indexMinor = i;
			}
		}

		return indexMinor;

	}

}
