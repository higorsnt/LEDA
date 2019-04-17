import java.util.Scanner;

public class FilaComArray {

    private int[] array;
    private int head;
    private int tail;
    private int elements;

    public FilaComArray(int size) {
        this.array = new int[size + 1];
        this.head = 0;
        this.elements = 0;
        this.tail = 0;
    }

    private boolean isFull(){
        return (this.elements == this.array.length - 1);
    }

    private boolean isEmpty() {
        return (this.elements == 0);
    }

    public void add(int e) {
        if (isFull()) System.out.println("full");
        else {
            this.array[this.tail++] = e;
            this.elements++;
        }
    }

    public void element(){
        if (isEmpty()) System.out.println("empty");
        else System.out.println(this.array[this.head]);
    }

    public void remove() {
        if (isEmpty()) System.out.println("empty");
        else {
            this.head++;
            this.elements--;
        }
    }

    public void print() {
        if (isEmpty()) System.out.println("empty");
        else {
            String s = "";
            for (int i = this.head; i < this.tail; i++) {
                s += this.array[i] + " ";
            }

            System.out.println(s.trim());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FilaComArray f = new FilaComArray(sc.nextInt());
        sc.nextLine();
        String op;

        while (true){
            op = sc.nextLine();

            if (op.equalsIgnoreCase("print")){
                f.print();
            } else if (op.equalsIgnoreCase("remove")) {
                f.remove();
            } else if (op.equalsIgnoreCase("element")) {
                f.element();
            } else if (op.split(" ")[0].equalsIgnoreCase("add")) {
                f.add(Integer.parseInt(op.split(" ")[1]));
            } else if (op.equalsIgnoreCase("end")) {
                break;
            }
        }
    }

}
