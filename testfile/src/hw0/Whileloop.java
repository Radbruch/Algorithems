package hw0;

public class Whileloop {
    public static void main(String[] args){
        int bottles = 99;
        while (bottles > 0){
            System.out.println(bottles + " bottles of beer on the wall");
            bottles -= 1;
        }
    }
}
