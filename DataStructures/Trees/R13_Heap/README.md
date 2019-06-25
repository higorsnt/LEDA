# Heap

É uma árvore binária onde satisfaz duas propriedades:
1. **Shape Property:** Estar completa até pelo menos seu penúltimo nível. Além disso, se o último nível não estiver completo, todos os nós do último nível deverão estar agrupados à esquerda.
2. **Tipo:** Uma heap pode ser do tipo _Max Heap_, onde todos os valores dos nós são menores do que o valor do nó pai (raiz possui maior valor), ou do tipo _Min Heap_, onde todos os valores dos nós são maiores do que o valor do nó pai (raiz possui menor valor).

<p align="center">
    <img src="https://i2.wp.com/www.techiedelight.com/wp-content/uploads/2016/11/Min-Max-Heap.png?resize=738%2C430&ssl=1"/></br>
    Fonte: <a href="https://www.techiedelight.com/introduction-priority-queues-using-binary-heaps/"> Techie Delight </a>
</p>

Cada posição do array passa a ser considerado pai de outras duas posições. Onde,
> O índice do pai de um elemento na posição _i_ pode ser obtido: `(i - 1) / 2`  
> O índice do filho à esquerda de um elemento na posição _i_ pode ser obtido: `2i + 1`  
> O índice do filho à direita de um elemento na posição _i_ pode ser obtido: `(2i + 1) + 1`

Exemplo: Observando a _Min Heap_ da imagem acima, temos o array `[2, 3, 6, 8, 10, 15, 18]`. Tomando 2 como exemplo:  
* 2 está na posição 0:
    * esquerda: `2 * 0 + 1 = 1`, logo 3 é o filho da esquerda de 2
    * direita: `(2 * 0 + 1) + 1 = 2`, logo 6 é o filho da direita de 2

## Métodos

### Heapify

Esse método é o que garante que as propriedades de uma heap se mantenham.

**Pseudocódigo**

<p align="center">
    <img src="img/heapify.png"/></br>
    Fonte: Wikipédia
</p>

### Inserir

Para inserir um elemento na heap devemos colocá-lo na primeira posição vaga do array, ou seja, no final do array e em seguida levar o elemento para a posição correta de acordo com a prioridade da heap.

<p align="center">
    <img src="https://i.gifer.com/2cH8.gif"/>
</p>

**Pseudocódigo**

<p align="center">
    <img src="img/insert.png"/>
</p>

### Build Heap

Permite construir uma heap a partir de um array passado como parâmetro.

**Pseudocódigo**
<p align="center">
    <img src="img/buildheap.png"/>
</p>

_OBS.: Vai até `length /2` pois após esse número a grande maioria dos elementos serão nó folha!_

### Extract Root Element

As remoções na heap ocorrem pela raiz. Logo, ao se remover a raiz se traz o último elemento para a posição e em seguida chama o Heapify para consertar a estrutura.

<p align="center">
    <img src="https://i2.wp.com/algorithms.tutorialhorizon.com/files/2015/02/Delete-OR-Extract-Min-from-Heap.gif?ssl=1"/></br>
    Fonte: <a href="https://algorithms.tutorialhorizon.com/binary-min-max-heap/delete-or-extract-min-from-heap/">Algorithms @tutorialhorizon</a>
</p>

**Pseudocódigo**

<p align="center">
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3ISuMDCVj5hH6Bl_v_UED7BTezXJTvUWkeWgq0n48z-8ZblQY"/>
</p>


### HeapSort

É uma forma de ordenar dados utilizando uma heap. Portanto, o método recebe um array e insere em uma heap, em seguida é só inserir os dados em um novo array, fazendo extrações pela raiz.

<p align="center">
    <img src="https://upload.wikimedia.org/wikipedia/commons/f/fe/Heap_sort_example.gif"/></br>
    Fonte: <a href="https://commons.wikimedia.org/wiki/File:Heap_sort_example.gif">Wikipédia</a>
</p>

**Pseudocódigo**

<p align="center">
    <img src="img/heapsort.png"/>
</p>