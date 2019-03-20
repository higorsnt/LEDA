package solucao.forma;

public class Main {

    public static void main(String[] args) {
        Forma f1 = new Circulo(4);
        Forma f2 = new Quadrado(8);
        Forma f3 = new Triangulo(3, 4);
        Forma f4 = new Retangulo(6, 8);

        System.out.println(f1.area());
        System.out.println(f2.area());
        System.out.println(f3.area());
        System.out.println(f4.area());

    }
}
