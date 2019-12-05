import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class List {
    private ListNode head;

    //default constructor
    public List()
    {
        head = null;
    }

    //wrapper for write function
    public void writeList(int n)
    {
        writeList(head, n);
    }

    //add node wrapper function
    public void addNode(ListNode add)
    {
        //if list is empty
        if(head == null) {
            head = add;
            return;
        }
        addNode(head, add);
    }

    //add node to list
    public void addNode(ListNode head, ListNode add)
    {
        //stopping condition
        if(head.goNext() == null) {
            head.setNext(add);
            return;
        }

        addNode(head.goNext(), add);
    }

    //recursively write list to file
    public void writeList(ListNode head, int n)
    {
        //stopping condition
        if(head == null)
           return;

        //write out data
        try{
            write(n);
        } catch (IOException x)
        {

        }

        //recursive call
        writeList(head.goNext(), n);
    }

    //send score to output file
    public void write(int n) throws IOException {
        String s = "Final Score: ";
        BufferedWriter b = new BufferedWriter(new FileWriter("scores.txt", true));
        PrintWriter w = new PrintWriter(b);
        w.append(s);
        w.write(Integer.toString(n));
        w.print("\n");
        w.close();
    }
}
