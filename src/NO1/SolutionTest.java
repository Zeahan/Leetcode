package NO1;

import static org.junit.Assert.*;

public class SolutionTest {

    @org.junit.Test
    public void twoSum() {
        Solution solution = new Solution();
        int[] output = solution.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(output, new int[]{0, 1});
    }
}