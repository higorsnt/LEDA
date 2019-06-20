# ROTEIRO 06

Nesse roteiro o objetivo é implementar uma lista encadeada simples e uma lista duplamente encadeada de maneira iterativa. Em seguida, é necessário construir uma pilha e fila utilizando as listas implementadas.

## Lista Encadeada Simples

Cada lista tem um nó de referência para o início da lista, a cabeça da lista. Logo, cada nó possui um dado que representa o valor inserido na posição e uma referência para o próximo elemento da lista, um novo nó.
É importante destacar que inicialmente a cabeça da lista é um **nó sentinela** e sempre que for inserido um elemento a referência para o próximo elemento passar a ser um novo **nó sentinela**.

<p align="center">
    <img src="https://he-s3.s3.amazonaws.com/media/uploads/1b76d10.png"/><br/>
    Fonte: <a href="https://www.hackerearth.com/pt-br/practice/data-structures/linked-list/singly-linked-list/tutorial">hackerearth</a>
</p>

**As operações básicas são:**

| Operações| Complexidade |
| :------: | :----------: |
|  insert  |     O(n)     |
|  remove  |     O(n)     |
|  search  |     O(n)     |
|   size   |     O(n)     |
|  isEmpty |     O(1)     |
|  toArray |     O(n)     |


## Lista Duplamente Encadeada

Cada lista possui dois nós de referência: um para indicar o início da lista, a cabeça da lista, e outro pra indicar o final da lista, a cauda da lista. Logo, cada nó possui três dados: o valor inserido na posição, uma referência para o próximo elemento e ainda uma referência para o elemento anterior a ele.
Assim como a Lista Encadeada Simples a cabeça da lista inicia como um **nó sentinela** e sempre que for inserido um elemento a referência para o próximo elemento passar a ser um novo **nó sentinela**. Porém, além disso é necessário indicar o anterior e no caso do head o anterior é um **nó sentinela**.

<p align="center">
    <img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/gq/2014/03/DLL1.png"/><br>
    Fonte: <a href="https://www.geeksforgeeks.org/doubly-linked-list/">GeeksforGeeks</a>
</p>

**As operações básicas são:**

| Operações| Complexidade |
| :------: | :----------: |
|  insert  |     O(n)     |
|insertFirst|    O(1)     |
|  remove  |     O(n)     |
|removeFirst|    O(1)     |
|removeLast|     O(1)     |
|  search  |     O(n)     |
|   size   |     O(n)     |
|  isEmpty |     O(1)     |
|  toArray |     O(n)     |