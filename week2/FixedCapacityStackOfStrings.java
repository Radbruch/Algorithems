package week2;

public class FixedCapacityStackOfStrings<Item>{
    private Item[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity){
        s = (Item[]) new Object[capacity]; // new Item[capacity];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(Item item){
        N++;
        s[N] = item;
    }

    public Item pop(){
        N--;
        Item item = s[N];
        s[N] = null; // this version avoids 'loitering'.
                     // garbage collector can reclaim memory only if no outstanding reference.
        return item;
    }
}
