/**
 * Author: Mariam Manukyan
 */
package HW3;

/**
 * Stack Functionality based on our lessons
 * @param <E>
 */
public interface Stack<E> {
    int size();
    boolean isEmpty();
    void push(E e);
    void print();
    E[] getData();
    E top();
    E pop();
}
/**
 *
 * @author Mariam
 */
class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 100;
    private E[] data;
    private int i = -1;
    public ArrayStack(){
        this(CAPACITY);
    }
    public ArrayStack(int capacity){
       data = (E[]) new Object[capacity];
    }

    public int size() {
        return (i+1);
    }
    public boolean isEmpty(){
        return (i==-1);
    }

    public void push(E e) throws IllegalStateException{
        if(size() == data.length) throw new IllegalStateException("Stack is full");
        data[++i] = e;
    }

    public E top() {
        if(isEmpty()) return null;
        return data[i];
    }

    public E pop() {
        if(isEmpty()) return null;
        E answer = data[i];
        data[i] = null;
        i--;
        return answer;
    }

    public void print(){
        System.out.println("Stack Data");
        for(int i=0; i<data.length;i++){
            System.out.print(data[i] + "  ");
        }
    }

    public E[] getData(){
        return data;
    }



}
