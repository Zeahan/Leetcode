package NO95;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n==0) {
            return new ArrayList<>();
        } else {
            return helper(1, n);
        }

    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();

        if (start > end) trees.add(null);


        for (int i=start; i<=end; i++) {
            List<TreeNode> lSubTrees = helper(start, i-1);
            List<TreeNode> rSubTrees = helper(i+1, end);


            for (TreeNode l : lSubTrees) {
                for (TreeNode r:rSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
