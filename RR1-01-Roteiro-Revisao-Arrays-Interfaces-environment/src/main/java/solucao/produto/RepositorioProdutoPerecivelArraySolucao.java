package solucao.produto;

import produto.Produto;
import produto.ProdutoPerecivel;

public class RepositorioProdutoPerecivelArraySolucao extends RepositorioProdutosArray {

	public RepositorioProdutoPerecivelArraySolucao(int size) {
		super(size);
	}

	@Override
	public void inserir(Produto produto) {
		if (produto instanceof ProdutoPerecivel) {
			super.inserir(produto);
		}
	}

	@Override
	public void atualizar(Produto produto) {
		if (produto instanceof ProdutoPerecivel) {
			super.atualizar(produto);
		}
	}
}
