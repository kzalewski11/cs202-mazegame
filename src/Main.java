
public class Main {
    public static void main(String[] args)
    {
        //create new BST
        BST tree = new BST();

        //build BST
        tree.build();

        //begin player portion
        System.out.println("You've awoken at the start of a maze. Work your way through to the end. Good luck.");

        //game structure
        int score = tree.gameStart();

        //create score LLL
        List l = new List();
        ListNode one = new ListNode(score, 1);
        l.addNode(one);

        //create adjusted score entry to LLL
        ListNode two = new ListNode(score * 10, 2);
        l.addNode(two);

        //write score to external file
        l.writeList(score);

        //print score to user
        System.out.println("Your score is: " + score);

        //exit sequence
        System.out.println("Thank you for playing!");

        /* this section was for testing original data structure
        //display tree nodes
        System.out.println("Displaying all nodes in sorted order:");
        tree.display();

        //retrieve nodes by number
        System.out.println("Searching for nodes by number:");
        tree.retrieve(1);
        tree.retrieve(5);
        tree.retrieve(12);

        //retrieve all related nodes (same type of turn)
        System.out.println("Displaying groups of nodes with similar type:");
        tree.retrieveRelated(1);
        tree.retrieveRelated(2);
        tree.retrieveRelated(3);
        tree.retrieveRelated(4);

        //remove specific node from tree
        System.out.println("Removing nodes 8, 1, 5, 6, and 12 from tree:");
        tree.remove(8);
        tree.remove(1);
        tree.remove(5);
        tree.remove(6);
        tree.remove(12);

        //redisplay modified tree
        System.out.println("Displaying modified tree in sorted order:");
        tree.display();

        //remove all nodes from tree
        System.out.println("Deleting all nodes from tree:");
        boolean deleted = tree.removeAll();
        if(deleted == true)
            System.out.println("Tree was deleted.");
        else
            System.out.println("Tree was not deleted.");

        //display empty tree
        tree.display();*/
    }

}
