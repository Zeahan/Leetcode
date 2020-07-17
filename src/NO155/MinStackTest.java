package NO155;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {
    MinStack minStack;

    @Before
    public void setUp() throws Exception {
        minStack = new MinStack();
    }

    @Test
    public void push() {
        minStack.push(6);
        minStack.push(7);
        minStack.push(8);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.push(9);
        minStack.getMin();
//        minStack.push(0);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }

    @Test
    public void pop() {
    }

    @Test
    public void top() {
    }

    @Test
    public void getMin() {
    }
}