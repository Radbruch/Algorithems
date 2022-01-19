package lecture9;

import lecture4.SLList;

public class VengefulSLList<T> extends SLList<T> {

    private SLList<T> deletedItems;

    public VengefulSLList(){
        super();
        deletedItems = new SLList<T>();
    }

    public VengefulSLList(T x){
        super(x);
        deletedItems = new SLList<>();
    }

    @Override
    public T removeLast(){
        T olditem = super.removeLast();
        deletedItems.addLast(olditem);
        return olditem;
    }


    /** Prints deleted items. */
    public void printLostItem(){
        deletedItems.print();
    }

    public static void main(String[] args){
        VengefulSLList x = new VengefulSLList(6);
        x.addFirst(5);
        x.addFirst(4);
        x.addFirst(3);
        x.addFirst(2);
        x.addFirst(1);
        x.removeLast();
        x.removeLast();
        x.printLostItem();
    }
}
