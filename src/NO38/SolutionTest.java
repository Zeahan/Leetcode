package NO38;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void countAndSay() {
        for (int i=1; i<20; i++) {
            System.out.println(i + ":"+solution.countAndSay(i));
        }
    }

    @Test
    public void converter() {
        System.out.println(solution.converter("21"));
    }
}