package solucao.produto;

import produto.ProdutoPerecivel;

public class RepositorioProdutoPerecivelArray extends
		RepositorioProdutosArray<ProdutoPerecivel> {

	public RepositorioProdutoPerecivelArray(int size) {
		super(size);
	}

	@Override
	public void inserir(ProdutoPerecivel produto) {
		if (produto instanceof ProdutoPerecivel) {
			super.inserir(produto);
		}
	}

	@Override
	public void atualizar(ProdutoPerecivel produto) {
		if (produto instanceof ProdutoPerecivel) {
			super.atualizar(produto);
		}
	}
}
