public class BackToStart extends Node{
    //default constructor
    public BackToStart(int turnNum)
    {
        super(turnNum, 4);
    }
    //derived class specific display function
    @Override public void display()
    {
        //display decision information
        //System.out.println("Node #" + turnNum);
        System.out.println("You are lost. Returning to beginning of maze.\n");
    }

    //backtoStart goNext function
    @Override public Node goNext()
    {
        return this;
    }
}
