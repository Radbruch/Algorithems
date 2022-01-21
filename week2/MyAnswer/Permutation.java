

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Permutation {

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        RandomizedQueue randomDeck = new RandomizedQueue();

        String string;
        while (!StdIn.isEmpty()) {
            string = StdIn.readString();
            randomDeck.enqueue(string);
        }
        Iterator y = randomDeck.iterator();
        for (int i = 0; i < n; i++){
            StdOut.println(y.next());
        }


    }
}
