package NO136;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    int[] nums;
    Solution solution;

    @Before
    public void setUp() throws Exception {
        nums = new int[]{1,2,3,2,3};
        solution = new Solution();
    }

    @Test
    public void singleNumber() {
        solution.singleNumber(nums);
    }
}