package NO14;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void longestCommonPrefix() {
        Solution solution = new Solution();
        String[]strs = {"flower","flow","flight"};
        assertEquals("a", solution.longestCommonPrefix(strs));
    }
}