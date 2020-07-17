package NO83;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> li = new ArrayList<>();

    public ListNode deleteDuplicates(ListNode head) {
        if (!li.contains(head.val)) {
            li.add(head.val);
            if (head.next != null) {
                head.next = deleteDuplicates(head.next);
            }
            return head;
        } else if(head.next != null){
            return deleteDuplicates(head.next);
        } else {
            return null;
        }
    }
}
