package hw0;

public class Switch {
    public static void main(String[] args){
        int month = 12;
        switch(month){
            case 12:
                System.out.println("It's December");
                break;
            case 1:
            case 2:
            case 11:
                System.out.println("It's cold");
                break;
            default:
                System.out.println("It's warm");
                break;
        }
    }
}
