package cliente;
public class RepositorioClientesArray {
  private Cliente[]  clientes;
  private int indice;

  public RepositorioClientesArray() {
    indice = 0;
    clientes = new Cliente[20];
  }

  private int procurarIndice(String cpf) {
    int     i = 0;
    int     resp = -1;
    boolean achou = false;

    while ((i < indice) &&!achou) {
      if ((clientes[i].getCpf()).equals(cpf)) {
        resp = i;
        achou = true;
      }
      i = i + 1;
    }
    return resp;
  }

  public boolean existe(String cpf) {
    boolean resp = false;

    int i = this.procurarIndice(cpf);
    if(i != -1){
      resp = true;
    }

    return resp;
  }

  public void inserir(Cliente novoCliente){
    clientes[indice] = novoCliente;
    indice = indice + 1;
  }

  public void atualizar(Cliente cliente){
    int i = procurarIndice(cliente.getCpf());
    if (i != -1) {
      clientes[i] = cliente;
    } else {
      throw new RuntimeException("Conta nao encontrada");
    }
  }

  public Cliente procurar(String cpf){
    Cliente resp = null;
    int i = this.procurarIndice(cpf);
    if ( i != -1) {
      resp = clientes[i];
    } else {
      throw new RuntimeException("Cliente nao encontrado");
    }

    return resp;
  }


  public void remover(String cpf){
    int i = this.procurarIndice(cpf);
    if (i != -1) {
      clientes[i] = clientes[indice - 1];
      clientes[indice - 1] = null;
      indice = indice - 1;
    } else {
      throw new RuntimeException("Cliente nao encontrado");
    }
  }
}