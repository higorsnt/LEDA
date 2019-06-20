package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import util.Util;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o maior sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 3 > 2),
 * essa heap deixa os elementos maiores no topo. Essa comparação não é feita 
 * diretamente com os elementos armazenados, mas sim usando um comparator. 
 * Dessa forma, dependendo do comparator, a heap pode funcionar como uma max-heap 
 * ou min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é
	 * mudar apenas o comparator e mandar reordenar a heap usando esse
	 * comparator. Assim os metodos da heap não precisam saber se vai funcionar
	 * como max-heap ou min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma
	 * min-heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento
	 * indexado pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento
	 * indexado pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (int i = 0; i <= this.index; i++) {
			resp.add(this.heap[i]);
		}
		return (T[])resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode
	 * ser a raiz da heap ou de uma sub-heap. O heapify deve colocar os maiores
	 * (comparados usando o comparator) elementos na parte de cima da heap.
	 */
	private void heapify(int position) {
		int right = this.right(position);
		int left = this.left(position);
		int largest;

		if (left < this.size() &&
				(this.comparator.compare(this.heap[position], this.heap[left]) > 0)){
			largest = left;
		} else {
			largest = position;
		}

		if (right < this.size() &&
				(this.comparator.compare(this.heap[largest], this.heap[right]) > 0)){
			largest = right;
		}

		if (largest !=  position) {
			Util.swap(this.heap, position, largest);
			heapify(largest);
		}

	}

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}

		if (element != null) {
			int i = ++this.index;

			while (i > 0 &&
					this.comparator.compare(element, this.heap[this.parent(i)]) < 0) {
				this.heap[i] = this.heap[parent(i)];
				i = parent(i);
			}

			this.heap[i] = element;
		}
	}

	@Override
	public void buildHeap(T[] array) {
		if (array != null) {
			this.heap = array;
			this.index = array.length - 1;

			for (int i = this.size() / 2; i > -1; i--) {
				heapify(i);
			}
		}
	}

	@Override
	public T extractRootElement() {
		T temp = null;

		if (this.size() > 0) {
			temp = this.heap[0];
			this.heap[0] = this.heap[this.index--];

			heapify(0);
		}

		return temp;
	}

	@Override
	public T rootElement() {
		T result = null;

		if (this.index > 0) {
			result = this.heap[0];
		}

		return result;
	}

	@Override
	public T[] heapsort(T[] array) {Comparator<T> oldComparator = this.comparator;
		this.setComparator((o1, o2) -> o1.compareTo(o2));

		this.buildHeap(array);

		List<T> aux = new ArrayList<>();

		for (int i = 0; i < array.length; i++) {
			aux.add(this.extractRootElement());
		}

		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.setComparator(oldComparator);
		return aux.toArray((T[]) new Comparable[0]);
	}

	@Override
	public int size() {
		return this.index + 1;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}

}
