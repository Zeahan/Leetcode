package NO117;

import common.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode connect(TreeNode root) {
        if (root == null) return null;

        TreeNode leftMost = root;
        while (leftMost.left != null || leftMost.right != null || leftMost.next != null) {
            leftMost = findNextWithChild(leftMost);
            if (leftMost == null) break;
            TreeNode cur = leftMost;
            while(cur != null) {

                TreeNode leftTreeNode = (cur.left != null)?cur.left:cur.right;

                if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                    leftTreeNode = cur.right;
                }

                TreeNode nextNeighbor = findNextWithChild(cur.next);

                if (nextNeighbor != null) {
                    leftTreeNode.next = (nextNeighbor.left != null)?nextNeighbor.left:nextNeighbor.right;
                }

                cur = nextNeighbor;
            }
            leftMost = (leftMost.left != null)?leftMost.left:leftMost.right;
        }
        return root;
    }

    public TreeNode findNextWithChild(TreeNode node) {
        while (node != null && node.left == null && node.right == null) node = node.next;
        return node;
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
            TreeNode root = stringToTreeNode(line);

            TreeNode ret = new Solution().connect(root);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}