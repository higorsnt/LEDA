package adt.btree;

public class BNodePosition<T extends Comparable<T>> {
	protected BNode<T> node;
	protected int position;

	public BNodePosition(BNode<T> node, int position) {
		this.node = node;
		this.position = position;
	}

	public BNodePosition() {
	}
}
