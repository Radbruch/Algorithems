package MyAnswer;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedQueue<Item> implements Iterable<Item>{

    private class Stuffnode{
        private Item item;
        private Stuffnode next;
        private Stuffnode prev;

        private Stuffnode(Stuffnode prevnode, Item itemnode, Stuffnode nextnode){
            item = itemnode;
            next = nextnode;
            prev = prevnode;
        }
    }

    private Stuffnode sentinel;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue(){
        sentinel = new Stuffnode(sentinel, null, sentinel);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    // is the randomized queue empty?

    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the randomized queue

    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        if (item == null) {
            throw new IllegalArgumentException("Can't add null to queue");
        } else {
            Stuffnode newnode = new Stuffnode(sentinel.prev, item, sentinel);
            sentinel.prev.next = newnode;
            sentinel.prev = newnode;
            size++;
        }
    }

    private Stuffnode randomnode(){
        Stuffnode pointer = sentinel;
        int randomNum = ThreadLocalRandom.current().nextInt(1, size() + 1);
        for (int i = 0; i < randomNum; i++){
            pointer = pointer.next;
        }
        return pointer;
    }

    // remove and return a random item
    public Item dequeue(){
        if (size() == 0) {
            throw new NoSuchElementException("Queue is empty now");
        } else {

            Stuffnode outnode = randomnode();
            Item outitem = outnode.item;
            outnode.prev.next = outnode.next;
            outnode.next.prev = outnode.prev;
            size--;
            return outitem;
        }
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if (size() == 0) {
            throw new NoSuchElementException("Queue is empty now");
        } else {
            return randomnode().item;
        }
    }

    private class Itr implements Iterator<Item>{
        private Stuffnode randomsentinel;
        private int numLeft;

        private Stuffnode randomOrderDeque(){
            numLeft = size();
            randomsentinel = new Stuffnode(randomsentinel, null, randomsentinel );
            randomsentinel.next = randomsentinel;
            randomsentinel.prev = randomsentinel;

            while (size() > 0){
                Item randomitem = dequeue();
                Stuffnode newnode = new Stuffnode(randomsentinel.prev, randomitem, randomsentinel);
                randomsentinel.prev.next = newnode;
                randomsentinel.prev = newnode;
            }
            size = numLeft;
            sentinel = randomsentinel;
            return sentinel;
        }

        private Stuffnode iterationdeque = randomOrderDeque();

        private int nextNode = 0;
        private Stuffnode pointer = iterationdeque;

        public boolean hasNext() {
            return nextNode < size();
        }

        public Item next() {
            if (!hasNext()){
                nextNode = 0;
                pointer = iterationdeque;
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


    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new Itr();
    }

    // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<Integer> x = new RandomizedQueue<>();
        x.enqueue(1);
        x.enqueue(2);
        x.enqueue(3);
        x.enqueue(4);
        x.enqueue(5);
        x.enqueue(6);
        x.enqueue(7);
        x.enqueue(8);
        x.enqueue(9);
        x.enqueue(10);
        Iterator y = x.iterator();
        while (y.hasNext()) {
            System.out.println(y.next());
        }
    }
}
