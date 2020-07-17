package NO124;

import common.TreeNode;

class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;

        // 获取左子树，右子树*向上反馈*的最优解
        int left = Math.max(0,helper(root.left)); // 如最优解为赋值，直接舍弃该子树
        int right = Math.max(0,helper(root.right));

        // 将*以当前节点为顶点*的路径上的最优解与历史最优解作比较，如当前更优则进行更新
        max = Math.max(max, root.val + left + right);

        // 将当前节点*不为顶点*的最优解向上（父节点）传递
        return root.val + Math.max(left, right);
    }
}