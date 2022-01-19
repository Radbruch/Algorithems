package lecture5;

import lecture8.List61B;

/** array based list
 * author Radbruch Zhou
 */
// example:
// i:      0 1 2  3 4 5 6 7
// alist: [5 7 1 -3 8 9 0 0]
// size(): 8
// getLast(): 9
// get(3): -3



public class AList<T> implements List61B<T>{

    private int head;
    private int tail;
    private T alist[];

    public AList(){
        alist = (T[]) new Object[1];
        head = 0;
        tail = -1;
    }

    public AList(T x){
        alist = (T[]) new Object[]{x};
        head = 0;
        tail = 0;
    }

    @Override
    public void insert(T x, int position) {
        if (size() == 0 && position == 0){
            alist[0] = x;
            tail = 0;
        } else {
            T[] newlist = (T[]) new Object[alist.length + 1];
            System.arraycopy(alist, 0, newlist, 0, position);
            newlist[position] = x;
            System.arraycopy(alist, position, newlist, position + 1, alist.length - position);
            alist = newlist;
            tail++;
        }
    }

    @Override
    public void addFirst(T x){
        insert(x,0);

    }

    @Override
    public T getFirst(){
        return get(0);
    }

    @Override
    public void addLast(T x){
    // the next item we want to add.
        if (tail == -1){
            alist[0] = x;
            tail = 0;
        }
        else {
            if (tail+1 == alist.length) {
                resize(alist.length * 2);
            }
                tail++;
                alist[tail] = x;
        }
    }


    private void resize(int length){
        T[] resizearray = (T[]) new Object[length];
        System.arraycopy(alist,head,resizearray,0,tail+1);
        alist = resizearray;
        tail = tail - head;
        head = 0;
    }

    @Override
    public T removeLast(){
        if (tail == -1){throw new IllegalArgumentException("alist is empty");}
        T olditem = alist[tail];
        alist[tail] = null;
        tail--;
        if (tail - head + 1 == alist.length/4){
            resize(alist.length/4);
        }
        return olditem;
    }

    @Override
    public T getLast(){
        // return the last item we had added in array.
        if (tail == -1) throw new ArrayIndexOutOfBoundsException("alist is empty");
        return alist[tail];
    }

    @Override
    public T get(int i) {
        // return the i-th position item.
        if (i >= tail+1){throw new ArrayIndexOutOfBoundsException();}
        else {return alist[i];}
    }

    @Override
    public int size(){
        // return the size of array
        return tail-head+1;
    }

    public static void main(String[] args){
    }
}
