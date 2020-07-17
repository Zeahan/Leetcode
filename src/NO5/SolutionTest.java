package NO5;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void longestPalindrome() {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("ac"));
        int a = 1;
        StringBuilder builder = new StringBuilder();
        builder.insert(0, a);
    }
}