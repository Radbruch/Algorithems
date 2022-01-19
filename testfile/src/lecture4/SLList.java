package lecture4;
import lecture8.List61B;

public class SLList<T> implements List61B<T>{

    private class IntNode {
        public T item;
        public IntNode next;

        public IntNode(T i, IntNode n){
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next */
    private IntNode sentinel;
    private int size;
    private IntNode sentBack;

    /* Creates an empty SLList. */
    public SLList(){
        sentinel = new IntNode(null,null);
        sentBack = new IntNode(null,null);
        sentinel.next = sentBack;
        size = 0;
    }
    public SLList(T x){
        sentinel = new IntNode(null,null);
        sentinel.next = new IntNode(x, null);
        sentBack = new IntNode(null, null);
        sentinel.next.next = sentBack;
        size = 1;
    }

    @Override
    public void addFirst(T x){
        sentinel.next = new IntNode(x,sentinel.next);
        size += 1;
    }

    @Override
    public T getFirst(){
        return sentinel.next.item;
    }

    @Override
    public void insert(T x, int position){
        IntNode newNode = new IntNode(x,null);
        if (position == 0){
            newNode.next = sentinel.next;
            sentinel.next = newNode;
        }
        else {
            IntNode p = sentinel;
            int i = 0;
            while (i < position) {
                i++;
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T x){
        insert(x, size());
    }

    @Override
    public T getLast(){
        return get(size()-1);
    }

    @Override
    public T get(int position){
        IntNode p = sentinel;
        int i = 0;
        while (i <= position){
            p = p.next;
            i++;
        }
        return p.item;
    }

    @Override
    public T removeLast(){
        if (size() == 0) {
            throw new ArrayIndexOutOfBoundsException("list is empty now");
        }
        else {
            IntNode p = sentinel;
            int i = 1;
            while (i < size()) {
                p = p.next;
                i++;
            }
            T olditem = p.next.item;
            p.next = sentBack;
            size--;
            return olditem;
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void print() {
        if (size() == 0) {
            throw new ArrayIndexOutOfBoundsException("list is empty now");
        } else {
            IntNode p = sentinel;
            for (int i = 0; i < size(); i++) {
                p = p.next;
                System.out.println(p.item + "");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        SLList x = new SLList();
        x.addFirst(4);
        x.addFirst(3);
        x.addFirst(2);
        x.addFirst(1);
        x.addLast(5);
        x.removeLast();
        x.removeLast();
    }
}
