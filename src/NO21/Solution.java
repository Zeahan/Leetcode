package NO21;
import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result;
        if (l1 == null && l2 == null) {
            result = null;
        } else if (l1 == null || l2 == null) {
            result = (l1 != null)?l1:l2;
        } else {
            ListNode smaller = (l1.val < l2.val)?l1:l2;
            ListNode bigger = (l1.val > l2.val)?l1:l2;
            result = new ListNode(smaller.val);
            result.next = mergeTwoLists(bigger, smaller.next);
        }
        return result;
    }

//    public ListNode helper(ListNode l1, ListNode l2) {
//        ListNode result;
//        if (l1 == null && l2 == null) {
//            return null;
//        } else if (l1 == null || l2 == null) {
//            return (l1 != null)?l1:l2;
//        } else {
//            result = new ListNode(Math.min(l1.val, l2.val));
//            result.next = new ListNode(Math.max(l1.val, l2.val));
//            result.next.next = helper(l1.next, l2.next);
//        }
//    }
}
