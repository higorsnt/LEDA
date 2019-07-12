# Skip Lists

É um estrutura de dados probabilística, baseada em listas ligadas paralelas, cuja eficiência pode ser comparada à de uma árvore binária.

<p align="center">
    <img src="https://i.stack.imgur.com/cz9pS.png"/></br>
    Fonte: <a href="https://www.epaperpress.com/sortsearch/download/skiplist.pdf">Link</a>
</p>

Uma skip list possui diversas camadas, onde a camada mais inferior é uma lista encadeada. Enquanto que a camada mais alta atua como uma forma de acesso para as listas abaixo.

Uma de suas propriedades é armazenar os dados de maneira ordenada.

## Definições

1. Altura máxima: é a maior altura que um nó pode possuir.
2. Altura: a altura da skip list é a altura do maior nó, que não é nem o nó cabeçalho, nem o nó vazio.
3. Probabilidade: é o valor usado no algoritmo para determinar aleatoriamente o nível (altura) de cada nó.

## Métodos

### Pesquisa

O método segue, basicamente, o passo a passo:
1. Comece atravessando os apontadores que não levam a um elemento menor que o procurado.
2. Depois siga para o elemento menor e aplique o mesmo raciocínio até descer ao nível 1.
3. Depois é só seguir o próximo apontador do nivel 1 do ultimo nó visitado.

<p align="center">
    <img src="https://cdncontribute.geeksforgeeks.org/wp-content/uploads/Skip-List-1.jpg"/></br>
    Fonte: <a href="https://www.geeksforgeeks.org/skip-list-set-3-searching-deletion/">GeeksforGeeks</a>
</p>

### Inserção

Necessita de uma função randômica para definir o tamanho de um nó. E o passo a passo é bastante próximo ao da busca.

É importante salientar que é necessário armazenar os nós que irão mudar os apontadores assim que ocorrer a inserção do novo nó.

<p align="center">
    <img src="https://upload.wikimedia.org/wikipedia/commons/2/2c/Skip_list_add_element-en.gif"/></br>
    Fonte: <a href="https://en.wikipedia.org/wiki/Skip_list">Wikipedia</a>
</p>

### Remoção

Para realizar a remoção é necessário procurar pelo nó e guardar os nós que necessitarão de atualização nos apontadores após a remoção do nó.

<p align="center">
    <img src="https://d2vlcm61l7u1fs.cloudfront.net/media%2F19a%2F19a9ff4e-3988-4935-8ea1-655cb5d165b3%2FphpHmPfvA.png"/></br>
    Fonte: <a href="https://www.chegg.com/homework-help/questions-and-answers/draw-example-skip-list-results-performing-following-series-operations-skip-list-shown-figu-q19861350">Link</a>
</p>

### Height

É a maior altura possível dos elementos, excluindo-se o **HEADER** e o **NIL**.

### toArray

Lembrando que o último nível de uma skip list possui referências para todos os elementos da lista, então a ideia básica é percorrer o nível mais baixo da lista e ir inserindo no array e por fim é só retornar o produto final dessa iteração.

### Size

Para a implementação desse método deve-se utilizar a mesma ideia do toArray (percorrendo o último nível da lista).