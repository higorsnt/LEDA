package main.avltree;

import main.bst.BSTImpl;
import main.bst.BSTNode;
import main.bt.Util;

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

		if (!node.isEmpty() && node != null) {
			balance = height(node.getLeft()) - height(node.getRight());
		}

		return balance;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);

		if (balance > 1) {
			this.heavierLeft(node);
		} else if (balance < -1) {
			this.heavierRight(node);
		}
	}

	private void heavierLeft(BSTNode<T> node) {
		BSTNode<T> aux;
		if (calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
			// LEFT LEFT
			aux = Util.rightRotation(node);
		} else {
			// LEFT RIGHT
			Util.leftRotation((BSTNode<T>) node.getLeft());
			aux = Util.rightRotation(node);
		}

		if (aux.getParent() == null) {
			super.root = aux;
		}
	}

	private void heavierRight(BSTNode<T> node) {
		BSTNode<T> aux;

		if (calculateBalance((BSTNode<T>) node.getRight()) < 0) {
			// RIGHT RIGHT
			aux = Util.leftRotation(node);
		} else {
			// RIGHT LEFT
			Util.rightRotation((BSTNode<T>) node.getRight());
			aux = Util.leftRotation(node);
		}

		if (aux.getParent() == null) {
			super.root = aux;
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();

		while (parent != null) {
			rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			insert(this.root, element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());
			node.setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());
		} else {
			if (node.getData().compareTo(element) < 0){
				this.insert((BSTNode<T>) node.getRight(), element);
			} else if (node.getData().compareTo(element) > 0) {
				this.insert((BSTNode<T>) node.getLeft(), element);
			}

			rebalance(node);
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = super.search(element);
		super.remove(element);
		this.rebalanceUp(node);
	}
}
