package conta;

import cliente.Cliente;

public class Conta extends ContaAbstrata{

  public Conta(String numero, double saldo, Cliente cliente) {
    super(numero, saldo, cliente);
  }

  public void debitar(double valor){
    setSaldo(getSaldo() - valor);
  }
}