/**
 * Author: Mariam Manukyan
 */
package HW3;

/**
 * 3. Implement the Deque ADT using a circular array. Note that all operations should have O(1) running time.
 * Your ArrayDeque class should implement the Deque
 * interface given in the textbook. Write a program to test all the methods of your class.
 */

/**
 * Implement the Deque ADT using a circular array
 */
// A Class to represent a Deque

/**
 * ArrayDeque class, wrote it myself before, and it is not the one in textbook,
 * Saw the requirement late :(( Don't have time to change, sorry
 */

class CircularDequeue
{
    static final int maxCount = 10;
    int  arr[];
    int  front;
    int  end;
    int  size;

    public CircularDequeue(int size)
    {
        arr = new int[maxCount];
        front = -1;
        end = 0;
        this.size = size;
    }

    // Checks if Deque is full or not.
    boolean isFull()
    {
        return ((front == 0 && end == size-1) || front == end+1);
    }

    // Checks whether Deque is empty or not. 
    boolean isEmpty ()
    {
        return (front == -1);
    }

    // Inserts an element at front 
    void insertToFront(int key)
    {
        // check whether Deque if  full or not 
        if (isFull())
        {
            return;
        }
        //Empty queue
        if (front == -1)
        {
            front = end = 0;
        }  else if (front == 0) {
            front = size - 1; // First position
        } else {// decrement front end by '1'
            front--;
        }
        // insert current element into Deque 
        arr[front] = key ;
    }

    // function to inset element at end end 
    // of Deque. 
    void insertEnd(int key)
    {
        if (isFull())
        {
            System.out.println(" Overflow ");
            return;
        }

        // If queue is empty
        if (front == -1)
        {
            front = end = 0;
        } else if (end == size-1) { // last one
            end = 0;
        } else {
            end++;
        }
        arr[end] = key ;
    }

    // Deletes element at front end of Deque 
    void deleteFromFront()
    {
        // check whether Deque is empty or not 
        if (isEmpty())
        {
            return;
        }
        // Only one element left
        if (front == end)
        {
            front = end = -1;
        }
        else {
            // back to initial
            front = (front == size -1) ? 0 : front+1;
        }
    }

    // Delete element at end end of Deque 
    void deletFromEnd()
    {
        if (isEmpty())
        {
            System.out.println(" Underflow");
            return ;
        }

        // Deque has only one element 
        if (front == end)
        {
            front = end = -1;
        } else if (end == 0) {
            end = size-1;
        } else {
            end = end-1;
        }
    }

    // Returns front element of Deque 
    int getFront()
    {
        // check whether Deque is empty or not 
        if (isEmpty())
        {
            return -1 ;
        }
        return arr[front];
    }

    // function return end element of Deque 
    int getEnd()
    {
        // check whether Deque is empty or not 
        if(isEmpty() || end < 0)
        {
            System.out.println(" Underflow\n");
            return -1 ;
        }
        return arr[end];
    }

    /**
     * Write a program to test all the methods of your class.
     * @param args
     */
    public static void main(String[] args)
    {

        CircularDequeue deck = new CircularDequeue(5);

        System.out.println("Insert element at end end  : 5 ");
        deck.insertEnd(5);

        System.out.println("insert element at end end : 10 ");
        deck.insertEnd(10);

        System.out.println("get end element : "+ deck.getEnd());

        deck.deletFromEnd();
        System.out.println("After delete end element new end become : " +
                deck.getEnd());

        System.out.println("inserting element at front end");
        deck.insertToFront(15);

        System.out.println("get front element: " + deck.getFront());

        deck.deleteFromFront();

        System.out.println("After delete front element new front become : " +
                +  deck.getFront());

    }
} 