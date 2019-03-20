package solucao.forma;

public class Retangulo implements Forma {

	protected double comprimento;
	protected double altura;

	public Retangulo(double comprimento, double altura) {
		super();
		this.comprimento = comprimento;
		this.altura = altura;
	}

	@Override
	public double area() {
		return comprimento * altura;
	}

}
