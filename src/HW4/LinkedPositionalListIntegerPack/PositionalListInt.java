package HW4.LinkedPositionalListIntegerPack;


import HW4.Position;

public interface PositionalListInt<Integer> {
    int size();
    boolean isEmpty();

    Position<Integer> first();
    Position<Integer> last();

    Position<Integer> before(Position<Integer> p) throws IllegalArgumentException;
    Position<Integer> after(Position<Integer> p) throws IllegalArgumentException;

    Position<Integer> addFirst(int e);
    Position<Integer> addLast(int e);

    Position<Integer> addBefore(Position<Integer> p, int e) throws IllegalArgumentException;
    Position<Integer> addAfter(Position<Integer> p, int e) throws IllegalArgumentException;

    int set(Position<Integer> p, int e) throws IllegalArgumentException;
    int remove(Position<Integer> p) throws IllegalArgumentException;

}