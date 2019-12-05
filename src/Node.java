public abstract class Node {
    protected int turnNum;            //identifier for adding into BST
    protected int turnType;           //identifier for turn type (derived class)
    protected Node left;              //left pointer
    protected Node right;             //right pointer

    //default constructor
    public Node()
    {
        left = null;
        right = null;
        turnNum = 0;
        turnType = 0;
    }

    //constructor with arguments
    public Node(int turnN, int turnT)
    {
        left = null;
        right = null;
        turnNum = turnN;
        turnType = turnT;
    }

    //left getter
    public Node goLeft()
    {
        return left;
    }

    //right getter
    public Node goRight() {
        return right;
    }

    //turnNum getter
    public int getTurnNum()
    {
        return turnNum;
    }

    //turnType getter
    public int getTurnType()
    {
        return turnType;
    }

    //left setter
    public void setLeft(Node newLeft)
    {
        left = newLeft;
    }

    //right setter
    public void setRight(Node newRight)
    {
        right = newRight;
    }

    //turnNum setter
    public void setTurnNum(int n)
    {
        turnNum = n;
    }

    //node comparison function
    public int nodeCompare(Node toCompare)
    {
        //if current object is lower value than passed in object
        if(turnNum < toCompare.turnNum)
            return -1;

        //if objects are equal
        if(turnNum == toCompare.turnNum)
            return 0;

        //if current object is greater than passed in object
        return 1;
    }

    //return min node in subtree
    public Node min()
    {
        if(left != null)
            return left.min();

        return this;
    }

    //retrieve parent node of passed in node
    public Node parent(Node child) {
        //if current is less than child
        if(turnNum < child.getTurnNum()) {
            if (right != child)
                return right.parent(child);
            return this;
        }

        //if current is more than child
        if(turnNum > child.getTurnNum()) {
            if (left != child)
                return left.parent(child);
            return this;
        }
        //if current node is a match
        return this;
    }

    //return parent to min node in subtree
    public Node minParent()
    {
        if(left.goLeft() == null)
            return this;

        return left.minParent();
    }

    //int function to tell calling method how many subtrees node has
    public int numSubs()
    {
        if(left == null && right == null)
            return 0;
        if(left != null && right != null)
            return 2;
        return 1;
    }

    //Node number comparison (for traversing tree to look for a specific value)
    public int numCompare(int n)
    {
        if(turnNum < n)
            return 1;
        if(turnNum == n)
            return 0;
        return -1;
    }

    //compare object types
    public boolean typeCompare(int n)
    {
        //if passed in type is same as current object type
        if(turnType == n)
            return true;

        //if not same type
        return false;
    }


    //zero out node
    public void delete()
    {
        left = null;
        right = null;
        turnNum = 0;
        turnType = 0;
    }

    //abstract display function
    public abstract void display();

    //abstract goNext function
    public abstract Node goNext();
}
