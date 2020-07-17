package NO50;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void myPow() {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, 5));
        System.out.println(Math.pow(2, 5));
    }
}