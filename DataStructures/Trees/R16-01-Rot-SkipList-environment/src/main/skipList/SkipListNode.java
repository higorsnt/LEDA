package adt.skipList;

public class SkipListNode<T> {

	// a chave do root eh Integer.MIN_VALUE e a do NIL eh Integer.MAX_VALUE
	protected int key;
	protected T value;
	protected SkipListNode<T>[] forward;

	@SuppressWarnings("unchecked")
	public SkipListNode(int key, int height, T satelliteData) {
		this.key = key;
		this.value = satelliteData;
		this.forward = new SkipListNode[height];
	}

	public int height() {
		return this.forward.length;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public String toString() {
		String result = "";
		if (this.key == Integer.MIN_VALUE) {
			result = "<ROOT," + this.forward.length + "," + this.countForwardsNotNull()
					+ ">";
		} else if (this.key == Integer.MAX_VALUE) {
			result = "<NIL," + this.forward.length + ">";
		} else {
			result = "<" + this.key + "," + this.forward.length + ">";
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		if (obj instanceof SkipListNode) {
			resp = this.key == ((SkipListNode<T>) obj).key
					&& this.forward.length == ((SkipListNode<T>) obj).forward.length
					&& this.countForwardsNotNull() == ((SkipListNode<T>) obj)
							.countForwardsNotNull();
		}
		return resp;
	}

	private int countForwardsNotNull() {
		int resp = 0;
		for (int i = 0; i < forward.length; i++) {
			if (forward[i] != null) {
				resp++;
			}
		}
		return resp;
	}

	public SkipListNode<T>[] getForward() {
		return forward;
	}

	public SkipListNode<T> getForward(int level) {
		return forward[level];
	}

	public int getKey() {
		return key;
	}
}
