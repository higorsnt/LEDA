package solucao.produto;

import produto.Produto;

/**
 * Classe que generaliza os repositorios de produtos em array.
 * 
 * @author Adalberto
 *
 */
public class RepositorioProdutosArray implements RepositorioProdutosSolucao {

	private Produto[] produtos;
	private int index = -1;

	public RepositorioProdutosArray(int size) {
		super();
		this.produtos = new Produto[size];
	}

	private int procurarIndice(int codigo) {
		int i = 0;
		int resp = -1;
		boolean achou = false;

		while ((i <= index) && !achou) {
			if (produtos[i].getCodigo() == codigo) {
				resp = i;
				achou = true;
			}
			i = i + 1;
		}
		return resp;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see solucao.produto.RepositorioProdutos#existe(int)
	 */
	@Override
	public boolean existe(int codigo) {
		boolean resp = false;

		int i = this.procurarIndice(codigo);
		resp = (i == -1);

		return resp;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see solucao.produto.RepositorioProdutos#inserir(produto.Produto)
	 */
	@Override
	public void inserir(Produto produto) {
		produtos[++index] = produto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see solucao.produto.RepositorioProdutos#atualizar(produto.Produto)
	 */
	@Override
	public void atualizar(Produto produto) {
		int i = procurarIndice(produto.getCodigo());
		if (i != -1) {
			produtos[i] = produto;
		} else {
			throw new RuntimeException("Produto nao encontrado");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see solucao.produto.RepositorioProdutos#remover(int)
	 */
	@Override
	public void remover(int codigo) {
		int i = this.procurarIndice(codigo);
		if (i != -1) {
			produtos[i] = produtos[index];
			produtos[index] = null;
			index--;
		} else {
			throw new RuntimeException("Produto nao encontrado");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see solucao.produto.RepositorioProdutos#procurar(int)
	 */
	@Override
	public Produto procurar(int codigo) {
		Produto resp = null;
		int i = this.procurarIndice(codigo);
		if (i != -1) {
			resp = produtos[i];
		} else {
			throw new RuntimeException("Produto nao encontrado");
		}

		return resp;
	}
}
