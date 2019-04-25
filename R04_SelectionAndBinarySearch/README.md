# ROTEIRO 04

## Estatística de Ordem Utilizando Selection

Esse algoritmo busca o k-ésimo menor elemento de um conjunto de dados sem ser necessário ordenar.


Para se entender o que é a estatística de ordem é necessário imaginar um conjunto de dados aleatórios {X<sub>1</sub>, ..., X<sub>n</sub>}. Ao se colocar em ordem crescente é garantido que teremos um conjunto da forma X<sub>(1)</sub> &le; X<sub>(2)</sub> &le; ... &le;	X<sub>(n)</sub>. Daí, se desejo a 1ª estatística de ordem deve se retornar o elemento X<sub>(1)</sub>, se desejo a 2ª estatística de ordem deve se retornar o elemento X<sub>(2)</sub>, ou seja, deve sempre se retornar o X<sub>(k)</sub> (onde k é a estatística de ordem desejada).

Então, para se implementar esse algoritmo uma solução é utilizar a ideia de selecionar sempre o menor elemento utilizado no selection e sem realizar a ordenação você faz comparação entre o menor até o momento e o elemento que estou iterando. Na primeira iteração eu terei o primeiro menor, na segunda iteração eu terei um elemento maior que meu menor anterior, mas que é menor que o restante dos elementos do array.
Um exemplo de execução:

<p align="center">
<img src="img/order.png"/>
</p>

## Busca Binária

A busca binária consiste em pegar o elemento mais central do conjunto (ordenado) e verificar se é igual, maior ou menor que o elemento desejado. Daí, o programa pode seguir três caminhos: 
* Se for igual a busca está encerrada;
* Se o elemento central for maior que o elemento buscado é porque o que quero está entre o inicio do array e a posição do elemento central. Logo, a busca passa a ser nesse pedaço do conjunto.
* Se o elemento central for menor que o elemento buscado é porque o que quero está entre o seguinte ao elemento central e o final do array. Logo, a busca passa a ser nesse pedaço do conjunto.

### Floor utilizando Busca Binária

Floor é uma função que retorna um elemento que é menor ou igual a _x_ e que seja mais próximo possível dele. 

Utilizando a ideia da busca binária, o floor segue o mesmo caminho descrito. Porém, quando o elemento central for menor que o buscado eu devo atualizar a variável que me retornará o floor como sendo o elemento central.

```python
if (x > array[meio]):
    floor = array[meio]
```

### Ceil Utilizando Busca Binária

Ceil é uma função que retorna um elemento que é maior ou igual a _x_ e que seja mais próximo possível dele.

Utilizando a ideia da busca binária, o ceil segue o mesmo caminho descrito. Porém, quando o elemento central for maior que o buscado eu devo atualizar a variável que me retornará o ceil como sendo o elemento central.

```python
if (x < array[meio]):
    ceil = array[meio]
```
