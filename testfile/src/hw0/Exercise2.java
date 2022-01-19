package hw0;

public class Exercise2 {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int n = m.length;
        int i = 0;
        int maxnow = m[0];
        while (i < n){
            if(m[i] > maxnow){
                maxnow = m[i];
            }
            i ++;
        }
        return maxnow;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
    }
}
