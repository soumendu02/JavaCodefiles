import java.util.*;;
public class Binarytree {
    public Binarytree(){}
    private static class Node{
        int value;
        Node left;
        Node right;
    
        Node(int value)
        {
            this.value=value;
        }
    }
    private Node root;
    public void insertNodes(Scanner sc)
    {
        System.out.println("Enter value of root node-->");
        int val=sc.nextInt();
        root=new Node(val);
        populate(sc,root);
    }
    private void populate(Scanner sc, Node node) {
        System.out.println("Do u want to insert at left");
        boolean left=sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of left node-->");
            int val=sc.nextInt();
            node.left=new Node(val);
            populate(sc, node.left);
        }
        System.out.println("Do u want to insert at right");
        boolean right=sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of right node-->");
            int val=sc.nextInt();
            node.right=new Node(val);
            populate(sc, node.right);
        }
    }
    public void prettyDisplay() {
        prettyDisplay(root, 0);
      }
    
      private void prettyDisplay(Node node, int level) {
        if (node == null) {
          return;
        }
    
        prettyDisplay(node.right, level + 1);
    
        if (level != 0) {
          for (int i = 0; i < level - 1; i++) {
            System.out.print("|\t");
          }
          System.out.println("|------->" + node.value);
        } else {
          System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
      }


      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Binarytree tree = new Binarytree();
        tree.insertNodes(scanner);
        tree.prettyDisplay();
      }
}
