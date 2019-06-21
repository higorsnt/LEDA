package main.bst.extended;

import java.util.Comparator;

import main.bst.BSTImpl;
import main.bst.BSTNode;

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
	public void insert(T element) {
		if (element != null) {
			insert(this.root, element);
		}
	}

	private void insert (BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);

			node.setLeft(new BSTNode.Builder<T>()
									.data(null)
									.left(null)
									.right(null)
									.parent(node)
									.build());

			node.setRight(new BSTNode.Builder<T>()
									 .data(null)
									 .left(null)
									 .right(null)
									 .parent(node)
									 .build());

		} else {
			if (this.comparator.compare(node.getData(), element) > 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else if (this.comparator.compare(node.getData(), element) < 0){
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> result = new BSTNode<>();

		if (element != null) {
			if (!isEmpty()) {
				result = search(this.root, element);
			}
		}

		return result;
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> aux = new BSTNode<>();

		if (!node.isEmpty()) {
			if (node.getData().equals(element)) {
				aux = node;
			} else if (this.comparator.compare(node.getData(), element) > 0) {
				aux = search((BSTNode<T>) node.getLeft(), element);
			} else {
				aux = search((BSTNode<T>) node.getRight(), element);
			}
		}

		return aux;
	}

	@Override
	public T[] sort(T[] array) {
		super.root = new BSTNode<>();

		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				this.insert(array[i]);
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
