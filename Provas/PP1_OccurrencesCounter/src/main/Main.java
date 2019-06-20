package main;

public class Main {

    public static void main(String[] args) {
        OccurrencesCounterImpl<Integer> oci = new OccurrencesCounterImpl();

        Integer[] a = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Integer[] b = {1,2,2,2,2,3,3,6,8,8,8,8,8,8,8,8,8,9,9,10,12,13};

        //System.out.println(a.length);
        System.out.println(oci.count(b, 13));
    }
}
