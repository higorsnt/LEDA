# ROTEIRO 01

Nesse roteiro deve-se implementar os algoritmos de ordenação por comparação que possuem tempo de complexidade médio em O(n²).

## 💡 Bubble Sort

Dado um vetor de tamanho _n_, para realizar a ordenação nesse método é necessário realizar diversas comparações entre elementos adjacentes e se caso necessário troca-los. Ou seja, cada elemento de posição _i_ será comparado com o elemento de posição _i + 1_, e quando a ordenação procurada (crescente ou decrescente) é encontrada, uma troca de posições entre os elementos é feita.  

![Bubble Sort][img1]

Versões melhoradas:
1. Cada elemento de posição _i_ será comparado com o de posição _i - 1_, e quando a ordenação procurada (crescente ou decrescente) é encontrada, uma troca de posições entre os elementos é feita. Assim, temos dois laços, o laço externo `for(int i = 1; i < n; i++)` e o laço interno `for(int j = n - 1; j >= i; j--)`;
2. Realizar comparações enquanto houver trocas, ou seja, _i = 1_ e `while(j <= n && troca == 1)` e dentro desse laço um outro laço que percorre da primeira à ultima posição.



[img1]: https://commons.wikimedia.org/wiki/File:Bubble-sort.gif#/media/File:Bubble-sort.gif