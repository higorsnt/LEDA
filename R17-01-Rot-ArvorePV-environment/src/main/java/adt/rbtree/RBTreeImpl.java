package adt.rbtree;

import adt.bst.BSTImpl;
import adt.rbtree.RBNode.Colour;

import java.awt.*;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements RBTree<T> {

	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}

	protected int blackHeight() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected boolean verifyProperties() {
		boolean resp = verifyNodesColour() && verifyNILNodeColour()
				&& verifyRootColour() && verifyChildrenOfRedNodes()
				&& verifyBlackHeight();

		return resp;
	}

	/**
	 * The colour of each node of a RB tree is black or red. This is guaranteed
	 * by the type Colour.
	 */
	private boolean verifyNodesColour() {
		return true; // already implemented
	}

	/**
	 * The colour of the root must be black.
	 */
	private boolean verifyRootColour() {
		return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
																// implemented
	}

	/**
	 * This is guaranteed by the constructor.
	 */
	private boolean verifyNILNodeColour() {
		return true; // already implemented
	}

	/**
	 * Verifies the property for all RED nodes: the children of a red node must
	 * be BLACK.
	 */
	private boolean verifyChildrenOfRedNodes() {
		return auxVerifyChildrenOfRedNodes((RBNode<T>) this.root);
	}

	private boolean auxVerifyChildrenOfRedNodes(RBNode<T> node) {
		boolean result = false;

		if (node != null && node.isEmpty()) {
			RBNode<T> leftNode = (RBNode<T>) node.getRight();
			RBNode<T> rightNode = (RBNode<T>) node.getLeft();

			if (node.getColour().equals(Color.RED)) {
				if (!(leftNode.getColour().equals(Colour.RED))
						|| !(rightNode.getColour().equals(Colour.RED))) {
					result = true;
				}
			} else {
				auxVerifyChildrenOfRedNodes((RBNode<T>) node.getLeft());
				auxVerifyChildrenOfRedNodes((RBNode<T>) node.getRight());
			}

			return true;
		}

		return result;
	}

	/**
	 * Verifies the black-height property from the root.
	 */
	private boolean verifyBlackHeight() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void insert(T value) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public RBNode<T>[] rbPreOrder() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// FIXUP methods
	protected void fixUpCase1(RBNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected void fixUpCase2(RBNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected void fixUpCase3(RBNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected void fixUpCase4(RBNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected void fixUpCase5(RBNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
