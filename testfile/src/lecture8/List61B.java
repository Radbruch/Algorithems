package lecture8;

public interface List61B<T> {
    public void addLast(T x);
    public T getLast();
    public T get(int i);
    public int size();
    public T removeLast();
    public void insert(T x, int position);
    public void addFirst(T x);
    public T getFirst();
    default public void print(){
        for (int i = 0; i < size(); i++){
            System.out.println(get(i) + " ");
        }
        System.out.println();
    }
}
