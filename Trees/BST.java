public class BST {
    
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
    public BST(){}
    
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
        return node;
    }
    public void populate(int[] nums)
    {
        for (int i = 0; i < nums.length; i++) {
            this.insertNode(nums[i]);
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
        BST tree=new BST();
        tree.populate(arr);
        tree.display();
        System.out.println();
        System.out.println("INORDER");
        inOrder(tree.rootNode);
        System.out.println();
        System.out.println("POSTORDER");
        postOrder(tree.rootNode);

    }
}
