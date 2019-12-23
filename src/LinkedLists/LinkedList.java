package LinkedLists;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    // Just for creating a list We want to work on
    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.prev = null;

        if(head == null) {
            head = node;
            size++;
        } else {
            Node n = head;
            while(n.next!=null) {
                n = n.next;
            }
            n.next = node;
            tail = n.next;
            ++size;
        }
    }


    // 4. Given head, print every next
    public void print(Node head){
        Node tmp = head;
        while(tmp!=null){
            System.out.printf(tmp.data + ", ");
            tmp = tmp.next;
        }
        System.out.println("\n");
    }

    public Node getHead() {
        return head;
    };

    /**
     * Get current size of the list
     * @return
     */
    public int getSize(){
        return size;
    }


    // Function to remove the first node
    // of the linked list /
    public void removeFirstNodesIfPrime()
    {
        if (head == null)
            return;
        boolean isPrimeNum = IsPrime.isPrimeOrNot(head.data);
        if(isPrimeNum) {
            head = head.next;
            size--;
            removeFirstNodesIfPrime();
        }
    }

    /**
     * Function for removing a tail from singly linked List
     */
    public void removeLastElement() {
        //Checks if the list is empty
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        else {
            //Checks whether the list contains only one element
            if(head != tail ) {
                Node temp = head;
               while(temp.next != tail) {
                    temp = temp.next;
                }
                tail = temp;
                tail.next = null;
                decreaseSize();
            }
            else {
                head = tail = null;
                decreaseSize();
            }
        }
    }

    public void decreaseSize() {
        size--;
    }
    public void printSizesOfOriginalAndModified(int size){

        System.out.println(size + ": old size");
        System.out.println(getSize() + ": newSize");

    }


    /**
     * Iterator to remove the Prime Numbers
     * @param size
     */
    public void iteratorForRemovalOfPrimeNumbers(int size){
        removeFirstNodesIfPrime();
        Node temp = head;
        if(size==2) {
            if(IsPrime.isPrimeOrNot(head.data)){
                head = tail;
                tail.prev = null;
                decreaseSize();
            } else if(IsPrime.isPrimeOrNot(tail.data)){
                tail.prev = null;
                head.next = null;
                decreaseSize();
            }
        } else {
            for(int i=0; i<size - 1; i++){
                if (temp.next != null) {
                    temp = temp.next;
                }
                if (IsPrime.isPrimeOrNot(temp.data)) {
                    Node tmp = temp.next;
                    if (tmp != null) {
                        temp.data = tmp.data;
                        temp.next = tmp.next;
                        decreaseSize();
                        int sizeChange = getSize();
                        iteratorForRemovalOfPrimeNumbers(sizeChange);
                    } else {
                        removeLastElement();
                        break;
                    }
                }
            }
        }
    }

    /**
     *
     // Function to 1.Remove primes from list,
     // 2. Print sizes of original and modified arrays
     // 3. return head node
     * @param size
     * @return
     */
    public Node removePrimesPrintSizesReturnHead(int size) {
        iteratorForRemovalOfPrimeNumbers(size);
        print(head); //after removal
        printSizesOfOriginalAndModified(size); // old and new sizes
        System.out.println(head.data + ": is head Value we have now");
        return head;
    }
}
