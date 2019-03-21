package repositorio;

import conta.ContaAbstrata;

public class RepositorioContaHerdado extends RepositorioGenerico {

	@Override
	public boolean existe(Object objeto) {
		boolean resp = false;
		if(objeto instanceof ContaAbstrata){
			resp = super.existe(objeto);
		}
		return resp;
	}

	@Override
	public void inserir(Object novo) {
		if(novo instanceof ContaAbstrata){
			super.inserir(novo);
		}
	}

	@Override
	public void atualizar(Object objeto) {
		if(objeto instanceof ContaAbstrata){
			super.atualizar(objeto);
		}
	}

	@Override
	public Object procurar(Object objeto) {
		Object resp = null;
		if(objeto instanceof ContaAbstrata){
			resp = super.procurar(objeto);
		}
		return resp;
	}

	@Override
	public void remover(Object objeto) {
		if(objeto instanceof ContaAbstrata){
			super.remover(objeto);
		}
	}
	
}
