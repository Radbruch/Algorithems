package week2;

public class ResizingArrayQueueOfStrings {
    private String s[];
    private int head = 0;
    private int tail = 0;

    public ResizingArrayQueueOfStrings(){
        s = new String[1];
    }
    public void push(String item){
        if (head == tail && s[tail] == null){
            s[tail] = item;
        }
        else {
            if (tail + 1 == s.length) {
                resize(2 * s.length);
            }
            tail++;
            s[tail] = item;
        }
    }

    public String pop(){
        if ( head == tail && s[head] == null){
            throw new IllegalArgumentException("Array is empty");
        }
        String oldstring = s[head];
        s[head] = null;
        head++;
        if (tail - head + 1 == s.length/4){
            resize(s.length/4);
        }
        return oldstring;
    }

    private void resize(int capacity){
        String[] copy = new String[capacity];
        for (int i = 0; i <= tail-head; i++){
            copy[i] = s[i+head];}
        s = copy;
        tail = tail - head;
        head = 0;

    }
}
