package adt.btree;

public interface BTree<T extends Comparable<T>> {

	/**
	 * Returns the root of the tree.
	 */
	public BNode<T> getRoot();

	/**
	 * Checks if the tree is empty.
	 */
	public boolean isEmpty();

	/**
	 * Returns the height of a b tree.
	 */
	public int height();

	/**
	 * Searches a pair (BNode, position) whose node contains the given element.
	 * If the element is not present the method returns a BNodePosition with
	 * null fields.
	 */
	public BNodePosition<T> search(T element);

	/**
	 * Inserts a new element.
	 */
	public void insert(T element);

	/**
	 * Returns an array of BNodes visited in depth-left. The algorithm must
	 * visit each node in the following way: add the ROOT, then visit
	 * recursively all children of the ROOT (from left to right), and so on.
	 * Therefore, the algorithm goes down at the left side of the tree.
	 */
	public BNode<T>[] depthLeftOrder();

	/**
	 * Returns the number of elements of all nodes of the tree.
	 */
	public int size();

	/**
	 * Returns the node containing the maximum element of the tree.
	 */
	public BNode<T> maximum(BNode<T> node);

	/**
	 * Returns the node containing the minimum element of the tree.
	 */
	public BNode<T> minimum(BNode<T> node);

	/**
	 * Removes the element containing the given key.
	 */
	public void remove(T element);
}
