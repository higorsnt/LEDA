# ROTEIRO 03

O objetivo é implementar algum algoritmo de ordenação linear.

## 🔍 Couting Sort

A ideia por trás desse algoritmo é contar, para cada elemento do array, quantos elementos são menores que _x_. Dessa forma é possível saber qual a posição correta de _x_ no vetor. Para isso é necessário dois arrays adicionais um para a resposta e outro pra contar as ocorrências.

1. Cria-se um array de tamanho _k_, onde k é o maior elemento do array, com todas as posição em 0.
2. Percorre cada elemento do array que está sendo ordenado e adiciona uma ocorrência na posição correspondente ao elemento no array de ocorrências.
3. Realiza a soma acumulada no array de ocorrências.
4. E por fim, ordena o array se baseando no array de ocorrências.

<p align="center">
<img src="/img/CoutingSort.gif"/>
</p>


**Características**
1. Fácil de implementar
2. É estável, ou seja, mantém a ordem dos elementos iguais
3. Não é _in-place_
4. Pior caso é O(n + k)

**Implementação**

```python
def counting_sort(lista, inicio, fim):
    copia = lista[:]
    maximo = max(copia)
    ocorrencias = [0] * (maximo + 1)

    for i in range(len(copia)):
        ocorrencias[copia[i]] += 1
    
    for i in range(len(ocorrencias) - 1):
        ocorrencias[i + 1] += ocorrencias[i]

    resultado = [None] * len(lista)

    for i in range(fim, inicio - 1, -1):
        elemento = lista[i]
        ocorrencias[elemento] -= 1
        resultado[ocorrencias[elemento]] = elemento
    
    for i in range(len(resultado)):
        lista[i] = resultado[i]
```