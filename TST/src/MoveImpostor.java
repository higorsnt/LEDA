import java.util.Arrays;
import java.util.Scanner;

public class MoveImpostor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(" ");

        int i = 0;
        boolean findImpostor = false;

        while (!findImpostor && i < array.length) {

            if (Integer.parseInt(array[i]) > Integer.parseInt(array[i + 1])){
                String key = array[i + 1];
                int j = i;
                while (j>= 0 && (Integer.parseInt(array[j]) > Integer.parseInt(key))){
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = key;
                findImpostor = true;
            }

            i++;
        }

        System.out.println(Arrays.toString(array));
    }

}
