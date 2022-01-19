

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args){
        Stack<String> ops = new Stack<String>();
        Stack<Integer> vals = new Stack<Integer>();
        while (StdIn.isEmpty() == false){
            String s = StdIn.readString();
            if (s.equals("(")) {}
            else if (s.equals("+")) {ops.push(s);}
            else if (s.equals("*")) {ops.push(s);}
            else if (s.equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
            }
            else vals.push(Integer.parseInt(s));
        }
        StdOut.println(vals.pop());
    }
}
