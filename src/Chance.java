import java.util.Random;

public class Chance extends Node {
    //default constructor
    public Chance(int turnNum) {
        super(turnNum, 2);
    }

    //derived class specific display function
    @Override
    public void display() {
        //display decision information
        //System.out.println("Node #" + turnNum);
        System.out.println("This space is a chance\n");
    }

    @Override public Node goNext() {
        Random r = new Random();
        int random = r.nextInt(2) + 1;

        if (random == 1)
        {
            System.out.println("You feel an overwhelming force move you uncontrollably to the left corridor...\n");
            return left;
        }

        System.out.println("You feel an overwhelming force move you uncontrollably to the right corridor...\n");
        return right;
    }

}
