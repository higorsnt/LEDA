# Set Linked List

Um conjunto é uma estrutura de dados que não permite elementos repetidos e nem possui uma ordem específica.

O objetivo desse roteiro é permitir que uma Linked List se torne a qualquer momento um conjunto.


## Métodos

1. **removeDuplicates**

Percorre a lista e remove todas as ocorrências de um elemento (caso ele se repita), deixando apenas a primeira.

2. **union**

Faz a união dos elementos do conjunto com os elementos de um outro conjunto passado como parâmetro, retornando um SetLinkedList, estrutura oferecida pelo próprio Java.

3. **intersection**

Faz a interseção dos elementos do conjunto com os elementos de um outro conjunto passado como parâmetro, retornando um SetLinkedList, estrutura oferecida pelo próprio Java.

4. **concatenate**

Faz a concatenação do conjunto com um outro conjunto passado como parâmetro.  
A concatenação é uma operação de união, mas que modifica este conjunto, e é mais eficiente do que a união: Precisa apenas aumentar essa estrutura com todos os elementos do parâmetro, sem precisar inserir um a um.