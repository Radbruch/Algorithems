package hw0;

public class Exercise3 {
    public static int summm(int[] m){
        int sum = 0;
        for (int i = 0; i < m.length;i++){
            sum += m[i];
        }
        return sum;
    }

    public static void main(String[] args){
        int[] number = new int[]{1, 2, 3, 4};
        System.out.println(summm(number));
    }
}
