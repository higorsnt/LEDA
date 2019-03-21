package conta;

import cliente.Cliente;

public class ContaImposto extends ContaAbstrata {

  private static final double TAXA = 0.01;

  public ContaImposto(String numero, double saldo, Cliente cliente) {
    super(numero,saldo,cliente);
  }

  public void debitar(double valor) {
    double valorComImposto = valor + (valor * TAXA);
    double saldo = this.getSaldo();
    this.setSaldo(saldo - valorComImposto);
  }
}