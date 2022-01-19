package hw0;

public class Forloop {
    public static int summ(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i ++){
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args){
        int[] numbers = new int[]{1,2,3,4};
        System.out.println(summ(numbers));
    }
}
