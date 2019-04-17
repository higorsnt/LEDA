# ROTEIRO 02

Nesse roteiro deve-se implementar os algoritmos de ordenação por comparação que se utilizam da técnica de _dividir para conquistar_. Todos possuem tempo de complexidade médio em O(nlogn).

# 🔍 Merge Sort
Inicialmente o vetor é dividido recursivamente em vetores menores. Esse processo só para quando temos _n_ vetores de tamanho 1. A partir daí os vetores serão ordenados e intercalados para se obter a ordenação.
Por ser um algoritmo que utiliza a técnica _dividir para conquistar_ deve-se seguir alguns passos:
1. **Dividir**: dividir a sequência de _n_ elementos a serem ordenados em duas subsequências de _n/2_ elementos cada.
2. **Conquistar**: ordenar as duas subsequências recursivamente utilizando a ordenação por intercalação;
3. **Combinar**: intercalar as duas subsequências ordenadas para produzir a solução.

<p align="center">
<img src="https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif"/>
Fonte: Wikipedia
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

## 🔍 Quick Sort
De forma semelhante ao merge sort, o quick sort particiona um vetor em dois por meio de recursão. Essa divisão ocorre até que o vetor fique com apenas um elemento, enquanto os demais ficam ordenados à medida que ocorre o particionamento.
1. **Dividir**: o vetor v[inicio...fim] é particionado em dois subvetores não vazios v[inicio...meio] e v[meio+1...fim], tais que cada elemento de v[inicio...meio] é menor ou igual a cada elemento de v[meio+1...fim]. Para determinar o meio, escolhe-se um elemento, chamado de pivô, e rearranjam-se os elememtos do vetor de forma que os elementos à esquerda do pivô são menores (ou iguais) ao ele e os que ficarem à direita do pivô são maiores (ou iguais) ao pivô.
2. **Conquistar**: os dois subvetores são ordenados por chamadas recursivas.
3. **Combinar**: durante o processo recursivo os elementos vão sendo ordenados no próprio vetor.

<p align="center">
<img src="https://upload.wikimedia.org/wikipedia/commons/9/9c/Quicksort-example.gif"/>
Fonte: Wikipedia
</p>

**Características**
1. Boa perfomance, apesar de possui um pior caso O(n²), que é muito raro de ocorrer, o seu caso médio é O(logn).
2. _In-place_ e estável

**Implementações**
1. Versão 1 (pivô como o primeiro elemento):
```java
void quickSort(T[] array, int leftIndex, int rightIndex) {
	int pivot;

	if (validation(array, leftIndex, rightIndex)) {
		pivot = this.partition(array, leftIndex, rightIndex);
		this.quickSort(array, leftIndex, pivot - 1);
		this.quickSort(array, pivot + 1, rightIndex);
	}
}

int partition(T[] array, int leftIndex, int rightIndex){
	T pivot = array[leftIndex];

	int start = leftIndex;

	for (int i = start + 1; i <= rightIndex; i++) {
		if (array[i].compareTo(pivot) <= 0) {
			start++;
			swap(array, start, i);
		}
    }

	swap(array, leftIndex, start);
	return start;
}

void swap(Object[] array, int i, int j) {
	if (array == null)
		throw new IllegalArgumentException();

	Object temp = array[i];
	array[i] = array[j];
	array[j] = temp;
}
```

2. Versão 2 (pivô como elemento do meio):
```java
void quickSort(int[] lista, int inicio, int fim){
    if (inicio < fim){
        int meio = partition(lista, inicio, fim);
        quickSort(lista, inicio, meio);
        quickSort(lista, meio + 1, fim);
    }
}

int partition(int[] lista, int inicio, int fim){
    int meio = (inicio + fim) / 2;
    int pivo = lista[meio];
    int i = inicio;
    int j = fim;
    
    while (true){
        while (lista[i] < pivo){
            i++;
        }

        while (lista[j] > pivo){
            j--;
        }
    
        if (i >= j){
            return j;
        }

        swap(lista, i, j);
    }
}

void swap(int[] lista, int i, int j){
    int temp = lista[i];
    lista[i] = lista[j];
    lista[j] = temp;
}
```