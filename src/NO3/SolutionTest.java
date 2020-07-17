package NO3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;

    @Before
    public void setUp() throws Exception {
        solution= new Solution();
    }

    @Test
    public void lengthOfLongestSubstring() {
        solution.lengthOfLongestSubstring("dvdf");
    }
}