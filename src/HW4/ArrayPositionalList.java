package HW4;

import java.util.Iterator;

public class ArrayPositionalList<E> implements PositionalList<E>, Iterable {

    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;
    //constructors
    public ArrayPositionalList(){this(CAPACITY);}
    public ArrayPositionalList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    private Position<E> position(E p) {
        if (isEmpty())
            return null; // do not expose user to the sentinels
        return (Position<E>) p;
    }
    public boolean isEmpty() {
        return size==0;
    }

    public Position<E> first() {
        return position(data[0]);
    }

    public Position<E> last() {
        return position(data[size() - 1]);
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    public Position<E> addFirst(E e) {
        return null;
    }

    public Position<E> addLast(E e) {
        return null;
    }

    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        return null;
    }

    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        return null;
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        return null;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
