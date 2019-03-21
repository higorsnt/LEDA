package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor {

	// O array interno onde os objetos manipulados são guardados
	private Object[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(Object o) {
		// TODO Remove the exception and implement your code
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// Remove um objeto do vetor
	public Object remover(Object o) {
		// TODO Remove the exception and implement your code
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// Procura um elemento no vetor
	public Object procurar(Object o) {
		// TODO Remove the exception and implement your code
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		// TODO Remove the exception and implement your code
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		// TODO Remove the exception and implement your code
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
