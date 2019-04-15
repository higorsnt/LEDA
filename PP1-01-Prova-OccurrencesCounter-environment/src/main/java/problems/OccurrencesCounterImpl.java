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
		return this.occurencesCounter(array, elem, 0, array.length - 1, 0);
	}

	private int occurencesCounter(T[] array, T elem, int leftIndex, int rightIndex, int occurrences){
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
	}

}
