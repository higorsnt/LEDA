package adt.linkedList.reverseappend;

/**
 * Esta classe representa uma lista simplesmente encadeada que possui 
 * apenas um método de inserção, que executa o procedimento de inserção da seguinte maneira:
 * 
 * Ao receber um novo elemento para inserção, inverte-se a ordem dos elementos contidos na lista e, em seguida,
 * o elemento recebido é posicionado na frente (na primeira posição da lista).
 * 
 *  EXEMPLO:
 *  
 *  LISTA ATUAL: A B C
 *  NOVO ELEMENTO: D
 *  LISTA MODIFICADA: D C B A
 *  
 *  Para esta implementação, considera-se a existência do node sentinela (NIL) no final da lista.
 *  A existência da sentinela é considerada para execução dos testes automáticos.
 *  
 *  Procure implementar da forma mais eficiente possível, pois isso será relevante na análise da solução proposta.
 *  
 *  ATENÇÃO
 *  - Não é permitido criar outros métodos auxiliares.
 *  - Não é permitido criar usar estruturas auxiliares, tais como arrays.
 *  
 *  @author campelo
 *   
 */
public interface SingleLinkedListReverseAppend<T> {

    public void doIt(T elem);

}
