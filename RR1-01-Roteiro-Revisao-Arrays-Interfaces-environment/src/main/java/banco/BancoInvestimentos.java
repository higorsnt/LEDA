package banco;

public class BancoInvestimentos implements QualquerBanco {

  @Override
public double saldoTotal(){
    return 10000;
  }

  @Override
public int numContas(){
    return 12;
  }
  
  public void m(){
	  System.out.println("Banco de investimento");
  }

}