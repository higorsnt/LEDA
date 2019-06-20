 package adt.linkedList.set;

import adt.linkedList.LinkedList;

/**
 * Interface que representa uma implementacao de um conjunto utilizando a nocao de 
 * linked list. Um conjunto pode ser visto como uma lista ligada sendo 
 * que nao possui duplicatas. Essa remocao de duplicatas pode ser feita em um 
 * metodo especifico. Outras operacoes que sao possiveis sao: uniao e intesecao 
 * de conjuntos, onde elementos sao inseridos sem gerar duplicatas. 
 * 
 * @author Adalberto
 *
 */
public interface SetLinkedList<T> extends LinkedList<T>{
	/**
	 * Remove as duplicatas de um conjunto implementado com uma linked list. 
	 * Apenas a primeira ocorrencia eh mantida no conjnto, as demais sao removidas. 
	 */
	public void removeDuplicates();
	
	/**
	 * Faz a uniao dos elementos deste conjunto com os elementos do conjunto 
	 * passado como parametro, retornando uma outra estrutura (SetLinkedList). 
	 * 
	 * @param otherSet
	 * @return
	 */
	public SetLinkedList<T> union(SetLinkedList<T> otherSet);
	
	/**
	 * Faz a operacao de intersecao entre este conjunto e otherSet, retornando 
	 * uma nova estrutura (SetLinkedList).
	 * 
	 * @param otherSet
	 * @return
	 */
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet);
	
	/**
	 * Faz a concatenacao deste conjunto com otherSet. A concatenacao eh uma operacao 
	 * de uniao mas que modifica este conjunto e eh mais eficiente do que a uniao:
	 * Precisa apenas aumentar esaa estrutura com todos os elementos de otherSet, sem 
	 * precisar inserir um a um.
	 * 
	 * @param otherSet
	 */
	public void concatenate(SetLinkedList<T> otherSet);
}
