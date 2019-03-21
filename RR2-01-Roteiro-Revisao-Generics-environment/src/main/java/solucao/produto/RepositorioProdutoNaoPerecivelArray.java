package solucao.produto;

import produto.ProdutoNaoPerecivel;

public class RepositorioProdutoNaoPerecivelArray extends
		RepositorioProdutosArray<ProdutoNaoPerecivel> {

	public RepositorioProdutoNaoPerecivelArray(int size) {
		super(size);
	}

	@Override
	public void inserir(ProdutoNaoPerecivel produto) {
		if (produto instanceof ProdutoNaoPerecivel) {
			super.inserir(produto);
		}
	}

	@Override
	public void atualizar(ProdutoNaoPerecivel produto) {
		if (produto instanceof ProdutoNaoPerecivel) {
			super.atualizar(produto);
		}
	}

}
