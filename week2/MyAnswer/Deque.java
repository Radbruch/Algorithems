package MyAnswer;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {

    private int size;
    private Stuffnode sentinel;


    private class Stuffnode{
        private Item item;
        private Stuffnode next;
        private Stuffnode prev;

        private Stuffnode(Stuffnode prevnode, Item itemnode, Stuffnode nextnode){
            item = itemnode;
            prev = prevnode;
            next = nextnode;
        }

    }
    // construct an empty deque
    public Deque(){
        sentinel = new Stuffnode(sentinel, null, sentinel);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    // is the deque empty?

    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the deque

    public int size(){
        return size;
    }

    // add the item to the front

    public void addFirst(Item item){
        if(item == null) {
            throw new IllegalArgumentException("Can't add null to deque");
        }
        else {
            Stuffnode newNode = new Stuffnode(sentinel, item, sentinel.next);
            sentinel.next.prev = newNode;
            sentinel.next = newNode;
            size++;
        }
    }

    // add the item to the back

    public void addLast(Item item){
        if(item == null) {
            throw new IllegalArgumentException("Can't add null to deque");
        }
        else {
            Stuffnode newnode = new Stuffnode(sentinel.prev, item, sentinel);
            sentinel.prev.next = newnode;
            sentinel.prev = newnode;
            size++;
        }
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty");
        }
        else {
            Item olditem = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return olditem;
        }
    }

    // remove and return the item from the back
    public Item removeLast(){
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty");
        }
        else {
            Item olditem = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            return olditem;
        }
    }

    // return an iterator over items in order from front to back


    private class Itr implements Iterator<Item> {

        private int nextNode = 0;
        private Stuffnode pointer = sentinel;

        public boolean hasNext() {
            return nextNode < size();
        }

        public Item next() {
            if (!hasNext()){
                nextNode = 0;
                pointer = sentinel;
                throw new NoSuchElementException("It's the end of the deque");
            }
            pointer = pointer.next;
            Item thisitem = pointer.item;
            nextNode++;

            return thisitem;
        }

        public void remove() {
            throw new UnsupportedOperationException("[INFO] removal is not allowed");
        }
    }


    public Iterator<Item> iterator() {
        return new Itr();
    }

    // unit testing (required)
    public static void main(String[] args){
        Deque<Integer> x = new Deque<>();
        x.addFirst(5);
        x.addFirst(4);
        x.addFirst(3);
        x.addFirst(2);


        x.removeFirst();
        x.removeFirst();
        x.removeLast();
        x.removeLast();

        x.addFirst(1);
        Iterator y = x.iterator();
        while (y.hasNext()) {
            System.out.println(y.next());
        }
    }

}
