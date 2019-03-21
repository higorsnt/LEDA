package repositorio;

import cliente.Cliente;
import conta.Conta;
import conta.ContaBonificada;
import conta.Poupanca;

public class TesteRepositorioGenerico {
	public static void main(String[] args) {
		RepositorioCliente repClientes = new RepositorioCliente();
		RepositorioConta repContas = new RepositorioConta();
		RepositorioGenerico rep = new RepositorioGenerico();
		
		//quero um repositorio que só guarda clientes
		Cliente cli1 = new Cliente("1","Jose");
		Cliente cli2 = new Cliente("2","Joao");
		repClientes.inserir(cli1);
		repClientes.inserir(cli2);
		//repClientes.inserir(new Conta("3",100.0,cli1));
		
		//quero um repositorio que so guarda contas
		Conta c1 = new Conta("4",50.0, cli1);
		Conta c2 = new Poupanca("5",60.0, cli1);
		Conta c3 = new ContaBonificada("5",70.0, cli1);
		Conta c4 = new Conta("6",80.0, cli1);

		repContas.inserir(c1);
		repContas.inserir(c2);
		repContas.inserir(c3);
		repContas.inserir(c4);
		//repContas.inserir(cli1);
		
		//testando um reporitorio generico
		rep.inserir(c1);
		rep.inserir(cli1);
		rep.inserir(c2);

		//Conta procurado = rep.procurar(c2);
		
		//testando repositorio herdado
		RepositorioContaHerdado repHerdado = new RepositorioContaHerdado();
		repHerdado.inserir(c1);
		repHerdado.inserir(cli1);
		repHerdado.inserir(c2);
		
		//procurado = repHerdado.procurar(c3);
		
	}
}
