# ROTEIRO 01

Nesse roteiro deve-se implementar os algoritmos de ordenação por comparação que possuem tempo de complexidade médio em O(n²).

## 🔎 Bubble Sort

Dado um vetor de tamanho _n_, para realizar a ordenação nesse método é necessário realizar diversas comparações entre elementos adjacentes e se caso necessário troca-los. Ou seja, cada elemento de posição _i_ será comparado com o elemento de posição _i + 1_, e quando a ordenação procurada (crescente ou decrescente) é encontrada, uma troca de posições entre os elementos é feita.  

<p align="center">
<img src="https://codepumpkin.com/wp-content/uploads/2017/10/bubble.gif"/>
Fonte: CodePumpkin
</p>

Versões melhoradas:
1. Cada elemento de posição _i_ será comparado com o de posição _i - 1_, e quando a ordenação procurada (crescente ou decrescente) é encontrada, uma troca de posições entre os elementos é feita. Assim, temos dois laços, o laço externo `for(int i = 1; i < n; i++)` e o laço interno `for(int j = n - 1; j >= i; j--)`;
2. Realizar comparações enquanto houver trocas, ou seja, _i = 1_ e `while(j <= n && troca == 1)` e dentro desse laço um outro laço que percorre da primeira à ultima posição.

**Características**
1. É O(n²) no pior caso
2. É um algoritmo estável<sup>[1](#footnote-1)</sup> e _in-place<sup>[2](#footnote-2)</sup>_
3. Número alto de comparações e trocas


**Implementações do Bubble Sort**
```python
def swap(lista, i, j):
    temp = lista[i]
    lista[i] = lista[j]
    lista[j] = temp
def BubbleSort(lista):
    for i in range(len(lista) - 1):
        for j in range(len(lista) - 1):
            if (lista[j] > lista[j + 1]):
                swap(lista, j + 1, j)
def BubbleSortV1(lista):
    for i in range(len(lista) - 1):
        for j in range(len(lista) - 1, i, -1):
            if (lista[j - 1] > lista[j]):
                swap(lista, j - 1, j)
def BubbleSortV2(lista):
    swapped = True
    while (swapped):
        swapped = False

        for i in range(len(lista) - 1):
            if (lista[i] > lista[i + 1]):
                swap(lista, i, i + 1)
                swapped = True
def BubbleSortRecursive(lista, n):
    if (n == 1):
        return
    for i in range(len(lista) - 1):
        if (lista[i] > lista[i+1]):
            swap(lista, i, i+1)
    BubbleSortRecursive(lista, n - 1)
```

## 🔎 Selection Sort

Inicialmente procura-se o menor elemento por meio de uma busca linear e o troca com o elemento na primeira posição. Em seguida, procura-se o segundo menor elemento e o troca com o elemento da segunda posição... Continuando até que todos elementos estejam na posição correta.

<p align="center">
<img src="https://codepumpkin.com/wp-content/uploads/2017/10/selectionSort.gif"/>
Fonte: CodePumpkin
</p>

**Características**
1. Em seu pior caso é O(n²)
2. É um algoritmo estável<sup>[1](#footnote-1)</sup> e _in-place<sup>[2](#footnote-2)</sup>_
3. Possui poucas trocas (fazendo-o melhor que o Bubble Sort)

**Implementações do Selection Sort**
```python
def swap(lista, i, j):
    temp = lista[i]
    lista[i] = lista[j]
    lista[j] = temp
def SelectionSortMin(lista):
    for i in range(len(lista)):
        minimo = i
        for j in range(i + 1, len(lista)):
            if (lista[j] < lista[minimo]):
                minimo = j
        swap(lista, minimo, i)
def SelectionSortMax(lista):
    for i in range(len(lista) - 1, -1, -1):
        maximo = i
        for j in range(i - 1, -1, -1):
            if (lista[j] > lista[maximo]):
                maximo = j
        swap(lista, i, maximo)
def SelectionSortRecursivo(lista, index):
    if (index == len(lista)):
        return
    minimo = index
    for i in range(index + 1, len(lista)):
        if (lista[i] < lista[minimo]):
            minimo = i
    swap(lista, minimo, index)
    InsertionSortRecursivo(lista, index + 1)
```

## 🔎 Insertion Sort

Iniciando a partir do segundo elemento (número eleito na primeira execução), o insertion faz se considerar que todos os elementos à esquerda deste está ordenado. E por meio de um laço serão feitas comparações do segundo elemento ao último. Enquanto existirem elementos à esquerda do número eleito para comparações e for menor que o eleito o laço será executado.

<p align="center">
<img src="https://cdn-images-1.medium.com/max/1600/1*krA0OFxEDgi8hVHJffCi4w.gif"/>
Fonte: <a href="https://medium.com/yay-its-erica/algorithms-for-beginners-bubble-sort-insertion-sort-merge-sort-29bd5506cc48">Medium</a>
</p>

**Características**
1. Pior caso é O(n²), porém pode chegar a ser O(n)
2. É um algoritmo estável<sup>[1](#footnote-1)</sup> e _in-place<sup>[2](#footnote-2)</sup>_
3. Muita troca e menos comparações

**Implementações**
```python
def InsertioSort(lista):
    for i in range(1, len(lista)):
        chave = lista[i]
        j = i - 1
        while (j >= 0 and (lista[j] > chave)):
            lista[j + 1] = lista[j]
            j -= 1
        lista[j + 1] = chave

def InsertioSortRecursivo(lista, i):
    if (i == len(lista)):
        return
    chave = lista[i]
    j = i - 1
    while (j >= 0 and (lista[j] > chave)):
        lista[j + 1] = lista[j]
        j -= 1
    lista[j + 1] = chave
    SelectionSortRecursivo(lista, i + 1)
```

____________________________________________________
1. <a name="footnote-1"></a> Algoritmos estáveis mantêm a ordem de dois elementos que possuem a mesma chave. Exemplo, `["C", "A", "A"]` ao se ordenar `[1]` continuará aparecendo antes de `[2]`.
2. <a name="footnote-2"></a> Algoritmo _in-place_ significa que a ordenação é feita no mesmo local onde os dados estão armazenados.