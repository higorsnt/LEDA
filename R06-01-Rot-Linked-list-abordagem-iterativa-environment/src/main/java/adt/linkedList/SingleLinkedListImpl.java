package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return (this.head.isNIL());
	}

	@Override
	public int size() {
		int length = 0;

		if (this.head.data != null) {
			SingleLinkedListNode node = this.head;

			while (node.data != null) {
				length++;
				node = node.next;
			}
		}
		return length;
	}

	@Override
	public T search(T element) {
		T result = null;

		if (element != null){
			SingleLinkedListNode node = this.getHead();

			while (node.data != null) {
				if (node.data.equals(element)) {
					result = (T) node.data;
					break;
				}
				node = node.next;
			}
		}

		return result;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode node = this.head;
		if (element != null) {
			if (this.head.isNIL()) {
				SingleLinkedListNode newHead = new SingleLinkedListNode();
				newHead.setData(element);
				newHead.setNext(new SingleLinkedListNode());
				this.setHead(newHead);
			} else {
				while (!node.isNIL()) {
					node = node.next;
				}

				node.setData(element);
				node.setNext(new SingleLinkedListNode());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (this.head.data.equals(element)) {
				this.head = this.head.next;
			} else {
				SingleLinkedListNode nextNode = this.head;
				SingleLinkedListNode previousNode = this.head;
				while (nextNode != null && !nextNode.data.equals(element)) {
					previousNode = nextNode;
					nextNode = nextNode.next;
				}
				if (nextNode != null) {
					previousNode.next = nextNode.next;
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		List<T> array = new ArrayList<>();
		SingleLinkedListNode node = this.head;

		while (node.data != null) {
			array.add((T) node.data);
			node = node.next;
		}

		return (T[]) array.toArray();
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
