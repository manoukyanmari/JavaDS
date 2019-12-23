/**
 * Author: Mariam Manukyan
 */
package HW3;

public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public static class Node<E> {
        public E element;
        public Node<E> prev;
        public Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        // Function to insert a node at the beginning of a linked list
        public static Node insertAtTheBegin(Node start_ref, int data) {
            Node first = new Node(null, null, null);
            first.element = data;
            first.next = start_ref;
            if (start_ref != null)
                (start_ref).prev = first;
            start_ref = first;
            return start_ref;
        }


    }

    public DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getPrev().getElement();
    }

    public Node<E> getTail() {
        if (isEmpty()) return null;
        return tail.getPrev();
    }

    public Node<E> getHead() {
        if (isEmpty()) return null;
        return head.getNext();
    }

    public void addFirst(E e) {
        addBetween(e, head, head.getNext());
    }

    public void addLast(E e) {
        addBetween(e, tail.getPrev(), tail);
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(head.getNext());
    }

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(tail.getPrev());
    }

    private void addBetween(E e, Node<E> preElement, Node<E> nextElement) {
        Node<E> newest = new Node<>(e, preElement, nextElement);
        preElement.setNext(newest);
        nextElement.setPrev(newest);
        size++;
    }


    private E remove(Node<E> node) {
        Node<E> preElement = node.getPrev();
        Node<E> nextElement = node.getNext();
        preElement.setNext(nextElement);
        nextElement.setPrev(preElement);
        size--;
        return node.getElement();
    }

    // Function to print nodes in a given linked list
    static void printList(Node start) {
        if (start == null) System.out.println("List is Empty");
        if (start != null) {
            Node temp = start;
            System.out.print(temp.getElement() + " ");
            while (temp.getNext() != null) {
                temp = temp.getNext();
                System.out.print(temp.getElement() + " ");
            }
        }
        System.out.println(" ");
    }

}
