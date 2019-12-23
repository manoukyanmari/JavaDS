/**
 * Author: Mariam Manukyan
 */
package HW3;

/**
 * 4. (a)  Suppose you have two nonempty stacks S and T and a doubly linked
 * list D. Write an efficient method/function that uses D to modify S to store all the
 * original elements of both S and T, and to make T empty. In the resulting S, the
 * original elements of S should go above all of the original elements of T. Note that
 * both sets of elements should still be in their original order.
 */

 /**
 * Class for Stack Issue
 */
public class ProblemStack {


     private static DoublyLinkedList.Node D = new DoublyLinkedList.Node<Integer>(null,null,null);
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Suppose you have two nonempty stacks S and T and a doubly linked
         * list D.
         */
        Stack s = new ArrayStack(5);
        s.push(41);
        s.push(42);
        s.push(43);
        s.push(44);
        s.push(45);
        s.print();
        System.out.println("Is Stack for S");

        Stack t = new ArrayStack(8);
        t.push(21);
        t.push(22);
        t.push(23);
        t.push(24);
        t.push(25);
        t.push(26);
        t.push(27);
        t.push(28);

        t.print();
        System.out.println("Is Stack for T");
        //Call Method responsible for implementing the task requirements
        s = addDoublyElementsToSStack(s, t);
        System.out.println("Stack Result for S element above T's element");
        s.print();

    }

     /**
      * Write an efficient method/function that uses D to modify S to store all the
      * original elements of both S and T, and to make T empty. In the resulting S, the
      * original elements of S should go above all of the original elements of T. Note that
      * both sets of elements should still be in their original order.
      * @param s
      * @param t
      * @return
      */
    // Function to print nodes in a given linked list
    static Stack addDoublyElementsToSStack(Stack s, Stack t) {
        // start with empty linked list
        DoublyLinkedList.Node start = null;
        Object[] data1 = s.getData();
        Object[] data2 = t.getData();
        //Created linked list will be 1->11->2->56->12
        for (int i = 0; i < data1.length; i++) {
            int item = (int) s.pop();
            //Pop each and apply as start for doubly linked list
            start = D.insertAtTheBegin(start, item);
        }
        for (int i = 0; i < data2.length; i++) {
            int item = (int) t.pop();
            //Pop each and apply as start for doubly linked list
            start = D.insertAtTheBegin(start, item);
        }

        s = new ArrayStack(data1.length + data2.length);
        if(start != null) {
            DoublyLinkedList.Node tmp = start;
            s.push(tmp.getElement());
            while (tmp.getNext()!=null) {
                tmp = tmp.getNext();
                s.push(tmp.getElement());
            }
        }
        return s;
    }
     /**
      * Explain the time complexity of your method in part (a)??
      *
      * The complexity is just O(n), same reason as for second question,
      * as both the For loops and While loop for looping through fixed arrays have O(n)
      */
    
}
