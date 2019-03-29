import java.util.Arrays;
import java.util.Scanner;

public class FuraFila {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] queue = sc.nextLine().split(" ");
        int position = sc.nextInt();

        int index = 0;

        for (int i = position; i < queue.length; i++) {
            String key = queue[i];

            int j = i - 1;

            while (j >= index){
                queue[j + 1] = queue[j];
                j--;
            }
            queue[j + 1] = key;
            index++;
            System.out.println(Arrays.toString(queue));
        }

    }
}
