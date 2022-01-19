package lecture2;

public class Dog {
    public int weightInPounds;

    /** One interger Constructor for dogs. */
    public Dog(int w){
        weightInPounds = w;
    }

    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yipyipyip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark!");
        } else {
            System.out.println("woooof!");
        }
    }
}
