import java.util.Scanner;

public class PotenciaRecursiva {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long base = sc.nextLong();
        sc.nextLine();
        long exponent  = sc.nextLong();
        sc.nextLine();

        System.out.println(recursivePower(base, exponent));
    }

    public static long recursivePower(long base, long exponent){
        if (exponent == 0) {
            return 1;
        }

        return base * recursivePower(base, exponent - 1);
    }
}
