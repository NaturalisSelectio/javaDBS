/** An array implementation of a stack. */
public class ArrayStack<T> implements Stack<T> {

    // The elements of the list are in theArray[0..n-1], with the
    // bottom element in theArray[0] and top in theArray{n-1]
    // Thus, the stack contains n elements.
    private Object[] theArray; 
    private int n;

    /** Constructor: an empty stack with capacity c */
    public ArrayStack(int c) {
        theArray= new Object[c];
        n= 0;
    }

    /** Constructor: an empty stack with capacity 10. */
    public ArrayStack() {
        this(10);
    }

    /** Push e on this stack. */
    public @Override void push(T e) {
        // if no room, allocate a new array, copy over old one
        if (n == theArray.length) {
            Object[] newArray= new Object[2 * theArray.length + 1];
            System.arraycopy(theArray, 0, newArray, 0, n);
            theArray= newArray;
        }
        theArray[n]= e;
        n= n+1;
    }

    /** Pop the top element of this stack and return it.
     * Throw RuntimeException if the stack is empty */
	public @Override T pop() {
        if (n == 0)
            throw new RuntimeException("Cannot pop an empty Stack");
        n= n-1;
        return (T) theArray[n];
    }

    /** Return the number of elements.    */
    public @Override int size() {
        return n;
    }

    /** Delete first (topmost) occurrence of e from this stack (if it is there). */
    public void delete(T e) {
        // invariant: theArray[i+1..] does not contain e
        for (int i= n-1; 0 <= i; i= i-1) {
            if (equal(e, theArray[i])) {
                // Move theArray[i+1..n-1] down to theArray[i..n-2]
                for (int j= i + 1; j < n; j= j+1) {
                    theArray[j-1]= theArray[j];
                }
                n= n-1;
                return;
            }
        }
    }

    /** Return true iff x and y are both null or
     * x is not null and x.equals(y). */
    private boolean equal(T x, Object y) {
        return (x != null && x.equals(y)) || (x == null && y == null);
    }


    /** Return true iff this stack contains e. */
    public @Override boolean contains(T e) {
        for (int i= 0; i < n; i= i+1)
            if (equal(e, theArray[i])) return true;
        return false;
    }
    
    /** Return the representation of this stack in this form:<br>
     * [ e0, e1, ..., e(n-1)]<br>
     * where e0 is the top element and elast is the bottom one. */
    public String toString() {
        String result = "[";
        for (int i = n-1; 0 <= i; i= i-1) {
            if (i < n-1) 
                result= result + ", ";
            result= result + theArray[i];
        }
        return result + "]";
    }
    
    /** Reverse this list in place. */
    public void ReverseInPlace() {
        int h= 0; 
        int k= n-1;
        // invariant: theArray[0..h-1] and theArray[k+1..n-1] already reversed,
        //            so theArray[h..k] needs to be reversed
        while (0 < k-h) {
            Object temp= theArray[h];
            theArray[h]= theArray[k];
            theArray[k]= temp;
            h= h+1;
            k= k-1;
        }
    }
}
