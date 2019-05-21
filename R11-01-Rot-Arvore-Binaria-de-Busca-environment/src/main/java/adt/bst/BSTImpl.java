package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		int height = -1;

		if (!isEmpty()) {
			height = height(this.root);
		}

		return height;
	}

	private int height (BTNode<T> node) {
		int height = 0;

		if (!isEmpty()) {
			height = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		}

		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> result = new BSTNode<>();

		if (!isEmpty()) {
			result = search(this.root, element);
		}

		return result;
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> aux = new BSTNode<>();

		if (!node.isEmpty()) {
			if (node.getData().equals(element)) {
				aux = node;
			} else if (node.getData().compareTo(element) > 0) {
				aux = search((BSTNode<T>) node.getLeft(), element);
			} else {
				aux = search((BSTNode<T>) node.getRight(), element);
			}
		}
		return aux;
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
			node.setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());
			node.setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());
		} else {
			if (node.getData().compareTo(element) > 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else {
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.root);
	}

	private BSTNode<T> maximum(BSTNode<T> node){
		BSTNode<T> max = node;

		if (!node.getRight().isEmpty()) {
			max = maximum((BSTNode<T>) node.getRight());
		}

		return max;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.root);
	}

	private BSTNode<T> minimum(BSTNode<T> node){
		BSTNode<T> min = node;

		if (!node.getLeft().isEmpty()) {
			min = minimum((BSTNode<T>) node.getLeft());
		}

		return min;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = new BSTNode<>();

		if (element != null) {
			if (!this.root.getRight().isEmpty()) {
				result = minimum((BSTNode<T>) this.root.getRight());
			} else {
			}
		}

		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
