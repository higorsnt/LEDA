# Set Linked List

Um conjunto é uma estrutura de dado que não permite elementos repetidos, e nem possui uma ordem específica.

O objetivo desse roteiro é permitir que uma Linked List se torne a qualquer momento um conjunto, e para isso deverá possuir os seguintes métodos:


## Métodos

1. **removeDuplicates**

Percorre a lista e remove todas as ocorrências de um elemento, deixando apenas a primeira.

2. **union**

Faz a união dos elementos do conjunto com os elementos de um outro conjunto passado como parâmetro, retornando uma outra estrutura (SetLinkedList).

3. **intersection**

Faz a interseção dos elementos do conjunto com os elementos de um outro conjunto passado como parâmetro, retornando uma outra estrutura (SetLinkedList).

4. **concatenate**

Faz a concatenação do conjunto com um outro conjunto passado como parâmetro.  
A concatenação é uma operação de união, mas que modifica este conjunto, e é mais eficiente do que a união: Precisa apenas aumentar essa estrutura com todos os elementos do parâmetro, sem precisar inserir um a um.