package prac.A_Queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    String[] deadEnds;
    String target;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
        deadEnds = new String[]{"0201", "0101", "0102", "1212", "2002"};
        target = "0202";
    }

    @Test
    public void openLock() {
        System.out.println(solution.openLock(deadEnds, target));
    }

    @Test
    public void changePwd() {
    }
}