import java.util.Scanner;

class ElementosRepetidos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] elements = sc.nextLine().split(" ");
        boolean exists = false;

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < i; j++) {
                if (!exists && elements[i].equals(elements[j])){
                    exists = true;
                }
            }
        }

        System.out.println(exists);
    }
}
