package adt.bst.extended;

import java.util.Comparator;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public T[] sort(T[] array) {
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				super.insert(array[i]);
			}
		}

		return super.order();
	}

	@Override
	public T[] reverseOrder() {
		T[] array = (T[]) new Comparable[super.size()];

		reverseOrder(getRoot(), 0, array);

		return array;
	}

	private int reverseOrder(BSTNode<T> node, int index, T[] array) {
		if (!node.isEmpty()) {
			index = reverseOrder((BSTNode<T>) node.getRight(), index, array);
			array[index++] = node.getData();
			index = reverseOrder((BSTNode<T>) node.getLeft(), index, array);
		}

		return index;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}
