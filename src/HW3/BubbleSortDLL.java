/**
 * Author: Mariam Manukyan
 */
package HW3;

/**
 * 1. Implement bubble sort for a doubly linked list of integers. Your bubble
 * sort method/function should receive only the header node of the list. Write a program
 * that (i) constructs a doubly linked list of integers, (ii) calls your method to bubble sort
 * the list, and (iii) prints the sorted sequence. Your method should not access or use
 * any of the data/methods of the DoublyLinkedList class. Thus, the nested Node
 * class must be declared public for use outside of the DoublyLinkedList class.
 */
public class BubbleSortDLL {

    // Driver code
    public static void main(String args[]) {
        int arr[] = {12, 56, 2, 11, 1, 90};


        /**
         * (i) Constructs a doubly linked list of integers
         */
        //Start with empty
        DoublyLinkedList.Node start = null;
        // Create linked list from the array arr[].
        //Created linked list will be 1->11->2->56->12
        for (int i = 0; i < 6; i++)
            start = DoublyLinkedList.Node.insertAtTheBegin(start, arr[i]);

        // print list before sorting
        System.out.println("Linked list before sorting ");
        DoublyLinkedList.printList(start);

        /**
         * (ii) calls your method to bubble sort the list
         */
        // sort the linked list by function implemented for Doubly Linked List Sorting
        start = bubbleSort(start);

        /**
         * (iii) prints the sorted sequence.
         */
        // print list after sorting
        System.out.println("Linked list after sorting ");
        DoublyLinkedList.printList(start);
    }

    /**
     * (iii)Your method should not access or use
     * any of the data/methods of the DoublyLinkedList class. Thus, the nested Node
     * class must be declared public for use outside of the DoublyLinkedList class.
     * @param start
     * @return
     */
    // Bubble sort the given linked list
    static DoublyLinkedList.Node bubbleSort(DoublyLinkedList.Node start) {
        int swapped = -1, i;
        DoublyLinkedList.Node first;
        DoublyLinkedList.Node second = null;

        // Checking for empty list
        if (start == null) return null;
        while (swapped != 0) {
            swapped = 0;
            first = start;

            while (first.getNext() != second) {
                if ((int) first.element > (int) first.next.element) {
                    int t = (int) first.element;
                    first.element = first.getNext().element;
                    first.getNext().element = t;
                    swapped += 1;
                }
                first = first.getNext();
            }
            second = first;
        }
        return start;
    }
}

