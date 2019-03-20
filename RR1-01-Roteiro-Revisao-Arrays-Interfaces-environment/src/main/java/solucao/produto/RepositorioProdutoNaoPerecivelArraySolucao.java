package solucao.produto;

import produto.Produto;
import produto.ProdutoNaoPerecivel;

public class RepositorioProdutoNaoPerecivelArraySolucao extends
		RepositorioProdutosArray {

	public RepositorioProdutoNaoPerecivelArraySolucao(int size) {
		super(size);
	}

	@Override
	public void inserir(Produto produto) {
		if (produto instanceof ProdutoNaoPerecivel) {
			super.inserir(produto);
		}
	}

	@Override
	public void atualizar(Produto produto) {
		if (produto instanceof ProdutoNaoPerecivel) {
			super.atualizar(produto);
		}
	}

}
