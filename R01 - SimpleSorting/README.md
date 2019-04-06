# ROTEIRO 01

Nesse roteiro deve-se implementar os algoritmos de ordenação por comparação que possuem tempo de complexidade médio em O(n²).

## 💡 Bubble Sort

Dado um vetor de tamanho _n_, para realizar a ordenação nesse método é necessário realizar diversas comparações entre elementos adjacentes e se caso necessário troca-los. Ou seja, cada elemento de posição _i_ será comparado com o elemento de posição _i + 1_, e quando a ordenação procurada (crescente ou decrescente) é encontrada, uma troca de posições entre os elementos é feita.  

<p align="center"><a href="https://commons.wikimedia.org/wiki/File:Bubble-sort.gif#/media/File:Bubble-sort.gif"><img src="https://upload.wikimedia.org/wikipedia/commons/0/06/Bubble-sort.gif" alt="Bubble-sort.gif" height="300" width="500"></a><br>By <a href="//commons.wikimedia.org/w/index.php?title=User:Swfung8&amp;action=edit&amp;redlink=1" class="new" title="User:Swfung8 (page does not exist)">Swfung8</a> - <span class="int-own-work" lang="en">Own work</span>, <a href="https://creativecommons.org/licenses/by-sa/3.0" title="Creative Commons Attribution-Share Alike 3.0">CC BY-SA 3.0</a>, <a href="https://commons.wikimedia.org/w/index.php?curid=14953378">Link</a></p>

Versões melhoradas:
1. Cada elemento de posição _i_ será comparado com o de posição _i - 1_, e quando a ordenação procurada (crescente ou decrescente) é encontrada, uma troca de posições entre os elementos é feita. Assim, temos dois laços, o laço externo `for(int i = 1; i < n; i++)` e o laço interno `for(int j = n - 1; j >= i; j--)`;
2. Realizar comparações enquanto houver trocas, ou seja, _i = 1_ e `while(j <= n && troca == 1)` e dentro desse laço um outro laço que percorre da primeira à ultima posição.

**Bubble Sort Recursivo**
```python
def bubble_sort(lista, index):
    if (index == 1):
        return
    for i in range(len(lista)-1):
        if (lista[i] > lista[i+1]):
            lista[i], lista[i+1] = lista[i+1], lista[i]
    bubble_sort(lista, index - 1)
```
