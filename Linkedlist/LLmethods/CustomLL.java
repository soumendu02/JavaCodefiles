package Linkedlist.LLmethods;

public class CustomLL {
    private Node head;
    private Node tail;
    private int size;
    public CustomLL(){
        this.size=0;
    }
    //GET NODE BY VALUE
    public Node getNodeByValue(int val){
        Node temp=head;
        while(temp!=null)
        {
            if(temp.value==val)
            {
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    //GET NODE BY INDEX
    public Node getNodeByIndex(int index)
    {
        Node node=head;
        for(int i=0;i<index;i++)
        {
            node=node.next;
        }
        return node;
    }
    //INSERT AT THE BEGINNING OF A LL
    public void insertAtStart(int val){
        Node newnode=new Node(val);
        newnode.next=head;
        head=newnode;
        if(tail==null)
        {
            tail=newnode;
        }
        size++;
    }
    //INSERT AT THE END OF LL
    public void insertAtEnd(int val){
        Node newnode=new Node(val);
        if(tail==null){insertAtStart(val);}
        else{tail.next=newnode;tail=newnode;}
        size++;
    }
    //INSERT AT ANY POSITION
    public void insertAtAnyPos(int val,int index)
    {
        if(index==size-1){
            insertAtEnd(val);
        }
        if(index==0)
        {
            insertAtStart(val);
        }
        else{
            Node temp=head;
            for(int i=1;i<index;i++){
                temp=temp.next;
            }
            Node newnNode=new Node(val,temp.next);
            temp.next=newnNode;
            size++;
        }
    }
    //DELETE AT FIRST
    public int deleteAtFirst()
    {
        int val=head.value;
        head=head.next;
        return val;
    }
    //DELETE AT END
    public int deleteAtend(){
        int val = tail.value;
        Node secondLastNode=getNodeByIndex(size-1);
        tail=secondLastNode;
        tail.next=null;
        return val;
    }
    //DELETE AT ANY POSITION
    public int deleteAtAnyPos(int index)
    {
        if(index==0){deleteAtFirst();}
        else if (index==size-1) {
            deleteAtend();
        }
        Node prevNode=getNodeByIndex(index-1);
        int val=prevNode.next.value;
        prevNode.next=prevNode.next.next;
        return val;
    }
    //PRINT THE LL
    public void printLL()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.value + " -> ");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    private class Node{
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        
    }
}
