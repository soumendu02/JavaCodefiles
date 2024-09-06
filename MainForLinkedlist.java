

import Linkedlist.LLmethods.CustomLL;

public class MainForLinkedlist {
    public static void main(String[] args) {
        CustomLL list=new CustomLL();
        list.insertAtStart(0);
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtAnyPos(58, 5);
        list.deleteAtAnyPos(5);
        list.deleteAtAnyPos(5);
        list.printLL();
    }
}
