public class AVL {
    
    private static class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;
        Node(int value)
        {
            this.value=value;
        }
        public int getValue()
        {
            return value;
        }
    }
    private Node rootNode;
    public AVL(){}
    public int height()
    {
        return height(rootNode);
    }
    public int height(Node node)
    {
        if(node==null)
        {
            return -1;
        }
        return node.height;
    }
    public void insertNode(int value)
    {
        rootNode=insertNode(rootNode,value);
    }
    private Node insertNode(Node node,int value)
    {
        if(node==null)
        {
            node=new Node(value);
            return node;
        }
        if(value<node.value)
        {
            node.left=insertNode(node.left, value);
        }
        if(value>node.value)
        {
            node.right=insertNode(node.right, value);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return rotate(node);
    }
    private Node rotate(Node node) {
        if(height(node.left)-height(node.right)>1)
        {
            //LEFT HEAVY TREE(L-L)
            if(height(node.left.left)-height(node.left.right)>0)
            {
                return rightRotate(node);
            }
            //LEFT HEAVY TREE(L-R)
            if(height(node.left.left)-height(node.left.right)<0)
            {
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(height(node.left)-height(node.right)<-1)
        {
            //LEFT HEAVY TREE(L-L)
            if(height(node.right.right)-height(node.right.left)>0)
            {
                return leftRotate(node);
            }
            //LEFT HEAVY TREE(L-R)
            if(height(node.right.right)-height(node.right.left)<0)
            {
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private AVL.Node rightRotate(AVL.Node p) {
        Node c=p.left;
        Node t=c.right;
        c.right=p;
        p.left=t;
        c.height=Math.max(height(c.left), height(c.right))+1;
        p.height=Math.max(height(p.left), height(p.right))+1;
        return c;
    }

    private AVL.Node leftRotate(AVL.Node p) {
        Node c=p.right;
        Node t=c.left;
        c.left=p;
        p.right=t;
        c.height=Math.max(height(c.left), height(c.right))+1;
        p.height=Math.max(height(p.left), height(p.right))+1;
        return c;
    }

    public void populate()
    {
        for (int i = 0; i < 1000; i++) {
            this.insertNode(i);
        }
    }
    public void display() {
        display(this.rootNode, "Root Node: ");
    }
    
    private void display(Node node, String details) {
        if (node == null) {
          return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }
    
    public static void preOrder(Node node)
    {
        if(node==null)
        {
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node)
    {
        if(node==null)
        {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
    public static void postOrder(Node node)
    {
        if(node==null)
        {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
    public static void main(String[] args) {
        int[] arr={5,7,19,8,6,2,3,71,36};
        AVL tree=new AVL();
        for(int i=0; i < 1000; i++) {
            tree.insertNode(i);
          }
        System.out.println(tree.height());

    }
}

