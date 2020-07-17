package I29;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    int[][]matrix;
    Solution solution;

    @Test
    public void spiralOrder() {
        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        solution = new Solution();
        solution.spiralOrder(matrix);
    }
}