# ROTEIRO 05

Nesse roteiro o objetivo era implementar as estruturas básicas de dados.

# Pilha

A pilha segue uma política de inserção de elementos conhecida como **LIFO** (last in, first out). Dessa forma a inserção e remoção se faz pela mesma extremidade, conhecida como topo.

<figure>
    <p align="center">
        <img src="https://cdn-images-1.medium.com/max/800/1*kkK3EZNOzBsuwkDNvSVR9g.gif"/>
            <figcaption style="font-size:14px" align="center">
            Fonte: <a href="https://medium.com/dev-blogs/ds-with-js-stack-queue-d91fc8cea7a3">Medium</a>
            </figcaption>
    </p>
</figure>

<center>
As operações básicas são:

| Operação | Complexidade |
| :------: | :----------: |
|   pop    |     O(1)     |
|   push   |     O(1)     |
|   top    |     O(1)     |
|  isEmpty |     O(1)     |
|  isFull  |     O(1)     |
</center>

# Fila

Em uma fila cada elemento é inserido na cauda e removido pela cabeça, ou seja, a estrutura respeita a ordem conhecida como **FIFO** (first in, first out). Seu funcionamento é semelhante às filas de espera.

Uma particularidade da fila, é que em algumas implementações se faz necessário trazer todos os elementos pra frente após uma remoção.

<figure>
    <p align="center">
        <img src="http://daltonschool.github.io/CS3A/assets/queue-animation.gif"/>
            <figcaption style="font-size:14px" align="center">
            Fonte: <a href="http://daltonschool.github.io/CS3A/collections/">CS3A</a>
            </figcaption>
    </p>
</figure>


<center>As operações básicas são:

| Operação | Complexidade |
| :------: | :----------: |
|  enqueue |     O(1)     |
|  dequeue |     O(n)     |
|  head    |     O(1)     |
|  isEmpty |     O(1)     |
|  isFull  |     O(1)     |
</center>


# Fila Circular

A diferença entre a implementação tradicional e a fila circular é a necessidade de utilizar operações modulares para se obter os índices da cabeça e da cauda da fila, pois dessa forma ao estourar a capacidade do array os ponteiros voltam ao inicio.
  

<figure>
    <p align="center">
        <img src="http://daltonschool.github.io/CS3A/assets/queuearray-animation.gif"/>
            <figcaption style="font-size:14px" align="center">
            Fonte: <a href="http://daltonschool.github.io/CS3A/collections/">CS3A</a>
            </figcaption>
    </p>
</figure>
<div align="center">As operações básicas são:

<table style="background-color: #59d0bc; border-color: #000605;">
	<tbody>
		<tr style="height: 23px;">
			<th style="text-align: center; height: 23px;">&nbsp;Opera&ccedil;&otilde;es</th>
			<th style="text-align: center; height: 23px;">Complexidade</th>
		</tr>
		<tr style="height: 23px;">
			<td style="text-align: center; height: 23px;">&nbsp;enqueue</td>
			<td style="text-align: center; height: 23px;">&nbsp;O(1)&nbsp;</td>
		</tr>
		<tr style="height: 23px;">
			<td style="text-align: center; height: 23px;">&nbsp;dequeue</td>
			<td style="text-align: center; height: 23px;">&nbsp;O(1)&nbsp;</td>
		</tr>
		<tr style="height: 23px;">
			<td style="text-align: center; height: 23px;">&nbsp;isFull</td>
			<td style="text-align: center; height: 23px;">&nbsp;O(1)</td>
		</tr>
		<tr style="height: 23px;">
			<td style="text-align: center; height: 23px;">&nbsp;isEmpty</td>
			<td style="text-align: center; height: 23px;">&nbsp;O(1)&nbsp;</td>
		</tr>
		<tr style="height: 23px;">
			<td style="text-align: center; height: 23px;">&nbsp;head</td>
			<td style="text-align: center; height: 23px;">&nbsp;O(1)</td>
		</tr>
	</tbody>
</table>
