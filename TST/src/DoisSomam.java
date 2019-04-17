import java.util.Arrays;
import java.util.Scanner;

public class DoisSomam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(s ->
                Integer.parseInt(s)).toArray();
        int sumSearch = sc.nextInt();
        sc.nextLine();
        int addend1 = -1;
        int addend2 = -1;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i] + array[j]) == sumSearch){
                    addend1 = array[i];
                    addend2 = array[j];
                    break;
                }
            }
        }

        if (addend1 != -1 && addend2 != -1){
            System.out.println(addend1 + " " + addend2);
        } else {
            System.out.println(addend1);
        }
    }

}
