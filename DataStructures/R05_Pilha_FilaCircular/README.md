# ROTEIRO 05

O objetivo deste roteiro é implementar as estruturas básicas de dados.

## Pilha

A pilha segue uma política de inserção de elementos conhecida como **LIFO** (last in, first out). Dessa forma a inserção e remoção se faz pela mesma extremidade, conhecida como topo.

<p align="center">
    <img src="https://cdn-images-1.medium.com/max/800/1*kkK3EZNOzBsuwkDNvSVR9g.gif"/><br/>
    Fonte: <a href="https://medium.com/dev-blogs/ds-with-js-stack-queue-d91fc8cea7a3">Medium</a>
</p>


**As operações básicas são:**

| Operação | Complexidade |
| :------: | :----------: |
|   pop    |     O(1)     |
|   push   |     O(1)     |
|   top    |     O(1)     |
|  isEmpty |     O(1)     |
|  isFull  |     O(1)     |

## Fila

Em uma fila cada elemento é inserido na cauda e removido pela cabeça, ou seja, a estrutura respeita a ordem conhecida como **FIFO** (first in, first out). Seu funcionamento é semelhante às filas de espera.

Uma particularidade da fila, é que em algumas implementações se faz necessário trazer todos os elementos pra frente após uma remoção.

<p align="center">
    <img src="http://daltonschool.github.io/CS3A/assets/queue-animation.gif"/><br/>
    Fonte: <a href="http://daltonschool.github.io/CS3A/collections/">CS3A</a>
</p>


**As operações básicas são:**

| Operação | Complexidade |
| :------: | :----------: |
|  enqueue |     O(1)     |
|  dequeue |     O(n)     |
|  head    |     O(1)     |
|  isEmpty |     O(1)     |
|  isFull  |     O(1)     |


## Fila Circular

A diferença entre a implementação tradicional e a fila circular é a necessidade de utilizar operações modulares para se obter os índices da cabeça e da cauda da fila, pois dessa forma ao estourar a capacidade do array os ponteiros voltam ao inicio.
  

<p align="center">
    <img src="http://daltonschool.github.io/CS3A/assets/queuearray-animation.gif"/><br/>
    Fonte: <a href="http://daltonschool.github.io/CS3A/collections/">CS3A</a>
</p>

**As operações básicas são:**

| Operação | Complexidade |
| :------: | :----------: |
|  enqueue |     O(1)     |
|  dequeue |     O(1)     |
|  head    |     O(1)     |
|  isEmpty |     O(1)     |
|  isFull  |     O(1)     |