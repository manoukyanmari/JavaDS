package LinkedLists;

public class Runner {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(45);
        list.insert(12);
        list.insert(13);
        list.insert(7);
        list.insert(6);
        list.insert(2);
        list.insert(8);
        list.insert(19);
        //Given head of Element Print every next

        Node head = list.getHead();

        /**
         * HW 4th assignment
         * Given the head, print every next element in the list
         */
        list.print(head);
        // remove every prime one
        int size = list.getSize();

        /** HW 5th Assignment:
        // 1.Remove primes from list,
        // 2. Print sizes of original and modified arrays
        // 3. return head node */
        list.removePrimesPrintSizesReturnHead(size);

    }
}
