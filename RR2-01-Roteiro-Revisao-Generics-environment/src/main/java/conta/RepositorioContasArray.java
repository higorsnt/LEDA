package conta;

import java.util.Collection;
import java.util.Vector;

public class RepositorioContasArray {
  private Conta[]  contas;
  private int indice;

  public RepositorioContasArray() {
    indice = 0;
    contas = new Conta[20];
  }

  private int procurarIndice(String numero) {
    int     i = 0;
    int     resp = -1;
    boolean achou = false;

    while ((i < indice) &&!achou) {
      if ((contas[i].getNumero()).equals(numero)) {
        resp = i;
        achou = true;
      }
      i = i + 1;
    }
    return resp;
  }

  public boolean existe(String numero) {
    boolean resp = false;

    int i = this.procurarIndice(numero);
    if(i != -1){
      resp = true;
    }

    return resp;
  }

  public void inserir(Conta novaConta){
    contas[indice] = novaConta;
    indice = indice + 1;
  }

  public void atualizar(Conta conta){
    int i = procurarIndice(conta.getNumero());
    if (i != -1) {
      contas[i] = conta;
    } else {
      throw new RuntimeException("Conta nao encontrada");
    }
  }
  public Conta procurar(String numero){
    Conta c = null;
    int i = this.procurarIndice(numero);

    if (i != -1) {
      c = contas[i];
    } else {
      throw new RuntimeException("Conta nao encontrada");
    }

    return c;
  }


  public void remover(String numero){

    int i = this.procurarIndice(numero);

    if (i != -1) {
      contas[i] = contas[indice - 1];
      contas[indice - 1] = null;
      indice = indice - 1;
    } else {
      throw new RuntimeException("Conta nao encontrada");
    }
  }

  public Collection procurarContas(String cpfCliente){
    Vector resp = new Vector();

    for (int i = 0; i < indice; i++) {
      if(contas[i].getCliente().getCpf().equals(cpfCliente)){
        resp.addElement(contas[i]);
      }
    }

    return resp;
  }
}