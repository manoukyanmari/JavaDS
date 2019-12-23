package HW4.LinkedPositionalListIntegerPack;
import HW4.Position;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalListInt<Integer> implements PositionalListInt<Integer> {
    private Node<Integer> header; // header sentinel
    private Node<Integer> trailer; // trailer sentinel
    private int size = 0;

    private static class Node<Integer> implements PositionInt<java.lang.Integer> {
        private int element;
        private Node<Integer> prev;
        private Node<Integer> next;

        public Node(java.lang.Integer e, Node<Integer> p, Node<Integer> n) {
            element = e;
            prev = p;
            next = n;
        }

        public int getElement() throws IllegalStateException {
            if (next == null) // convention for defunct node
                throw new IllegalStateException("Position no longer valid");
            return element;
        }

        public Node<Integer> getPrev() {
            return prev;
        }

        public Node<Integer> getNext() {
            return next;
        }

        public void setElement(java.lang.Integer e) {
            element = e;
        }

        public void setPrev(Node<Integer> p) {
            prev = p;
        }

        public void setNext(Node<Integer> n) {
            next = n;
        }

    }

    public LinkedPositionalListInt() {
        header = new Node<Integer>(null, null, null);
        trailer = new Node<Integer>(null, header, null);
        header.setNext(trailer);
    }

    private Node<Integer> validate(Position<Integer> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<Integer> node = (Node<Integer>) p;
        if (node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    private Position<Integer> position(Node<Integer> node) {
        if (node == header || node == trailer)
            return null; // do not expose user to the sentinels
        return (Position<Integer>) node;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public Position<Integer> first() {
        return position(header.getNext());
    }
    public Position<Integer> last() {
        return position(trailer.getPrev());
    }

    public Position<Integer> before(Position<Integer> p) {
        Node<Integer> node = validate(p);
        return position(node.getPrev());
    }
    public Position<Integer> after(Position<Integer> p) {
        Node<Integer> node = validate(p);
        return position(node.getNext());
    }

    // private utilities
    private Position<Integer> addBetween(int e, Node<Integer> pred, Node<Integer> succ) {
        Node<Integer> newest = new Node<>(e, pred, succ); // create and link a new node
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return (Position<Integer>) newest;
    }

    // public update methods
    public Position<Integer> addFirst(int e) {
        return addBetween(e, header, header.getNext()); // just after the header
    }

    public Position<Integer> addLast(int e) {
        return addBetween(e, trailer.getPrev(), trailer); // just before the trailer
    }

    public Position<Integer> addBefore(Position<Integer> p, int e) throws IllegalArgumentException {
        Node<Integer> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }
    public Position<Integer> addAfter(Position<Integer> p, int e) throws IllegalArgumentException {
        Node<Integer> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    public int set(Position<Integer> p, int e) throws IllegalArgumentException {
        Node<Integer> node = validate(p);
        int answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    public int remove(Position<Integer> p) throws IllegalArgumentException {
        Node<Integer> node = validate(p);
        Node<Integer> predecessor = node.getPrev();
        Node<Integer> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        int answer = node.getElement();
        node.setElement(null); // help with garbage collection
        node.setNext(null); // and convention for defunct node
        node.setPrev(null);
        return answer;
    }



    private class PositionIterator implements Iterator<Position<Integer>> {
        private Position<Integer> cursor = first();
        private Position<Integer> recent = null;

        public boolean hasNext() { return(cursor!=null); }

        public Position<Integer> next() throws NoSuchElementException {
            if(cursor==null) throw new NoSuchElementException("nothing left");
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }
        public void remove() throws IllegalStateException {
            if(recent==null) throw new IllegalStateException("Nothing to remove");
            LinkedPositionalListInt.this.remove(recent);
            recent = null;
        }
    }


    public Iterable<Position<Integer>> positions() {
        return new PositionIterable();
    }

    private class ElementIterator implements Iterator<Integer> {
        Iterator<Position<Integer>> posIterator = new PositionIterator();
        public boolean hasNext() { return posIterator.hasNext();}
        public Integer next() { return posIterator.next().getElement(); }
        public void remove() { posIterator.remove(); }
    }

    private class PositionIterable implements Iterable<Position<Integer>> {
        public Iterator<Position<Integer>> iterator() {return new PositionIterator();}
    }
    public Iterator<Integer> iterator() { return new ElementIterator();}

}
