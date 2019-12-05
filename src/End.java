public class End extends Node{
    //default constructor
    public End(int turnNum)
    {
        super(turnNum, 3);
    }
    //derived class specific display function
    @Override public void display()
    {
        //display decision information
        //System.out.println("Node #" + turnNum);
        //System.out.println("You have reached the end of the maze!\n");
        System.out.println("You have reached the end of the maze! Congratulations!\n");
    }

    //end goNext function
    @Override public Node goNext()
    {
        return this;
    }
}
