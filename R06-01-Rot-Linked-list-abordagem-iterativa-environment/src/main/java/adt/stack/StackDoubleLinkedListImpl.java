package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		if (size < 0) size = 0;

		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) throw new StackOverflowException();

		if (element != null) {
			this.top.insert(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) throw new StackUnderflowException();

		T element = this.top();
		this.top.removeLast();

		return element;
	}

	@Override
	public T top() {
		return ((DoubleLinkedListImpl<T>) this.top).getLast().getData();
	}

	@Override
	public boolean isEmpty() {
		return (this.top.isEmpty());
	}

	@Override
	public boolean isFull() {
		return (this.top.size() == this.size);
	}

}
