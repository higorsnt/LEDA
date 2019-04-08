package problems;

/**
 * Dado um array ordenado de inteiros ordenado, floor(x) eh o elemento do array menor 
 * (e mais proximo possível de x) ou igual a x (podendo x pertencer ou nao ao array). 
 * Analogamente, ceil(x) seria o elemento do array que é maior (e mais próximo 
 * possível de x) ou igual a x.
 * 
 * Exemplo: floor([4,6,8,10],7) = 6, ceil([4,6,8,10],7) = 8,
 * floor([4,6,8,10],8) = ceil([4,6,8,10],8) = 8
 * 
 * @author Adalberto
 *
 */
public interface FloorCeil {
	/**
	 * Retorna o elemento do array que eh menor que x e mais proximo possivel dele.
	 * @param array
	 * @return o maior inteiro pertencente ao array que seja menor que x. Caso nao exista floor, 
	 * retorna null.
	 */
	public Integer floor(Integer[] array, Integer x);

	/**
	 * Retorna o elemento do array que eh maior que x e mais proximo possivel dele.
	 * @param array
	 * @return o menor inteiro pertencente ao array que seja maior que x. Caso nao exista floor, 
	 * retorna null.
	 */
	public Integer ceil(Integer[] array, Integer x);
	
}
