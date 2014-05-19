import java.util.*;

/** A linked list implementation of Stack using recursion and no loops. */
public class LinkedListStackRe<T> implements Stack<T> {

    // Head (first cell) of the List --null if list empty.
    // When viewed as a stack, the first element on the list is the top
    // and the last element on the list is the bottom.
    StackCell<T> head; // Head (first cell) of the List. null if list is empty

    /**Constructor: An empty stack. */
    public LinkedListStackRe() {
        head= null;
    }

    /** Push e on this stack. */
    public @Override void push(T e) {
        head= new StackCell<T>(e, head);
    }

    /** Pop the top element of this stack and return it.
     * Throw RuntimeException if the stack is empty */
    public @Override T pop() {
        if (head == null)
            throw new RuntimeException("Cannot pop an empty Stack");
        T h= head.datum;
        head= head.next;
        return h;
    }

    /** Return the number of elements. */
    public @Override int size() {
        return size(head);
    }

    /** Return the number of elements in list c. */
    private int size(StackCell<T> c) {
        if (c == null) return 0;
        return 1 + size(c.next);
    }

    /** Delete first (topmost) occurrence of e from this list (if it is there). */
    public void delete(T e) {
        head= delete(e, head);
    }

    /** Delete the first occurrence of e from list c
     * (if it is in c) and return the resulting list. */
    private StackCell<T> delete(T e, StackCell<T> c) {
        if (c == null) return null;
        if (equal(c.datum, e)) return c.next;
        c.next= delete(e, c.next);
        return c;
    }

    /** Return true iff x and y are both null or
     * x is not null and x.equals(y). */
    private boolean equal(T x, T y) {
        return (x == null && y == null) || (x != null && x.equals(y));
    }

    /** Return true iff this stack contains e.  */
    public boolean contains(T e) {
        return contains(e, head);
    }

    /** Return true iff e is in list c. */
    private boolean contains(T e, StackCell<T> c) {
        if (c == null) return false;
        return equal(c.datum, e) || contains(e, c.next);
    }

    /** Return the representation of this list in this form:
     * [ e0, e1, ..., elast] */
    public String toString() {
        if (head == null) return "[]";
        return "[" + head.datum + toString(head.next) + "]";
    }

    /** Return the elements of c, each preceded by ", ". */
    private String toString(StackCell<T> c) {
        if (c == null) return "";
        return ", " + c.datum.toString() + toString(c.next);
    }

    /** Reverse this list in place. */
    public void ReverseInPlace() {
        StackCell<T> c= head;
        head= null;
        prependInPlace(c);  // this prepends all elements of c to head
    }

    /** Prepend the elements of list c to this list */
    private void prependInPlace(StackCell<T> c) {
        if (c == null) return;
        StackCell<T> t= c;
        c= c.next;
        t.next= head;
        head= t;
        prependInPlace(c);
    }
}
