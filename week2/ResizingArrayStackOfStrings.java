package week2;

public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N = 0;

    public ResizingArrayStackOfStrings(){
        s = new String[1];
    }

    public  void push(String item){
        if (s[0] == null) {
            s[N] = item;}
        else if (N+1 == s.length) {
            resize( 2 * s.length);
            N++;
            s[N] = item;
        }
        else {
            N++;
            s[N] = item;}

    }

    public String pop() {
        if (s[0] == null && N == 0){ throw new ArrayIndexOutOfBoundsException();}
        else {
            String popstring = s[N];
            s[N] = null;
            N--;
            if (N + 1 == s.length / 4) {
                resize(s.length / 4);
            }
            return popstring;
        }
    }

    private void resize(int capacity){
        String[] copy = new String[capacity];
        for (int i = 0; i <= N; i++)
            copy[i] = s[i];
        s = copy;
    }
}
