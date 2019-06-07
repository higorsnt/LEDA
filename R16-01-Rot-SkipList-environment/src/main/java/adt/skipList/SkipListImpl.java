package adt.skipList;

import java.util.ArrayList;
import java.util.List;

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
		if (newValue != null && height > 0) {
			SkipListNode<T>[] update = new SkipListNode[this.maxHeight];
			SkipListNode<T> node = this.root;

			for (int i = this.maxHeight - 1; i > -1; i--) {
				while ((node.getForward(i).getValue() != null) && (node.getForward(i).getKey() < key)) {
					node = node.getForward(i);
				}

				update[i] = node;
			}

			node = node.getForward(0);

			if (node.getKey() == key) {
				node.setValue(newValue);
			} else {
				if (height > this.maxHeight) throw new RuntimeException();

				SkipListNode newNode = new SkipListNode(key, height, newValue);

				for (int i = 0; i < newNode.height(); i++) {
					newNode.getForward()[i] = update[i].getForward(i);
					update[i].getForward()[i] = newNode;
				}
			}

		}
	}

	@Override
	public void remove(int key) {
		SkipListNode<T>[] update = new SkipListNode[this.maxHeight];
		SkipListNode<T> node = this.root;

		for (int i = this.maxHeight - 1; i > -1; i--) {
			while ((node.getForward(i).getValue() != null) && (node.getForward(i).getKey() < key)) {
				node = node.getForward(i);
			}

			update[i] = node;
		}

		node = node.getForward(0);

		if (node.getKey() == key) {
			for (int i = 0; i < this.maxHeight; i++) {
				if (update[i].getForward(i).equals(node)) {
					update[i].getForward()[i] = node.getForward(i);
				}
			}
		}

	}

	@Override
	public int height() {
		return this.maxHeight;
	}

	@Override
	public SkipListNode<T> search(int key) {
		SkipListNode<T> result = this.root;

		for (int i = this.maxHeight - 1; i > -1; i--) {
			while ((result.getForward(i).getValue() != null) && (result.getForward(i).getKey() < key)) {
				result = result.getForward(i);
			}
		}

		result = result.getForward(0);

		if (result.getKey() != key) {
			result = null;
		}

		return result;
	}

	@Override
	public int size() {
		int size = 0;
		SkipListNode<T> node = this.root;

		while (node.getForward(0).getKey() < Integer.MAX_VALUE) {
			size++;
			node = node.getForward(0);
		}

		return size;
	}

	@Override
	public SkipListNode<T>[] toArray() {
		List<SkipListNode<T>> list = new ArrayList<>();
		SkipListNode<T> node = this.root;

		while (node.getKey() < Integer.MAX_VALUE) {
			list.add(node);
			node = node.getForward(0);
		}

		list.add(node);

		SkipListNode<T>[] array = new SkipListNode[list.size()];
		return list.toArray(array);
	}

}
