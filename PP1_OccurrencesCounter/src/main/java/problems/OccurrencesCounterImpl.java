package problems;

/**
 * 
 * Dado um array ordenado de elementos comparaveis e um outro elemento comparavel, 
 * implemente o metodo que conte as ocorrências do elemento no array. 
 * 
 * Restricoes:
 * - a complexidade esperada é O (log.n). Soluções com tempo O(n) ou superiores serão desconsideradas.
 * - voce nao pode usar memoria extra
 * - voce nao pode usar metodos prontos da bilbioteca de arrays (exceto o metodo length)
 * - Dica: tente pensar numa forma eficiente (em log n) de descobrir a posicao de um 
 *   elemento no array e use essa ideia para contar as ocorrencias desse elemento no array
 * 
 * @author campelo
 *
 * @param <T>
 */
public class OccurrencesCounterImpl<T extends Comparable<T>> {

	/*
	 * Se elem está presente no array[], retorna a quantidade de ocorrências de elem.
	 * Caso contrário, retorna 0.
	 */
	public int count(T[] array, T elem) {
		return this.occurencesCounter(array, elem, 0, array.length - 1);
	}

	private int occurencesCounter(T[] array, T elem, int leftIndex, int rightIndex){
		/**

		 Esse código foi o realizado durante a prova, porém possui complexidade O(n) no pior caso.
		 (Pior caso é quando todos os elementos são iguais).

		int middle = (leftIndex + rightIndex) / 2;

		if (leftIndex <= rightIndex && array.length > 0) {
			if (array[middle].compareTo(elem) == 0) {
				occurrences++;
			}
			if (array[middle].compareTo(elem) <= 0){
				occurrences = this.occurencesCounter(array, elem, middle + 1, rightIndex, occurrences);
			}
			if (array[middle].compareTo(elem) >= 0){
				occurrences = this.occurencesCounter(array, elem, leftIndex, middle - 1, occurrences);
			}
		}
		return occurrences;
		*/

		int occurrences = 0;
		int lastOccurrence = upperBound(array, elem);
		int firstOccurrence = lowerBound(array, elem);

		if (lastOccurrence != -1 && firstOccurrence != -1) {
			occurrences = lastOccurrence - firstOccurrence + 1;
		}

		return  occurrences;
	}

	public int upperBound(T[] array, T x) {
		int upper = -1;

		int start = 0;
		int last = array.length;

		while (start < last) {
			int mid = (start + last) / 2;

			if (array[mid].compareTo(x) == 0) {
				upper = mid;
				last = mid - 1;
			} else if (array[mid].compareTo(x) < 0){
				start = mid + 1;
			} else {
				last = mid - 1;
			}
		}

		return upper;
	}

	public int lowerBound(T[] array, T x) {
		int lower = -1;

		int start = 0;
		int last = array.length;

		while (start < last) {
			int mid = (start + last) / 2;

			if (array[mid].compareTo(x) == 0) {
				lower = mid;
				start = mid + 1;
			} else if (array[mid].compareTo(x) < 0) {
				start = mid + 1;
			} else {
				last = mid - 1;
			}
		}

		return lower;
	}

}
