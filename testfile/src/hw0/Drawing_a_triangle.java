package hw0;

public class Drawing_a_triangle {
    public static String cha = "*";
    public static int i = 1;
    public static void drawTriangle(int n){
        while ( i <= n){
            System.out.println(cha);
            i ++;
            cha = cha + "*";
        }

    }

    public static void main(String[] args){
        drawTriangle(10);
    }
}
