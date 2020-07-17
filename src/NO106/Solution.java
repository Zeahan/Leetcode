package NO106;

import common.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> inorderIndexs = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;

        for (int i=0; i<inorder.length; i++) {
            inorderIndexs.put(inorder[i], i);
        }

        return getTreeRoot(0, inorder.length-1, postorder.length-1, 0);
    }

    public TreeNode getTreeRoot(int inorderFront, int inorderEnd,
                                int postorderFront, int postorderEnd) {
        if (postorderFront < postorderEnd) return null;

        int rootValue = postorder[postorderFront];
        int rightSize = inorderEnd - inorderIndexs.get(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.right = getTreeRoot(inorderIndexs.get(rootValue) + 1,
                inorderEnd,
                postorderFront - 1,
                postorderFront - rightSize);

        root.left = getTreeRoot(inorderFront,
                inorderIndexs.get(rootValue) - 1,
                postorderFront - rightSize -1,
                postorderEnd);

        return root;
    }
}

class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] inorder = stringToIntegerArray(line);
            line = in.readLine();
            int[] postorder = stringToIntegerArray(line);

            TreeNode ret = new Solution().buildTree(inorder, postorder);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
