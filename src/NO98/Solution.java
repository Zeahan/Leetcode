package NO98;
import common.TreeNode;

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, 2147483647, -2147483648);
    }

    public boolean helper(TreeNode root, Integer max, Integer min) {
        boolean result = true;
        if (root.left != null) {
            if (root.left.val >= root.val) return false;
            if (root.left.val > max || root.left.val < min) return false;
            result = result && helper(root.left, root.val, min);
        }
        if (root.right != null) {
            if (root.right.val <= root.val) return false;
            if (root.right.val > max || root.right.val < min) return false;
            result = result && helper(root.right, max, root.val);
        }
        return result;
    }
}