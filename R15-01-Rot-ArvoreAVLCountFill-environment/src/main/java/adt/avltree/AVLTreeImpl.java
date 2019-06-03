package adt.avltree;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int balance = 0;

		if (node != null && !super.isEmpty()) {
			balance = super.height(node.getLeft()) - super.height(node.getRight());
		}

		return balance;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);

		if (balance > 1) {
			this.heavierLeft(node);
		} else if (balance < -1) {
			this.heavierRight(node);
		}
	}

	protected void heavierLeft(BSTNode<T> node) {
		BSTNode<T> aux;

		if (this.calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
			aux = Util.rightRotation(node);
		} else {
			Util.leftRotation((BSTNode<T>) node.getLeft());
			aux = Util.rightRotation(node);
		}

		if (aux != null) {
			super.root = aux;
		}
	}

	protected void heavierRight(BSTNode<T> node) {
		BSTNode<T> aux;

		if (this.calculateBalance((BSTNode<T>) node.getRight()) < 0) {
			aux = Util.leftRotation(node);
		} else {
			Util.rightRotation((BSTNode<T>) node.getRight());
			aux = Util.leftRotation(node);
		}

		if (aux != null) {
			super.root = aux;
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = super.search(element);
		super.remove(element);
		rebalanceUp(node);
	}

	@Override
	public void insert(T element) {
		super.insert(element);
		BSTNode<T> node = super.search(element);
		rebalance(node);
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> parentNode = (BSTNode<T>) node.getParent();

		while (parentNode != null) {
			rebalance(parentNode);
			parentNode = (BSTNode<T>) parentNode.getParent();
		}
	}
}
