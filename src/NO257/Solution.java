package NO257;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new LinkedList<>();
        dfs(root, "");
        return result;
    }

    public void dfs(TreeNode root, String path) {
        if (root == null) return;
        path += (path.length() == 0) ? root.val : String.format("->%d", root.val);
        if (root.left == null && root.right == null) result.add(path);
        dfs(root.left, path);
        dfs(root.right, path);
    }


}
