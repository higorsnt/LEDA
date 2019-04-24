package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl () {
		this.setHead(new DoubleLinkedListNode<>());
		this.setLast((DoubleLinkedListNode<T>) this.head);
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			//DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode();
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode();

			//newLast.setPrevious(newNode);

			newLast.setData(element);
			newLast.setNext(new DoubleLinkedListNode());
			newLast.setPrevious(this.getLast());

			this.getLast().setNext(newLast);

			if (this.getLast().isNIL()) {
				this.setHead(newLast);
			}

			this.setLast(newLast);
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode();

			newHead.setData(element);
			newHead.setNext(this.getHead());
			newHead.setPrevious(new DoubleLinkedListNode<>());

			((DoubleLinkedListNode<T>)this.head).setPrevious(newHead);

			if (this.head.isNIL()) {
				this.setLast(newHead);
			}

			this.setHead(newHead);
		}
	}

	@Override
	public void remove (T element) {
		if (element != null) {
			if (this.getHead().equals(element)) this.removeFirst();
			else if (this.getLast().equals(element)) this.removeLast();
			else {
				DoubleLinkedListNode<T> node = (DoubleLinkedListNode) this.getHead();

				 while (!node.isNIL() && !node.getData().equals(element)) {
				 	node = (DoubleLinkedListNode<T>) node.getNext();
				 }

				 if (!node.isNIL()) {
				 	node.getPrevious().setNext(node.getNext());
					 ((DoubleLinkedListNode<T>)node.getNext()).setPrevious(node.getPrevious());
				 }
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.getHead().isNIL()) {
			this.head = this.head.getNext();
			if (this.head.isNIL()) {
				this.last = (DoubleLinkedListNode<T>) this.head;
			}

			((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if (!this.getLast().isNIL()) {
			this.last = this.last.getPrevious();

			if (this.last.isNIL()) {
				this.head = this.last;
			}

			this.last.setNext(new DoubleLinkedListNode<>());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
