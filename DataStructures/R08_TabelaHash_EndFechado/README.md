# Tabelas Hash

As tabelas hash, que são conhecidas também como tabelas de dispersão, são estruturas que armazenam dados associando uma chave de pesquisa a um valor. Daí, é possível realizar operações com rápida execução.

As tabelas hash funcionam em conjunto com uma **função de hashing** que deve ser eficiente o suficiente para se evitar que duas chaves sejam mapeadas para a mesma posição (colisão).   
É praticamente impossível não obter nenhuma colisão, porém elas devem ser minimizadas!

<p align="center">
    <img src="https://www.cs.cmu.edu/~adamchik/15-121/lectures/Hashing/pix/hashing0.bmp"/><br/>
    Fonte: <a href="https://www.cs.cmu.edu/~adamchik/15-121/lectures/Hashing/hashing.html">Carnegie Mellon University</a>
</p>

# Tabelas Hash com Endereçamento Fechado

Nessa implementação, elementos com mesmo hash são colocados na mesma posição da tabela. E esse elemento deve ser inserido na cabeça da lista, já que se tem a ideia de que o elemento será utilizado em breve.  
Para se escolher a **função de hashing** é necessário satisfazer a ideia de um _hashing uniforme_, que é aquele em que qualquer chave tem a mesma probabilidade de ser mapeada em qualquer um dos _m_ (m = tamanho da tabela) slots.

1. **Método da divisão:**

Usa o resto da divisão para encontrar os valores hash. Sua fórmula é a seguinte: `h(k) = k mod m`, onde k é a chave e m o tamanho da tabela.

2. **Método da multiplicação:**

Nesse método a fórmula é a seguinte: `h(k) = ⌊m (kA mod 1)⌋`, onde:
> **k** é a chave  
> **A** é valor entre 0 e 1. Um bom valor para A é `A ≈ (√5 - 1 ) / 2 = 0.6180339887...`  
> **m** é o tamanho da tabela  


<p align="center">
    <img src="https://www.geeksforgeeks.org/wp-content/uploads/implementing-own-hash-table.png"/><br/>
    Fonte: <a href="https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/">GeeksForGeeks</a>
</p>