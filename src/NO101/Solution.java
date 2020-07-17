package NO101;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*递归*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null ^ r == null) return false;
        if (!helper(l.left, r.right)) return false;
        if (l.val != r.val) return false;
        return helper(l.right, r.left);
    }
}

/*迭代*/
class Solution1 {
    Stack<TreeNode> leftStack = new Stack<>();
    Stack<TreeNode> rightStack = new Stack<>();
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null ^ root.right == null) return false;

        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;
        while ((!leftStack.isEmpty() && !rightStack.isEmpty())
                || (leftTree != null && rightTree != null)) {
            while (leftTree != null && rightTree != null) {
                leftStack.push(leftTree);
                rightStack.push(rightTree);
                if (leftTree.left == null ^ rightTree.right == null) return false;
                leftTree = leftTree.left;
                rightTree = rightTree.right;
            }
            leftTree = leftStack.pop();
            rightTree = rightStack.pop();
            if (leftTree.val != rightTree.val) return false;
            if (leftTree.right == null ^ rightTree.left == null) return false;
            leftTree = leftTree.right;
            rightTree = rightTree.left;
        }

        return leftStack.isEmpty() && rightStack.isEmpty();
    }
}

class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args){
        String line = "[1,2,2,3,4,4,3]";

            TreeNode root = stringToTreeNode(line);

            boolean ret = new Solution().isSymmetric(root);

            String out = booleanToString(ret);

            System.out.print(out);

    }
}