import java.util.Scanner;

public class FilaComArray {

    private int[] array;
    private int head;
    private int tail;

    public FilaComArray(int size) {
        this.array = new int[size];
        this.head = -1;
        this.tail = -1;
    }

    private boolean isFull(){
        return (this.tail == this.array.length - 1);
    }

    private boolean isEmpty() {
        return (this.tail == -1);
    }

    public void enqueue(int e) {
        if (isFull())
            System.out.println("full");
        else if (isEmpty()){
            this.head++;
            this.array[++this.tail] = e;
        } else {
            this.array[++this.tail] = e;
        }
    }

    public String head(){
        String result = "empty";
        if (!isEmpty())
            result = "" + this.array[this.head];

        return result;
    }

    public void dequeue() {
        if (isEmpty())
            System.out.println("empty");
        else {
            this.head++;
            System.out.println(head + " " + tail);
        }
    }

    public String print() {
        String result = "empty";

        if (!isEmpty()){
            result = "";
            for (int i = this.head; i <= this.tail; i++) {
                result += this.array[i] + " ";
            }
        }

        return result.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tamanho = Integer.parseInt(sc.nextLine());
        FilaComArray fila = new FilaComArray(tamanho);

        String[] entrada;
        String operacao = "";

        while (!operacao.equalsIgnoreCase("end")) {

            entrada = sc.nextLine().split(" ");
            operacao = entrada[0];

            if (operacao.equalsIgnoreCase("add")) {
                fila.enqueue(Integer.parseInt(entrada[1]));
            } else if (operacao.equalsIgnoreCase("remove")) {
                fila.dequeue();
            } else if (operacao.equalsIgnoreCase("element")) {
                System.out.println(fila.head());
            } else if (operacao.equalsIgnoreCase("print")) {
                System.out.println(fila.print());
            }

        }

        sc.close();
    }

}

/*
import java.util.Scanner;

class FilaComArray {

    private int[] array;
    private int tail;

    public FilaComArray(int size) {
        this.array = new int[size];
        this.tail = -1;
    }

    private boolean isFull(){
        return (this.tail == this.array.length - 1);
    }

    private boolean isEmpty() {
        return (this.tail == -1);
    }

    public void enqueue(int e) {
        if (isFull())
            System.out.println("full");
        else
            this.array[++this.tail] = e;
    }

    public String head(){
        String result = "empty";
        if (!isEmpty())
            result = "" + this.array[0];

        return result;
    }

    public void dequeue() {
        if (isEmpty())
            System.out.println("empty");
        else {
            shiftLeft();
            this.tail--;
        }
    }

    private void shiftLeft() {
        for (int i = 0; i < this.tail; i++) {
            this.array[i] = this.array[i + 1];
        }
    }

    public String print() {
        String result = "empty";

        if (!isEmpty()) {
            result = "";
            for (int i = 0; i <= this.tail; i++) {
                result += this.array[i] + " ";
            }
        }

        return result.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tamanho = Integer.parseInt(sc.nextLine());
        FilaComArray fila = new FilaComArray(tamanho);

        String[] entrada;
        String operacao = "";

        while (!operacao.equalsIgnoreCase("end")) {

            entrada = sc.nextLine().split(" ");
            operacao = entrada[0];

            if (operacao.equalsIgnoreCase("add")) {
                fila.enqueue(Integer.parseInt(entrada[1]));
            } else if (operacao.equalsIgnoreCase("remove")) {
                fila.dequeue();
            } else if (operacao.equalsIgnoreCase("element")) {
                System.out.println(fila.head());
            } else if (operacao.equalsIgnoreCase("print")) {
                System.out.println(fila.print());
            }

        }

        sc.close();
    }

}

 */