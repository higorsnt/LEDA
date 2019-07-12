package bst.extended;

import bst.BST;

/**
 * BST que verifica propriedades de nos: se sao primos em primeiro grau 
 * ou se sao primos em segundo grau. 
 * 
 * Restricoes:
 *  - Na implementacao dos metodos voce só pode utilizar o metodo search (ja implementado)
 *    e os metodos da classe BSTNode.
 *  - Voce pode implementar metodos auxiliares mas que nao facam nada de algum metodo existente
 *    da BST. Por exemplo, suponha que voce queira fazer um caminhamento em pre-ordem em sua 
 *    solucao e decide implementa-lo. Essa solucao nao sera valida porque caminhamento em 
 *    pre-ordem eh uma funcionalidade de BST nao permitida de ser utilizada.
 *  
 * @author Adalberto
 *
 * @param <T>
 */
public interface FamilyBST<T extends Comparable<T>> extends BST<T> {

	/**
	 * Diz se dois elementos de uma BST sao primos em primeiro grau.
	 * Pense nas condicoes para estabelecer essa restricao e implemente.
	 * 
	 * @param elem1
	 * @param elem2
	 * @return
	 */
	public boolean primosPrimeiroGrau(T elem1, T elem2);
	
	/**
	 * Diz se dois elementos de uma BST sao primos em segundo grau.
	 * Pense nas condicoes para estabelecer essa restricao e implemente.
	 * Dica: primos em primeiro grau de nossos pais sao nossos primos 
	 * em segundo grau.
	 * 
	 * @param elem1
	 * @param elem2
	 * @return
	 */
	public boolean primosSegundoGrau(T elem1, T elem2);
	
}
