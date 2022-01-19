package hw0;

public class Arrays {
    public static void main(String[] args){
        /* characters array */
        char[] c;
        c = new char[4];
        c[0] = 'b';
        c[1] = 'l';
        c[2] = 'u';
        c[3] = 'e';

        int n;
        n = c.length;
        System.out.println(n);
        System.out.println(c[0]);

        /* int array*/
        int[] numbers = new int[]{4, 7, 10};
        System.out.println(numbers[1]);

    }

}
