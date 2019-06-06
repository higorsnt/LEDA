package adt.skipList;

/**
 * A skip list.
 * @author adalberto
 * @author campelo
 */
public interface SkipList<T> {

	/**
	 * Inserts a new element (with a given height) in the skip list.
	 * If the skip list already contains a node with the same key, updates 
	 * the node value (does not update the node height / the height parameter 
	 * is ignored).
	 * Throws RunTimeException if the given height is greater than maxHeight
	 * (does not throw if it is functioning as an update).
	 */
	public void insert(int key, T newValue, int height);

	/**
	 * Removes a node (containing the given key) from the skip list. If the
	 * given key is not present is any node of the skip list, it remains
	 * unchanged.
	 */
	public void remove(int key);

	/**
	 * Returns the height of the highest node of the skip list.
	 * Returns zero if the skip list is empty.
	 */
	public int height();

	/**
	 * Searches a node (containing the given key) in the skip list. If the key
	 * is not present in any node of the skip list, it returns null.
	 * 
	 */
	public SkipListNode<T> search(int key);

	/**
	 * Returns the size (number of real elements) of the skip list. The sentinel
	 * nodes are not considered. For example, just after instantiating a skip
	 * list it has the first and the NIL nodes, but its size is 0.
	 */
	public int size();

	/**
	 * Returns an array containing all nodes (including sentinel nodes) of the
	 * skip list in order.
	 */
	public SkipListNode<T>[] toArray();
}
