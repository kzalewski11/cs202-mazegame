import java.util.Scanner;

public class Decision extends Node{
    //default constructor
    public Decision(int turnNum)
    {
        super(turnNum, 1);
    }
    //derived class specific display function
    @Override public void display()
    {
        //display decision information
        //System.out.println("Node #" + turnNum);
        System.out.println("This space is a decision\n");

    }

    //decision I/O function
    @Override public Node goNext()
    {
        //get user choice
        Scanner in = new Scanner(System.in);
        System.out.print("Would you like to move left or right?\n");
        String choice;

        do {
            choice = in.next();
            if (choice.equals("left"))
                return left;

            if (choice.equals("right"))
                return right;
        } while(!choice.equals("left") && !choice.equals("right"));

        return left;
    }
}
