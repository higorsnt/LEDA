# Árvore B

É uma árvore balanceada que surgiu para que ocorra uma otimização no acesso a armazenamento secundário.

Diferentemente das árvores anteriores esta permite que um nó tenha mais que 2 filhos e, portanto, reduza o número de acessos a disco.

<p align="center">
    <img src="http://www.lcad.icmc.usp.br/~nonato/ED/B_arvore/arvoreb.gif"/></br>
    Fonte: <a href="http://www.lcad.icmc.usp.br/~nonato/ED/B_arvore/btree.htm">Link</a>
</p>

## Propriedades

Considerando uma árvore B de ordem **m**:

1. Cada nó tem no máximo **m** filhos;
2. Cada nó, exceto a raiz, possui no máximo **`(m / 2) - 1`** filhos;
3. A raiz tem pelo menos 2 filhos se não for folha;
4. Todas as folhas estão no mesmo nível;
5. Um nó interno com _k_ filhos possui _k - 1_ chaves
6. As chaves de cada nó estão ordenados e servem como separadores dos filhos.