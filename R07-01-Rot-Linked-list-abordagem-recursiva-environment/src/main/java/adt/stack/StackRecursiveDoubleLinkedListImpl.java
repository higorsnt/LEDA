package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		// TODO Implement the method
		throw new UnsupportedOperationException("Method not implemented");
	}

	@Override
	public T pop() throws StackUnderflowException {
		// TODO Implement the method
		throw new UnsupportedOperationException("Method not implemented");
	}

	@Override
	public T top() {
		// TODO Implement the method
		throw new UnsupportedOperationException("Method not implemented");
	}

	@Override
	public boolean isEmpty() {
		// TODO Implement the method
		throw new UnsupportedOperationException("Method not implemented");
	}

	@Override
	public boolean isFull() {
		// TODO Implement the method
		throw new UnsupportedOperationException("Method not implemented");
	}

}
