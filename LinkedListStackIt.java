/** A linked list implementation of a stack, with no recursion. */
public class LinkedListStackIt<T> implements Stack<T> {

    // Head (first cell) of the List --null if list empty.
    // When viewed as a stack, the first element on the list is the top
    // and the last element on the list is the bottom.
    private StackCell<T> head; 

    /**Constructor: An empty stack. */
    public LinkedListStackIt() {
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
        int count= 0;
        StackCell<T> current= head;
        while (current != null) {
            count= count + 1;
            current= current.next;
        }
        return count;
    }

    /** Delete first (topmost) occurrence of e from this stack (if it is there). */
    public void delete(T e) {
        if (head == null) return;
        if (equal(e, head.datum)) {
            head= head.next;
            return;
        }

        StackCell<T> current= head;
        StackCell<T> scout= head.next;
        // invariant: the cells head, head.next, ..., current
        //            do not contain e
        //            and scout = current.next.
        while (scout != null) {
            if (equal(e, scout.datum)) {
                current.next= scout.next; // found--unlink cell
                return;
            }
            current= scout;
            scout= current.next;
        }
    }

    /** Return true iff x and y are both null or
     * x is not null and x.equals(y). */
    private boolean equal(T x, T y) {
        return (x == null && y == null) || (x != null && x.equals(y));
    }

    /** Return true iff this stack contains e.  */
    public @Override boolean contains(T e) {
        StackCell<T> current= head;
        // inv: e is not in head, head.next, ..., cell before current
        while (current != null  &&  !equal(e, current.datum)) {
            current= current.next;
        }
        return current != null;
    }

    /** Return the representation of this stack in this form:<br>
     * [ e0, e1, ..., elast]<br>
     * where e0 is the top element and elast is the bottom one. */
    public String toString() {
        String result = "[";
        StackCell<T> current = head;
        while (current != null) {
            if (current != head)
                result= result + ", ";
            result= result + current.datum;
            current = current.next;
        }
        return result + "]";
    }

    /** Reverse this list in place. */
    public void ReverseInPlace() {
        // Initial list is  head:  A -> B -> ... -> C -> D -> ... -> E
        // Final   list is         A <- B <- ... <- C <- D <- ... <- E :head

        StackCell<T> rest= head;
        head= null;
        // invariant, in words: head is a list of the first elements of the
        //           list, reversed. rest is a list the rest of the elements.
        // invariant in a diagram: A <- B <- ... <- C :head
        //                  rest:                        D -> ... -> E
        // So each iteration removes first node of rest and pushes it on head
        while (rest != null) {
            StackCell<T> temp= rest;
            rest= rest.next;
            temp.next= head;
            head= temp;
        }
    }

}
