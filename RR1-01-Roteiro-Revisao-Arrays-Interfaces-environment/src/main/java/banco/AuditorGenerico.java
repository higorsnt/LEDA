package banco;

public class AuditorGenerico {

  private static final double LIMITE = 500;

  boolean investigaBanco(QualquerBanco b){
    double sm;
    sm = b.saldoTotal()/b.numContas(); 
    return (sm > LIMITE);
  }

  public static void main(String[] args) {
  //instanciar um auditor generico
	  AuditorGenerico a = new AuditorGenerico();
	  
  //instanciar um banco de seguros
	  QualquerBanco bs = new BancoSeguros();
	  
  //instanciar um banco de investimentos
	  QualquerBanco bi = new BancoInvestimentos();

  //mandar o auditor investigar o banco de seguros
	  a.investigaBanco(bs);
	  
  //mandar o auditor investigar o banco de investimentos
	  a.investigaBanco(bi);
	  
  }
}