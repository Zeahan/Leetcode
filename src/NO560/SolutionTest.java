package NO560;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    int [] nums;
    int k;

    @org.junit.Before
    public void setUp() throws Exception {
        solution = new Solution();
        nums = new int[] {-1, -1, 1};
        k = 0;
    }

    @org.junit.Test
    public void subarraySum() {
        System.out.println(solution.subarraySum(nums, k));
    }
}