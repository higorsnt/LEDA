package adt.avltree;

import adt.bst.BSTNode;
import adt.bt.Util;

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
			for (T element : array) {
				this.insert(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			super.insert(this.root, element);

			BSTNode<T> node = super.search(element);
			this.rebalance(node);
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

	@Override
	protected void heavierRight(BSTNode<T> node) {
		if (this.calculateBalance((BSTNode<T>) node.getRight()) < 0) {
			this.RRcounter++;
		} else {
			this.RLcounter++;
		}
	}

	@Override
	protected void heavierLeft(BSTNode<T> node) {
		if (this.calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
			this.LLcounter++;
		} else {
			this.LRcounter++;
		}
	}

	@Override
	public void remove(T element) {
		// TODO
	}
}
