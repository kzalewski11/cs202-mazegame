public class ListNode {
    private int [] score;
    private ListNode next;

    //default constructor
    public ListNode()
    {
        score = new int[2];
        next = null;
    }

    //constructor with passed in args
    public ListNode(int a, int b)
    {
        score = new int[2];
        score[0] = a;
        score[1] = b;
    }

    //go next function
    public ListNode goNext()
    {
        return next;
    }

    //set next function
    public void setNext(ListNode add) {
        next = add;
    }
}
