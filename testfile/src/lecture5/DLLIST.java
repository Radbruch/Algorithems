package lecture5;

public class DLLIST<ItemType> {


    private class StuffNode {
        public ItemType item;
        public StuffNode prev;
        public StuffNode next;


        public StuffNode(StuffNode prevnode, ItemType i, StuffNode nextnode) {
            item = i;
            prev = prevnode;
            next = nextnode;
        }
    }

    private StuffNode sentinel;
    private int size;

    public DLLIST(){
        sentinel = new StuffNode(sentinel,null, sentinel);
        size = 0;
    }

    public DLLIST(ItemType x){
        sentinel = new StuffNode(sentinel, null, sentinel);
        sentinel.next = new StuffNode(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(ItemType x){
        StuffNode NewNode = new StuffNode(sentinel, x, sentinel.next);
        sentinel.next.prev = NewNode;
        sentinel.next = NewNode;
        size++;

    }

    public ItemType getFirst(){
        return sentinel.next.item;
    }

    public void addLast(ItemType x){
        StuffNode NewNode = new StuffNode(sentinel.prev, x, sentinel);
        sentinel.prev.next = NewNode;
        sentinel.prev = NewNode;
        size++;
    }

    public ItemType getLast(){
        return sentinel.prev.item;
    }

    public ItemType removeLast(){
        ItemType removeitem = getLast();
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return removeitem;
    }
    public static void main(String[] args){
        DLLIST x = new DLLIST(5);
        x.addFirst(4);
        x.addLast(6);
        System.out.println(x.sentinel.next.item);
        System.out.println(x.sentinel.prev.item);
        System.out.println(x.sentinel.next.next.item);
        System.out.println(x.sentinel.next.next.next.item);
        System.out.println(x.getFirst());
        System.out.println(x.getLast());
        System.out.println(x.size);
    }
}
