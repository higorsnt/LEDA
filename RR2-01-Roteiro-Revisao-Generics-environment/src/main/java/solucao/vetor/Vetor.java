package solucao.vetor;

import java.util.Comparator;

import vetor.Aluno;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> comparadorMaximo;
	private Comparator<T> comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (T[]) new Comparable[tamanho];
	}

	public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		this.arrayInterno[++indice] = o;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		// a procura se darah usando o equals o tipo T (precisa ser
		// sobrescrito). a remocao
		// nao deixa buracos no array
		T result = null;
		boolean achou = false;
		int i = 0;
		while (i <= indice && !achou) {
			if (arrayInterno[i].equals(o)) {
				result = arrayInterno[i];
				arrayInterno[i] = arrayInterno[indice];
				arrayInterno[indice] = null;
				indice--;
				achou = true;
			}
			i++;
		}
		return result;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		T result = null;
		boolean achou = false;
		int i = 0;
		while (i <= indice && !achou) {
			if (arrayInterno[i].equals(o)) {
				result = arrayInterno[i];
				achou = true;
			}
			i++;
		}
		return result;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return this.indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return this.indice == this.tamanho - 1;
	}

	public T maximo() {
		T result = null;
		if (!isVazio()) {
			result = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if (comparadorMaximo.compare(result, arrayInterno[i]) < 0) {
					result = arrayInterno[i];
				}
			}
		}
		return result;
	}

	public T minimo() {
		T result = null;
		if (!isVazio()) {
			result = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if (comparadorMinimo.compare(result, arrayInterno[i]) < 0) {
					result = arrayInterno[i];
				}
			}
		}
		return result;
	}

}

class ComparadorMaximo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o1.getMedia() - o2.getMedia());
	}

}

class ComparadorMinimo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o2.getMedia() - o1.getMedia());
	}

}