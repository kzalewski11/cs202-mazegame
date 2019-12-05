public class BST {
    //root node of BST
    protected Node root;

    //default constructor
    public BST() {
        root = null;
    }

    //constructor with argument
    public BST(Node newRoot) {
        root = newRoot;
    }

    //game start wrapper
    public int gameStart()
    {
        return gameStart(root);
    }

    //game start returns score
    public int gameStart(Node root)
    {
        //display turn information
        root.display();


        //if current node is end
        if(root.getTurnType() == 3)
            return 0;

        //if current node is backToStart
        if(root.getTurnType() == 4)
            return gameStart(this.root) + 1;

        //if current node has a way out
        if(root.goLeft() != null || root.goRight() != null) {
            //recursively call function
            return gameStart(root.goNext()) + 1;
        }

        return 0;
    }

    //insert new node into tree
    public boolean insert(Node r, Node toAdd) {

        //if tree is empty
        if (r == null) {
            root = toAdd;
            return true;
        }

        //if tree is not empty
        //if new node is less than current
        if (r.nodeCompare(toAdd) == 1) {
            //if root has no left child
            if (r.goLeft() == null) {
                r.setLeft(toAdd);
                return true;
            }

            //recursive call down left side of tree
            return insert(r.goLeft(), toAdd);
        }

        //if new node is greater than or equal to current
        //if leaf has been reached
        if (r.goRight() == null) {
            r.setRight(toAdd);
            return true;
        }

        //if leaf node has not been reached
        return insert(r.goRight(), toAdd);
    }

    //display wrapper
    public void display() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        display(root);
    }

    //inorder display all nodes in tree recursively
    public void display(Node r) {
        //traverse tree left
        if (r.goLeft() != null)
            display(r.goLeft());

        //display root node
        r.display();

        //traverse tree right
        if (r.goRight() != null)
            display(r.goRight());
    }

    //retrieve node wrapper
    public boolean retrieve(int t) {
        //if tree is empty
        if(root ==null)
            return false;

        //if tree is not empty
        return retrieve(root, t);
    }

    //retrieve node with name passed in
    public boolean retrieve(Node r, int t) {
        //if current node is a match
        if(r.numCompare(t) == 0)
        {
            r.display();
            //continue down right to make sure there are no additional matches
            if(r.goRight() != null) {
                if(r.goRight().numCompare(t) == 0)
                    return retrieve(r.goRight(), t);
            }
            return true;
        }

        //if passed in node is greater than current
        if(r.numCompare(t) > 0)
        {
            if(r.goRight() != null)
                return retrieve(r.goRight(), t);
        }

        if(r.numCompare(t) < 0)
        {
            if(r.goLeft() != null)
                return retrieve(r.goLeft(), t);
        }

        //if no match is found
        return false;
    }

    //retrieve all related wrapper
    public void retrieveRelated(int t)
    {
        String type = numToType(t);
        System.out.println("Displaying all nodes of type " + type + ":");
        retrieveRelated(root, t);
    }
    //retrieve all nodes related to the passed in name
    public void retrieveRelated(Node r, int t) {

        //traverse tree left
        if(r.goLeft() != null)
            retrieveRelated(r.goLeft(), t);

        //display root node if related
        if(r.typeCompare(t) == true)
            r.display();

        //traverse right
        if(r.goRight() != null)
            retrieveRelated(r.goRight(), t);
    }

    //remove individual wrapper
    public boolean remove(int t)
    {
        //if tree is empty
        if(root == null)
            return false;

        //if root is a match
        if(root.numCompare(t) == 0) {
            //if tree only has one node
            if (root.goLeft() == null && root.goRight() == null) {
                root.delete();
                root = null;
                return true;
            }

            //if root only has right child
            if (root.goLeft() == null) {
                Node tmp = root.goRight();
                root.delete();
                root = tmp;
                return true;
            }

            //if root only has left child
            if(root.goRight() == null)
            {
                Node tmp = root.goLeft();
                root.delete();
                root = tmp;
                return true;
            }

            //if root has 2 children
            //set data in root to successors data
            root.setTurnNum(root.goRight().min().getTurnNum());
            //set successors parents left pointer to point to successors right child
            root.goRight().minParent().setLeft(root.goRight().min().goRight());
            return true;
        }

        //if root is not a match, call recursive function
        return remove(root, t);
    }
    //remove an individual item
    public boolean remove(Node r, int t) {
        //if data to be deleted is in left subtree
        if(r.numCompare(t) < 0)
            return remove(r.goLeft(), t);

        //if data to be deleted is in right subtree
        if(r.numCompare(t) > 0)
            return remove(r.goRight(), t);

        //if found
        //no child nodes case
        if(r.numSubs() == 0)
        {
            //delete node
            //if node to delete is less than parent
            if(r.getTurnNum() < root.parent(r).getTurnNum())
            {
                root.parent(r).setLeft(null);
                r.delete();
                return true;
            }

            //if node to delete is more than parent
            if(r.getTurnNum() > root.parent(r).getTurnNum()) {
                root.parent(r).setRight(null);
                r.delete();
                return true;
            }
        }

        //one child node case
        if(r.numSubs() == 1)
        {
            //if only right child
            if(r.goLeft() == null)
            {
                root.parent(r).setRight(r.goRight());
                r.delete();
                return true;
            }

            //if only left child
            if(r.goRight() == null)
            {
                root.parent(r).setLeft(r.goLeft());
                r.delete();
                return true;
            }
        }

        //two child nodes case
        if(r.numSubs() == 2) {
            //set data in root to successors data
            r.setTurnNum(r.goRight().min().getTurnNum());
            //set successors parents left pointer to point to successors right child
            r.goRight().minParent().setLeft(r.goRight().min().goLeft());
        }


        //if no match is found
        return false;
    }

    //remove all wrapper
    public boolean removeAll()
    {
        return removeAll(root);
    }

    //remove all
    public boolean removeAll(Node r) {
        //if tree is empty
        if(r == null)
            return false;

        //if tree is not empty
        //traverse tree left
        if(r.goLeft() != null)
            removeAll(r.goLeft());

        //traverse tree right
        if(r.goRight() != null)
            removeAll(r.goRight());

        r.delete();
        root = null;
        return true;
    }



    //number to type conversion function
    public String numToType(int t)
    {
        switch (t)
        {
            case 1:
                return "Decision";
            case 2:
                return "Chance";
            case 3:
                return "End Game";
            case 4:
                return "Back To Start";
            default:
                return "Invalid Type";
        }
    }

    //build test decision tree
    public void build() {
        //create new nodes for maze
        Decision start = new Decision(8);
        Chance chance1 = new Chance(4);
        Chance chance2 = new Chance(2);
        BackToStart bts1 = new BackToStart(1);
        BackToStart bts2 = new BackToStart(3);
        Decision dec1 = new Decision(6);
        End end1 = new End(5);
        BackToStart bts3 = new BackToStart(7);
        Decision dec2 = new Decision(12);
        Chance chance3 = new Chance(10);
        BackToStart bts4 = new BackToStart(9);
        BackToStart bts5 = new BackToStart(11);
        Decision dec3 = new Decision(14);
        End end2 = new End(13);
        BackToStart bts6 = new BackToStart(15);

        //add nodes to tree in desired test order
        insert(root, start);
        insert(root, chance1);
        insert(root, chance2);
        insert(root, bts1);
        insert(root, bts2);
        insert(root, dec1);
        insert(root, end1);
        insert(root, bts3);
        insert(root, dec2);
        insert(root, chance3);
        insert(root, bts4);
        insert(root, bts5);
        insert(root, dec3);
        insert(root, end2);
        insert(root, bts6);
    }
}
