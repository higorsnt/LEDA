# Tabelas Hash

As tabelas hash, que são conhecidas também como tabelas de dispersão, é uma estrutura que armazena dados associando uma chave de pesquisa a um valor. Daí, é possível realizar operações com rápida execução.

As tabelas hash funcionam em conjunto com uma **função de hashing** que deve ser eficiente o suficiente para se evitar que duas chaves sejam mapeadas para a mesma posição (colisão). Mesmo que seja impossível não obter nenhum colisão elas devem ser minimizadas!

<p align="center">
    <img src="https://www.cs.cmu.edu/~adamchik/15-121/lectures/Hashing/pix/hashing0.bmp"/><br/>
    Fonte: <a href="https://www.cs.cmu.edu/~adamchik/15-121/lectures/Hashing/hashing.html">Carnegie Mellon University</a>
</p>

# Tabelas Hash com Endereçamento Aberto

Essa forma de implementar utiliza algo chamado de _probe_, onde é examinada a tabela até encontrar um espaço vazio. Logo, quem define quais posições serão examinadas é a chave.

A função de hashing pode seguir 3 modelos:

1. Linear Probing

Para se utilizar esse método se faz necessário ter uma função de hash ordinária (utilizando os métodos da multiplicação ou divisão). Sua fórmula é: `h(k, i) = ((h'(k) + i) mod m)`, onde:
> k é a chave
> i é o probe
> m é o tamanho da tabela
> h'(k) é a função de hash auxiliar

2. 

<p align="center">
    <img src="https://study.cs50.net/slideshows/1WyRdHGA7wYMYg078wXpv9qAjrELJBokRFRKGnVbnI7Q/img/0.png"/><br/>
    Fonte: <a href="https://study.cs50.net/hashtables">CS50 Study</a>
</p>