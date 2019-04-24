package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		if (size >= 0) {
			this.size = size;
			this.list = new DoubleLinkedListImpl<T>();
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if (this.isFull()) throw new QueueOverflowException();

		if (element != null) {
			list.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty()) throw new QueueUnderflowException();

		T element = this.head();
		this.list.removeFirst();

		return element;
	}

	@Override
	public T head() {
		return ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return (this.list.size() == this.size);
	}

}
