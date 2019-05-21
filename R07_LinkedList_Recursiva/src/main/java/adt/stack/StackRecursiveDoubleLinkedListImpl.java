package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		if (size < 0) size = 0;

		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
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

		T result = this.top();
		this.top.removeLast();

		return result;
	}

	@Override
	public T top() {
		T[] array = this.top.toArray();

		T answer = null;

		if (array.length > 0) {
			answer = array[array.length - 1];
		}

		return answer;
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
