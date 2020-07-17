package NO2;

import common.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }

    public ListNode helper(ListNode l1, ListNode l2, int carry) {
        ListNode result;
        int sum;
        if (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            result = new ListNode(sum % 10);
            result.next = helper(l1.next, l2.next, sum / 10);
        } else if (l1 != null || l2 != null) {
            sum = ((l1 != null)?l1.val:l2.val) + carry;
            result = new ListNode(sum % 10);
            result.next = helper((l1 != null)?l1.next:l2.next, null, sum / 10);
        } else {
            result = (carry>0)?new ListNode(carry):null;
        }
        return result;
    }

//    public long nodesToLong(ListNode listNode) {
//        long result = 0;
//        long exponent = 0;
//        ListNode currentNode = listNode;
//
//        do {
//            result += currentNode.val * Math.pow(10, exponent);
//            exponent += 1;
//            currentNode = currentNode.next;
//        } while (currentNode != null);
//        return result;
//    }
//
//    public ListNode longToNodes(long num){
//        ListNode result;
//
//        result = new ListNode((int)(num % 10));
//        num = num / 10;
//
//        if (num == 0) {
//            return result;
//        } else {
//            result.next = longToNodes(num);
//        }
//        return result;
//    }
}
