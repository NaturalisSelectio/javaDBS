/** A stack is a list that follows the last-in-first-out (LIFO)
 * principle. An example is a stack of cafeteria trays. You take
 * the top one, which is the last one that the staff put in.*/
public interface Stack<T> {

   /** Push e on this stack. */
   public void push(T e);

   /** Pop the top element of this stack and return it.
    * Throw RuntimeException if the stack is empty */
   public T pop();

   /** Return true iff this stack contains e. */
   public boolean contains(T e);

   /** Return the number of elements in this stack. */
   public int size();
}

/** Stack cell (a helper class; visible to other classes in same package). */
class StackCell<T> {
   public T datum; // Data for this cell
   public StackCell<T> next; // Next cell in this Stack

   /** Constructor: an instance with datum d and next cell next. */
   public StackCell(T d, StackCell<T> next) {
      datum= d;
      this.next= next;
   }
}
