package linkedList.reverseappend;

import linkedList.SingleLinkedListNode;

/**
 * 
 * @see SingleLinkedListReverseAppend
 * 
 * @author campelo
 *
 * @param <T>
 */
public class SingleLinkedListReverseAppendImpl<T> implements SingleLinkedListReverseAppend<T> {
	
	/*
	 * Nao remover esse atributo nem criar outros
	 */
	protected SingleLinkedListNode<T> head;
	
	/*
	 * Nao modifique o construtor
	 * @param head
	 */
	public SingleLinkedListReverseAppendImpl() {
		head = new SingleLinkedListNode<T>();
	}

	/* (non-Javadoc)
	 * @see adt.linkedList.reverseappend.SingleLinkedListReverseAppend#doIt(java.lang.Object)
	 * 
	 * Implemente apenas este metodo de acordo com os comentários da interface.
	 * 
	 */
	@Override
    public void doIt(T elem) {
		if (elem != null) {
			if (this.head.isNIL()) {
				this.head.setData(elem);
				this.head.setNext(new SingleLinkedListNode<>());
			} else {
				SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>();

				SingleLinkedListNode<T> auxNode = this.head;
				SingleLinkedListNode<T> otherAux = new SingleLinkedListNode<>();

				newNode.setData(elem);
				newNode.setNext(new SingleLinkedListNode<>());

				while (!auxNode.isNIL()) {
					otherAux.setData(auxNode.getData());
					otherAux.setNext(newNode.getNext());

					newNode.setNext(otherAux);
					auxNode = auxNode.getNext();
					otherAux = new SingleLinkedListNode<>();
				}

				this.head = newNode;
			}
		}
    }
    
	
	
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     */
	@Override
    public String toString() {
    	String retorno = "";
    	SingleLinkedListNode<T> currentNode = this.head;
    	while (currentNode!=null) {
    		if (!retorno.equals("")) {
    			retorno += " ";
    		}
    		retorno += currentNode;
    		currentNode = currentNode.getNext();
    	}
		return retorno;
    }
    
}