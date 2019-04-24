package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		Integer floor = null;

		if (array != null && array.length > 0){
			int leftIndex = 0;
			int rightIndex = array.length - 1;

			while (leftIndex <= rightIndex){
				int middle = (leftIndex + rightIndex) / 2;

				if (array[middle].compareTo(x) == 0) {
					return array[middle];
				} else if (x.compareTo(array[middle]) < 0) {
					rightIndex = middle - 1;
				} else {
					floor = array[middle];
					leftIndex = middle + 1;
				}
			}
		}

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		Integer ceil = null;

		if (array != null && array.length > 0) {
			int leftIndex = 0;
			int rightIndex = array.length - 1;

			while (leftIndex <= rightIndex) {
				int middle = (leftIndex + rightIndex) / 2;

				if (array[middle].compareTo(x) == 0) {
					return array[middle];
				} else if (x.compareTo(array[middle]) < 0) {
					ceil = array[middle];
					rightIndex = middle - 1;
				} else {
					leftIndex = middle + 1;
				}
			}
		}
		return ceil;
	}
}
