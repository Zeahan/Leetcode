package NO76;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution = new Solution();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void minWindow() {
        System.out.println(solution.minWindow("aaaaaaaaaaaabbbbbcdd",
                "abcdd"));
    }
}