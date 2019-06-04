package adt.avltree;

import adt.bst.BSTNode;
import adt.bt.Util;

import java.util.Arrays;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		if (array != null) {
			Arrays.sort(array);
			auxFillWithoutRebalance(array, 0, array.length - 1);
		}
	}

	private void auxFillWithoutRebalance(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex <= rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;

			T element = array[middle];
			insertWithoutRebalance(element);

			auxFillWithoutRebalance(array, leftIndex + 1, middle - 1);
			auxFillWithoutRebalance(array, middle + 1, rightIndex);
		}
	}

	private void insertWithoutRebalance(T element) {
		auxInsertWithoutRebalance(this.root, element);
	}

	private void auxInsertWithoutRebalance(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());
			node.setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());
		} else {
			if (node.getData().compareTo(element) > 0) {
				auxInsertWithoutRebalance((BSTNode<T>) node.getLeft(), element);
			} else {
				auxInsertWithoutRebalance((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	protected void rebalance(BSTNode<T> node) {
		int balance = super.calculateBalance(node);

		if (balance > 1) {
			this.heavierLeft(node);
		} else if (balance < -1) {
			this.heavierRight(node);
		}
	}

	private void heavierLeft(BSTNode<T> node) {
		BSTNode<T> aux;

		if (this.calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
			aux = Util.rightRotation(node);
			this.LLcounter++;
		} else {
			Util.leftRotation((BSTNode<T>) node.getLeft());
			aux = Util.rightRotation(node);
			this.LRcounter++;
		}

		if (aux.getParent() == null) {
			super.root = aux;
		}
	}

	private void heavierRight(BSTNode<T> node) {
		BSTNode<T> aux;

		if (this.calculateBalance((BSTNode<T>) node.getRight()) < 0) {
			aux = Util.leftRotation(node);
			this.RRcounter++;
		} else {
			Util.rightRotation((BSTNode<T>) node.getRight());
			aux = Util.leftRotation(node);
			this.RLcounter++;
		}

		if (aux.getParent() == null) {
			super.root = aux;
		}
	}
}
