package solucao.forma;

public class Circulo implements Forma {

	protected double raio;

	public Circulo(double raio) {
		super();
		this.raio = raio;
	}

	@Override
	public double area() {
		return Math.PI * raio * raio;
	}

}
