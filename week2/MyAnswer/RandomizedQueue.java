import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item>{

    /**
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
*/

    private Item[] randomq;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        randomq = (Item[]) new Object[1];
        size = 0;
    }
    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }
    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    //resize the array
    private void resize(int newsize) {
        Item[] temp = (Item[]) new Object[newsize];
        for(int i=0;i<size;i++) temp[i] = randomq[i];
        randomq = temp;
    }

    // add the item
    public void enqueue(Item item) {
        if (item==null) throw new java.lang.IllegalArgumentException("there is nothing");
        if(size==randomq.length) resize(2*size);
        randomq[size++] = item;

    }

    // remove and return a random item
    //exchange the chosen element with the last element
    //then,delete the last one
    //so that realize deleting the random element in the end of queue
    public Item dequeue() {
        //faster than call isEmpty()
        if(size==0) throw new java.util.NoSuchElementException("array is empty");
        int i = StdRandom.uniform(0,size);
        Item temp = randomq[i];
        // pay attention to the change of size
        if(i != --size) randomq[i] = randomq[size];
        randomq[size] = null;
        //here without n>0.wrong,try:add one,delete one
        if(size>0 && size==randomq.length/4) resize(randomq.length/2);
        return temp;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if(size==0) throw new java.util.NoSuchElementException("array is empty");
        return randomq[StdRandom.uniform(0,size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RandomIterator();
    }

    // inner class
    private class RandomIterator implements Iterator<Item>{
        // m is as index,just like the pointer in Deque
        private int m;
        private Item[] iterq;
        private RandomIterator() {
            iterq = (Item[])new Object[size];
            for(int i=0;i<size;i++) iterq[i] = randomq[i];
            //random order
            StdRandom.shuffle(iterq);
        }

        public boolean hasNext() {
            return m < size;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException("you mustn't do this!");
        }

        public Item next() {
            if(m>=size) throw new java.util.NoSuchElementException("no next element!");
            Item temp = iterq[m++];
            return temp;
        }
    }
    // unit testing (optional)
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        rq.enqueue("haha");
        rq.enqueue("heihei");
        rq.enqueue("hiahia");
        rq.enqueue("hehe");
        rq.enqueue("houhou");
        System.out.println(rq.size());
        rq.dequeue();
        rq.dequeue();

        Iterator<String> iter = rq.iterator();
        while(iter.hasNext()) System.out.println(iter.next());
        System.out.println();
        Iterator<String> iter2 = rq.iterator();
        while(iter2.hasNext()) System.out.println(iter2.next());
    }
}
