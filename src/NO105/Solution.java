package NO105;

import common.TreeNode;

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, Integer> inorderIndexes;
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        inorderIndexes = new HashMap<>();

        int n = inorder.length;

        for (int i=0; i<n; i++) {
            inorderIndexes.put(inorder[i], i);
        }

        return helper(0, n-1, 0, n-1);
    }

    public TreeNode helper(int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int rootVal = preorder[preorderLeft];

        TreeNode root = new TreeNode(rootVal);
        int leftSize = inorderIndexes.get(rootVal) - inorderLeft;

        root.left = helper(preorderLeft + 1, preorderLeft + leftSize,
                inorderLeft, inorderIndexes.get(rootVal) - 1);

        root.right = helper(preorderLeft + leftSize + 1, preorderRight, inorderIndexes.get(rootVal) + 1, inorderRight);

        return root;
    }
}
