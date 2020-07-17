package NO103;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>(); // 解法1：使用栈
        List<TreeNode> list = new ArrayList<>(); // 解法2：使用List
        List<List<Integer>> result = new ArrayList<>();
//        stack.push(root); // 解法1：使用栈
        list.add(root); // 解法2：使用List

        boolean rightOrder = false;
//        while (!stack.isEmpty()) { // 解法1：使用栈
        while (!list.isEmpty()) { // 解法2：使用List
//            Stack<TreeNode> tempStack = new Stack<>(); // 解法1：使用栈
//            int size = stack.size();
            int size = list.size();
            List<Integer> nodesOfLevel = new ArrayList<>();
//            for (int i=0; i<size; i++) { // 解法1：使用栈
            for (int i=size-1; i>-1; i--) {
//                TreeNode current = stack.pop(); // 解法1：使用栈
                TreeNode current = list.remove(i); // 解法2: 使用List
                if (rightOrder) {
//                    if(current.right != null) tempStack.push(current.right); // 解法1：使用栈
//                    if(current.left != null) tempStack.push(current.left);
                    if(current.right != null) list.add(current.right); // 解法2: 使用List
                    if(current.left != null) list.add(current.left);
                } else {
//                    if(current.left != null) tempStack.push(current.left); // 解法1：使用栈
//                    if(current.right != null) tempStack.push(current.right);
                    if(current.left != null) list.add(current.left); // 解法2: 使用List
                    if(current.right != null) list.add(current.right);
                }
                nodesOfLevel.add(current.val);
            }
            result.add(nodesOfLevel);
            rightOrder = !rightOrder;
//            stack = tempStack; // 解法1：使用栈
        }
        return result;
    }
}
