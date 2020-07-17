package NO113;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pathRec = new ArrayList<>();
        helper(root, sum, pathRec, res);
        return res;
    }

    public void helper(TreeNode root, int sum, List<Integer> pathRec, List<List<Integer>> res) {
        if (root == null) return;
        sum -= root.val;
        if (root.left == null && root.right == null && sum != 0) return;

        pathRec = pathRec.subList(0,pathRec.size());
        pathRec.add(root.val);

        if (root.left == null && root.right == null && sum == 0) {
            res.add(pathRec);
            return;
        }

        helper(root.left, sum, pathRec, res);
        helper(root.right, sum, pathRec, res);
    }
}
