package NO110;

import common.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    HashMap<TreeNode,Integer> depths = new HashMap<>();
    int depth_times = 0;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) return false;
         return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root) {
        depth_times++;
        System.out.println(depth_times);
        if (root == null) return 0;
        if (depths.containsKey(root)) return depths.get(root);
        int depth = 1 + Math.max(getDepth(root.left),getDepth(root.right));
        depths.put(root, depth);
        return depth;
    }
}

//class Solution {
//    int depth_times = 0;
//    public boolean isBalanced(TreeNode root) {
//        return getDepth(root) != -1;
//    }
//
//    public int getDepth(TreeNode root) {
//        if (root == null) return 0;
//        int leftDepth = getDepth(root.left);
//        int rightDepth = getDepth(root.right);
//        depth_times++;
//        System.out.println(depth_times);
//        return (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1)?-1:Math.max(leftDepth, rightDepth);
//    }
//}

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            boolean ret = new Solution().isBalanced(root);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
