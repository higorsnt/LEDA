package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;

	protected int maxHeight;

	protected double PROBABILITY = 0.5;

	public SkipListImpl(int maxHeight) {
		this.maxHeight = maxHeight;
		root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
	 * metodo deve conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxHeight; i++) {
			root.forward[i] = NIL;
		}
	}

	
	@Override
	public void insert(int key, T newValue, int height) {
		if (height > this.maxHeight) throw new RuntimeException();

		if (newValue != null) {
			SkipListNode<T>[] update = new SkipListNode[this.maxHeight];
			SkipListNode<T> node = this.root;

			for (int i = this.maxHeight - 1; i > -1; i--) {
				while (node.getForward(i).getKey() < key) {
					node = node.getForward(i);
				}

				update[i] = node;
			}

			if (node.getKey() == key) {
				node.setValue(newValue);
			} else {
				SkipListNode newNode = new SkipListNode(key, height, newValue);
				update(newNode, update);
			}

		}
	}

	private void update(SkipListNode<T> newNode, SkipListNode[] update){
		for (int i = 0; i < newNode.height() - 1; i++) {
			newNode.getForward()[i] = update[i];
			update[i] = newNode;
		}
	}

	@Override
	public void remove(int key) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public SkipListNode<T> search(int key) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public SkipListNode<T>[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
