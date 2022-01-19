package hw0;

public class Exercise4 {
    public static void windowPosSum(int[] a, int n) {
        /** your code here */
        for(int i = 0;i < a.length;i++){
            if(a[i] > 0){
                int des = Math.min(i+n ,a.length-1);
                for(int k = i+1; k <= des; k++){
                    a[i] += a[k];
                }
            }
            else{
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}
