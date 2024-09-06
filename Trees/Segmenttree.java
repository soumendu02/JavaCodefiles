public class Segmenttree {
    public class Node
    {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
        
    }
    Node root;
    public Segmenttree(int[] arr){
        this.root=constructTree(arr,0,arr.length-1);
    }
    private Segmenttree.Node constructTree(int[] arr, int start, int end) {
        //LEAF NODE
        if(start==end)
        {
            Node leaf=new Node(start, end);
            leaf.data=arr[start];
            return leaf;
        }
        //CREATE NEW NODE WITH INDEX YOU ARE AT
        Node node=new Node(start,end);
        int mid=(start+end)/2;
        node.left=constructTree(arr, start, mid);
        node.right=constructTree(arr, mid+1, end);
        node.data=node.left.data+node.right.data;
        return node;
    }
    public int query(int qsi,int qei)
    {
        return query(root,qsi,qei);
    }
    private int query(Node node,int qsi,int qei)
    {
        if(node.startInterval>=qsi && node.endInterval<=qei)
        {
            return node.data;
        }
        else if(node.startInterval>qei || node.endInterval<qsi)
        {
            return 0;
        }
        else
        {
            int left= query(node.left,qsi,qei);
            int right=query(node.right,qsi,qei);
            return left+right;
        }
    }
    public void display() {
        display(this.root);
      }
      private void display(Node node) {
        String str = "";
    
        if(node.left != null) {
          str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => "; 
        } else {
          str = str + "No left child";
        }
    
        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= "; 
        
        if(node.right != null) {
          str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data; 
        } else {
          str = str + "No right child";
        }
    
        System.out.println(str + '\n');
    
        // call recursion
        if(node.left != null) {
          display(node.left);
        }
    
        if(node.right != null) {
          display(node.right);
        }
      }
    // UPDATE 
    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }
    private int update(Node node, int index, int value) {
        if (index >= node.startInterval&& index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
    Segmenttree tree = new Segmenttree(arr);
    

    System.out.println(tree.query(1, 6));
    }
}
