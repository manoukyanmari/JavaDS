/**
 * Author: Mariam Manukyan
 */
package HW3;

/**
 2. (20 points) Extend the CircularlyLinkedList class with a method/function
 that implements the removeLast operation for a circularly linked list. What is the running
 time of your method/function? Can you improve the running time? If so, how?
 */

public class CircularRunner {

    public static void main(String[] args) {
        CircularlyLinkedList cl = new CircularlyLinkedList();
        //Adds data to the list
        cl.add(1);
        cl.add(2);
        cl.add(3);
        cl.add(4);
        //Displays all the nodes present in the list
        System.out.println("Displays all the nodes present in the list: ");
        cl.display();
        //Method Written inside CircularlyLinkedList class to remove last node
        /**
         *  Extend the CircularlyLinkedList class with a method/function
         * that implements the removeLast operation for a circularly linked list.
         *
         * removeLastNode in CircularlyLinkedList is the method
         */
        cl.removeLastNode();
        System.out.println("Displays all the nodes After removal of the last element in the list: ");
        cl.display();
    }
}
