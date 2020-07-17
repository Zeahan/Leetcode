package NO230;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Stack;


class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        int cur = 0;

        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            cur++;
            if (cur == k) return root.val;
            root = root.right;
        }

        return -1;
    }
}