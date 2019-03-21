package conta;

import cliente.Cliente;

public class Poupanca extends Conta {

  public Poupanca(String numero, double saldo, Cliente cliente) {
    super(numero,saldo,cliente);
  }

  public void renderJuros(double taxa){
    double saldo = this.getSaldo();
    this.creditar(saldo*taxa);
  }
}