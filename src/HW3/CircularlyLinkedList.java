/**
 * Author: Mariam Manukyan
 */
package HW3;

/**
 * Circularly Linked List implementatrion for myself
 */

public class CircularlyLinkedList {
    //Represents the node of list.
    public class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    //Declaring head and tail pointer as null.
    public Node head = null;
    public Node tail = null;

    //This function will add the new node at the end of the list.
    public void add(int data){
        //Create new node
        Node newNode = new Node(data);
        //Checks if the list is empty.
        if(head == null) {
            //If list is empty, both head and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else {
            //tail will point to new node.
            tail.next = newNode;
            //New node will become new tail.
            tail = newNode;
            //Since, it is circular linked list tail will point to head.
            tail.next = head;
        }
    }

    /**
     *
     What is the running time of your method/function?

     Running time of removeLastNode is :  O(n) as I have a while loop there
     The number of iterations depends on array's elements' quantity in the list, which means
     it will have O(n) complexity, so that the time for execution varies depending on Array input size N.
     */
    //Deletes node from end of the list
    public void removeLastNode() {
        //Checks whether list is empty
        if(head == null) return;
        if(head != tail ) {
            Node current = head;
            while(current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = head;
        } else {
            head = tail = null;
        }
    }

    //Displays all the nodes in the list
    public void display() {
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            System.out.println("Nodes of the circular linked list: ");
            do{
                //Prints each node by incrementing pointer.
                System.out.print(" "+ current.data);
                current = current.next;
            }while(current != head);
            System.out.println();
        }
    }
}