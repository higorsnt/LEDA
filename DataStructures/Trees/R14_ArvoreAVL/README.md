# 🌲 Árvore AVL

É uma árvore binária de busca que possui a característica de estar sempre balanceada. O fato de estar sempre balanceada garante que nos piores casos a árvore tenha complexidade O(log n).

Ela permite rebalanceamento local, apenas na parte afetada pela inserção ou remoção de um elemento, através de operações de rotações.

## Fator de balanceamento

É a diferença entre as alturas da subárvore da esquerda com da direita. Caso a diferença resulte se encaixe em `fator > 1` ou `fator < -1` é sinal que a árvore deve ser rebalanceada.
```
Fator_Balanceamento = height(esquerda) - height(direita)
```

> Fator_Balanceamento > 0 pesa mais para a esquerda  
> Fator_Balanceamento < 0 pesa mais para a direita  
> Fator_Balanceamento = 0 árvore "equilibrada"

## Rotações

A realização de rotações permite que a árvore mantenha a sua característica principal, o balanceamento. Após a realização de uma rotação temos que uma subárvore diminui de altura, enquanto a outra aumenta, além disso garante uma árvore próxima do preenchimento completo e operações em O(log n).

<p align="center">
    <img src="https://upload.wikimedia.org/wikipedia/commons/2/23/Tree_rotation.png"/></br>
    Fonte: <a href="https://en.wikipedia.org/wiki/Tree_rotation">Wikipedia</a>
</p>

Existem 2 rotações:
### **Simples**
Ocorrem quando um nó está desbalanceado e seu filho estiver com inclinação no mesmo sentido.

Dentro das rotações simples podem ocorrer dois casos:
1. Left-Left (LL): que é quando a raiz e seu filho pesam para a esquerda. Nesse caso deve-se fazer uma rotação para a direita na raiz.
<p align="center">
    <img src="https://www.tutorialspoint.com/data_structures_algorithms/images/unbalanced_avl_trees.jpg"/></br>
    Fonte: <a href="https://www.tutorialspoint.com/data_structures_algorithms/avl_tree_algorithm.htm">TutorialsPoint</a>
</p>

2. Right-right (RR): caso onde a raiz e o filho pesam para a direita. Nesse caso deve-se fazer uma rotação para a esquerda na raiz.

<p align="center">
    <img src="https://www.tutorialspoint.com/data_structures_algorithms/images/avl_right_rotation.jpg"/></br>
    Fonte: <a href="https://www.tutorialspoint.com/data_structures_algorithms/avl_tree_algorithm.htm">TutorialsPoint</a>
</p>

### **Dupla**
Ocorrem quando um nó estiver desbalanceado e seu filho estiver inclinado no sentido inverso.

Assim como nas rotações simples, as duplas possuem dois tipos:

1. Left-right (LR): Ocorre quando a raiz está pesando para a esquerda e seu filho está pesando para a direita. Daí, para resolver é necessário realizar duas rotações: a primeira deve ser no filho para a esquerda e depois uma no pai na direita.

<p align="center">
    <img src="img/lr.gif"/></br>
    Simulação feita no Visualgo
</p>


2. Right-left (RL): Ocorre quando a raiz está pesando para a direita e seu filho está pesando para a direita. Nesse caso, a solução é realizar uma rotação para a direita no filho e, posteriormente, uma para esquerda no pai.

<p align="center">
    <img src="img/rl.gif"/></br>
    Simulação feita no Visualgo
</p>

## Métodos

Os métodos de uma AVL são praticamente os mesmos de uma BST, porém devem-se sobrescrever o **insert** e o **remove**, isso para que se mantenha o balanceamento. Portanto, para se manter o balanceamento deve-se ter alguns métodos adicionais:

1. calculateBalance

Que calcula o fator de balanceamento de um determinado nó.

2. rebalance

Chama o fator de balanceamento e verifica, se for necessário, qual o caso de rotação que deverá ser feito.

3. rebalanceUp

Vai subindo na árvore para garantir que os nós estão balanceados após uma remoção.