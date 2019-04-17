import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InverteFrase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = split(sc.nextLine());
        String out = "";

        for (int i = text.length - 1; i >= 0; i--) {
            out += text[i] + " ";
        }

        System.out.println(out.trim());
    }

    public static String[] split(String string){
        List<String> lista = new ArrayList<>();
        int i = 0;
        int length = string.length();
        String s = "";

        while (i < length) {
            if (string.charAt(i) == ' '){
                lista.add(s);
                s = "";
            } else {
                s += string.charAt(i);
            }
            i++;
        }

        lista.add(s);
        return lista.toArray(new String[0]);
    }

}
