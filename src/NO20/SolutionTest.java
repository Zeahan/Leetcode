package NO20;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isValid() {
        Solution solution = new Solution();
        assertTrue(solution.isValid("()[]{}"));
        assertTrue(solution.isValid("{[]}"));
        assertFalse(solution.isValid("{[)]"));
    }
}