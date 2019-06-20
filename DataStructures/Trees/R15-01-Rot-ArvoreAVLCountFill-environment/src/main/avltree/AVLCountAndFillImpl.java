package adt.avltree;

import adt.bst.BSTNode;
import adt.bt.Util;

import java.util.*;

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

			Map<Integer, List<T>> levels = new TreeMap<>();

			auxFillWithoutRebalance(levels, 0, array.length - 1, 0, array);

			for (List<T> list : levels.values()) {
				list.forEach(t -> super.insert(t));
			}

		}
	}

	private void auxFillWithoutRebalance(Map<Integer, List<T>> map, int leftIndex,
										 int rightIndex, int level, T[] array) {
		if (leftIndex <= rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			if (map.containsKey(level)) {
				map.get(level).add(array[middle]);
			} else {
				map.put(level, new ArrayList<>());
				map.get(level).add(array[middle]);
			}

			auxFillWithoutRebalance(map, leftIndex, middle - 1, level + 1, array);
			auxFillWithoutRebalance(map, middle + 1, rightIndex, level + 1, array);
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
