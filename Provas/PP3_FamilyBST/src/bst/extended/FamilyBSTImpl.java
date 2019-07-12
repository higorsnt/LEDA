package bst.extended;

import bst.BSTImpl;
import bst.BSTNode;

public class FamilyBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements FamilyBST<T>{	
	

	@Override
	public boolean primosPrimeiroGrau(T elem1, T elem2) {
		boolean result = false;
		BSTNode<T> node1 = search(elem1);
		BSTNode<T> node2 = search(elem2);

		BSTNode<T> parentNode1;
		BSTNode<T> uncleNode1 = null;

		if (!node1.isEmpty()) {
			parentNode1 = (BSTNode<T>) node1.getParent();

			if (parentNode1.getParent() != null) {
				if (parentNode1.getParent().getRight().equals(parentNode1)) {
					uncleNode1 = (BSTNode<T>) parentNode1.getParent().getLeft();
				} else {
					uncleNode1 = (BSTNode<T>) parentNode1.getParent().getRight();
				}
			} else {
				if (parentNode1.getLeft().equals(node1)) {
					uncleNode1 = (BSTNode<T>) parentNode1.getRight();
				} else {
					uncleNode1 = (BSTNode<T>) parentNode1.getLeft();
				}
			}
		}

		if (uncleNode1 != null) {
			if (uncleNode1.getRight().equals(node2) || uncleNode1.getLeft().equals(node2)) {
				result = true;
			}
		}

		return result;
	}


	@Override
	public boolean primosSegundoGrau(T elem1, T elem2) {
		boolean result = false;
		BSTNode<T> node1 = search(elem1);

		BSTNode<T> parentNode1;

		if (!node1.isEmpty()) {
			parentNode1 = (BSTNode<T>) node1.getParent();

			if (primosPrimeiroGrau(parentNode1.getData(), elem2)) {
				result = true;
			}
		}

		return result;
	}
	
	
	/**
	 * NAO ALTERAR OS METODOS ABAIXO PORQUE SERAO UTULIZADOS PELOS TESTES
	 */
	@Override
	public void insert(T element) {
		insert(root, element);
	}

	protected void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>)node.getLeft(), element);
			} else if (element.compareTo(node.getData()) > 0) {
				insert((BSTNode<T>)node.getRight(), element);
			}
		}
	}
	
	@Override
	public BSTNode<T> search(T element) {
		return search(root, element);
	}

	protected BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> result = node;
		if (element != null) {
			if (!node.isEmpty()) {
				if (element.compareTo(node.getData()) == 0) {
					result = node;
				} else if (element.compareTo(node.getData()) < 0) {
					result = search((BSTNode<T>)node.getLeft(), element);
				} else {
					result = search((BSTNode<T>)node.getRight(), element);
				}
			}
		}

		return result;
	}
}
