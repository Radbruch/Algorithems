/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;

public class RandomWord {
    private static String RandomWord(){
        Scanner sc = new Scanner(System.in);
        String winner = sc.next();
        int n = 1;
        double probability = 0;
        while (!sc.hasNext()) {
            String constent = sc.next();
            probability = Math.random();
            n += 1;
            if (probability <= 1.0 / n) {
                winner = constent;
            }
        }
        return winner;
    }
    public static void main(String[] args) {
        System.out.println(RandomWord());
    }
}
