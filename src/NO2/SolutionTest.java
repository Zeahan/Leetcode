package NO2;

import common.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionTest {
    ArrayList<Integer> list1;
    ArrayList<Integer> list2;
    ListNode l1;
    ListNode l2;
    Solution solution;

    @Before
    public void setUp() throws Exception {
        list1 = new ArrayList<>(Arrays.asList(9,8));
        list2 = new ArrayList<>(Arrays.asList(1));
        l1 = helper(list1);
        l2 = helper(list2);
        solution = new Solution();
    }

    @Test
    public void addTwoNumbers() {
        solution.addTwoNumbers(l1, l2);
    }



    public ListNode helper(ArrayList<Integer> list) {
        ListNode output;

        output = new ListNode(list.get(0));
        list.remove(0);
        if (list.size()>0) {
            output.next = helper(list);
        }
        return output;
    }
}