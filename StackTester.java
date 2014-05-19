import static org.junit.Assert.*;

import org.junit.Test;
import CS2110Stacks.*;

/** Test methods in package CS2110Stacks */
public class StackTester {

    @Test
    public void testArrayStack() {
        ArrayStack s1= new ArrayStack();
        assertEquals(0, s1.size());
        s1.push("a");
        s1.push("b");
        s1.push("c");
        assertEquals(true, s1.contains("a"));
        assertEquals(true, s1.contains("b"));
        assertEquals(true, s1.contains("c"));
        assertEquals(false, s1.contains("d"));
        assertEquals(3, s1.size());
        Object t1= s1.pop();
        Object t2= s1.pop();
        assertEquals("c", t1);
        assertEquals("b", t2);
        assertEquals(1, s1.size());
        s1.push("b");
        s1.push("c");
        s1.push("d");
        s1.delete("c");
        assertEquals("[d, b, a]", s1.toString());
        s1.ReverseInPlace();
        assertEquals("[a, b, d]", s1.toString());
        }
    
    @Test
    public void LinkedListStackIt() {
        LinkedListStackIt s1= new LinkedListStackIt();
        assertEquals(0, s1.size());
        s1.push("a");
        s1.push("b");
        s1.push("c");
        assertEquals(true, s1.contains("a"));
        assertEquals(true, s1.contains("b"));
        assertEquals(true, s1.contains("c"));
        assertEquals(false, s1.contains("d"));
        assertEquals(3, s1.size());
        Object t1= s1.pop();
        Object t2= s1.pop();
        assertEquals("c", t1);
        assertEquals("b", t2);
        assertEquals(1, s1.size());
        s1.push("b");
        s1.push("c");
        s1.push("d");
        s1.delete("c");
        assertEquals("[d, b, a]", s1.toString());
        s1.ReverseInPlace();
        assertEquals("[a, b, d]", s1.toString());
        }
    
    @Test
    public void LinkedListStackRe() {
        LinkedListStackRe s1= new LinkedListStackRe();
        assertEquals(0, s1.size());
        s1.push("a");
        s1.push("b");
        s1.push("c");
        assertEquals(true, s1.contains("a"));
        assertEquals(true, s1.contains("b"));
        assertEquals(true, s1.contains("c"));
        assertEquals(false, s1.contains("d"));
        assertEquals(3, s1.size());
        Object t1= s1.pop();
        Object t2= s1.pop();
        assertEquals("c", t1);
        assertEquals("b", t2);
        assertEquals(1, s1.size());
        s1.push("b");
        s1.push("c");
        s1.push("d");
        s1.delete("c");
        assertEquals("[d, b, a]", s1.toString());
        s1.ReverseInPlace();
        assertEquals("[a, b, d]", s1.toString());
        }

}
