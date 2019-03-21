package conta;

import cliente.Cliente;

public abstract class ContaAbstrata {
  private String numero;
  private double saldo;
  private Cliente cliente;

  public ContaAbstrata(String numero, double saldo, Cliente cliente) {
    this.numero = numero;
    this.saldo = saldo;
    this.cliente = cliente;
  }
  public abstract void debitar(double valor);
  public void creditar(double valor){
    saldo = saldo + valor;
  }
  public void transferir(ContaAbstrata c, double v){
    this.debitar(v);
    c.creditar(v);
  }
  public Cliente getCliente() {
    return cliente;
  }
  public String getNumero() {
    return numero;
  }
  public double getSaldo() {
    return saldo;
  }
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }
  
  @Override
	public boolean equals(Object obj) {
		boolean resp = false;
		if (obj instanceof ContaAbstrata) {
			resp = ((ContaAbstrata) obj).getNumero().equals(this.numero);
		}
		return resp;
	}
  
}
