package week2.MyAnswer;

import java.util.Iterator;
import java.util.Scanner;

public class Permutation {

    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        RandomizedQueue x = new RandomizedQueue();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String nextitem = in.next();
            x.enqueue(in.next());
        }
        Iterator y = x.iterator();
        for (int i = 0; i < n; i++){
            System.out.println(y.next());
        }


    }
}
