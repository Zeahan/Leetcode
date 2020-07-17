package NO102;

import common.TreeNode;

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        result.add(Arrays.asList(root.val));

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> children = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.peek();
                if (cur.left != null) {
                    children.add(cur.left.val);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    children.add(cur.right.val);
                    queue.offer(cur.right);
                }
                queue.poll();
            }
            if (!children.isEmpty()) {
                result.add(children);
            }
        }

        return result;
    }
}
