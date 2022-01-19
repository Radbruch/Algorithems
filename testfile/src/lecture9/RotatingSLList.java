package lecture9;

import lecture4.SLList;

public class RotatingSLList<T> extends SLList<T> {


    /* Rotates list to the right. */
    public void rotateRight(){
        T olditem = (T) removeLast();
        addFirst(olditem);
    }


    public static void main(String[] args){
        RotatingSLList x = new RotatingSLList();
        x.addFirst(4);
        x.addFirst(3);
        x.addFirst(2);
        x.addFirst(1);
        x.addLast(0);
        x.rotateRight();
    }
}
