# ROTEIRO 02

Nesse roteiro deve-se implementar os algoritmos de ordenação por comparação que se utilizam da técnica de _dividir para conquistar_. Todos possuem tempo de complexidade médio em O(nlogn).

# 🔍 Merge Sort
Inicialmente o vetor é dividido recursivamente em vetores menores. Esse processo só para quando temos _n_ vetores de tamanho 1. A partir daí os vetores serão ordenados e intercalados para se obter a ordenação.
Por ser um algoritmo que utiliza a técnica _dividir para conquistar_ deve-se seguir alguns passos:
1. **Dividir**: dividir a sequência de _n_ elementos a serem ordenados em duas subsequências de _n/2_ elementos cada.
2. **Conquistar**: ordenar as duas subsequências recursivamente utilizando a ordenação por intercalação;
3. **Combinar**: intercalar as duas subsequências ordenadas para produzir a solução.

<p align="center">
    <img src="https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif"/><br/>
    Fonte: <a href="https://pt.wikipedia.org/wiki/Merge_sort">Wikipedia</a>
</p>

**Características**
1. Boa performance, O(nlogn)
2. Não é _in-place_, pois precisa de espaço extra.

**Implementação do Merge Sort**

```python
def MergeSort(lista, inicio, fim):
    if (inicio < fim):
        meio = (inicio + fim) / 2
        MergeSort(lista, inicio, meio)
        MergeSort(lista, meio + 1, fim)
        merge(lista, inicio, meio, fim)


def merge(lista, inicio, meio, fim):
    aux = [0] * len(lista)
    inicio_v1 = inicio
    inicio_v2 = meio + 1
    index = inicio

    while (inicio_v1 <= meio and inicio_v2 <= fim):
        if (lista[inicio_v1] <= lista[inicio_v2]):
            aux[index] = lista[inicio_v1]
            inicio_v1 += 1
        else:
            aux[index] = lista[inicio_v2]
            inicio_v2 += 1
        index += 1
        
    for i in range(inicio_v1, meio + 1):
        aux[index] = lista[i]
        index += 1

    for i in range(inicio_v2, fim + 1):
        aux[index] = lista[i]
        index += 1
    
    for i in range(inicio, fim + 1):
        lista[i] = aux[i]
```

## 🔍 QuickSort
De forma semelhante ao merge sort, o quick sort particiona um vetor em dois por meio de recursão. Essa divisão ocorre até que o vetor fique com apenas um elemento, enquanto os demais ficam ordenados à medida que ocorre o particionamento.
1. **Dividir**: o vetor v[inicio...fim] é particionado em dois subvetores não vazios v[inicio...meio] e v[meio+1...fim], tais que cada elemento de v[inicio...meio] é menor ou igual a cada elemento de v[meio+1...fim]. Para determinar o meio, escolhe-se um elemento, chamado de pivô, e rearranjam-se os elememtos do vetor de forma que os elementos à esquerda do pivô são menores (ou iguais) ao ele e os que ficarem à direita do pivô são maiores (ou iguais) ao pivô.
2. **Conquistar**: os dois subvetores são ordenados por chamadas recursivas.
3. **Combinar**: durante o processo recursivo os elementos vão sendo ordenados no próprio vetor.

<p align="center">
    <img src="https://upload.wikimedia.org/wikipedia/commons/9/9c/Quicksort-example.gif"/><br/>
    Fonte: <a href="https://en.wiktionary.org/wiki/quicksort">Wiktionary</a>
</p>

**Características**
1. Boa perfomance, apesar de possui um pior caso O(n²), que é muito raro de ocorrer, o seu caso médio é O(logn).
2. _In-place_ e estável

**Implementações**
1. Versão 1 (pivô como o primeiro elemento):

```python
def quickSort(array, inicio, fim):
	if (inicio < fim):
		pivo = partition(array, inicio, fim)
		quickSort(array, inicio, pivo - 1)
		quickSort(array, pivo + 1, fim)

def partition(array, inicio, fim):
    pivo = array[inicio]
    start = inicio

    for i in range(start + 1, fim + 1):
        if (array[i] <= pivo):
            start += 1
            #swap(array, start, i)
            array[start], array[i] = array[i], array[start]
    
    #swap(array, start, inicio)
    array[start], array[inicio] = array[inicio], array[start]
    return start
```

2. Versão 2 (pivô como elemento do meio):

```python
def QuickSort(lista, inicio, fim):
    if (inicio < fim):
        meio = partition(lista, inicio, fim)
        QuickSort(lista, inicio, meio - 1)
        QuickSort(lista, meio + 1, fim)


def partition(lista, inicio, fim):
    pivo = lista[(inicio + fim) / 2]
    i = inicio
    j = fim

    while (True):
        while (lista[i] < pivo):
            i += 1
        
        while (lista[j] > pivo):
            j -= 1
        
        if (i >= j):
            return j
        
        #swap(lista, i, j)
        lista[i], lista[j] = lista[j], lista[i]
```


## 🔍 3-Way QuickSort

3-Way QuickSort é uma otimização do QuickSort tradicional que melhora a execução do algoritmo quando temos muitas ocorrências de elementos iguais.  
Ele executa 3 partições no array sendo uma com elementos menores que o pivô, outra com elementos iguais ao pivô e uma terceira contendo os elementos maiores que o pivô.

<p align="center">
    <img src="https://algorithmsandme.com/wp-content/uploads/2018/03/3-way-quicksort.png"/><br/>
    Fonte: <a href="https://algorithmsandme.com/3-way-quicksort/">Algorithms & Me</a>
</p>

**Implementação**

```python
def quickSort(array, inicio, fim):
	if  (inicio < fim  and (inicio >= 0 and fim >= 0)):
		partition(array, inicio, fim)


def partition(array, inicio, fim):
	if (inicio < fim):
		start = inicio
		end = fim
		i = inicio
		pivo = array[inicio]

        while(i <= end):
            if(array[i] < pivo):
                # swap(array, start, i)
                array[start], array[i] = array[i], array[start]
                start += 1
                i += 1
            elif(array[i] > pivo):
                # swap(array, i, end)
                array[i], array[end] = array[end], array[i]
                end -= 1
            else:
                i += 1
        
        quickSort(array, inicio, start - 1)
        quickSort(array, end + 1, fim)
```