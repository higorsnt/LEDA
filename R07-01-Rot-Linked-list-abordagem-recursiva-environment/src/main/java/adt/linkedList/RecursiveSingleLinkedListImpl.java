package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return (this.data == null);
	}

	@Override
	public int size() {
		int size = 0;

		if (!this.isEmpty()) {
			size = 1 + this.next.size();
		}

		return size;
	}

	@Override
	public T search(T element) {
		T answer = null;

		if (element != null && !this.isEmpty()) {
			if (this.data.equals(element)) {
				answer = this.data;
			} else {
				answer = this.next.search(element);
			}
		}

		return answer;
	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			this.data = element;
			this.setNext(new RecursiveSingleLinkedListImpl<>());
		} else {
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if (this.getNext().isEmpty()) {
				this.data = null;
				this.next = this.next.getNext();
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		List<T> array = new ArrayList<>();
		auxToArray(array);

		return (T[]) array.toArray();
	}

	private void auxToArray(List<T> array){
		if (!this.isEmpty()) {
			array.add(this.data);
			this.next.auxToArray(array);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
