package MyAnswer;


import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedQueue<Item> implements Iterable<Item>{

    private Random rand;
    private Deque<Item> deck;

    // construct an empty randomized queue
    public RandomizedQueue() {
        deck = new Deque<>();
        rand = new Random();
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return deck.isEmpty();
    }

    // return the number of items on the randomized queue
    public int size() {
        return deck.size();
    }

    // add the item
    public void enqueue(Item item) {
        deck.addLast(item);
    }

    // remove and return a random item
    public Item dequeue() {
        int index = rand.nextInt(size());
        return deck.remove(index);
    }

    // return a random item (but do not remove it)
    public Item sample() {
        int index = rand.nextInt(size());
        return deck.get(index);
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Item> {
        private Deque<Integer> indexList = new Deque<>();

        private Itr() {
            initializeIndex();
        }

        private void initializeIndex() {
            for (int i = 0; i < deck.size(); i++) {
                indexList.addLast(i);
            }
        }

        @Override
        public boolean hasNext() {
            return !(indexList.size() == 0);
        }

        @Override
        public Item next() {
            int index = rand.nextInt(indexList.size());
            Item item = deck.get(indexList.get(index));
            indexList.remove(indexList.get(index));
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue x = new RandomizedQueue();
        x.enqueue(3);
        x.enqueue(4);
        x.enqueue(5);
        x.enqueue(6);


        Iterator y = x.iterator();
        while (y.hasNext()) {
            System.out.println(y.next());
        }
    }

/**
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
    }*/
}
