import java.util.Scanner;

public class BinarySearch {

    public static void binarySearch(String[] array, int element, int begin, int end) {
        int middle;

        if(begin > end) {
            System.out.println(-1);
        } else {
            middle = ((begin + end) / 2);
            System.out.println(middle);

            int middleElement = Integer.parseInt(array[middle]);

           if (middleElement > element) {
                binarySearch(array, element, begin,middle - 1);
            } else if(middleElement < element) {
                binarySearch(array, element, middle + 1, end);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(" ");
        int search = sc.nextInt();

        binarySearch(array, search, 0, array.length - 1);
    }
}
